package samples.bluetooth.demo;
import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 

import java.util.Vector; 

import javax.bluetooth.DiscoveryAgent; 
import javax.bluetooth.LocalDevice; 
import javax.bluetooth.ServiceRecord; 
import javax.bluetooth.UUID; 
import javax.microedition.io.Connector; 
import javax.microedition.io.StreamConnection; 
import javax.microedition.io.StreamConnectionNotifier; 

import javax.microedition.lcdui.Command; 
import javax.microedition.lcdui.CommandListener; 
import javax.microedition.lcdui.Displayable; 

import javax.microedition.lcdui.TextBox; 
import javax.microedition.lcdui.TextField; 

/** 
* 服务端GUI 
* @author Jagie 
* 
* TODO To change the template for this generated type comment go to 
* Window - Preferences - Java - Code style - Code Templates 
*/ 
public class ServerBox extends TextBox implements Runnable, CommandListener { 

   Command com_pub = new Command("开启服务", Command.OK, 0); 

   Command com_cancel = new Command("终止服务", Command.CANCEL, 0); 

   Command com_back = new Command("返回", Command.BACK, 1); 

   LocalDevice localDevice; 

   StreamConnectionNotifier notifier; 

   ServiceRecord record; 

   boolean isClosed; 

   ClientProcessor processor; 

   StupidBTMIDlet midlet; 
   //响应服务的uuid 
   private static final UUID ECHO_SERVER_UUID = new UUID( 
           "F0E0D0C0B0A000908070605040302010", false); 

   public ServerBox(StupidBTMIDlet midlet) { 
       super(null, "", 500, TextField.ANY); 
       this.midlet = midlet; 
       this.addCommand(com_pub); 
       this.addCommand(com_back); 
       this.setCommandListener(this); 
   } 


   public void run() { 
       boolean isBTReady = false; 

       try { 

           localDevice = LocalDevice.getLocalDevice(); 

           if (!localDevice.setDiscoverable(DiscoveryAgent.GIAC)) { 
               showInfo("无法设置设备发现模式"); 
               return; 
           } 

           // prepare a URL to create a notifier 
           StringBuffer url = new StringBuffer("btspp://"); 

           // indicate this is a server 
           url.append("localhost").append(':'); 

           // add the UUID to identify this service 
           url.append(ECHO_SERVER_UUID.toString()); 

           // add the name for our service 
           url.append(";name=Echo Server"); 

           // request all of the client not to be authorized 
           // some devices fail on authorize=true 
           url.append(";authorize=false"); 

           // create notifier now 
           notifier = (StreamConnectionNotifier) Connector 
                   .open(url.toString()); 

           record = localDevice.getRecord(notifier); 

           // remember we've reached this point. 
           isBTReady = true; 
       } catch (Exception e) { 
           e.printStackTrace(); 
            
       } 

       // nothing to do if no bluetooth available 
       if (isBTReady) { 
           showInfo("初始化成功，等待连接"); 
           this.removeCommand(com_pub); 
           this.addCommand(com_cancel); 
       } else { 
           showInfo("初始化失败,退出"); 
           return; 

       } 

       // 生成服务端服务线程对象 
       processor = new ClientProcessor(); 

       // ok, start accepting connections then 
       while (!isClosed) { 
           StreamConnection conn = null; 

           try { 
               conn = notifier.acceptAndOpen(); 
           } catch (IOException e) { 
               // wrong client or interrupted - continue anyway 
               continue; 
           } 
           processor.addConnection(conn); 
       } 

   } 

   public void publish() { 
       isClosed = false; 
       this.setString(null); 
       new Thread(this).start(); 

   } 

   public void cancelService() { 
       isClosed = true; 
       showInfo("服务终止"); 
       this.removeCommand(com_cancel); 
       this.addCommand(com_pub); 
   } 

   /* 
    * (non-Javadoc) 
    *  
    * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, 
    *      javax.microedition.lcdui.Displayable) 
    */ 
   public void commandAction(Command arg0, Displayable arg1) { 
       if (arg0 == com_pub) { 
           //发布service 
           publish(); 
       } else if (arg0 == com_cancel) { 
           cancelService(); 
       } else { 
           cancelService(); 
           midlet.showMainMenu(); 
       } 

   } 
    
   /** 
    * 内部类，服务端服务线程。 
    * @author Jagie 
    * 
    * TODO To change the template for this generated type comment go to 
    * Window - Preferences - Java - Code style - Code Templates 
    */ 
   private class ClientProcessor implements Runnable { 
       private Thread processorThread; 

       private Vector queue = new Vector(); 

       private boolean isOk = true; 

       ClientProcessor() { 
           processorThread = new Thread(this); 
           processorThread.start(); 
       } 

       public void run() { 
           while (!isClosed) { 

               synchronized (this) {
                   if (queue.size() == 0) {
                       try { 
                           //阻塞，直到有新客户连接 
                           wait(); 
                       } catch (InterruptedException e) { 

                       }
                   }
               }
                
               //处理连接队列 

               StreamConnection conn; 

               synchronized (this) { 

                   if (isClosed) { 
                       return; 
                   } 
                   conn = (StreamConnection) queue.firstElement(); 
                   queue.removeElementAt(0); 
                   processConnection(conn); 
               } 
           } 
       } 
        
       /** 
        * 往连接队列添加新连接，同时唤醒处理线程 
        * @param conn 
        */ 

       void addConnection(StreamConnection conn) { 
           synchronized (this) { 
               queue.addElement(conn); 
               notify(); 
           } 
       } 

   } 

   /** 
    * 从StreamConnection读取输入 
    * @param conn 
    * @return 
    */ 
   private String readInputString(StreamConnection conn) { 
       String inputString = null; 

       try { 

           DataInputStream dis = conn.openDataInputStream(); 
           inputString = dis.readUTF(); 
           dis.close(); 
       } catch (Exception e) { 
           e.printStackTrace(); 
       } 
       return inputString; 
   } 
    
   /** 
    * debug 
    * @param s 
    */ 

   private void showInfo(String s) { 
       StringBuffer sb = new StringBuffer(this.getString()); 
       if (sb.length() > 0) { 
           sb.append("\n"); 
       } 

       sb.append(s); 
       this.setString(sb.toString()); 

   } 
    

   /** 
    * 处理客户端连接 
    * @param conn 
    */     
   private void processConnection(StreamConnection conn) { 

       // 读取输入 
       String inputString = readInputString(conn); 
       //生成响应 
       String outputString = inputString.toUpperCase(); 
       //输出响应 
       sendOutputData(outputString, conn); 

       try { 
           conn.close(); 
       } catch (IOException e) { 
       } // ignore 
       showInfo("客户端输入:" + inputString + ",已成功响应!"); 
   } 
    
   /** 
    * 输出响应 
    * @param outputData 
    * @param conn 
    */ 

   private void sendOutputData(String outputData, StreamConnection conn) { 

       try { 
           DataOutputStream dos = conn.openDataOutputStream(); 
           dos.writeUTF(outputData); 
           dos.close(); 
       } catch (IOException e) { 
       } 

   } 
} 
