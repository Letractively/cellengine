/*
 * WAZA
 * Created on 2006-7-3
 *
 */
package com.morefuntek.cell.MusicGame;

import java.util.Vector;

/**
 * @author WAZA
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * <summary> �����¼���
 */
class Note {
    /**������ʼʱ�䣬��λ����*/
    public int time;// ms
    /**�������ڵ���Ϸ�Ĺ��*/
    public byte pos;
    /**����*/
    public byte data;
}


/**
 * <summary> �����¼���
 */
class Meta {
    /**�����ٶȸı��¼�*/
    final static public byte META_TYPE_TEMPO = (byte)(0x80 + 1) ;
    
    
    /**����ʱ�䣬��λ����*/
    public int time;
    /**����*/
    public byte type;
    /**ֵ*/
    public int data;
}



/**
 * <summary> �������߼���
 */
public class DJZPlayer {

    private MGPlayerListener Screen;
    
    private Vector Events;
    private Vector Controls;
    
    private int LineCount;
    private int BPM = 120;

    private long PerBeatTime;
    private long BeatTick;

    public long EndTime ;
    
    /**�ٶ�*/
    public int Speed = 100;
    
    /**�������ж���Χ����λms*/
    public int BeatScope = 500;//0.5s
    /**����MISS�ķ�Χ����λms����lostscope֮��û�а��������㶪ʧ��*/
    public int LostScope = 2000;//2s

    
    private int BuffSize;//ͬʱ����������

    private int[][] Pos;
    private int[] hitted;
    private int[] losted;
    private int[] hitAcc;
    
    /**�Զ�����*/
    public boolean AutoPlay = false;
    /**�Զ���������λms*/
    public int AutoPlayHoldTime = 75;
    
    private boolean isBeat = false;
    
    /**�������ӵ�ǰ�ܹ����ж��ٴ�beat*/
    private int beatCount = 0 ;

    /**
     * <summary>
     * @param	��Ļ
     * @param	djz 2.0 �ļ�·��
     * @param	��Ϸ�����
     * @param	ͬʱ����������������ͬ��Ļ�����ʾ����
     */
    public DJZPlayer(MGPlayerListener screen,String DjzFile,int lineCount,int buffSize){
        
        Screen = screen;
        

        byte[] data = com.morefuntek.cell.CIO.loadFile(DjzFile);
        int P = 0 ;
        
        int FileSize 	= Util.read32(data, P); P += 4;//�ļ���С 
        EndTime 	= Util.read32(data, P); P += 4;//����ʱ��
        
        int NoteCount 	= Util.read32(data, P); P += 4;//��������
        Events = new Vector(NoteCount);
        for (int i = 0; i < NoteCount; i++){//������������
            Note note = new Note();
            note.time 	= Util.read32(data, P); P += 4;
            note.pos 	= Util.read8(data, P); P += 1;
            note.data 	= Util.read8(data, P); P += 1;
            Events.addElement(note);       
        }

        int MetaCount = Util.read32(data, P); P += 4;//��������
        Controls = new Vector(MetaCount);
        for (int i = 0; i < MetaCount; i++){//������������
            Meta meta = new Meta();
            meta.time 	= Util.read32(data, P); P += 4;
            meta.type 	= Util.read8(data, P); P += 1;
            meta.data 	= Util.read32(data, P); P += 4;
            Controls.addElement(meta);       
        }
        
        
        LineCount = lineCount;
        BuffSize = buffSize;
        
        Pos = new int[LineCount][BuffSize];
        hitted = new int[LineCount];
        losted = new int[LineCount];
        hitAcc = new int[LineCount];
        PerBeatTime = 0;
        BeatTick = 1000 * 60 / BPM;

        Speed = 100;
    }
    
