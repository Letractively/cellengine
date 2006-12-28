package samples.bluetooth.demo;
import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 

import java.util.Vector; 

import javax.microedition.io.Connector; 
import javax.microedition.io.StreamConnection; 
import javax.microedition.lcdui.Command; 
import javax.microedition.lcdui.CommandListener; 
import javax.microedition.lcdui.Displayable; 
import javax.microedition.lcdui.Form; 
import javax.microedition.lcdui.Gauge; 
import javax.microedition.lcdui.StringItem; 
import javax.microedition.lcdui.TextField; 

//jsr082 API 
import javax.bluetooth.BluetoothStateException; 

import javax.bluetooth.DeviceClass; 
import javax.bluetooth.DiscoveryAgent; 
import javax.bluetooth.DiscoveryListener; 
import javax.bluetooth.LocalDevice; 
import javax.bluetooth.RemoteDevice; 
import javax.bluetooth.ServiceRecord; 
import javax.bluetooth.UUID; 

/** 
* 客户端GUI 
* @author Jagie 
* 
* TODO To change the template for this generated type comment go to 
* Window - Preferences - Java - Code style - Code Templates 
*/ 
public class ClientBox extends Form implements Runnable, CommandListener, 
       DiscoveryListener { 

    
   //字串输入框 
   TextField input = new TextField(null, "", 50, TextField.ANY); 
   //loger 
   StringItem result = new StringItem("结果:", ""); 

   private DiscoveryAgent discoveryAgent; 

    
   private UUID[] uuidSet; 

   //响应服务的UUID 
   private static final UUID ECHO_SERVER_UUID = new UUID( 
           "F0E0D0C0B0A000908070605040302010", false); 

   //设备集合 
   Vector devices = new Vector(); 
   //服务集合 
   Vector records = new Vector(); 
    
   //服务搜索的事务id集合 
   int[] transIDs; 
   StupidBTMIDlet midlet; 

   public ClientBox(StupidBTMIDlet midlet) { 
       super(""); 
       this.midlet=midlet; 
        
       this.append(result); 
        
       this.addCommand(new Command("取消",Command.CANCEL,1)); 
       this.setCommandListener(this); 
        
       new Thread(this).start(); 
   } 
    
   public void commandAction(Command arg0, Displayable arg1) { 
       if(arg0.getCommandType()==Command.CANCEL){ 
           midlet.showMainMenu(); 
       }else{ 
           //匿名内部Thread，访问远程服务。 
           Thread fetchThread=new Thread(){ 
               public void run(){ 
                   for(int i=0;i<records.size();i++){ 
                       ServiceRecord sr=(ServiceRecord)records.elementAt(i); 
                       if(accessService(sr)){ 
                           //访问到一个可用的服务即可 
                           //break; 
                       } 
                   } 
               } 
           }; 
           fetchThread.start(); 
       } 
        
   } 
    
    
   private boolean  accessService(ServiceRecord sr){ 
       boolean result=false; 
        try { 
           String url = sr.getConnectionURL( 
                   ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false); 
           StreamConnection    conn = (StreamConnection) Connector.open(url); 
            
           DataOutputStream dos=conn.openDataOutputStream(); 
           dos.writeUTF(input.getString()); 
           dos.close(); 
           
           DataInputStream dis=conn.openDataInputStream(); 
           String echo=dis.readUTF(); 
           dis.close(); 
           
           showInfo("反馈结果是:"+echo); 
           result=true; 
            
       } catch (IOException e) { 
            
       } 
       return result; 
   } 

   public synchronized void run() { 
       //发现设备和服务的过程中，给用户以Gauge 
       Gauge g=new Gauge(null,false,Gauge.INDEFINITE,Gauge.CONTINUOUS_RUNNING); 
       this.append(g); 
       showInfo("蓝牙初始化..."); 
       boolean isBTReady = false; 

       try { 

           LocalDevice localDevice = LocalDevice.getLocalDevice(); 
           discoveryAgent = localDevice.getDiscoveryAgent(); 

           isBTReady = true; 
       } catch (Exception e) { 
           e.printStackTrace(); 
       } 

       if (!isBTReady) { 
           showInfo("蓝牙不可用"); 
           //删除Gauge 
           this.delete(1); 
           return; 
       } 

       uuidSet = new UUID[2]; 

       //标志我们的响应服务的UUID集合 
       uuidSet[0] = new UUID(0x1101); 
       uuidSet[1] = ECHO_SERVER_UUID; 


        
       try { 
           discoveryAgent.startInquiry(DiscoveryAgent.GIAC, this); 
       } catch (BluetoothStateException e) { 

       } 

       try { 
           //阻塞,由inquiryCompleted()回调方法唤醒 
           wait(); 
       } catch (InterruptedException e1) { 
            
           e1.printStackTrace(); 
       } 
       showInfo("设备搜索完毕,共找到"+devices.size()+"个设备,开始搜索服务"); 
       transIDs = new int[devices.size()]; 
       for (int i = 0; i < devices.size(); i++) { 
           RemoteDevice rd = (RemoteDevice) devices.elementAt(i); 
           try { 
               //记录每一次服务搜索的事务id 
               transIDs[i] = discoveryAgent.searchServices(null, uuidSet, 
                       rd, this); 
           } catch (BluetoothStateException e) { 
               continue; 
           } 

       } 
        
       try { 
           //阻塞,由serviceSearchCompleted()回调方法在所有设备都搜索完的情况下唤醒 
           wait(); 
       } catch (InterruptedException e1) { 
           e1.printStackTrace(); 
       } 
        
       showInfo("服务搜索完毕,共找到"+records.size()+"个服务,准备发送请求"); 
       if(records.size()>0){ 
           this.append(input); 
           this.addCommand(new Command("发送",Command.OK,0)); 
       } 
        
       //删除Gauge 
       this.delete(1); 
        
   } 
    
   /** 
    * debug 
    * @param s 
    */ 
    
   private void showInfo(String s){ 
       StringBuffer sb=new StringBuffer(result.getText()); 
       if(sb.length()>0){ 
           sb.append("\n"); 
       } 
       sb.append(s); 
       result.setText(sb.toString()); 

   } 
    
   /** 
    * 回调方法 
    */ 

   public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) { 

       if (devices.indexOf(btDevice) == -1) { 
           devices.addElement(btDevice); 
       } 
   } 

   /** 
    * 回调方法，唤醒初始化线程 
    */ 
   public void inquiryCompleted(int discType) { 

       synchronized (this) { 
           notify(); 
       } 
   } 
   /** 
    * 回调方法 
    */ 
   public void servicesDiscovered(int transID, ServiceRecord[] servRecord) { 
       for (int i = 0; i < servRecord.length; i++) { 
           records.addElement(servRecord[i]); 
       } 
   } 
    
   /** 
    * 回调方法，唤醒初始化线程 
    */ 

   public void serviceSearchCompleted(int transID, int respCode) { 
        
       for (int i = 0; i < transIDs.length; i++) { 
           if (transIDs[i] == transID) { 
               transIDs[i] = -1; 
               break; 
           } 
       } 
        
       //如果所有的设备都已经搜索服务完毕，则唤醒初始化线程。 

       boolean finished = true; 
       for (int i = 0; i < transIDs.length; i++) { 
           if (transIDs[i] != -1) { 
               finished = false; 
               break; 
           } 
       } 

       if (finished) { 
           synchronized (this) { 
               notify(); 
           } 
       } 

   } 

} 
