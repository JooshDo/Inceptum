package com.jooshdo.inceptum.entity.player;

import java.awt.Rectangle;

import com.jooshdo.inceptum.level.block.Block;
import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.misc.Coordinate;

public class Collision {

	public static void checkPlayer() {
		
		Coordinate pos = new Coordinate( Game.player.test.getX(), Game.player.test.getY() );
		Coordinate coords = Game.player.test.getCoords();
		Rectangle bounds = Game.player.test.getBounds();
		Block[][] blocks = Game.level.level.getBlocks();
		
		for( int y = coords.getY() - 1; y < coords.getY() + 2; y++ ) {
			for( int x = coords.getX() - 1; x < coords.getX() + 2; x++ ) {
				
				if( x >= 0 && y >= 0 ) {
					
					if( bounds.intersects( blocks[x][y].getBounds() ) ) {
						
						if( pos.getY() < blocks[x][y].getY() + 64 ) { //top
							Game.player.test.setY( blocks[x][y].getY() + 64 );
						}
						else if( pos.getY() + 64 > blocks[x][y].getY() ) { //bottom
							Game.player.test.setY( blocks[x][y].getY() - 64 );
						}
						else if( pos.getX() + 64 > blocks[x][y].getX() ) { //right
							Game.player.test.setY( blocks[x][y].getX() - 64 );
						}
						else if( pos.getX() < blocks[x][y].getX() + 64  ) { //left
							Game.player.test.setY( blocks[x][y].getY() + 64 );
						}
						
					}
					
				}
				
			}
		}
		
	}
	
}
