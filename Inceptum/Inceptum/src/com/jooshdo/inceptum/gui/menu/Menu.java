package com.jooshdo.inceptum.gui.menu;

import java.awt.Graphics;
import java.util.ArrayList;

import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.ui.Button;
import com.jooshdo.inceptum.util.Scale;

public class Menu {

	private MeteorShower meteorShower;
	
	private ArrayList<Button> menuButtons;
	private Button buttonHost;
	private Button buttonConnect;
	private Button buttonSettings;
	private Button buttonQuit;
	
	public Menu() {
		
		meteorShower = new MeteorShower();
		
		menuButtons = new ArrayList<Button>();
		buttonHost = new Button( Game.tex.getMenu().get( 3 ), Game.tex.getMenu().get( 4 ), Scale.posX( 327 ), Scale.posY( 590 ), Scale.width( 210 ), Scale.width( 38 ) );
		buttonConnect = new Button( Game.tex.getMenu().get( 5 ), Game.tex.getMenu().get( 6 ), Scale.posX( 327 ), Scale.posY( 640 ), Scale.width( 210 ), Scale.width( 38 ) );
		buttonSettings = new Button( Game.tex.getMenu().get( 7 ), Game.tex.getMenu().get( 8 ), Scale.posX( 327 ), Scale.posY( 690 ), Scale.width( 210 ), Scale.width( 38 ) );
		buttonQuit = new Button( Game.tex.getMenu().get( 9 ), Game.tex.getMenu().get( 10 ), Scale.posX( 327 ), Scale.posY( 740 ), Scale.width( 210 ), Scale.width( 38 ) );
		
		menuButtons.add( buttonHost );
		menuButtons.add( buttonConnect );
		menuButtons.add( buttonSettings );
		menuButtons.add( buttonQuit );
		
	}
	
	public void tick() {
		
		meteorShower.tick();
		
	}

	public void render( Graphics g ) {
		
		//Background
		g.drawImage( Game.tex.getMenu().get( 0 ), 0, 0, Scale.width( 1920 ), Scale.height( 1080 ), null );
		
		//Meteor Shower
		meteorShower.render(g);
		
		//Logo
		g.drawImage( Game.tex.getMenu().get( 1 ), Scale.posX( 304 ), Scale.posY( 249 ), Scale.width( 256 ), Scale.height( 256 ), null );
		
		//Title
		g.drawImage( Game.tex.getMenu().get( 2 ), Scale.posX( 232 ), Scale.posY( 490 ), Scale.width( 400 ), Scale.height( 100 ), null );
		
		//Menu Buttons
		for( Button b: menuButtons ) {
			b.render(g);
		}

	}
	
	public ArrayList<Button> getMenuButtons() {
		return menuButtons;
	}
	
}