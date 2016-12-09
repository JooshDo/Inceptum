package com.jooshdo.inceptum.gui.menu;

import java.awt.image.BufferedImage;

public class Meteor {

	private int x;
	private int y;
	private BufferedImage img;
	private int width;
	private int height;
	private int speed;
	
	private int counter = 0;
	
	public Meteor( int x, int y, BufferedImage img, int speed ) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.width = img.getWidth();
		this.height = img.getHeight();
		this.speed = speed;
	}

	public int getX() {
		return x;
	}
	public void setX( int x ) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY( int y ) {
		this.y = y;
	}

	public BufferedImage getImg() {
		return img;
	}
	public void setImg( BufferedImage img ) {
		this.img = img;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed( int speed ) {
		this.speed = speed;
	}
	
	public int getCounter() {
		return counter;
	}
	public void setCounter( int counter ) {
		this.counter = counter;
	}
	
}
