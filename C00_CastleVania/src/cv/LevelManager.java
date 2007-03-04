package cv;

import java.util.Hashtable;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.cell.AScreen;
import com.cell.IImages;
import com.cell.game.CCD;
import com.cell.game.CCamera;
import com.cell.game.CMap;
import com.cell.game.CSprite;
import com.cell.game.CWorld;
import com.cell.hud.CTextBox;

import cv.unit.Unit;
import cv.unit.UnitActor;

import ResesScript;


public class LevelManager extends CWorld {
	
	public String 	WorldName 	= "Entry";
	public Unit 	Actor;
	public int 		ActorX;
	public int 		ActorY;

	public int WindowX;
	public int WindowY;
	public int WindowW;
	public int WindowH;
	
	public int X;
	public int Y;

	public String[]	SprsTile;
	public String[]	SprsType;
	public String[]	SprsInfo;
	public int[]	SprsX;
	public int[] 	SprsY;
	
	public String MapTile;
	public String MapType;
	public String MapInfo;
	public Hashtable UnitTable ;
	
	
	Hashtable TileTable ;
	
	
	Vector UnitTeam0 = new Vector();
	Vector UnitTeam1 = new Vector();
	Vector UnitTeam2 = new Vector();
	
	public boolean 	IsChangeRoom	= false;
	public boolean 	IsChangeLevel	= false;

	// test room scope
	public String getRoom(int x, int y){
		for(int i=ResesScript.WorldRooms.length-1;i>=0;i--){
			if(CCD.cdRectPoint(
					ResesScript.WorldRooms[i].X1, 
					ResesScript.WorldRooms[i].Y1, 
					ResesScript.WorldRooms[i].X2, 
					ResesScript.WorldRooms[i].Y2, 
					x, y)){
				return ResesScript.WorldNames[i];
			}
		}
		return null;
	}
	
	public void initLevel(){
		try{
//		 	create tile bank
			IImages tile;
			for(int i=0;i<SprsTile.length;i++){
				tile = (IImages)TileTable.get(SprsTile[i]);
				if( tile == null ){
					tile = ResesScript.createImages(SprsTile[i]);
					TileTable.put(SprsTile[i], tile);
					println(" create tile : " + SprsTile[i]);
				}
			}
			if(MapTile!=null){
				tile = (IImages)TileTable.get(MapTile);
				if( tile == null ){
					tile = ResesScript.createImages(MapTile);
					TileTable.put(MapTile, tile);
					println(" create tile : " + MapTile);
				}
			}
		}catch(Exception err){
			println(err.getMessage());
			err.printStackTrace();
		}
	}

	public void initRoom(){
//		create sprs 	
		for(int i=0;i<SprsType.length;i++){
			CSprite spr = ResesScript.createSprite(SprsType[i],(IImages)TileTable.get(SprsTile[i]));

			try{
				Unit.SprStuff = spr;
				Unit ai = (Unit)Class.forName(((String)UnitTable.get(SprsType[i]))).newInstance();
				Unit.SprStuff = null;
				
				switch(ai.Team){
				case Unit.TEAM_ACTOR:
					UnitTeam0.addElement(ai);
					Actor = ai;
					ActorX = X;
					ActorY = Y;
					break;
				case Unit.TEAM_ENEMY:
					UnitTeam1.addElement(ai);
					break;
				case Unit.TEAM_ITEM:
					UnitTeam2.addElement(ai);
					break;
				}
				
				ai.Type = SprsType[i];
				ai.Info = SprsInfo[i];
				ai.X = SprsX[i];
				ai.Y = SprsY[i];
				ai.HPos256 = ai.X * 256 ;
				ai.VPos256 = ai.Y * 256 ;
				ai.world = this;
				
				this.addSprite(ai);
				
				print("AI OK : " );
			}catch(Exception err){
				spr.X = SprsX[i];
				spr.Y = SprsY[i];
				spr.HPos256 = spr.X * 256 ;
				spr.VPos256 = spr.Y * 256 ;
				this.addSprite(spr);
				print("Error : " + err.getMessage() + " : ");
			}
			println(SprsType[i] + " -> " + ((String)UnitTable.get(SprsType[i])) + " : " + SprsInfo[i]);
			
		}
//		setup actor world pos
		if( !UnitTeam0.contains(Actor) ){
			Actor.X = ActorX - X;
			Actor.Y = ActorY - Y;
			Actor.HPos256 = Actor.X * 256 ;
			Actor.VPos256 = Actor.Y * 256 ;
			Actor.world = this;
			UnitTeam0.addElement(Actor);
			this.addSprite(Actor);
		}
		
		
//		create map
		CMap map = ResesScript.createMap(MapType, (IImages)TileTable.get(MapTile), true, false);
		this.setMap(map);
		
//		create camera
		WindowX = 0;
		WindowY = 0;
		WindowW = AScreen.SCREEN_WIDTH;
		WindowH = AScreen.SCREEN_HEIGHT;
		
		CCamera camera = new CCamera(
				WindowX,
				WindowY,
				WindowW,
				WindowH,
       			map,true,0xff00ff00);
		this.setCamera(camera);
		
	}
	

