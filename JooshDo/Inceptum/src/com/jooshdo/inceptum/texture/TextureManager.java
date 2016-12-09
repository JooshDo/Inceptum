package com.jooshdo.inceptum.texture;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TextureManager {

	//Block Sheet
	private BufferedImage sheetBlock = new Texture( "/resources/texture/sprite/sheetBlock.png" ).getTexture();
	SpriteSheet bs = new SpriteSheet( sheetBlock );
	private ArrayList<BufferedImage> blocks = new ArrayList<BufferedImage>();
	
	//Character Sheet
	private BufferedImage sheetCharacter = new Texture( "/resources/texture/sprite/sheetCharacter.png" ).getTexture();
	SpriteSheet cs = new SpriteSheet( sheetCharacter );
	private ArrayList<BufferedImage> characters = new ArrayList<BufferedImage>();
	
	//Splash Screen
	private ArrayList<BufferedImage> splash = new ArrayList<BufferedImage>();
	private BufferedImage splashBackground = new Texture( "/resources/texture/splash/splashBackground.png" ).getTexture();
	private BufferedImage logoAA = new Texture( "/resources/texture/splash/logoAA.png" ).getTexture();
	
	//Main Menu
	private ArrayList<BufferedImage> menu = new ArrayList<BufferedImage>();
	private BufferedImage menuBackground = new Texture( "/resources/texture/menu/menuBackground.png" ).getTexture();
	private BufferedImage menuLogo = new Texture( "/resources/texture/menu/menuLogo.png" ).getTexture();
	private BufferedImage menuTitle = new Texture( "/resources/texture/menu/menuTitle.png" ).getTexture();
	private BufferedImage buttonHost = new Texture( "/resources/texture/menu/buttonHost.png" ).getTexture();
	private BufferedImage buttonHostHover = new Texture( "/resources/texture/menu/buttonHostHover.png" ).getTexture();
	private BufferedImage buttonConnect = new Texture( "/resources/texture/menu/buttonConnect.png" ).getTexture();
	private BufferedImage buttonConnectHover = new Texture( "/resources/texture/menu/buttonConnectHover.png" ).getTexture();
	private BufferedImage buttonSettings = new Texture( "/resources/texture/menu/buttonSettings.png" ).getTexture();
	private BufferedImage buttonSettingsHover = new Texture( "/resources/texture/menu/buttonSettingsHover.png" ).getTexture();
	private BufferedImage buttonQuit = new Texture( "/resources/texture/menu/buttonQuit.png" ).getTexture();
	private BufferedImage buttonQuitHover = new Texture( "/resources/texture/menu/buttonQuitHover.png" ).getTexture();
	private BufferedImage meteor1 = new Texture( "/resources/texture/menu/meteor1.png" ).getTexture();
	private BufferedImage meteor2 = new Texture( "/resources/texture/menu/meteor2.png" ).getTexture();
	private BufferedImage meteor3 = new Texture( "/resources/texture/menu/meteor3.png" ).getTexture();
	
	//Settings
	private ArrayList<BufferedImage> settings = new ArrayList<BufferedImage>();
	private BufferedImage settingsTitle = new Texture( "/resources/texture/menu/settings/settingsTitle.png" ).getTexture();
	private BufferedImage settingsButtonBack = new Texture( "/resources/texture/menu/settings/settingsButtonBack.png" ).getTexture();
	private BufferedImage settingsButtonBackHover = new Texture( "/resources/texture/menu/settings/settingsButtonBackHover.png" ).getTexture();
	private BufferedImage settingsVideo = new Texture( "/resources/texture/menu/settings/settingsVideo.png" ).getTexture();
	private BufferedImage settingsVideoHover = new Texture( "/resources/texture/menu/settings/settingsVideoHover.png" ).getTexture();
	private BufferedImage videoTitle = new Texture( "/resources/texture/menu/settings/videoTitle.png" ).getTexture();
	private BufferedImage settingsAudio = new Texture( "/resources/texture/menu/settings/settingsAudio.png" ).getTexture();
	private BufferedImage settingsAudioHover = new Texture( "/resources/texture/menu/settings/settingsAudioHover.png" ).getTexture();
	private BufferedImage audioTitle = new Texture( "/resources/texture/menu/settings/audioTitle.png" ).getTexture();

	//Levels
	private ArrayList<BufferedImage> levels = new ArrayList<BufferedImage>();
	private BufferedImage levelTest = new Texture( "/resources/texture/level/layout/LevelTest.png" ).getTexture();
	
	public TextureManager() {
		
		getTextures();
		
	}
	
	private void getTextures() {

		//Blocks
		blocks.add( bs.grabImage( 1, 1, 64, 64 ) ); //0 Stone
		
		//Characters
		characters.add( cs.grabImage( 1, 1, 64, 64 ) ); //0 Waffle
		characters.add( cs.grabImage( 2, 2, 64, 64 ) ); //1 Marshmallow
		characters.add( cs.grabImage( 3, 3, 64, 64 ) ); //2 Banana
		characters.add( cs.grabImage( 4, 1, 64, 64 ) ); //3 Gudetama
		
		//Splash
		splash.add( splashBackground ); //0 
		splash.add( logoAA ); //1 
		
		//Menu
		menu.add( menuBackground ); //0
		menu.add( menuLogo ); //1
		menu.add( menuTitle ); //2
		menu.add( buttonHost ); //3
		menu.add( buttonHostHover ); //4
		menu.add( buttonConnect ); //5
		menu.add( buttonConnectHover ); //6
		menu.add( buttonSettings ); //7
		menu.add( buttonSettingsHover ); //8
		menu.add( buttonQuit ); //9
		menu.add( buttonQuitHover ); //10
		menu.add( meteor1 ); //11
		menu.add( meteor2 ); //12
		menu.add( meteor3 ); //13
		
		//Settings
		settings.add( settingsTitle ); //0
		settings.add( settingsButtonBack ); //1
		settings.add( settingsButtonBackHover ); //2
		settings.add( settingsVideo ); //3
		settings.add( settingsVideoHover ); //4
		settings.add( videoTitle ); //5
		settings.add( settingsAudio ); //6
		settings.add( settingsAudioHover ); //7
		settings.add( audioTitle ); //8
		
		//Levels
		levels.add( levelTest ); //0
		
	}
	
	public ArrayList<BufferedImage> getBlocks() {
		return blocks;
	}
	
	public ArrayList<BufferedImage> getCharacters() {
		return characters;
	}
	
	public ArrayList<BufferedImage> getSplash() {
		return splash;
	}
	
	public ArrayList<BufferedImage> getMenu() {
		return menu;
	}
	
	public ArrayList<BufferedImage> getSettings() {
		return settings;
	}
	
	public ArrayList<BufferedImage> getLevels() {
		return levels;
	}
	
}
