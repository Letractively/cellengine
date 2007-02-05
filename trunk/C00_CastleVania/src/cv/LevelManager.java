package cv;

import java.util.Hashtable;
import java.util.Vector;

import com.cell.AScreen;
import com.cell.CImages20;
import com.cell.IImages;
import com.cell.game.CCamera;
import com.cell.game.CMap;
import com.cell.game.CSprite;
import com.cell.game.CWorld;

import cv.unit.Unit;
import cv.unit.UnitActor;
import cv.unit.SprStuff;
import cv.unit.UnitZombi;

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

	Hashtable UnitTable;
	
	Vector UnitTeam0 = new Vector();
	Vector UnitTeam1 = new Vector();
	
	public void init(Hashtable unitTable){
		try{
		UnitTable = unitTable;
			
//		 create tile bank
		IImages tile;
		Hashtable tileTable = new Hashtable();
		for(int i=0;i<SprsTile.length;i++){
			tile = (IImages)tileTable.get(SprsTile[i]);
			if( tile == null ){
				tile = ResesScript.createImages(SprsTile[i]);
				tileTable.put(SprsTile[i], tile);
				println(" create tile : " + SprsTile[i]);
			}
		}
		tile = (IImages)tileTable.get(MapTile);
		if( tile == null ){
			tile = ResesScript.createImages(MapTile);
			tileTable.put(MapTile, tile);
			println(" create tile : " + MapTile);
		}
		
//		create sprs 	
//		Hashtable sprTable = new Hashtable();
		for(int i=0;i<SprsType.length;i++){
//			CSprite spr = (CSprite)sprTable.get(SprsType[i]);
//			if( spr == null ){
//				spr = ResesScript.createSprite(SprsType[i],(IImages)tileTable.get(SprsTile[i]));
//				sprTable.put(SprsType[i], spr);
//				println(" create sprite : " + SprsType[i]);
//			}
			CSprite  spr = ResesScript.createSprite(SprsType[i],(IImages)tileTable.get(SprsTile[i]));
			SprStuff obj = new SprStuff(spr);
			obj.X = SprsX[i];
			obj.Y = SprsY[i];
			obj.HPos256 = obj.X * 256 ;
			obj.VPos256 = obj.Y * 256 ;
			
			try{
				Unit ai = (Unit)Class.forName(((String)UnitTable.get(SprsType[i]))).newInstance();
				ai.init(obj, SprsType[i], SprsInfo[i]);
				switch(ai.Team){
				case 0:UnitTeam0.addElement(ai);break;
				case 1:UnitTeam1.addElement(ai);break;
				}
				print("AI OK : " );
			}catch(Exception err){
				print("Error : " + err.getMessage() + " : ");
			}
			println(SprsType[i] + " -> " + ((String)UnitTable.get(SprsType[i])) + " : " + SprsInfo[i]);
			
			
			
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
		for(int i=UnitTeam0.size()-1;i>=0;i--){
			for(int j=UnitTeam1.size()-1;j>=0;j--){
				Unit t0 = (Unit)UnitTeam0.elementAt(i);
				Unit t1 = (Unit)UnitTeam1.elementAt(j);
				
				if( t0.Spr.OnScreen && t1.Spr.OnScreen && //
					t0.Spr.Active   && t1.Spr.Active   ){ //
					if(CSprite.touch_Spr_Spr(
							t0.Spr, CSprite.CD_TYPE_ATK, 
							t1.Spr, CSprite.CD_TYPE_DEF )){
						t0.attack(t1);
						t1.damage(t0);
					}
					
					if(CSprite.touch_Spr_Spr(
							t1.Spr, CSprite.CD_TYPE_ATK, 
							t0.Spr, CSprite.CD_TYPE_DEF )){
						t1.attack(t0);
						t0.damage(t1);
					}
				}
			}
		}
		
		super.update();
	}
	
	
	
}



