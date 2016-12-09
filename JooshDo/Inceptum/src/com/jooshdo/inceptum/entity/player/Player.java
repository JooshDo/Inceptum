package com.jooshdo.inceptum.entity.player;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.jooshdo.inceptum.entity.Entity;
import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.misc.Coordinate;
import com.jooshdo.inceptum.util.Scale;

public class Player extends Entity {
	
	private int character;
	
	private int x;
	private int y;
	private int velX = 0;
	private int velY = 0;
	private int speedMax = 15;
	
//	private int speed;
//	private int jumpHeight;
//	private int speedMax;
	private int gravity = 1;
	
	public Player( int x, int y, int character ) {
		this.x = x;
		this.y = y;
		this.character = character;
	}
	
	public void tick() {
		
		//Gravity
		velY += gravity;
		if( velY >= speedMax ) {
			velY = speedMax;
		}
		
		Collision.checkPlayer();
		
		x += velX;
		y += velY;
		
	}
	
	public void render( Graphics g ) {
		
		g.drawImage( Game.tex.getCharacters().get( character ), Scale.posX(  x ), Scale.posY( y ), Scale.width( 64 ), Scale.height( 64 ), null );
		
	}
	
	public void collision() {
		
	}
	
	public Coordinate getCoords() {
		
		return new Coordinate( x / 64, y / 64 );
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle( Scale.posX( x ), Scale.posY( y ), Scale.width( 64 ), Scale.height( 64 ) );
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
	
	public int getVelX() {
		return velX;
	}
	public void setVelX( int velX ) {
		this.velX = velX;
	}
	
	public int getVelY() {
		return velY;
	}
	public void setVelY( int velY ) {
		this.velY = velY;
	}
	
}
