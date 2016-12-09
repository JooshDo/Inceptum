package com.jooshdo.inceptum.util;

import com.jooshdo.inceptum.gui.settings.Settings;

public class Scale {

	public static int posX( int posX ) {
		return (int) ( Settings.widthScreen / 1920.0 * posX );
		
	}
	
	public static int posY( int posY ) {
		
		return  (int) ( Settings.heightScreen / 1080.0 * posY );
		
	}
	
	public static int width( int width ) {
		
		return (int) ( Settings.widthScreen / 1920.0 * width );
		
	}
	
	public static int height( int height ) {
		
		return  (int) ( Settings.heightScreen / 1080.0 * height );
		
	}
	
}
