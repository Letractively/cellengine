package samples.bluetooth.demo;
import javax.microedition.lcdui.Alert; 
import javax.microedition.lcdui.AlertType; 
import javax.microedition.lcdui.Command; 
import javax.microedition.lcdui.CommandListener; 
import javax.microedition.lcdui.Display; 
import javax.microedition.lcdui.Displayable; 
import javax.microedition.lcdui.List; 
import javax.microedition.midlet.MIDlet; 
import javax.microedition.midlet.MIDletStateChangeException; 

/** 
* @author Jagie 
*  
*  MIDlet 
*/ 
public class StupidBTMIDlet extends MIDlet implements CommandListener { 
   List list; 
   ServerBox sb; 
   ClientBox cb; 
   
   class A implements Runnable {
		public A(){
			run();
		}
		public void run(){
			System.out.println("orginal run()");
		}
	}
  	A a = new A(){
	   public void run(){
		   System.out.println("overwrite run()");
	   }
	};
	
   /* 
    * (non-Javadoc) 
    *  
    * @see javax.microedition.midlet.MIDlet#startApp() 
    */ 
   protected void startApp() throws MIDletStateChangeException { 
       list = new List("傻瓜蓝牙入门", List.IMPLICIT); 
       list.append("Client", null); 
       list.append("Server", null); 
       list.setCommandListener(this); 
       Display.getDisplay(this).setCurrent(list); 

   } 
    
   /** 
    * debug方法 
    * @param s 要显示的字串 
    */ 

   public void showString(String s) { 
       Displayable dp = Display.getDisplay(this).getCurrent(); 
       Alert al = new Alert(null, s, null, AlertType.INFO); 
       al.setTimeout(2000); 
       Display.getDisplay(this).setCurrent(al, dp); 
   } 
    
   /** 
    * 显示主菜单 
    * 
    */ 

   public void showMainMenu() { 
       Display.getDisplay(this).setCurrent(list); 
   } 

    
   protected void pauseApp() { 
       // TODO Auto-generated method stub 

   } 

   public void commandAction(Command com, Displayable disp) { 
       if (com == List.SELECT_COMMAND) { 
           List list = (List) disp; 
           int index = list.getSelectedIndex(); 
           if (index == 1) { 
               if (sb == null) { 
                   sb = new ServerBox(this); 
               } 
               sb.setString(null); 
               Display.getDisplay(this).setCurrent(sb); 
           } else { 
               //每次都生成新的客户端实例 
               cb = null; 
               System.gc(); 
               cb = new ClientBox(this); 

               Display.getDisplay(this).setCurrent(cb); 
           } 
       } 
   } 


   protected void destroyApp(boolean arg0) throws MIDletStateChangeException { 
       // TODO Auto-generated method stub 

   } 

   
} 


