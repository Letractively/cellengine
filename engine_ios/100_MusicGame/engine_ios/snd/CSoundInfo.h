//
//  CSoundInfo.h
//  100_MusicGame
//
//  Created by wazazhang on 11-8-13.
//  Copyright 2011年 __MyCompanyName__. All rights reserved.
//
#ifndef _COM_CELL_SOUND_INFO
#define _COM_CELL_SOUND_INFO

#include <string>
#include "CUtil.h"

namespace com_cell 
{
    class SoundInfo
    {
    public:
        
        virtual std::string		getResource() = 0;
        
        /** stereo mono , 1, 2*/
        virtual int             getChannels() = 0;
        
        /** 16bit 8bit */
        virtual int             getBitLength() = 0;
        
        /** 44100hz 22050hz */
        virtual int             getFrameRate() = 0;
        
        /** file comment */
        virtual std::string     getComment() = 0;
        
        /** 
         * PCM raw data stream <br>
         * 读取此缓冲区当前位置的字节流，然后该位置递增。 
         * */
        virtual void*           getData() = 0;
        
        /**获得数据长度，字节*/
        virtual int             getDataSize() = 0;
        
        /**
         * if the raw stream has remain data <br>
         * 该缓冲区是否有新数据。
         */
        virtual bool            hasData() = 0;
        
        /**
         * reset the raw data stream to head<br>
         * 重设读取的数据流到最开始。
         */
        virtual void            resetData() = 0;
        
        
        inline std::string toString() {
            std::string sb = std::string("SoundInfo : ");
            sb.append(getResource()).append("\n")
            .append("\t  channels : ").append(intToString(getChannels())).append("\n")
            .append("\tbit_length : ").append(intToString(getBitLength())).append("\n")
            .append("\tframe_rate : ").append(intToString(getFrameRate())).append("\n")
            .append(getComment());
            return sb;
        }
        
    };
    
    
}; // namespcace 

#endif // _COM_CELL_SOUND_INFO

