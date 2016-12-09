package com.jooshdo.inceptum.main;

import com.jooshdo.inceptum.state.GameState;

public class Tick {

	public void tick() {
		
		if( Game.state == GameState.SPLASH ) {
			
			Game.gui.splash.tick();
			
		}
		
		if( Game.state == GameState.MENU ) {

			Game.gui.menu.tick();
			
		}
		
		if( Game.state == GameState.SETTINGS ) {
			
			Game.gui.settings.tick();
			
		}
		
		if( Game.state == GameState.VIDEO ) {
			
			Game.gui.video.tick();
			
		}
		
		if( Game.state == GameState.AUDIO ) {
			
			Game.gui.audio.tick();
			
		}
		
		if( Game.state == GameState.LOBBY ) {
			
			Game.gui.lobby.tick();
			
		}
		
		if( Game.state == GameState.GAME ) {
			
			Game.level.level.tick();
			Game.player.test.tick();
			
		}
		
	}
	
}