package com.jooshdo.inceptum.gui;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.state.GameState;
import com.jooshdo.inceptum.texture.Fade;
import com.jooshdo.inceptum.util.Scale;

public class Splash {

	private long startTime;
	private long currentTime;
	
	private Fade fade = new Fade( 1.5 );
	
	public Splash() {
		
		startTime = System.currentTimeMillis();
		
	}
	
	public void tick() {
		currentTime = System.currentTimeMillis();
		
		if( currentTime >= startTime + 5000 ) {
			Game.state = GameState.MENU;
		}
		
		fade.tick();
		
	}
	
	public void render( Graphics g ) {
		Graphics2D g2D = (Graphics2D) g;
		
		//Background
		g.drawImage( Game.tex.getSplash().get( 0 ), 0, 0, Scale.width( 1920 ), Scale.height( 1080 ), null );
		
		//AA Logo
		g2D.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_OVER, fade.getOpacity() ) );
		g.drawImage( Game.tex.getSplash().get( 1 ), Scale.posX( 690 ), Scale.posY( 270 ), Scale.width( 540 ), Scale.height( 540 ), null );
		
	}
	
}
