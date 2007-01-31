package cv;

import java.util.Hashtable;

import com.cell.CImages20;
import com.cell.IImages;
import com.cell.game.CCamera;
import com.cell.game.CMap;
import com.cell.game.CSprite;
import com.cell.game.CWorld;

import cv.unit.UnitActor;

import ResesScript;


public class LevelManager extends CWorld {
	
	public String WorldName;
	
	public int WindowX;
	public int WindowY;
	public int WindowW;
	public int WindowH;
	
	public String[]	SprsTile;
	public String[]	SprsType;
	public String[]	SprsInfo;
	public int[]	SprsX;
	public int[] 	SprsY;
	
	public String MapTile;
	public String MapType;
	public String MapInfo;

//	Hashtable SpritesTable = new Hashtable();
	
	public void init(){
		try{
//		 create tile bank
		Hashtable tileTable = new Hashtable();
		for(int i=0;i<SprsTile.length;i++){
			if(!tileTable.containsKey(SprsTile[i])){
				IImages tile = new CImages20();
				ResesScript.buildImages(SprsTile[i], tile);
				tileTable.put(SprsTile[i], tile);
				println(" create tile : " + SprsTile[i]);
			}
		}
		if(!tileTable.contains(MapTile)){
			IImages tile = new CImages20();
			ResesScript.buildImages(MapTile, tile);
			tileTable.put(MapTile, tile);
			println(" create tile : " + MapTile);
		}
		
//		create sprs 	
		Hashtable sprTable = new Hashtable();
		for(int i=0;i<SprsType.length;i++){
			if(!sprTable.containsKey(SprsType[i])){
				CSprite spr = ResesScript.createSprite(SprsType[i],(IImages)tileTable.get(SprsTile[i]));
				sprTable.put(SprsType[i], spr);
				println(" create sprite : " + SprsType[i]);
			}
			
			CSprite obj = new UnitActor((CSprite)sprTable.get(SprsType[i]));
			obj.X = SprsX[i];
			obj.Y = SprsY[i];
			obj.HPos256 = obj.X * 256 ;
			obj.VPos256 = obj.Y * 256 ;
			this.addSprite(obj);
		}

//		create map
		CMap map = ResesScript.createMap(MapType, (IImages)tileTable.get(MapTile), true, false);
		this.setMap(map);
		
//		create camera
		CCamera camera = new CCamera(
				WindowX,
				WindowY,
				WindowW,
				WindowH,
       			map,true,0xff00ff00);
		this.setCamera(camera);
		
		}catch(Exception err){
			println(err.getMessage());
			err.printStackTrace();
		}
	}

	public void update() {
		super.update();
	}
	
	
	
}



