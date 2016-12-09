package com.jooshdo.inceptum.level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jooshdo.inceptum.level.block.Block;
import com.jooshdo.inceptum.level.block.BlockAir;
import com.jooshdo.inceptum.level.block.BlockStone;

public abstract class Level {

	public abstract void tick();
	
	public abstract void render( Graphics g );
	
	public Block[][] LoadImageLevel( BufferedImage levelLayout ) {
		
		int w = levelLayout.getWidth();
		int h = levelLayout.getHeight();
		
		Block[][] blocks = new Block[w][h];
		
		for( int x = 0; x < w; x++ ) {
			for( int y = 0; y < h; y++ ) {
				
				int pixel = levelLayout.getRGB( x, y );
				int red = ( pixel >> 16 ) & 0xff;
				int green = ( pixel >> 8 ) & 0xff;
				int blue = ( pixel ) & 0xff;
				
				if( red == 0 && green == 0 && blue == 0) { //Black Air
					blocks[x][y] = new BlockAir( x, y );
				}
				else if( red == 255 && green == 255 && blue == 255) { //White Stone
					blocks[x][y] = new BlockStone( x, y );
				}
				
			}
		}
		
		return blocks;
		
	}
	
	public abstract Block[][] getBlocks();
	
}
