package com.jooshdo.inceptum.listener;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.jooshdo.inceptum.entity.player.Player;
import com.jooshdo.inceptum.gui.GUIManager;
import com.jooshdo.inceptum.gui.settings.Settings;
import com.jooshdo.inceptum.level.LevelSpike;
import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.main.Main;
import com.jooshdo.inceptum.net.GameClient;
import com.jooshdo.inceptum.packet.Packet00Ping;
import com.jooshdo.inceptum.state.GameState;
import com.jooshdo.inceptum.util.Scale;

public class MouseListener {
	
	public static void mouseClicked( MouseEvent e ) {
		
		int mx = e.getX();
		int my = e.getY();
		
		if( Game.state == GameState.MENU ) {
			
			//Host Button
			if( Game.gui.menu.getMenuButtons().get( 0 ).getBounds().contains( new Point( mx, my )) ) {
				
//				String input = JOptionPane.showInputDialog( "Please enter a port! (Leave blank for default)" );
//				
//				if( input == null ) {
//					
//				} else if( input.equals( "" ) ) {
//					input = "25565";
//					
//					Game.net.server = new GameServer();
//					Game.net.server.startServer();
//				}
				
				Game.level.level = new LevelSpike();
				Game.player.test = new Player( Scale.posX( 480 ), Scale.posY( 480 ), 3 );
				Game.state = GameState.GAME;

			}
			//Connect Button
			if( Game.gui.menu.getMenuButtons().get( 1 ).getBounds().contains( new Point( mx, my )) ) {
				
				String input = JOptionPane.showInputDialog( "Please enter an IP! (Leave blank for default)" );
				
				if( input == null ) {
					
				} else if( input.equals( "" ) ) {
					input = "localhost";
					
					Game.net.client = new GameClient( input );
					Game.net.client.startClient();
					
					Packet00Ping packet = new Packet00Ping();
					Game.net.client.sendData( packet.getData() );
					System.out.println( "ping" );
					
					Game.state = GameState.LOBBY;
				}
				
			}
			//Settings Button
			if( Game.gui.menu.getMenuButtons().get( 2 ).getBounds().contains( new Point( mx, my )) ) {
				Game.state = GameState.SETTINGS;
			}
			//Quit Button
			if( Game.gui.menu.getMenuButtons().get( 3 ).getBounds().contains( new Point( mx, my )) ) {
				System.exit(1);
			}
			
		}
		
		if( Game.state == GameState.SETTINGS ) {
			
			//Back Button
			if( Game.gui.settings.getSettingsButtons().get( 0 ).getBounds().contains( new Point( mx, my )) ) {
				Game.state = GameState.MENU;
			}
			//Video Button
			if( Game.gui.settings.getSettingsButtons().get( 1 ).getBounds().contains( new Point( mx, my )) ) {
				Game.state = GameState.VIDEO;
			}
			//Audio Button
			if( Game.gui.settings.getSettingsButtons().get( 2 ).getBounds().contains( new Point( mx, my )) ) {
				Game.state = GameState.AUDIO;
			}
			
		}
		
		if( Game.state == GameState.VIDEO ) {
			
			//Back Button
			if( Game.gui.settings.getSettingsButtons().get( 0 ).getBounds().contains( new Point( mx, my )) ) {
				Game.state = GameState.SETTINGS;
			}
			//Test
			if( Game.gui.settings.getSettingsButtons().get( 1 ).getBounds().contains( new Point( mx, my )) ) {
				Game.frame.setVisible( false );
				Settings.widthScreen = 1600;
				Settings.heightScreen = 900;
				Main.game.setSize( Settings.widthScreen, Settings.heightScreen );
				Game.frame.setSize( Settings.widthScreen, Settings.heightScreen);
				Game.gui = new GUIManager();
				Game.frame.setLocationRelativeTo( null );
				Game.frame.setVisible( true );
			}
			//Test
			if( Game.gui.settings.getSettingsButtons().get( 2 ).getBounds().contains( new Point( mx, my )) ) {
				Game.frame.setVisible( false );
				Settings.widthScreen = 1920;
				Settings.heightScreen = 1080;
				Main.game.setSize( Settings.widthScreen, Settings.heightScreen );
				Game.frame.setSize( Settings.widthScreen, Settings.heightScreen);
				Game.gui = new GUIManager();
				Game.frame.setLocationRelativeTo( null );
				Game.frame.setVisible( true );
			}
			
		}
		
		if( Game.state == GameState.AUDIO ) {
			
			//Back Button
			if( Game.gui.settings.getSettingsButtons().get( 0 ).getBounds().contains( new Point( mx, my )) ) {
				Game.state = GameState.SETTINGS;
			}
			
		}
		
	}
	
}
