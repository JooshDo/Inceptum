package com.jooshdo.inceptum.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Button {

	private BufferedImage button;
	private BufferedImage buttonHover;
	
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private boolean hover = false;
	
	public Button( BufferedImage button, BufferedImage buttonHover, int x, int y, int width, int height ) {
		this.button = button;
		this.buttonHover = buttonHover;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public void tick() {
		
	}
	
	public void render( Graphics g ) {
		
		if( !hover ) {
			
			g.drawImage( button, x, y, width, height, null );
			
		} else if( hover ) {
			
			g.drawImage( buttonHover, x, y, width, height, null );
			
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle( x, y, width, height );
	}
	
	public boolean getHover() {
		return hover;
	}
	public void setHover( Boolean hover ) {
		this.hover = hover;
	}
	
	public void setX( int x ) {
		this.x = x;
	}
	
	public void setY( int y ) {
		this.y = y;
	}
	
}