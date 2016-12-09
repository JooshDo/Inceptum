package com.jooshdo.inceptum.level.block;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.misc.Coordinate;
import com.jooshdo.inceptum.util.Scale;

public class BlockStone extends Block {

	private Coordinate ID;
	private int x;
	private int y;
	
	public BlockStone( int x, int y ) {
		ID = new Coordinate( x, y );
		this.x = ID.getX() * 64;
		this.y = ID.getY() * 64;
	}
	
	public void render(Graphics g) {
		g.drawImage( Game.tex.getBlocks().get( 0 ), Scale.posX( x ), Scale.posY( y ), Scale.width( 64), Scale.height( 64 ), null );
	}

	public Rectangle getBounds() {
		return new Rectangle( Scale.posX( x ), Scale.posY( y ), Scale.width( 64 ), Scale.height( 64 ) );
	}

	public Coordinate getID() {
		return ID;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
