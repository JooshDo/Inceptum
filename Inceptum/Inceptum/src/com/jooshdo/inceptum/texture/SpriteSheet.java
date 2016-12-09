package com.jooshdo.inceptum.texture;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage image;
	
	public SpriteSheet( BufferedImage spritesheet ) {
		this.image = spritesheet;
	}
	
	public BufferedImage grabImage( int col, int row, int width, int height ) {
		
		BufferedImage img = image.getSubimage(  (col * 64) - 64, (row * 64) - 64, width, height );
		return img;
		
	}
	
}
