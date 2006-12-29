
import java.util.Random;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.CMath;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.ParticleSystem.CParticle;
import com.morefuntek.cell.ParticleSystem.CParticleSystem;
import com.morefuntek.cell.ParticleSystem.IParticleLauncher;



//import csLib.CSGraphics;
//import csLib.CSSprite;
//import csLib.CSUtil;

/*
 * ’≈“Ì∑…
 * Created on 2006-2-13
 *
 */

/*#_DEBUG#*///<vorb-local>

/*#_DEBUG#*///<vorb-local>

class MyParticleLauncher implements IParticleLauncher {
	final static public int Div = 256 ;
	
	final static public int TYPE_HOLD 		= 0;
	final static public int TYPE_DIFFUSE 	= 1;
	final static public int TYPE_CONTRACT	= 2;
	final static public int TYPE_GFORCE		= 3;
	final static public int TYPE_EXP		= 4;
	final static public int TYPE_RAISE		= 5;
	final static public int TYPE_RANDOM		= 6;
	final static public int TYPE_GRAVITY	= 7;
	
	final static public int TYPECOUNT = 8 ;
	
	static public int Type = 1 ;
	//
	Random random = new Random();
	
	int Gravity = 32 ;

	public void particleTerminated(CParticle particle, int id) {
		//System.out.println(id+" is Terminated !");
	}
	
	public void particleEmitted(CParticle particle, int id) {
		particle.TerminateTime = 32;
		particle.Color = 255;
		particle.Timer = 0;
		
		if(AScreen.isKeyDown(AScreen.KEY_ANY)){
			particle.X = AScreen.SCREEN_HCENTER * Div;
			particle.Y = AScreen.SCREEN_VCENTER * Div;
		}
		if(AScreen.isPointerHold()){
			particle.X = AScreen.getPointerX() * Div;
			particle.Y = AScreen.getPointerY() * Div;
		}
		
		particle.SpeedX = 0;
		particle.SpeedY = 0;
		particle.AccX = 0;
		particle.AccY = 0;
		
		int angle = random.nextInt();

		switch(Type){
		case TYPE_CONTRACT:
			particle.X += CMath.sinTimes256(id*10 + angle)*32;
			particle.Y += CMath.cosTimes256(id*10 + angle)*32;
			particle.SpeedX = -CMath.sinTimes256(id*10 + angle);
			particle.SpeedY = -CMath.cosTimes256(id*10 + angle);
			break;
		case TYPE_DIFFUSE:
			particle.SpeedX = CMath.sinTimes256(id*10 + angle);
			particle.SpeedY = CMath.cosTimes256(id*10 + angle);
			break;
		case TYPE_EXP:
			particle.SpeedX = CMath.sinTimes256(id*10 + angle)*4;
			particle.SpeedY = CMath.cosTimes256(id*10 + angle)*4;
			particle.AccX = -CMath.sinTimes256(id*10 + angle)/8;
			particle.AccY = -CMath.cosTimes256(id*10 + angle)/8;
			break;
		case TYPE_GRAVITY:
			particle.SpeedX = CMath.sinTimes256(id*10 + angle)*2;
			particle.SpeedY = CMath.cosTimes256(id*10 + angle)*2;
			particle.AccX = -CMath.sinTimes256(id*10 + angle)/8;
			particle.AccY = -CMath.cosTimes256(id*10 + angle)/8;
			break;
		case TYPE_GFORCE:
			particle.SpeedX = CMath.sinTimes256(id*10 + angle);
			particle.SpeedY = CMath.cosTimes256(id*10 + angle);
			particle.AccY = Gravity;
			break;
		case TYPE_HOLD:
			break;
		case TYPE_RAISE:
			particle.X += CMath.sinTimes256(id*10 + angle)*16;
			particle.Y += CMath.cosTimes256(id*10 + angle)*16;
			particle.AccY = -Gravity;
			break;
		case TYPE_RANDOM:
			particle.X += CMath.sinTimes256(id*10 + angle)*16;
			particle.Y += CMath.cosTimes256(id*10 + angle)*16;
			break;
		}
	}

	public void particleAffected(CParticle particle, int id) {
		particle.Color -= 255 / particle.TerminateTime;
		if(particle.Color<0)particle.Color = 0;
		particle.SpeedX += particle.AccX;
		particle.SpeedY += particle.AccY;
		particle.Y += particle.SpeedY;
		particle.X += particle.SpeedX;
	}
	
