import com.morefuntek.cell.*;
import com.morefuntek.cell.Game.*;

public class Reses {
final static public void buildImages_unamed_Tile(IImages stuff)
{
    stuff.buildImages(null, 64);
    for(int i=0;i<64;i++){
        stuff.setTileImage(CIO.loadImage("/unamed_Tile/tile_"+i+".png"));
        stuff.addTile();
    }
    stuff.gc();
}
final static public void buildClipImages_unamed_Tile(IImages stuff)
{
    stuff.buildImages(CIO.loadImage("/unamed_Tile.png"), 64);
    stuff.addTile(0,0,16,16);
    stuff.addTile(16,0,16,16);
    stuff.addTile(32,0,16,16);
    stuff.addTile(48,0,16,16);
    stuff.addTile(64,0,16,16);
    stuff.addTile(80,0,16,16);
    stuff.addTile(96,0,16,16);
    stuff.addTile(112,0,16,16);
    stuff.addTile(0,16,16,16);
    stuff.addTile(16,16,16,16);
    stuff.addTile(32,16,16,16);
    stuff.addTile(48,16,16,16);
    stuff.addTile(64,16,16,16);
    stuff.addTile(80,16,16,16);
    stuff.addTile(96,16,16,16);
    stuff.addTile(112,16,16,16);
    stuff.addTile(0,32,16,16);
    stuff.addTile(16,32,16,16);
    stuff.addTile(32,32,16,16);
    stuff.addTile(48,32,16,16);
    stuff.addTile(64,32,16,16);
    stuff.addTile(80,32,16,16);
    stuff.addTile(96,32,16,16);
    stuff.addTile(112,32,16,16);
    stuff.addTile(0,48,16,16);
    stuff.addTile(16,48,16,16);
    stuff.addTile(32,48,16,16);
    stuff.addTile(48,48,16,16);
    stuff.addTile(64,48,16,16);
    stuff.addTile(80,48,16,16);
    stuff.addTile(96,48,16,16);
    stuff.addTile(112,48,16,16);
    stuff.addTile(0,64,16,16);
    stuff.addTile(16,64,16,16);
    stuff.addTile(32,64,16,16);
    stuff.addTile(48,64,16,16);
    stuff.addTile(64,64,16,16);
    stuff.addTile(80,64,16,16);
    stuff.addTile(96,64,16,16);
    stuff.addTile(112,64,16,16);
    stuff.addTile(0,80,16,16);
    stuff.addTile(16,80,16,16);
    stuff.addTile(32,80,16,16);
    stuff.addTile(48,80,16,16);
    stuff.addTile(64,80,16,16);
    stuff.addTile(80,80,16,16);
    stuff.addTile(96,80,16,16);
    stuff.addTile(112,80,16,16);
    stuff.addTile(0,96,16,16);
    stuff.addTile(16,96,16,16);
    stuff.addTile(32,96,16,16);
    stuff.addTile(48,96,16,16);
    stuff.addTile(64,96,16,16);
    stuff.addTile(80,96,16,16);
    stuff.addTile(96,96,16,16);
    stuff.addTile(112,96,16,16);
    stuff.addTile(0,112,16,16);
    stuff.addTile(16,112,16,16);
    stuff.addTile(32,112,16,16);
    stuff.addTile(48,112,16,16);
    stuff.addTile(64,112,16,16);
    stuff.addTile(80,112,16,16);
    stuff.addTile(96,112,16,16);
    stuff.addTile(112,112,16,16);
    stuff.gc();
}

final static public CMap createMap_unamed_Tile_unamed_Map(IImages tiles,boolean isAnimate,boolean isCyc)
{
    CAnimates animates = new CAnimates(5,tiles);
    animates.addPart(0,0,0,2);
    animates.addPart(0,0,0,0);
    animates.addPart(0,0,50,2);
    animates.addPart(0,0,16,2);
    animates.addPart(0,0,48,2);
    animates.setFrame(new int[5][]);
    animates.setComboFrame(new int[]{0,},0);
    animates.setComboFrame(new int[]{1,},1);
    animates.setComboFrame(new int[]{2,},2);
    animates.setComboFrame(new int[]{3,},3);
    animates.setComboFrame(new int[]{4,},4);

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
        {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
        {0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,},
        {0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,},
        {0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3,0,0,},
        {0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,3,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,3,0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,3,0,0,3,0,0,3,3,3,3,3,3,3,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},
        {0,0,3,4,0,3,0,0,3,0,0,3,0,0,0,0,0,3,0,0,3,0,0,3,0,0,3,0,0,3,0,2,},
        {0,0,3,0,0,3,0,0,3,0,0,3,0,0,2,0,0,3,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,3,0,0,3,0,0,3,0,0,3,3,3,3,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,3,4,0,3,0,0,3,0,0,3,0,0,},
        {0,0,3,0,0,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},
        {1,1,3,0,0,3,0,0,3,4,0,3,3,3,3,3,3,3,3,3,3,0,0,3,0,0,3,0,0,3,0,0,},
        {1,1,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,},
        {1,1,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,1,1,},
        {1,1,3,0,0,3,0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3,0,0,3,1,1,},
        {1,1,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,1,1,},
        {1,1,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,1,1,},
        {1,1,3,0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3,1,1,},
        {1,1,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,3,1,1,},
        {1,1,3,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,},
        {1,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,1,1,},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
    };
    short[][] flagMatrix = new short[][]{
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
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
final static public void buildImages_unamed_Tile2(IImages stuff)
{
    stuff.buildImages(null, 16);
    for(int i=0;i<16;i++){
        stuff.setTileImage(CIO.loadImage("/unamed_Tile2/tile_"+i+".png"));
        stuff.addTile();
    }
    stuff.gc();
}
final static public void buildClipImages_unamed_Tile2(IImages stuff)
{
    stuff.buildImages(CIO.loadImage("/unamed_Tile2.png"), 16);
    stuff.addTile(32,0,32,48);
    stuff.addTile(0,0,32,48);
    stuff.addTile(64,0,32,48);
    stuff.addTile(96,0,32,48);
    stuff.addTile(0,48,32,48);
    stuff.addTile(32,48,32,48);
    stuff.addTile(64,48,32,48);
    stuff.addTile(96,48,32,48);
    stuff.addTile(0,96,32,48);
    stuff.addTile(32,96,32,48);
    stuff.addTile(64,96,32,48);
    stuff.addTile(96,96,32,48);
    stuff.addTile(0,144,32,48);
    stuff.addTile(32,144,32,48);
    stuff.addTile(64,144,32,48);
    stuff.addTile(96,144,32,48);
    stuff.gc();
}
final static public CSprite createSprite_unamed_Tile2_unamed_Sprite(IImages tiles)
{
    CAnimates animates = new CAnimates(2,tiles);
    animates.addPart(-16,-24,0,0);
    animates.addPart(-16,-24,1,0);
    animates.setFrame(new int[2][]);
    animates.setComboFrame(new int[]{0,},0);
    animates.setComboFrame(new int[]{1,},1);

    CCollides collides = new CCollides(0);
    collides.setFrame(new int[1][]);
    collides.setComboFrame(new int[]{},0);

    int[][] frameAnimate = new int[][]{
        {0,1,},
    };
    int[][] frameCDMap = new int[][]{
        {0,0,},
    };
    int[][] frameCDAtk = new int[][]{
        {0,0,},
    };
    int[][] frameCDDef = new int[][]{
        {0,0,},
    };
    int[][] frameCDExt = new int[][]{
        {0,0,},
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
final static public CSprite createSprite_unamed_Tile2_unamed_Sprite2(IImages tiles)
{
    CAnimates animates = new CAnimates(22,tiles);
    animates.addPart(-16,-24,0,0);
    animates.addPart(-16,-24,1,0);
    animates.addPart(-16,-24,2,0);
    animates.addPart(-16,-24,3,0);
    animates.addPart(-16,-24,4,0);
    animates.addPart(-16,-24,5,0);
    animates.addPart(-16,-24,6,0);
    animates.addPart(-16,-24,7,0);
    animates.addPart(-16,-24,8,0);
    animates.addPart(-16,-24,9,0);
    animates.addPart(-16,-24,10,0);
    animates.addPart(-16,-24,11,0);
    animates.addPart(-16,-24,12,0);
    animates.addPart(-16,-24,13,0);
    animates.addPart(-16,-24,14,0);
    animates.addPart(-16,-24,15,0);
    animates.addPart(10,-24,0,0);
    animates.addPart(-40,-24,0,0);
    animates.addPart(-10,-24,0,3);
    animates.addPart(10,-24,0,6);
    animates.addPart(10,-24,0,7);
    animates.addPart(-40,-24,0,6);
    animates.setFrame(new int[19][]);
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
    animates.setComboFrame(new int[]{12,},12);
    animates.setComboFrame(new int[]{13,},13);
    animates.setComboFrame(new int[]{14,},14);
    animates.setComboFrame(new int[]{15,},15);
    animates.setComboFrame(new int[]{16,17,18,19,},16);
    animates.setComboFrame(new int[]{20,21,},17);
    animates.setComboFrame(new int[]{},18);

    CCollides collides = new CCollides(5);
    collides.addCDRect(65535,-7,13,14,10);
    collides.addCDRect(65535,-16,1,32,48);
    collides.addCDRect(65535,-16,-64,32,48);
    collides.addCDRect(65535,-37,1,32,48);
    collides.addCDRect(65535,10,-58,32,48);
    collides.setFrame(new int[6][]);
    collides.setComboFrame(new int[]{0,},0);
    collides.setComboFrame(new int[]{},1);
    collides.setComboFrame(new int[]{2,},2);
    collides.setComboFrame(new int[]{1,},3);
    collides.setComboFrame(new int[]{4,},4);
    collides.setComboFrame(new int[]{3,},5);

    int[][] frameAnimate = new int[][]{
        {0,1,2,3,},
        {4,5,6,7,},
        {8,9,10,11,},
        {12,13,14,15,},
        {16,17,18,},
    };
    int[][] frameCDMap = new int[][]{
        {0,0,0,0,},
        {0,0,0,0,},
        {0,0,0,0,},
        {0,0,0,0,},
        {2,4,1,},
    };
    int[][] frameCDAtk = new int[][]{
        {1,1,1,1,},
        {1,1,1,1,},
        {1,1,1,1,},
        {1,1,1,1,},
        {3,5,1,},
    };
    int[][] frameCDDef = new int[][]{
        {1,1,1,1,},
        {1,1,1,1,},
        {1,1,1,1,},
        {1,1,1,1,},
        {1,1,1,},
    };
    int[][] frameCDExt = new int[][]{
        {1,1,1,1,},
        {1,1,1,1,},
        {1,1,1,1,},
        {1,1,1,1,},
        {1,1,1,},
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
final static public CSprite createSprite_unamed_Tile2_unamed_Sprite3(IImages tiles)
{
    CAnimates animates = new CAnimates(1,tiles);
    animates.addPart(-16,-42,0,0);
    animates.setFrame(new int[1][]);
    animates.setComboFrame(new int[]{0,},0);

    CCollides collides = new CCollides(1);
    collides.addCDRect(65535,-18,-24,35,36);
    collides.setFrame(new int[2][]);
    collides.setComboFrame(new int[]{0,},0);
    collides.setComboFrame(new int[]{},1);

    int[][] frameAnimate = new int[][]{
        {0,},
    };
    int[][] frameCDMap = new int[][]{
        {0,},
    };
    int[][] frameCDAtk = new int[][]{
        {1,},
    };
    int[][] frameCDDef = new int[][]{
        {1,},
    };
    int[][] frameCDExt = new int[][]{
        {1,},
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
final static public void buildImages_PapaBeanTile(IImages stuff)
{
    stuff.buildImages(null, 14);
    for(int i=0;i<14;i++){
        stuff.setTileImage(CIO.loadImage("/PapaBeanTile/tile_"+i+".png"));
        stuff.addTile();
    }
    stuff.gc();
}
final static public void buildClipImages_PapaBeanTile(IImages stuff)
{
    stuff.buildImages(CIO.loadImage("/PapaBeanTile.png"), 14);
    stuff.addTile(0,0,30,28);
    stuff.addTile(0,28,30,28);
    stuff.addTile(0,56,30,28);
    stuff.addTile(0,84,30,28);
    stuff.addTile(0,112,30,28);
    stuff.addTile(0,140,30,28);
    stuff.addTile(0,168,30,28);
    stuff.addTile(0,196,30,28);
    stuff.addTile(0,224,18,25);
    stuff.addTile(0,249,19,31);
    stuff.addTile(0,280,19,32);
    stuff.addTile(0,312,21,30);
    stuff.addTile(0,342,28,28);
    stuff.addTile(0,370,28,28);
    stuff.gc();
}
final static public CSprite createSprite_PapaBeanTile_baby(IImages tiles)
{
    CAnimates animates = new CAnimates(16,tiles);
    animates.addPart(-15,-14,0,0);
    animates.addPart(-15,-14,1,0);
    animates.addPart(-15,-14,2,0);
    animates.addPart(-15,-14,3,0);
    animates.addPart(-15,-14,4,0);
    animates.addPart(-15,-14,5,0);
    animates.addPart(-15,-14,6,0);
    animates.addPart(-15,-14,7,0);
    animates.addPart(-14,-14,12,0);
    animates.addPart(-14,-14,13,0);
    animates.addPart(-14,-14,12,6);
    animates.addPart(-14,-14,13,6);
    animates.addPart(-14,-14,12,3);
    animates.addPart(-14,-14,13,3);
    animates.addPart(-14,-14,12,5);
    animates.addPart(-14,-14,13,5);
    animates.setFrame(new int[16][]);
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
    animates.setComboFrame(new int[]{12,},12);
    animates.setComboFrame(new int[]{13,},13);
    animates.setComboFrame(new int[]{14,},14);
    animates.setComboFrame(new int[]{15,},15);

    CCollides collides = new CCollides(1);
    collides.addCDRect(65535,-8,-10,12,23);
    collides.setFrame(new int[2][]);
    collides.setComboFrame(new int[]{0,},0);
    collides.setComboFrame(new int[]{},1);

    int[][] frameAnimate = new int[][]{
        {0,1,2,3,4,5,6,7,},
        {8,9,10,11,12,13,14,15,},
    };
    int[][] frameCDMap = new int[][]{
        {0,0,0,0,0,0,0,0,},
        {1,1,1,1,1,1,1,1,},
    };
    int[][] frameCDAtk = new int[][]{
        {1,1,1,1,1,1,1,1,},
        {1,1,1,1,1,1,1,1,},
    };
    int[][] frameCDDef = new int[][]{
        {1,1,1,1,1,1,1,1,},
        {1,1,1,1,1,1,1,1,},
    };
    int[][] frameCDExt = new int[][]{
        {1,1,1,1,1,1,1,1,},
        {1,1,1,1,1,1,1,1,},
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
final static public void buildImages_BossTile(IImages stuff)
{
    stuff.buildImages(null, 11);
    for(int i=0;i<11;i++){
        stuff.setTileImage(CIO.loadImage("/BossTile/tile_"+i+".png"));
        stuff.addTile();
    }
    stuff.gc();
}
final static public void buildClipImages_BossTile(IImages stuff)
{
    stuff.buildImages(CIO.loadImage("/BossTile.png"), 11);
    stuff.addTile(0,0,52,67);
    stuff.addTile(87,0,27,32);
    stuff.addTile(52,0,35,30);
    stuff.addTile(52,30,19,15);
    stuff.addTile(52,45,68,16);
    stuff.addTile(52,61,67,17);
    stuff.addTile(71,32,26,11);
    stuff.addTile(97,32,20,5);
    stuff.addTile(114,0,20,10);
    stuff.addTile(114,10,18,19);
    stuff.addTile(120,29,15,18);
    stuff.gc();
}
final static public CSprite createSprite_BossTile_boss(IImages tiles)
{
    CAnimates animates = new CAnimates(6,tiles);
    animates.addPart(12,-28,1,0);
    animates.addPart(-26,-33,0,0);
    animates.addPart(4,-37,3,0);
    animates.addPart(8,-40,2,0);
    animates.addPart(-33,18,4,0);
    animates.addPart(-33,18,5,0);
    animates.setFrame(new int[4][]);
    animates.setComboFrame(new int[]{0,1,2,},0);
    animates.setComboFrame(new int[]{3,1,},1);
    animates.setComboFrame(new int[]{4,0,1,2,},2);
    animates.setComboFrame(new int[]{5,0,1,2,},3);

    CCollides collides = new CCollides(0);
    collides.setFrame(new int[1][]);
    collides.setComboFrame(new int[]{},0);

    int[][] frameAnimate = new int[][]{
        {0,1,},
        {2,3,},
    };
    int[][] frameCDMap = new int[][]{
        {0,0,},
        {0,0,},
    };
    int[][] frameCDAtk = new int[][]{
        {0,0,},
        {0,0,},
    };
    int[][] frameCDDef = new int[][]{
        {0,0,},
        {0,0,},
    };
    int[][] frameCDExt = new int[][]{
        {0,0,},
        {0,0,},
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
final static public void buildImages_BabyMap(IImages stuff)
{
    stuff.buildImages(null, 29);
    for(int i=0;i<29;i++){
        stuff.setTileImage(CIO.loadImage("/BabyMap/tile_"+i+".png"));
        stuff.addTile();
    }
    stuff.gc();
}
final static public void buildClipImages_BabyMap(IImages stuff)
{
    stuff.buildImages(CIO.loadImage("/BabyMap.png"), 29);
    stuff.addTile(0,160,16,16);
    stuff.addTile(0,0,16,16);
    stuff.addTile(16,0,16,16);
    stuff.addTile(0,16,16,16);
    stuff.addTile(16,16,16,16);
    stuff.addTile(0,48,16,16);
    stuff.addTile(16,48,16,16);
    stuff.addTile(0,32,16,16);
    stuff.addTile(16,32,16,16);
    stuff.addTile(16,80,16,16);
    stuff.addTile(0,80,16,16);
    stuff.addTile(0,64,16,16);
    stuff.addTile(16,64,16,16);
    stuff.addTile(0,112,16,16);
    stuff.addTile(16,112,16,16);
    stuff.addTile(0,96,16,16);
    stuff.addTile(16,96,16,16);
    stuff.addTile(0,144,16,16);
    stuff.addTile(16,144,16,16);
    stuff.addTile(0,128,16,16);
    stuff.addTile(16,128,16,16);
    stuff.addTile(16,208,16,16);
    stuff.addTile(0,208,16,16);
    stuff.addTile(16,224,16,16);
    stuff.addTile(0,224,16,16);
    stuff.addTile(0,176,16,16);
    stuff.addTile(16,176,16,16);
    stuff.addTile(0,192,16,16);
    stuff.addTile(16,192,16,16);
    stuff.gc();
}

final static public CMap createMap_BabyMap_unamed_Map(IImages tiles,boolean isAnimate,boolean isCyc)
{
    CAnimates animates = new CAnimates(5,tiles);
    animates.addPart(0,0,0,0);
    animates.addPart(0,0,1,0);
    animates.addPart(0,0,2,0);
    animates.addPart(0,0,3,0);
    animates.addPart(0,0,4,0);
    animates.setFrame(new int[5][]);
    animates.setComboFrame(new int[]{0,},0);
    animates.setComboFrame(new int[]{1,},1);
    animates.setComboFrame(new int[]{2,},2);
    animates.setComboFrame(new int[]{3,},3);
    animates.setComboFrame(new int[]{4,},4);

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
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,1,2,0,0,0,0,0,0,0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,3,4,0,0,0,0,0,0,0,0,0,0,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,4,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,0,0,},
        {0,0,0,0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,4,0,0,0,},
        {0,0,0,0,0,0,0,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
    };
    short[][] flagMatrix = new short[][]{
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
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

class unamed_Level extends CWorld 
{
public CMap Map0000_unamed_Map;
private int Map0000_unamed_Map_X = 0;
private int Map0000_unamed_Map_Y = 0;
public CSprite Spr0001_unamed_Sprite;
private int Spr0001_unamed_Sprite_X = 59;
private int Spr0001_unamed_Sprite_Y = 231;
public CSprite Spr0002_unamed_Sprite;
private int Spr0002_unamed_Sprite_X = 422;
private int Spr0002_unamed_Sprite_Y = 300;
public CSprite Spr0003_unamed_Sprite3;
private int Spr0003_unamed_Sprite3_X = 392;
private int Spr0003_unamed_Sprite3_Y = 248;
public CSprite Spr0004_unamed_Sprite2;
private int Spr0004_unamed_Sprite2_X = 321;
private int Spr0004_unamed_Sprite2_Y = 45;
public void initPath()
{
    WayPoints = new CWayPoint[24];
    WayPoints[0] = new CWayPoint(261,29);
    WayPoints[1] = new CWayPoint(150,10);
    WayPoints[2] = new CWayPoint(33,55);
    WayPoints[3] = new CWayPoint(264,220);
    WayPoints[4] = new CWayPoint(212,87);
    WayPoints[5] = new CWayPoint(123,267);
    WayPoints[6] = new CWayPoint(19,181);
    WayPoints[7] = new CWayPoint(210,191);
    WayPoints[8] = new CWayPoint(344,352);
    WayPoints[9] = new CWayPoint(46,292);
    WayPoints[10] = new CWayPoint(410,58);
    WayPoints[11] = new CWayPoint(186,358);
    WayPoints[12] = new CWayPoint(625,164);
    WayPoints[13] = new CWayPoint(519,78);
    WayPoints[14] = new CWayPoint(470,162);
    WayPoints[15] = new CWayPoint(549,168);
    WayPoints[16] = new CWayPoint(450,338);
    WayPoints[17] = new CWayPoint(597,281);
    WayPoints[18] = new CWayPoint(141,133);
    WayPoints[19] = new CWayPoint(296,283);
    WayPoints[20] = new CWayPoint(323,117);
    WayPoints[21] = new CWayPoint(38,356);
    WayPoints[22] = new CWayPoint(25,21);
    WayPoints[23] = new CWayPoint(425,18);

    WayPoints[0].link(WayPoints[1]);
    WayPoints[0].link(WayPoints[3]);
    WayPoints[0].link(WayPoints[10]);
    WayPoints[0].link(WayPoints[20]);
    WayPoints[1].link(WayPoints[2]);
    WayPoints[1].link(WayPoints[0]);
    WayPoints[1].link(WayPoints[4]);
    WayPoints[1].link(WayPoints[18]);
    WayPoints[2].link(WayPoints[1]);
    WayPoints[2].link(WayPoints[6]);
    WayPoints[2].link(WayPoints[18]);
    WayPoints[2].link(WayPoints[22]);
    WayPoints[3].link(WayPoints[0]);
    WayPoints[3].link(WayPoints[5]);
    WayPoints[3].link(WayPoints[19]);
    WayPoints[3].link(WayPoints[20]);
    WayPoints[3].link(WayPoints[7]);
    WayPoints[4].link(WayPoints[1]);
    WayPoints[4].link(WayPoints[7]);
    WayPoints[4].link(WayPoints[18]);
    WayPoints[5].link(WayPoints[6]);
    WayPoints[5].link(WayPoints[3]);
    WayPoints[5].link(WayPoints[7]);
    WayPoints[5].link(WayPoints[18]);
    WayPoints[5].link(WayPoints[19]);
    WayPoints[5].link(WayPoints[11]);
    WayPoints[6].link(WayPoints[2]);
    WayPoints[6].link(WayPoints[5]);
    WayPoints[6].link(WayPoints[9]);
    WayPoints[6].link(WayPoints[18]);
    WayPoints[7].link(WayPoints[4]);
    WayPoints[7].link(WayPoints[5]);
    WayPoints[7].link(WayPoints[18]);
    WayPoints[7].link(WayPoints[3]);
    WayPoints[8].link(WayPoints[11]);
    WayPoints[8].link(WayPoints[10]);
    WayPoints[8].link(WayPoints[16]);
    WayPoints[8].link(WayPoints[19]);
    WayPoints[8].link(WayPoints[14]);
    WayPoints[9].link(WayPoints[6]);
    WayPoints[9].link(WayPoints[11]);
    WayPoints[9].link(WayPoints[21]);
    WayPoints[10].link(WayPoints[8]);
    WayPoints[10].link(WayPoints[0]);
    WayPoints[10].link(WayPoints[13]);
    WayPoints[10].link(WayPoints[14]);
    WayPoints[10].link(WayPoints[19]);
    WayPoints[10].link(WayPoints[20]);
    WayPoints[11].link(WayPoints[9]);
    WayPoints[11].link(WayPoints[8]);
    WayPoints[11].link(WayPoints[5]);
    WayPoints[12].link(WayPoints[13]);
    WayPoints[12].link(WayPoints[15]);
    WayPoints[12].link(WayPoints[17]);
    WayPoints[13].link(WayPoints[12]);
    WayPoints[13].link(WayPoints[10]);
    WayPoints[13].link(WayPoints[23]);
    WayPoints[14].link(WayPoints[15]);
    WayPoints[14].link(WayPoints[10]);
    WayPoints[14].link(WayPoints[16]);
    WayPoints[14].link(WayPoints[8]);
    WayPoints[15].link(WayPoints[14]);
    WayPoints[15].link(WayPoints[17]);
    WayPoints[15].link(WayPoints[12]);
    WayPoints[16].link(WayPoints[8]);
    WayPoints[16].link(WayPoints[17]);
    WayPoints[16].link(WayPoints[14]);
    WayPoints[17].link(WayPoints[16]);
    WayPoints[17].link(WayPoints[15]);
    WayPoints[17].link(WayPoints[12]);
    WayPoints[18].link(WayPoints[4]);
    WayPoints[18].link(WayPoints[1]);
    WayPoints[18].link(WayPoints[2]);
    WayPoints[18].link(WayPoints[6]);
    WayPoints[18].link(WayPoints[5]);
    WayPoints[18].link(WayPoints[7]);
    WayPoints[19].link(WayPoints[10]);
    WayPoints[19].link(WayPoints[3]);
    WayPoints[19].link(WayPoints[5]);
    WayPoints[19].link(WayPoints[8]);
    WayPoints[20].link(WayPoints[10]);
    WayPoints[20].link(WayPoints[3]);
    WayPoints[20].link(WayPoints[0]);
    WayPoints[21].link(WayPoints[9]);
    WayPoints[22].link(WayPoints[2]);
    WayPoints[23].link(WayPoints[13]);
}
public void initUnit()
{
    addMap(Map0000_unamed_Map);
    try{
    addSprite(Spr0001_unamed_Sprite);
    Spr0001_unamed_Sprite.X = Spr0001_unamed_Sprite_X;
    Spr0001_unamed_Sprite.Y = Spr0001_unamed_Sprite_Y;
    }catch(Exception err){}
    try{
    addSprite(Spr0002_unamed_Sprite);
    Spr0002_unamed_Sprite.X = Spr0002_unamed_Sprite_X;
    Spr0002_unamed_Sprite.Y = Spr0002_unamed_Sprite_Y;
    }catch(Exception err){}
    try{
    addSprite(Spr0003_unamed_Sprite3);
    Spr0003_unamed_Sprite3.X = Spr0003_unamed_Sprite3_X;
    Spr0003_unamed_Sprite3.Y = Spr0003_unamed_Sprite3_Y;
    }catch(Exception err){}
    try{
    addSprite(Spr0004_unamed_Sprite2);
    Spr0004_unamed_Sprite2.X = Spr0004_unamed_Sprite2_X;
    Spr0004_unamed_Sprite2.Y = Spr0004_unamed_Sprite2_Y;
    }catch(Exception err){}
}
}

class TD_Level extends CWorld 
{
public CMap Map0000_unamed_Map;
private int Map0000_unamed_Map_X = 0;
private int Map0000_unamed_Map_Y = 0;
public void initPath()
{
    WayPoints = new CWayPoint[21];
    WayPoints[0] = new CWayPoint(3,40);
    WayPoints[1] = new CWayPoint(469,40);
    WayPoints[2] = new CWayPoint(471,471);
    WayPoints[3] = new CWayPoint(41,470);
    WayPoints[4] = new CWayPoint(41,88);
    WayPoints[5] = new CWayPoint(424,90);
    WayPoints[6] = new CWayPoint(423,420);
    WayPoints[7] = new CWayPoint(86,421);
    WayPoints[8] = new CWayPoint(86,136);
    WayPoints[9] = new CWayPoint(371,134);
    WayPoints[10] = new CWayPoint(374,375);
    WayPoints[11] = new CWayPoint(136,373);
    WayPoints[12] = new CWayPoint(136,185);
    WayPoints[13] = new CWayPoint(324,184);
    WayPoints[14] = new CWayPoint(326,328);
    WayPoints[15] = new CWayPoint(184,324);
    WayPoints[16] = new CWayPoint(185,233);
    WayPoints[17] = new CWayPoint(277,232);
    WayPoints[18] = new CWayPoint(276,278);
    WayPoints[19] = new CWayPoint(229,279);
    WayPoints[20] = new CWayPoint(229,255);

    WayPoints[0].link(WayPoints[1]);
    WayPoints[1].link(WayPoints[2]);
    WayPoints[1].link(WayPoints[0]);
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
    WayPoints[13].link(WayPoints[12]);
    WayPoints[13].link(WayPoints[14]);
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
    addMap(Map0000_unamed_Map);
}
}
