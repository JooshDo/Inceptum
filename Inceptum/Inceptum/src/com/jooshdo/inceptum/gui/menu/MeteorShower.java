package com.jooshdo.inceptum.gui.menu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.util.Scale;

public class MeteorShower {

	Random rand = new Random();
	
	private ArrayList<Meteor> meteors = new ArrayList<Meteor>();

	public MeteorShower() {

		init();
		
	}
	
	public Meteor randomMeteor() {
		
		int x = 0;
		int y = 0;
		BufferedImage img = Game.tex.getMenu().get( rand.nextInt( 2 ) + 11 );
		int speed = rand.nextInt( 5 ) + 1;
		
		x = rand.nextInt( Scale.width( 1920 ) * 2 );
		if( x < Scale.width( 1920 ) ) {
			
			y = 0 - img.getHeight();
		
		} else {
			
			x = Scale.width( 1920 );
			y = rand.nextInt( Scale.width( 1080) );
			
		}
		
		return new Meteor( x, y, img, speed );
		
	}
	
	public void init() {
		
		for( int i = 0; i < 5; i++ ) {
			
			meteors.add( randomMeteor() );
			
		}
		
	}
	
	public void tick() {
		
		for( Meteor m : meteors ) {
			
			m.setCounter( m.getCounter() + 1 );
			
		}
		
		for( Meteor m : meteors ) {
			
			m.setX( m.getX() - m.getSpeed() * 2 );
			m.setY( m.getY() + m.getSpeed() );
			
			if( m.getCounter() == 1 ) {
				
//				m.setY( m.getY() + m.getSpeed() );
				
				m.setCounter( 0 );
				
			}
			
		}

		
		for( Meteor m : meteors ) {
			
			if( m.getX() < 0 - m.getWidth() || m.getY() > Scale.height( 1080 ) ) {
				
				Meteor randomMeteor = randomMeteor();
				
				m.setX( randomMeteor.getX() );
				m.setY( randomMeteor.getY() );
				m.setImg( randomMeteor.getImg() );
				m.setSpeed( randomMeteor.getSpeed() );
				
			}
			
		}
		
	}
	
	public void render( Graphics g ) {
		
		for( Meteor m : meteors ) {
			g.drawImage( m.getImg(), m.getX(), m.getY(), m.getWidth(), m.getHeight(), null );
		}
		
	}
	
}
