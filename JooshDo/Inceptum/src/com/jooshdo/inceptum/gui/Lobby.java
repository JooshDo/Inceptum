package com.jooshdo.inceptum.gui;

import java.awt.Graphics;

import com.jooshdo.inceptum.lib.Reference;
import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.util.Scale;

public class Lobby {

	public Lobby() {
		
	}
	
	public void tick() {
		
	}
	
	public void render( Graphics g ) {
		
		//Background
		g.drawImage( Game.tex.getMenu().get( 0 ), 0, 0, Scale.width( Reference.widthScreen ), Scale.height( Reference.heightScreen ), null );
		
	}
	
}
