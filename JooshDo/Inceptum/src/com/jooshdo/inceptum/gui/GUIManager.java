package com.jooshdo.inceptum.gui;

import com.jooshdo.inceptum.gui.menu.Menu;
import com.jooshdo.inceptum.gui.settings.Audio;
import com.jooshdo.inceptum.gui.settings.Settings;
import com.jooshdo.inceptum.gui.settings.Video;

public class GUIManager {
	
	//Splash
	public Splash splash = new Splash();
	
	//Menu
	public Menu menu = new Menu();
	
	//Settings
	public Settings settings = new Settings();
	
	//Video
	public Video video = new Video();
	
	//Audio
	public Audio audio = new Audio();
	
	//Lobby
	public Lobby lobby = new Lobby();
	
}
