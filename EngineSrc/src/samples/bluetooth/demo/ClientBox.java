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
* �ͻ���GUI 
* @author Jagie 
* 
* TODO To change the template for this generated type comment go to 
* Window - Preferences - Java - Code style - Code Templates 
*/ 
public class ClientBox extends Form implements Runnable, CommandListener, 
       DiscoveryListener { 

    
   //�ִ������ 
   TextField input = new TextField(null, "", 50, TextField.ANY); 
   //loger 
   StringItem result = new StringItem("���:", ""); 

   private DiscoveryAgent discoveryAgent; 

    
   private UUID[] uuidSet; 

   //��Ӧ�����UUID 
   private static final UUID ECHO_SERVER_UUID = new UUID( 
           "F0E0D0C0B0A000908070605040302010", false); 

   //�豸���� 
   Vector devices = new Vector(); 
   //���񼯺� 
   Vector records = new Vector(); 
    
   //��������������id���� 
   int[] transIDs; 
   StupidBTMIDlet midlet; 

   public ClientBox(StupidBTMIDlet midlet) { 
       super(""); 
       this.midlet=midlet; 
        
       this.append(result); 
        
       this.addCommand(new Command("ȡ��",Command.CANCEL,1)); 
       this.setCommandListener(this); 
        
       new Thread(this).start(); 
   } 
    
   public void commandAction(Command arg0, Displayable arg1) { 
       if(arg0.getCommandType()==Command.CANCEL){ 
           midlet.showMainMenu(); 
       }else{ 
           //�����ڲ�Thread������Զ�̷��� 
           Thread fetchThread=new Thread(){ 
               public void run(){ 
                   for(int i=0;i<records.size();i++){ 
                       ServiceRecord sr=(ServiceRecord)records.elementAt(i); 
                       if(accessService(sr)){ 
                           //���ʵ�һ�����õķ��񼴿� 
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
           
           showInfo("���������:"+echo); 
           result=true; 
            
       } catch (IOException e) { 
            
       } 
       return result; 
   } 

   public synchronized void run() { 
       //�����豸�ͷ���Ĺ����У����û���Gauge 
       Gauge g=new Gauge(null,false,Gauge.INDEFINITE,Gauge.CONTINUOUS_RUNNING); 
       this.append(g); 
       showInfo("������ʼ��..."); 
       boolean isBTReady = false; 

       try { 

           LocalDevice localDevice = LocalDevice.getLocalDevice(); 
           discoveryAgent = localDevice.getDiscoveryAgent(); 

           isBTReady = true; 
       } catch (Exception e) { 
           e.printStackTrace(); 
       } 

       if (!isBTReady) { 
           showInfo("����������"); 
           //ɾ��Gauge 
           this.delete(1); 
           return; 
       } 

       uuidSet = new UUID[2]; 

       //��־���ǵ���Ӧ�����UUID���� 
       uuidSet[0] = new UUID(0x1101); 
       uuidSet[1] = ECHO_SERVER_UUID; 


        
       try { 
           discoveryAgent.startInquiry(DiscoveryAgent.GIAC, this); 
       } catch (BluetoothStateException e) { 

       } 

       try { 
           //����,��inquiryCompleted()�ص��������� 
           wait(); 
       } catch (InterruptedException e1) { 
            
           e1.printStackTrace(); 
       } 
       showInfo("�豸�������,���ҵ�"+devices.size()+"���豸,��ʼ��������"); 
       transIDs = new int[devices.size()]; 
       for (int i = 0; i < devices.size(); i++) { 
           RemoteDevice rd = (RemoteDevice) devices.elementAt(i); 
           try { 
               //��¼ÿһ�η�������������id 
               transIDs[i] = discoveryAgent.searchServices(null, uuidSet, 
                       rd, this); 
           } catch (BluetoothStateException e) { 
               continue; 
           } 

       } 
        
       try { 
           //����,��serviceSearchCompleted()�ص������������豸�������������»��� 
           wait(); 
       } catch (InterruptedException e1) { 
           e1.printStackTrace(); 
       } 
        
       showInfo("�����������,���ҵ�"+records.size()+"������,׼����������"); 
       if(records.size()>0){ 
           this.append(input); 
           this.addCommand(new Command("����",Command.OK,0)); 
       } 
        
       //ɾ��Gauge 
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
    * �ص����� 
    */ 

   public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) { 

       if (devices.indexOf(btDevice) == -1) { 
           devices.addElement(btDevice); 
       } 
   } 

   /** 
    * �ص����������ѳ�ʼ���߳� 
    */ 
   public void inquiryCompleted(int discType) { 

       synchronized (this) { 
           notify(); 
       } 
   } 
   /** 
    * �ص����� 
    */ 
   public void servicesDiscovered(int transID, ServiceRecord[] servRecord) { 
       for (int i = 0; i < servRecord.length; i++) { 
           records.addElement(servRecord[i]); 
       } 
   } 
    
   /** 
    * �ص����������ѳ�ʼ���߳� 
    */ 

   public void serviceSearchCompleted(int transID, int respCode) { 
        
       for (int i = 0; i < transIDs.length; i++) { 
           if (transIDs[i] == transID) { 
               transIDs[i] = -1; 
               break; 
           } 
       } 
        
       //������е��豸���Ѿ�����������ϣ����ѳ�ʼ���̡߳� 

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