	public void particleRender(Graphics g, CParticle particle, int id) {
		
		int color = particle.Color;
		int size = particle.Timer / 2;
		int X = particle.X / Div ;
		int Y = particle.Y / Div ;
		
		// color
		g.setColor(0xff000000 
				| (color<<16) 
				//| (color<<8 )
				//| (color<<0 ) 
				);
		// draw
		g.drawArc(
				X - size/2, 
				Y - size/2,
				size, 
				size, 
				0, 360);

	}
}


class ParticleLauncherRain implements IParticleLauncher {
	final static public int Div = 256 ;
	//
	final public int TYPE_LIPPER	= 0;
	final public int TYPE_RAINDROP	= 1;
	
	
	Random random = new Random();
	
	int WindSpeed = Div * 2;
	int Gravity = Div * 16 ;
	
	int Width = AScreen.SCREEN_WIDTH ;
	int Height = AScreen.SCREEN_HEIGHT ;

	public void particleTerminated(CParticle particle, int id) {
		
	}
	
	public void particleEmitted(CParticle particle, int id) {
		particle.TerminateTime = 32;
		particle.Color = 255;
		particle.Timer = 0;
		
		particle.Category = Math.abs(random.nextInt()%3);
		
		if(particle.Category!=0)particle.Category = TYPE_RAINDROP;
		
		switch(particle.Category){
		case TYPE_RAINDROP:
			particle.X = Math.abs(random.nextInt()) % Width * Div;
			particle.Y = random.nextInt() % Height * Div;
			
			particle.SpeedX = WindSpeed;
			particle.SpeedY = Gravity;
			particle.AccX = WindSpeed;
			particle.AccY = Gravity;
			break;
		case TYPE_LIPPER:
			particle.X = Math.abs(random.nextInt()) % Width * Div;
			particle.Y = Math.abs(random.nextInt()) % Height * Div;
			break;
		}

	}

	public void particleAffected(CParticle particle, int id) {
		particle.Color -= 255 / particle.TerminateTime;
		if(particle.Color<0)particle.Color = 0;
		
		switch(particle.Category){
		case TYPE_RAINDROP:
			particle.Y += particle.SpeedY;
			particle.X += particle.SpeedX;
			break;
		case TYPE_LIPPER:
			break;
		}

	}
	
	public void particleRender(Graphics g, CParticle particle, int id) {
		
		int color = particle.Color;
		
		int X = particle.X / Div ;
		int Y = particle.Y / Div ;

		// color
		g.setColor(0xff000000 | 
				(color<<16) |
				(color<<8 ) |
				(color<<0 ) 
				);
		
		switch(particle.Category){
		case TYPE_RAINDROP:
			int X2 = (particle.X+particle.AccX) / Div  ;
			int Y2 = (particle.Y+particle.AccY) / Div  ;
			g.drawLine(X, Y, X2, Y2);
			break;
		case TYPE_LIPPER:
			int size = particle.Timer ;
			g.drawArc(X - size/2, Y - size/2, size, size, 0, 360);
			break;
		}

		
	}
}

class ParticleLauncherSnow implements IParticleLauncher  {

	final static public int Div = 256 ;
	//

	Random random = new Random();
	
	int SizeScope = Div * 4 ;
	int WaveScope = Div * 1 ;
	
	int WindSpeed = Div * 1;
	int Gravity = Div * 2 ;
	
	int Width = AScreen.SCREEN_WIDTH ;
	int Height = AScreen.SCREEN_HEIGHT ;

	public void particleTerminated(CParticle particle, int id) {
		
	}
	
	public void particleEmitted(CParticle particle, int id) {
		particle.TerminateTime = 32;
		particle.Color = 255;
		particle.Timer = 0;
		
		particle.Category = Math.abs(random.nextInt()%3);
		
		//if(particle.Category!=0)particle.Category = TYPE_RAINDROP;
		
		particle.X = random.nextInt() % Width  * Div  + Width/2;
		particle.Y = random.nextInt() % Height * Div;
		
		particle.SpeedX = WindSpeed + Math.abs(random.nextInt())%WaveScope;
		particle.SpeedY = Gravity + Math.abs(random.nextInt())%Gravity;

	}

	public void particleAffected(CParticle particle, int id) {
		particle.Color -= 255 / particle.TerminateTime;
		if(particle.Color<0)particle.Color = 0;
		
		particle.Y += particle.SpeedY;
		particle.X += particle.SpeedX;

	}
	
