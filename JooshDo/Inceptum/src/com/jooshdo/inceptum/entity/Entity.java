package com.jooshdo.inceptum.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

	public abstract void tick();
	
	public abstract void render( Graphics g );
	
	public abstract Rectangle getBounds();
	
}
