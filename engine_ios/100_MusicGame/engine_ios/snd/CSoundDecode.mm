//
//  CSoundDecode.mm
//  100_MusicGame
//
//  Created by wazazhang on 11-8-14.
//  Copyright 2011年 __MyCompanyName__. All rights reserved.
//

#include "CSoundDecode.h"
#include "CStaticSoundInfo.h"
#include "CStreamSoundInfo.h"
#import <AudioToolbox/AudioToolbox.h>
#import <AudioToolbox/ExtendedAudioFile.h>

namespace com_cell 
{

    SoundInfo* createWavSound(std::string const &filepath)
    {
        return new StaticSoundInfo(filepath);
    }
    
    SoundInfo* createOggSound(std::string const &filepath)
    {
        return NULL;
    }

	
	ALvoid  alBufferDataStaticProc(const ALint bid, ALenum format, ALvoid* data, ALsizei size, ALsizei freq)
	{
		static	alBufferDataStaticProcPtr	proc = NULL;
		
		if (proc == NULL) {
			proc = (alBufferDataStaticProcPtr) 
			alcGetProcAddress(NULL, (const ALCchar*) "alBufferDataStatic");
		}
		
		if (proc)
			proc(bid, format, data, size, freq);
		
		return;
	}
	
	void* MyGetOpenALAudioData(CFURLRef inFileURL, 
							   ALsizei *outDataSize, 
							   ALenum *outDataFormat, 
							   ALsizei*	outSampleRate)
	{
		OSStatus						err = noErr;	
		SInt64							theFileLengthInFrames = 0;
		AudioStreamBasicDescription		theFileFormat;
		UInt32							thePropertySize = sizeof(theFileFormat);
		ExtAudioFileRef					extRef = NULL;
		void*							theData = NULL;
		AudioStreamBasicDescription		theOutputFormat;
		
		// Open a file with ExtAudioFileOpen()
		err = ExtAudioFileOpenURL(inFileURL, &extRef);
		if(err) { 
			printf("MyGetOpenALAudioData: ExtAudioFileOpenURL FAILED, Error = %ld\n", err); 
			// Dispose the ExtAudioFileRef, it is no longer needed
			if (extRef) ExtAudioFileDispose(extRef);
			return theData;
		}
		
		// Get the audio data format
		err = ExtAudioFileGetProperty(extRef, kExtAudioFileProperty_FileDataFormat, &thePropertySize, &theFileFormat);
		if(err) { 
			printf("MyGetOpenALAudioData: ExtAudioFileGetProperty(kExtAudioFileProperty_FileDataFormat) FAILED, Error = %ld\n", err); 
			// Dispose the ExtAudioFileRef, it is no longer needed
			if (extRef) ExtAudioFileDispose(extRef);
			return theData;
		}
		if (theFileFormat.mChannelsPerFrame > 2)  { 
			printf("MyGetOpenALAudioData - Unsupported Format, channel count is greater than stereo\n"); 
			// Dispose the ExtAudioFileRef, it is no longer needed
			if (extRef) ExtAudioFileDispose(extRef);
			return theData;
		}
		
		// Set the client format to 16 bit signed integer (native-endian) data
		// Maintain the channel count and sample rate of the original source format
		theOutputFormat.mSampleRate = theFileFormat.mSampleRate;
		theOutputFormat.mChannelsPerFrame = theFileFormat.mChannelsPerFrame;
		
		theOutputFormat.mFormatID = kAudioFormatLinearPCM;
		theOutputFormat.mBytesPerPacket = 2 * theOutputFormat.mChannelsPerFrame;
		theOutputFormat.mFramesPerPacket = 1;
		theOutputFormat.mBytesPerFrame = 2 * theOutputFormat.mChannelsPerFrame;
		theOutputFormat.mBitsPerChannel = 16;
		theOutputFormat.mFormatFlags = kAudioFormatFlagsNativeEndian | kAudioFormatFlagIsPacked | kAudioFormatFlagIsSignedInteger;
		
		// Set the desired client (output) data format
		err = ExtAudioFileSetProperty(extRef, kExtAudioFileProperty_ClientDataFormat, sizeof(theOutputFormat), &theOutputFormat);
		if(err) { 
			printf("MyGetOpenALAudioData: ExtAudioFileSetProperty(kExtAudioFileProperty_ClientDataFormat) FAILED, Error = %ld\n", err); 
			// Dispose the ExtAudioFileRef, it is no longer needed
			if (extRef) ExtAudioFileDispose(extRef);
			return theData;
		}
		
		// Get the total frame count
		thePropertySize = sizeof(theFileLengthInFrames);
		err = ExtAudioFileGetProperty(extRef, kExtAudioFileProperty_FileLengthFrames, &thePropertySize, &theFileLengthInFrames);
		if(err) {
			printf("MyGetOpenALAudioData: ExtAudioFileGetProperty(kExtAudioFileProperty_FileLengthFrames) FAILED, Error = %ld\n", err);
			// Dispose the ExtAudioFileRef, it is no longer needed
			if (extRef) ExtAudioFileDispose(extRef);
			return theData;
		}
		
		// Read all the data into memory
		UInt32		dataSize = theFileLengthInFrames * theOutputFormat.mBytesPerFrame;;
		theData = malloc(dataSize);
		if (theData)
		{
			AudioBufferList		theDataBuffer;
			theDataBuffer.mNumberBuffers = 1;
			theDataBuffer.mBuffers[0].mDataByteSize = dataSize;
			theDataBuffer.mBuffers[0].mNumberChannels = theOutputFormat.mChannelsPerFrame;
			theDataBuffer.mBuffers[0].mData = theData;
			
			// Read the data into an AudioBufferList
			err = ExtAudioFileRead(extRef, (UInt32*)&theFileLengthInFrames, &theDataBuffer);
			if(err == noErr)
			{
				// success
				*outDataSize = (ALsizei)dataSize;
				*outDataFormat = (theOutputFormat.mChannelsPerFrame > 1) ? AL_FORMAT_STEREO16 : AL_FORMAT_MONO16;
				*outSampleRate = (ALsizei)theOutputFormat.mSampleRate;
			}
			else 
			{ 
				// failure
				free (theData);
				theData = NULL; // make sure to return NULL
				printf("MyGetOpenALAudioData: ExtAudioFileRead FAILED, Error = %ld\n", err); 
			}	
		}
		// Dispose the ExtAudioFileRef, it is no longer needed
		if (extRef) ExtAudioFileDispose(extRef);
		return theData;
	}

}; // namespcace 
