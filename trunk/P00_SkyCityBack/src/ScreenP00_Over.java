import game.unit.world.UnitWorldActor;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.cell.AScreen;
import com.cell.CIO;
import com.cell.CMath;
import com.cell.CSoundPlayer;
import com.cell.IImages;
import com.cell.game.CCamera;
import com.cell.game.CMap;
import com.cell.game.CSprite;
import com.cell.game.CWorld;
import com.cell.gui.CTextBox;


public class ScreenP00_Over extends AScreen {

	String Text = 
		"通关通关通关通关通关通" +
		"关通关通关通关通关通关" +
		"通关通关通关通关通关通" +
		"关通关通关通关通关通关" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"通关通关通关通关通关通" +
		"关通关通关通关通关\n" +
		"(按任意键继续)";
	
    
	Image title;
	
	public ScreenP00_Over() {
		if(GameMIDlet.soundman!=null){
			GameMIDlet.soundman.destroy();
		}
		
		try{
			GameMIDlet.soundman = new CSoundPlayer("/BGMUI.mid",CSoundPlayer.TYPE_MIDI,-1);
			GameMIDlet.soundman.play();
		}catch(Exception err){
		}
		
		FrameDelay = 20;
		KeyEnable = true;
		LogicEnable = true;
		RenderEnable = true;

		
		title = CIO.loadImage("/over.png");
		
		CTextBox.setTextBox(
				Text, 
				null, 
				0, 
				title.getHeight(), 
				SCREEN_WIDTH, 
				SCREEN_HEIGHT - title.getHeight()
				);
		
	}

	public void notifyLogic() {
		
		if(CTextBox.vScroll(1)){
			if(isKeyDown(KEY_ANY)){
				CTextBox.closeTextBox();
				ChangeSubScreen("ScreenP00_Menu");
			}
		}

	}

	public void notifyRender(Graphics g) {
		clearScreenAndClip(g, 0xffffffff);
		g.drawImage(
				title, 
				SCREEN_WIDTH/2-title.getWidth()/2, 
				0, 
				0);
		CTextBox.showTextBox(g);
	}

	  
	public void notifyPause(){ 
		try{
			GameMIDlet.soundman.pause();
		}catch(Exception err){
		}
	}
	public void notifyResume() {
		try{
			GameMIDlet.soundman.resume();
		}catch(Exception err){
		}
	}

}