    /**
     * <summary> ��ѭ����ÿ���ڵ���һ�Ρ�
     * @param	��ǰ��������ʱ��
     */
    public void update(long CurPlayTime){
//        control track
        if (Controls.isEmpty()==false && ((Meta)Controls.elementAt(0)).time <= CurPlayTime ){
            switch (((Meta)Controls.elementAt(0)).type){
            case Meta.META_TYPE_TEMPO:
                setBPM(((Meta)Controls.elementAt(0)).data);
            	Controls.removeElementAt(0);
                break;
            }
        }

//        event
        for (int t = LineCount - 1; t >= 0; t--) {
            hitted[t] = -1;
            for (int i = BuffSize - 1; i >= 0; i--) {
                Pos[t][i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < BuffSize; i++){
            if (i >= Events.size()) break;
            // ��⵱ǰ�������·�Χ
            if (AutoPlay == false){
                if (hitted[((Note)Events.elementAt(i)).pos % LineCount] < 0 &&
                    Math.abs(((Note)Events.elementAt(i)).time - CurPlayTime) < BeatScope){
                    hitted[((Note)Events.elementAt(i)).pos % LineCount] = i;
                    hitAcc[((Note)Events.elementAt(i)).pos % LineCount] = (int)(((Note)Events.elementAt(i)).time - CurPlayTime);
                }
            }else{
                if (((Note)Events.elementAt(i)).time <= CurPlayTime){
                    hitted[((Note)Events.elementAt(i)).pos % LineCount] = i;
                }
            }

            // ��������Ƿ��Ѿ�����
            if (((Note)Events.elementAt(i)).time < CurPlayTime - LostScope){
                losted[((Note)Events.elementAt(i)).pos % LineCount]++;
                // call back
                Screen.lostNote(((Note)Events.elementAt(i)).pos % LineCount);                
                Events.removeElementAt(i);
                continue;
            }
            
            // ����ʱ�������������Ļ����
            Pos[((Note)Events.elementAt(i)).pos % LineCount][i]= 
                (int)((((Note)Events.elementAt(i)).time - CurPlayTime) 
                        * Speed / 1000 );
            
            // call back
            Screen.showNote(Pos);
              
        }
//      bpm
        if (CurPlayTime - PerBeatTime >= BeatTick){
            beatCount++;
            isBeat = true;
            PerBeatTime = CurPlayTime;
            
            // call back
            Screen.beatBPM(beatCount);
        }else{
            isBeat = false;
        }
    }

    private void setBPM(int bpm){
        BPM = bpm;
        BeatTick = 1000 * 60 / BPM;
    }

    /**
	 * <summary> ��ʾ����λ�á�
     * @param 	
     * pos[��Ϸ�����][ͬʱ��ʾ������]������Ŀ���ľ��룬��λ���ء�
     * ��������δ����
     * �������Ѿ�������
     * �㣺�����պô���ԭ�㡣
     * ����ڰ���ָ����ť��ʱ�򣬸�ֵ�ľ���ֵС�ڻ����MGPlayer.BeatScope����ô�������ͱ�HIT��
     * �����ֵ����MGPlayer.LostScope����ô�������ͱ���ʧ��
     */
    public int[][] getPos(){
        return Pos;
    }

    /**
     * <summary> ָ������İ�ť���¡�
     * @param track ��Ϸ����ţ�С��LineCount��
     * @return ������ڵ���0��������С��0��û��HIT��������
     */
    public byte hit(int track){
        if (hitted[track] >= 0){
            Screen.hitNote(track,hitAcc[track]);
            byte ret = ((Note)Events.elementAt(hitted[track])).data;
         	Events.removeElementAt(hitted[track]);
            return ret;
        }
        return -1;
    }

    /**
     * <summary> ��Ѱ������ʧ��
     * @param ��һ����Ϸ�����
     * @return ��ʧ�˶���
     */
    public int lost(int track){
        if (losted[track] > 0){
            int ret = losted[track];
            losted[track] = 0;
            return ret;
        }
        return 0;
    }

    /**
     * <summary> ��ǰʱ���Ƿ����ķ�֮һ�ġ�
     * @return ��ǰʱ���Ƿ����ķ�֮һ�ġ�
     */
    public boolean beatBPM(){
        return isBeat;
    }

    /**
     * <summary> �õ���Ϸ���������
     * @return ��Ϸ�����
     */
    public int getLineCount(){
        return LineCount;
    }

    /**
     * <summary> �õ���ǰBPMֵ��
     * @return BPM
     */
    public int getBPM(){
        return BPM;
    }
}
