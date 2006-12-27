import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.Game.CScreen;


/**
 * This class will start an L2CAP service that will accept data and print it
 * to standard out.
 */
/**
 * This is the main method of the L2CAP Print Server application.  It will
 * accept connections and print the data received to standard out.
 */
public class ScreenBTServer extends CScreen {

	
	String message = "";
    byte[] data = null;
    int length;
    
    
	public ScreenBTServer(){
		
	}
	
	public void notifyLogic() {
    	if(isKeyDown(KEY_A)){ChangeSubSreen(GameMIDlet.SCREEN_KEY_MAIN2);}
    	if(isKeyDown(KEY_B)){ChangeSubSreen(GameMIDlet.SCREEN_KEY_LOGO);}
    	if(isKeyHold(KEY_0)){GameMIDlet.ExitGame = true;}
    	
    	if(isKeyDown(KEY_A)){
    		
    	}
		
    
	}
	
	public void notifyRender(Graphics g) {
		
	}

	public void notifyPause() {}
	public void notifyResume() {}

}


