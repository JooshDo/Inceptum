package com.jooshdo.inceptum.gui.settings;

import java.awt.Graphics;
import java.util.ArrayList;

import com.jooshdo.inceptum.lib.Reference;
import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.ui.Button;
import com.jooshdo.inceptum.util.Scale;

public class Settings {

	public static int widthScreen = Reference.widthScreen;
	public static int heightScreen = Reference.heightScreen;
	
	private ArrayList<Button> settingsButtons;
	private Button buttonBack;
	private Button buttonVideo;
	private Button buttonAudio;

	
	public Settings() {
		
		settingsButtons = new ArrayList<Button>();
		buttonBack = new Button( Game.tex.getSettings().get( 1 ), Game.tex.getSettings().get( 2 ), Scale.posX( 50 ), Scale.posY( Settings.heightScreen - 100 - 19 ), Scale.width( 210 ), Scale.width( 38 ) );
		buttonVideo = new Button( Game.tex.getSettings().get( 3 ), Game.tex.getSettings().get( 4 ), Scale.posX( Settings.widthScreen / 2 - 105 + 130 ), Scale.posY( Settings.heightScreen / 3 - 19 - 25 ), Scale.width( 210 ), Scale.width( 38 ) );
		buttonAudio = new Button( Game.tex.getSettings().get( 6 ), Game.tex.getSettings().get( 7 ), Scale.posX( Settings.widthScreen / 2 - 105 + 130 ), Scale.posY( Settings.heightScreen / 3 - 19 + 25), Scale.width( 210 ), Scale.width( 38 ) );
		
		settingsButtons.add( buttonBack );
		settingsButtons.add( buttonVideo );
		settingsButtons.add( buttonAudio );
		
	}
	
	public void tick() {
		
	}
	
	public void render( Graphics g ) {
		
		//Background
		g.drawImage( Game.tex.getMenu().get( 0 ), 0, 0, Scale.width( 1920 ), Scale.height( 1080 ), null );
		
		//Title
		g.drawImage( Game.tex.getSettings().get( 0 ), Scale.posX( Reference.widthScreen / 2 - 200 + 130 ), Scale.posY( Reference.heightScreen / 4 - 50 ), Scale.width( 400 ), Scale.height( 100 ), null );
		
		//Buttons
		for( Button b : settingsButtons ) {
			b.render(g);
		}
		
	}
	
	public ArrayList<Button> getSettingsButtons() {
		return settingsButtons;
	}
	
}