	public void particleRender(Graphics g, CParticle particle, int id) {
		
		int color = particle.Color;
		int size = 4 ;
		int X = particle.X / Div ;
		int Y = particle.Y / Div ;

		// color
		g.setColor(0xff000000 | 
				(color<<16) |
				(color<<8 ) |
				(color<<0 ) 
				);
		g.fillArc(X - size/2, Y - size/2, size, size, 0, 360);

		
	}

}

/**
 * @author ’≈“Ì∑…
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ScreenMain extends AScreen {
	Random random = new Random();
	// particle system
	int SpawnCount = 1 ;
	CParticleSystem myParticleSystem ;
	
	int Weather = 0;
	String WeatherType [] = new String[]{
		"None",
		"Rain",
		"Snow"
	};
	
	CParticleSystem rain ;
	CParticleSystem snow;

    public ScreenMain(){
       	resetTimer();

       	// my define particle
       	CParticle[] particles = new CParticle[128];
       	for(int i=0;i<particles.length;i++){
       		particles[i] = new CParticle();
       	}
       	MyParticleLauncher launcher = new MyParticleLauncher();
       	myParticleSystem = new CParticleSystem(particles,launcher);
       	// rain
    	CParticle[] particlesRain = new CParticle[128];
       	for(int i=0;i<particlesRain.length;i++){
       		particlesRain[i] = new CParticle();
       	}
       	ParticleLauncherRain launcherRain = new ParticleLauncherRain();
       	rain = new CParticleSystem(particlesRain,launcherRain);
       	// snow
    	CParticle[] particlesSnow = new CParticle[128];
       	for(int i=0;i<particlesSnow.length;i++){
       		particlesSnow[i] = new CParticle();
       	}
       	ParticleLauncherSnow launcherSnow = new ParticleLauncherSnow();
       	snow = new CParticleSystem(particlesSnow,launcherSnow);

    }

    public void notifyLogic() {
    	if(isKeyDown(KEY_STAR)) {FrameDelay --;}
        if(isKeyDown(KEY_SHARP)){FrameDelay ++;}
    	if(isKeyDown(KEY_A)){ChangeSubSreen(this.getClass().getName());}
    	if(isKeyDown(KEY_B)){ChangeSubSreen("ScreenLogo");}
    	if(isKeyHold(KEY_0)){GameMIDlet.ExitGame = true;}
    	
    	if(SpawnCount>0){
    		if(isPointerHold()){
        	 	myParticleSystem.spawn(SpawnCount, 0, 0);
        	}
        	if(isKeyHold(KEY_5)){
        	 	myParticleSystem.spawn(SpawnCount, 0, 0);
        	}
        	myParticleSystem.update();
        	switch(Weather){
        	case 1:
        		rain.spawn(SpawnCount, 0, 0);
            	rain.update();
            	break;
        	case 2:
            	snow.spawn(SpawnCount, 0, 0);
            	snow.update();
        		break;
        	}
    	}

        if(isKeyDown(KEY_3)){
        	SpawnCount--;
        	if(SpawnCount<0)
        		SpawnCount = 0;
        }
        if(isKeyDown(KEY_4)){
        	SpawnCount++;
        	if(SpawnCount>32)
        		SpawnCount = 32;
        }

        if(isKeyDown(KEY_1)){
        	MyParticleLauncher.Type++;
        	if(MyParticleLauncher.Type>MyParticleLauncher.TYPECOUNT-1)
        		MyParticleLauncher.Type = 0;
        }
        if(isKeyDown(KEY_2)){
        	Weather++;
        	if(Weather>WeatherType.length-1)
        		Weather = 0;
        }

        tickTimer();
        
    }

    long CurTime = 0 ;


    public void notifyRender(Graphics g) {
        clearScreenAndClip(g,0xff000000);
        
        if(SpawnCount>0){
        	myParticleSystem.render(g);
	        AScreen.drawString(g,
					"partical Type : " + MyParticleLauncher.Type +
					" Count : " + SpawnCount, 
					1 ,1+32, 
					0xffffffff);
	        switch(Weather){
	    	case 1:
	    		
	    		rain.render(g);
	        	break;
	    	case 2:
	    		snow.render(g);
	    		break;
	    	}
	        AScreen.drawString(g,
	 				"Weather Type : " + WeatherType[Weather] ,
	 				1 ,1+64, 
	 				0xffffffff);
        }

		//		debug
		showFPS(g, 1, 1);
    }

    public void notifyPause(){
    	
    }
    public void notifyResume(){
    	
    }
    
}
