package com.morefuntek.cell.ParticleSystem;

import javax.microedition.lcdui.Graphics;

/**
 * particles manager.
 * @author yifeizhang
 * @since 2006-12-5 
 * @version 1.0
 */
public class CParticleSystem {

	protected IParticleLauncher Launcher;
	protected CParticle[] Particles ;
	protected boolean Active = false;


	/**
	 * constract
	 * @param particle
	 * @param launcher 
	 */
	public CParticleSystem(CParticle[] particle,IParticleLauncher launcher){
		Particles = particle;
		Launcher  = launcher;
	}
	
	/**
	 * change particles node
	 * @param particle 
	 */
	public void changeParticles(CParticle[] particle){
		Particles = particle;
	}
	/**
	 * change particles movement's state
	 * @param launcher 
	 */
	public void changeLauncher(IParticleLauncher launcher){
		Launcher  = launcher;
	}
	
	/**
	 * get how many particles 
	 * @return 
	 */
	public int getCount(){
		return Particles.length;
	}
	
	/**
	 * spawn particles
	 * @param count
	 * @param category TODO
	 * @param x TODO
	 * @param y TODO
	 * @return 
	 */
	public int spawn(int count, int category, int x, int y){
		int c = 0;
		for(int i=0;i<Particles.length;i++){
			if(c>=count)break;
			if(Particles[i].isTerminate()==true){
				Particles[i].Category = category;
				Particles[i].X = x;
				Particles[i].Y = y;
				Launcher.particleEmitted(Particles[i],i);
				c++;		
			}
		}
		Active = true;
		return c;
	}
	
	/**
	 * update particles state
	 */
	public void update(){
		if(Active){
			Active = false;
			for(int i=0;i<Particles.length;i++){
				Particles[i].Timer--;
				if(Particles[i].isTerminate()==false){
					Launcher.particleAffected(Particles[i],i);
					Active = true;
				}else{
					Launcher.particleTerminated(Particles[i],i);
				}
	       	}
		}
	}
	
	/**
	 * render particles 
	 * @param g 
	 */
	public void render(Graphics g){
		if(Active){
			for(int i=0;i<Particles.length;i++){
				if(Particles[i].isTerminate()==false){
					Launcher.particleRender(g, Particles[i], i);
				}
	       	}
		}
	}
}