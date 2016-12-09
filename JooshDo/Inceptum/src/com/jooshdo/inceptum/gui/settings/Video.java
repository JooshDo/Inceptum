package com.jooshdo.inceptum.gui.settings;

import java.awt.Graphics;

import com.jooshdo.inceptum.lib.Reference;
import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.util.Scale;

public class Video {

	public void tick() {
		
	}
	
	public void render( Graphics g ) {
		
		//Background
		g.drawImage( Game.tex.getMenu().get( 0 ), 0, 0, Scale.width( 1920 ), Scale.height( 1080 ), null );
		
		//Title
		g.drawImage( Game.tex.getSettings().get( 5 ), Scale.posX( Reference.widthScreen / 2 - 200 + 130 ), Scale.posY( Reference.heightScreen / 4 - 50 ), Scale.width( 400 ), Scale.height( 100 ), null );
		
		//Back Button
		Game.gui.settings.getSettingsButtons().get( 0 ).render(g);
		
	}
	
}
