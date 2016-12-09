package com.jooshdo.inceptum.main;

import java.awt.Graphics;

import com.jooshdo.inceptum.state.GameState;

public class Render {

	public void render( Graphics g ) {
		
		if( Game.state == GameState.SPLASH ) {
			
			Game.gui.splash.render( g );

		}
		
		if( Game.state == GameState.MENU ) {
			
			Game.gui.menu.render( g );

		}
		
		if( Game.state == GameState.SETTINGS ) {
			
			Game.gui.settings.render( g );
			
		}
		
		if( Game.state == GameState.VIDEO ) {
			
			Game.gui.video.render( g );
			
		}
		
		if( Game.state == GameState.AUDIO ) {
			
			Game.gui.audio.render( g );
			
		}
		
		if( Game.state == GameState.LOBBY ) {
			
			Game.gui.lobby.render( g );
			
		}
		
		if( Game.state == GameState.GAME ) {
			
			Game.level.level.render( g );
			Game.player.test.render( g );
			
		}
		
	}
	
}