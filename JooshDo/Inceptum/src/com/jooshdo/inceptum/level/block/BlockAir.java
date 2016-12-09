package com.jooshdo.inceptum.level.block;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.jooshdo.inceptum.misc.Coordinate;

public class BlockAir extends Block {

	private Coordinate ID;
	private int x;
	private int y;
	
	public BlockAir( int x, int y ) {
		ID = new Coordinate( x, y );
		this.x = ID.getX() * 64;
		this.y = ID.getY() * 64;
	}
	
	public void render(Graphics g) {

	}

	public Rectangle getBounds() {
		return null;
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
