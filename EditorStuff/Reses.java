/* Cell Game Editor by WAZA Zhang */
/* Email : wazazhang@gmail.com */
import com.morefuntek.cell.*;
import com.morefuntek.cell.Game.*;

public class Reses {
final static public void buildImages_SprTile(IImages stuff)
{
    stuff.buildImages(null, 96);
    for(int i=0;i<96;i++){
        stuff.setTileImage(CIO.loadImage("/SprTile/tile_"+i+".png"));
        stuff.addTile();
    }
    stuff.gc();
}
final static public void buildClipImages_SprTile(IImages stuff)
{
    stuff.buildImages(CIO.loadImage("/SprTile.png"), 96);
    stuff.addTile(0,0,24,32);
    stuff.addTile(24,0,24,32);
    stuff.addTile(48,0,24,32);
    stuff.addTile(72,0,24,32);
    stuff.addTile(96,0,24,32);
    stuff.addTile(120,0,24,32);
    stuff.addTile(144,0,24,32);
    stuff.addTile(168,0,24,32);
    stuff.addTile(192,0,24,32);
    stuff.addTile(216,0,24,32);
    stuff.addTile(240,0,24,32);
    stuff.addTile(264,0,24,32);
    stuff.addTile(0,32,24,32);
    stuff.addTile(24,32,24,32);
    stuff.addTile(48,32,24,32);
    stuff.addTile(72,32,24,32);
    stuff.addTile(96,32,24,32);
    stuff.addTile(120,32,24,32);
    stuff.addTile(144,32,24,32);
    stuff.addTile(168,32,24,32);
    stuff.addTile(192,32,24,32);
    stuff.addTile(216,32,24,32);
    stuff.addTile(240,32,24,32);
    stuff.addTile(264,32,24,32);
    stuff.addTile(0,64,24,32);
    stuff.addTile(24,64,24,32);
    stuff.addTile(48,64,24,32);
    stuff.addTile(72,64,24,32);
    stuff.addTile(96,64,24,32);
    stuff.addTile(120,64,24,32);
    stuff.addTile(144,64,24,32);
    stuff.addTile(168,64,24,32);
    stuff.addTile(192,64,24,32);
    stuff.addTile(216,64,24,32);
    stuff.addTile(240,64,24,32);
    stuff.addTile(264,64,24,32);
    stuff.addTile(0,96,24,32);
    stuff.addTile(24,96,24,32);
    stuff.addTile(48,96,24,32);
    stuff.addTile(72,96,24,32);
    stuff.addTile(96,96,24,32);
    stuff.addTile(120,96,24,32);
    stuff.addTile(144,96,24,32);
    stuff.addTile(168,96,24,32);
    stuff.addTile(192,96,24,32);
    stuff.addTile(216,96,24,32);
    stuff.addTile(240,96,24,32);
    stuff.addTile(264,96,24,32);
    stuff.addTile(0,128,24,32);
    stuff.addTile(24,128,24,32);
    stuff.addTile(48,128,24,32);
    stuff.addTile(72,128,24,32);
    stuff.addTile(96,128,24,32);
    stuff.addTile(120,128,24,32);
    stuff.addTile(144,128,24,32);
    stuff.addTile(168,128,24,32);
    stuff.addTile(192,128,24,32);
    stuff.addTile(216,128,24,32);
    stuff.addTile(240,128,24,32);
    stuff.addTile(264,128,24,32);
    stuff.addTile(0,160,24,32);
    stuff.addTile(24,160,24,32);
    stuff.addTile(48,160,24,32);
    stuff.addTile(72,160,24,32);
    stuff.addTile(96,160,24,32);
    stuff.addTile(120,160,24,32);
    stuff.addTile(144,160,24,32);
    stuff.addTile(168,160,24,32);
    stuff.addTile(192,160,24,32);
    stuff.addTile(216,160,24,32);
    stuff.addTile(240,160,24,32);
    stuff.addTile(264,160,24,32);
    stuff.addTile(0,192,24,32);
    stuff.addTile(24,192,24,32);
    stuff.addTile(48,192,24,32);
    stuff.addTile(72,192,24,32);
    stuff.addTile(96,192,24,32);
    stuff.addTile(120,192,24,32);
    stuff.addTile(144,192,24,32);
    stuff.addTile(168,192,24,32);
    stuff.addTile(192,192,24,32);
    stuff.addTile(216,192,24,32);
    stuff.addTile(240,192,24,32);
    stuff.addTile(264,192,24,32);
    stuff.addTile(0,224,24,32);
    stuff.addTile(24,224,24,32);
    stuff.addTile(48,224,24,32);
    stuff.addTile(72,224,24,32);
    stuff.addTile(96,224,24,32);
    stuff.addTile(120,224,24,32);
    stuff.addTile(144,224,24,32);
    stuff.addTile(168,224,24,32);
    stuff.addTile(192,224,24,32);
    stuff.addTile(216,224,24,32);
    stuff.addTile(240,224,24,32);
    stuff.addTile(264,224,24,32);
    stuff.gc();
}
final static public CSprite createSprite_SprTile_Enemy00(IImages tiles)
{
    CAnimates animates = new CAnimates(12,tiles);
    animates.addPart(-12,-16,0,0);
    animates.addPart(-12,-16,1,0);
    animates.addPart(-12,-16,2,0);
    animates.addPart(-12,-16,12,0);
    animates.addPart(-12,-16,13,0);
    animates.addPart(-12,-16,14,0);
    animates.addPart(-12,-16,24,0);
    animates.addPart(-12,-16,25,0);
    animates.addPart(-12,-16,26,0);
    animates.addPart(-12,-16,36,0);
    animates.addPart(-12,-16,37,0);
    animates.addPart(-12,-16,38,0);
    animates.setFrame(new int[12][]);
    animates.setComboFrame(new int[]{0,},0);
    animates.setComboFrame(new int[]{1,},1);
    animates.setComboFrame(new int[]{2,},2);
    animates.setComboFrame(new int[]{3,},3);
    animates.setComboFrame(new int[]{4,},4);
    animates.setComboFrame(new int[]{5,},5);
    animates.setComboFrame(new int[]{6,},6);
    animates.setComboFrame(new int[]{7,},7);
    animates.setComboFrame(new int[]{8,},8);
    animates.setComboFrame(new int[]{9,},9);
    animates.setComboFrame(new int[]{10,},10);
    animates.setComboFrame(new int[]{11,},11);

    CCollides collides = new CCollides(0);
    collides.setFrame(new int[1][]);
    collides.setComboFrame(new int[]{},0);

    int[][] frameAnimate = new int[][]{
        {0,1,2,1,},
        {3,4,5,4,},
        {6,7,8,7,},
        {9,10,11,10,},
    };
    int[][] frameCDMap = new int[][]{
        {0,0,0,0,},
        {0,0,0,0,},
        {0,0,0,0,},
        {0,0,0,0,},
    };
    int[][] frameCDAtk = new int[][]{
        {0,0,0,0,},
        {0,0,0,0,},
        {0,0,0,0,},
        {0,0,0,0,},
    };
    int[][] frameCDDef = new int[][]{
        {0,0,0,0,},
        {0,0,0,0,},
        {0,0,0,0,},
        {0,0,0,0,},
    };
    int[][] frameCDExt = new int[][]{
        {0,0,0,0,},
        {0,0,0,0,},
        {0,0,0,0,},
        {0,0,0,0,},
    };

    CSprite ret = new CSprite(
            animates, 
            collides, 
            frameAnimate, 
            frameCDMap, 
            frameCDAtk, 
            frameCDDef, 
            frameCDExt 
            );

    return ret;

}
final static public void buildImages_MapTile(IImages stuff)
{
    stuff.buildImages(null, 48);
    for(int i=0;i<48;i++){
        stuff.setTileImage(CIO.loadImage("/MapTile/tile_"+i+".png"));
        stuff.addTile();
    }
    stuff.gc();
}
final static public void buildClipImages_MapTile(IImages stuff)
{
    stuff.buildImages(CIO.loadImage("/MapTile.png"), 48);
    stuff.addTile(0,0,16,16);
    stuff.addTile(16,0,16,16);
    stuff.addTile(32,0,16,16);
    stuff.addTile(48,0,16,16);
    stuff.addTile(64,0,16,16);
    stuff.addTile(80,0,16,16);
    stuff.addTile(0,16,16,16);
    stuff.addTile(16,16,16,16);
    stuff.addTile(32,16,16,16);
    stuff.addTile(48,16,16,16);
    stuff.addTile(64,16,16,16);
    stuff.addTile(80,16,16,16);
    stuff.addTile(0,32,16,16);
    stuff.addTile(16,32,16,16);
    stuff.addTile(32,32,16,16);
    stuff.addTile(48,32,16,16);
    stuff.addTile(64,32,16,16);
    stuff.addTile(80,32,16,16);
    stuff.addTile(0,48,16,16);
    stuff.addTile(16,48,16,16);
    stuff.addTile(32,48,16,16);
    stuff.addTile(48,48,16,16);
    stuff.addTile(64,48,16,16);
    stuff.addTile(80,48,16,16);
    stuff.addTile(0,64,16,16);
    stuff.addTile(16,64,16,16);
    stuff.addTile(32,64,16,16);
    stuff.addTile(48,64,16,16);
    stuff.addTile(64,64,16,16);
    stuff.addTile(80,64,16,16);
    stuff.addTile(0,80,16,16);
    stuff.addTile(16,80,16,16);
    stuff.addTile(32,80,16,16);
    stuff.addTile(48,80,16,16);
    stuff.addTile(64,80,16,16);
    stuff.addTile(80,80,16,16);
    stuff.addTile(0,96,16,16);
    stuff.addTile(16,96,16,16);
    stuff.addTile(32,96,16,16);
    stuff.addTile(48,96,16,16);
    stuff.addTile(64,96,16,16);
    stuff.addTile(80,96,16,16);
    stuff.addTile(0,112,16,16);
    stuff.addTile(16,112,16,16);
    stuff.addTile(32,112,16,16);
    stuff.addTile(48,112,16,16);
    stuff.addTile(64,112,16,16);
    stuff.addTile(80,112,16,16);
    stuff.gc();
}

final static public CMap createMap_MapTile_Map00(IImages tiles,boolean isAnimate,boolean isCyc)
{
    CAnimates animates = new CAnimates(3,tiles);
    animates.addPart(0,0,2,0);
    animates.addPart(0,0,9,0);
    animates.addPart(0,0,26,0);
    animates.setFrame(new int[3][]);
    animates.setComboFrame(new int[]{0,},0);
    animates.setComboFrame(new int[]{1,},1);
    animates.setComboFrame(new int[]{2,},2);

    CCollides collides = new CCollides(8);
    collides.addCDRect(0x00000000, 0, 0, 16,16);
    collides.addCDRect(0x00000001, 0, 0, 16,16);
    collides.addCDRect(0x00000002, 0, 0, 16,1);
    collides.addCDRect(0x00000004, 0, 15, 16,1);
    collides.addCDRect(0x00000008, 0, 0, 1,16);
    collides.addCDRect(0x00000010, 15, 0, 1,16);
    collides.addCDLine(0x00000020, 1, 1, 15,15);
    collides.addCDLine(0x00000040, 15, 1, 1,15);

    short[][] tileMatrix = new short[][]{
        {0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,},
        {0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,2,2,2,2,2,2,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,2,2,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,},
        {0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,},
        {0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,},
        {0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,},
        {0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
    };
    short[][] flagMatrix = new short[][]{
        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,},
        {0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,},
        {0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,},
        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,},
        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,},
        {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
    };

