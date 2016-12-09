package com.jooshdo.inceptum.level.block;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Block {

	public abstract void render( Graphics g );

	public abstract Rectangle getBounds();
	
	public abstract int getX();
	public abstract int getY();
	
}
