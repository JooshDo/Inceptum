package com.jooshdo.inceptum.texture;

public class Fade {

	private long currentTime;
	private long lastTime;
	
	private double pause;
	
	private float opacity = 0.0f;
	
	private boolean fadeIn = true;
	private boolean paused = false;
	private boolean fadeOut = false;
	
	private int counter = 0;
	
	public Fade( double pause ) {
		this.pause = pause;
		
		lastTime = System.currentTimeMillis();
	}
	
	public void tick() {
		currentTime = System.currentTimeMillis();
		
		if( fadeIn ) {
			
			if( currentTime >= lastTime + 1 ) {
				
				opacity += 0.01f;
				lastTime = currentTime;
				counter++;
				
				if( counter == 99 ) {
					
					fadeIn = false;
					counter = 0;
					lastTime = System.currentTimeMillis();
					
				}
				
			}
			
		} else if( fadeOut ) {
			
			if( currentTime >= lastTime + 1 ) {
				
				opacity -= 0.01f;
				lastTime = System.currentTimeMillis();
				counter++;
				
				if( counter == 99 ) {
					
					fadeOut = false;
					counter = 0;
					
				}
				
			}
			
		} else {
			
			if( !paused ) {

				if( currentTime >= lastTime + ( pause * 1000 ) ) {
					
					fadeOut = true;
					lastTime = System.currentTimeMillis();
					paused = true;
					
				}
				
			}
			
		}
		
	}
	
	public float getOpacity() {
		return opacity;
	}
	
}