    CMap ret = new CMap(
            animates, 
            collides, 
            16, 16, 
            tileMatrix, 
            flagMatrix, 
            isAnimate,isCyc 
            );

    return ret;

}
}

class Level00 extends CWorld 
{
public CMap Map0000_Map00;
private int Map0000_Map00_X = 0;
private int Map0000_Map00_Y = 0;
public void initPath()
{
    WayPoints = new CWayPoint[21];
    WayPoints[0] = new CWayPoint(38,2);
    WayPoints[1] = new CWayPoint(41,471);
    WayPoints[2] = new CWayPoint(470,470);
    WayPoints[3] = new CWayPoint(471,40);
    WayPoints[4] = new CWayPoint(90,38);
    WayPoints[5] = new CWayPoint(87,424);
    WayPoints[6] = new CWayPoint(424,423);
    WayPoints[7] = new CWayPoint(422,87);
    WayPoints[8] = new CWayPoint(140,89);
    WayPoints[9] = new CWayPoint(135,375);
    WayPoints[10] = new CWayPoint(373,373);
    WayPoints[11] = new CWayPoint(372,134);
    WayPoints[12] = new CWayPoint(182,134);
    WayPoints[13] = new CWayPoint(182,323);
    WayPoints[14] = new CWayPoint(324,325);
    WayPoints[15] = new CWayPoint(326,185);
    WayPoints[16] = new CWayPoint(232,185);
    WayPoints[17] = new CWayPoint(230,278);
    WayPoints[18] = new CWayPoint(280,281);
    WayPoints[19] = new CWayPoint(280,229);
    WayPoints[20] = new CWayPoint(256,220);

    WayPoints[0].link(WayPoints[1]);
    WayPoints[1].link(WayPoints[0]);
    WayPoints[1].link(WayPoints[2]);
    WayPoints[2].link(WayPoints[1]);
    WayPoints[2].link(WayPoints[3]);
    WayPoints[3].link(WayPoints[2]);
    WayPoints[3].link(WayPoints[4]);
    WayPoints[4].link(WayPoints[3]);
    WayPoints[4].link(WayPoints[5]);
    WayPoints[5].link(WayPoints[4]);
    WayPoints[5].link(WayPoints[6]);
    WayPoints[6].link(WayPoints[5]);
    WayPoints[6].link(WayPoints[7]);
    WayPoints[7].link(WayPoints[6]);
    WayPoints[7].link(WayPoints[8]);
    WayPoints[8].link(WayPoints[7]);
    WayPoints[8].link(WayPoints[9]);
    WayPoints[9].link(WayPoints[8]);
    WayPoints[9].link(WayPoints[10]);
    WayPoints[10].link(WayPoints[9]);
    WayPoints[10].link(WayPoints[11]);
    WayPoints[11].link(WayPoints[10]);
    WayPoints[11].link(WayPoints[12]);
    WayPoints[12].link(WayPoints[11]);
    WayPoints[12].link(WayPoints[13]);
    WayPoints[13].link(WayPoints[14]);
    WayPoints[13].link(WayPoints[12]);
    WayPoints[14].link(WayPoints[13]);
    WayPoints[14].link(WayPoints[15]);
    WayPoints[15].link(WayPoints[14]);
    WayPoints[15].link(WayPoints[16]);
    WayPoints[16].link(WayPoints[15]);
    WayPoints[16].link(WayPoints[17]);
    WayPoints[17].link(WayPoints[16]);
    WayPoints[17].link(WayPoints[18]);
    WayPoints[18].link(WayPoints[17]);
    WayPoints[18].link(WayPoints[19]);
    WayPoints[19].link(WayPoints[18]);
    WayPoints[19].link(WayPoints[20]);
    WayPoints[20].link(WayPoints[19]);
}
public void initUnit()
{
    addMap(Map0000_Map00);
}
}
