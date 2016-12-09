package com.jooshdo.inceptum.listener;

import java.awt.Point;
import java.awt.event.MouseEvent;

import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.state.GameState;

public class MouseMotionListener {
	
	public static void mouseMoved( MouseEvent e ) {
		
		int mx = e.getX();
		int my = e.getY();
		
		if( Game.state == GameState.MENU ) {
			
			//Host Button
			if( Game.gui.menu.getMenuButtons().get( 0 ).getBounds().contains( new Point( mx, my ) ) ) {
				Game.gui.menu.getMenuButtons().get( 0 ).setHover( true );
			} else {
				Game.gui.menu.getMenuButtons().get( 0 ).setHover( false );
			}
			//Connect Button
			if( Game.gui.menu.getMenuButtons().get( 1 ).getBounds().contains( new Point( mx, my ) ) ) {
				Game.gui.menu.getMenuButtons().get( 1 ).setHover( true );
			} else {
				Game.gui.menu.getMenuButtons().get( 1 ).setHover( false );
			}
			//Settings Button
			if( Game.gui.menu.getMenuButtons().get( 2 ).getBounds().contains( new Point( mx, my ) ) ) {
				Game.gui.menu.getMenuButtons().get( 2 ).setHover( true );
			} else {
				Game.gui.menu.getMenuButtons().get( 2 ).setHover( false );
			}
			//Quit Button
			if( Game.gui.menu.getMenuButtons().get( 3 ).getBounds().contains( new Point( mx, my ) ) ) {
				Game.gui.menu.getMenuButtons().get( 3 ).setHover( true );
			} else {
				Game.gui.menu.getMenuButtons().get( 3 ).setHover( false );
			}
			
		}
		
		if( Game.state == GameState.SETTINGS ) {
			
			//Back Button
			if( Game.gui.settings.getSettingsButtons().get( 0 ).getBounds().contains( new Point( mx, my ) ) ) {
				Game.gui.settings.getSettingsButtons().get( 0 ).setHover( true );
			} else {
				Game.gui.settings.getSettingsButtons().get( 0 ).setHover( false );
			}
			//Video Button
			if( Game.gui.settings.getSettingsButtons().get( 1 ).getBounds().contains( new Point( mx, my ) ) ) {
				Game.gui.settings.getSettingsButtons().get( 1 ).setHover( true );
			} else {
				Game.gui.settings.getSettingsButtons().get( 1 ).setHover( false );
			}
			//Audio Button
			if( Game.gui.settings.getSettingsButtons().get( 2 ).getBounds().contains( new Point( mx, my ) ) ) {
				Game.gui.settings.getSettingsButtons().get( 2 ).setHover( true );
			} else {
				Game.gui.settings.getSettingsButtons().get( 2 ).setHover( false );
			}
			
		}
		
		if( Game.state == GameState.VIDEO ) {
			
			//Back Button
			if( Game.gui.settings.getSettingsButtons().get( 0 ).getBounds().contains( new Point( mx, my ) ) ) {
				Game.gui.settings.getSettingsButtons().get( 0 ).setHover( true );
			} else {
				Game.gui.settings.getSettingsButtons().get( 0 ).setHover( false );
			}
			
		}
		
		if( Game.state == GameState.AUDIO ) {
			
			//Back Button
			if( Game.gui.settings.getSettingsButtons().get( 0 ).getBounds().contains( new Point( mx, my ) ) ) {
				Game.gui.settings.getSettingsButtons().get( 0 ).setHover( true );
			} else {
				Game.gui.settings.getSettingsButtons().get( 0 ).setHover( false );
			}
			
		}
		
	}

}