	public void update() {
		if(CTextBox.isShown()){
			if(!CTextBox.isTransition()){
				if(AScreen.isKeyDown(AScreen.KEY_ANY)){
					if(CTextBox.vScroll(CTextBox.getTextHeight())){
						CTextBox.closeTextBox();
					}
				}
			}
		}else{
			processCamera();
			processActorDamage();
			super.update();
		}
	}
	

	public void render(Graphics g) {
		super.render(g);
		CTextBox.render(g);
	}
	
	
	private void processCamera(){
		//���������
		int cdx = Actor.X - (getCamera().getX() + getCamera().getWidth() /2);
    	int cdy = Actor.Y - (getCamera().getY() + getCamera().getHeight()/2);
    	getCamera().mov(cdx/4,cdy/4);
    	//�����Ƿ����
    	IsChangeRoom = false;
    	if(!CCD.cdRectPoint(X, Y, X+Width, Y+Height, X+Actor.X, Y+Actor.Y - 12)){
    		WorldName = getRoom(X+Actor.X, Y+Actor.Y - 12);
    		if(WorldName!=null){
    			println("Change Room : " + WorldName);
    			IsChangeRoom = true;
    		}else{
    			println("Out Room : ");
    		}
    	}
	}
	
	private void processActorDamage(){
		
		// ����1�Ӻ�������ײ
		for(int i=UnitTeam1.size()-1;i>=0;i--){
			Unit t0 = Actor;
			Unit t1 = (Unit)UnitTeam1.elementAt(i);
			if( t0.OnScreen && t1.OnScreen && //
				t0.Active   && t1.Active   ){ //
				
				if(CSprite.touch_Spr_Spr(
						t0, CSprite.CD_TYPE_ATK, 
						t1, CSprite.CD_TYPE_DEF )){
					t0.attack(t1);
					t1.damage(t0);
				}
				
				if(CSprite.touch_Spr_Spr(
						t1, CSprite.CD_TYPE_ATK, 
						t0, CSprite.CD_TYPE_DEF )){
					t1.attack(t0);
					t0.damage(t1);
				}
			}
		}
		//  ����2�Ӻ�������ײ
		for(int i=UnitTeam2.size()-1;i>=0;i--){
			Unit t0 = Actor;
			Unit t1 = (Unit)UnitTeam2.elementAt(i);
			
			if( t0.OnScreen && t1.OnScreen && //
				t0.Active   && t1.Active   ){ //
				
				if(CSprite.touch_Spr_Spr(
						t1, CSprite.CD_TYPE_ATK, 
						t0, CSprite.CD_TYPE_DEF )){
					t1.attack(t0);
					t0.damage(t1);
				}
			}
		}
	}

	public void showMessage(String msg,Image icon,boolean isLeft){
		if(icon!=null){
			CTextBox.IconX = isLeft ? 0 : getCamera().getWidth() - icon.getWidth();
			CTextBox.IconY = -icon.getHeight();
		}
		CTextBox.showTextBox(
				msg, 
				icon, 
				getCamera().WindowX, 
				getCamera().WindowY + getCamera().getHeight()*3/4, 
				getCamera().getWidth(), 
				getCamera().getHeight()/4
				);
	}
	
}



