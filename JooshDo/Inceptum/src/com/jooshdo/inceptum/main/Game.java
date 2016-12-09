package com.jooshdo.inceptum.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.jooshdo.inceptum.entity.player.PlayerManager;
import com.jooshdo.inceptum.gui.GUIManager;
import com.jooshdo.inceptum.input.MouseInput;
import com.jooshdo.inceptum.input.MouseMotionInput;
import com.jooshdo.inceptum.level.LevelManager;
import com.jooshdo.inceptum.lib.Reference;
import com.jooshdo.inceptum.net.SocketManager;
import com.jooshdo.inceptum.state.GameState;
import com.jooshdo.inceptum.texture.TextureManager;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	//Frame
	public static JFrame frame = new JFrame();
	
	//Thread
	private Thread thread;
	public static boolean running = false;
	
	//Game State
	public static GameState state;
	
	//Main
	private Tick tick;
	private Render render;
	
	//Resource Managers
	public static TextureManager tex;
	
	//GUI Manager
	public static GUIManager gui;
	
	//Level Manager
	public static LevelManager level;
	
	//Player Manager
	public static PlayerManager player;
	
	//Socket Manager
	public static SocketManager net;
	
	public Game() {
		
		this.setSize( Reference.widthScreen, Reference.heightScreen );

		frame.setSize( Reference.widthScreen, Reference.heightScreen );
		frame.add( this );
		frame.setResizable( false );
		frame.setLocationRelativeTo( null );
		frame.setUndecorated( true );
		frame.setVisible( true );
		
		start();
		
	}
	
	public void init() {
		
		//Game State
		state = GameState.SPLASH;
		
		//Resource Managers
		tex = new TextureManager();
		
		//GUI Manager
		gui = new GUIManager();
		
		//Level Manager
		level = new LevelManager();
		
		//Player Manager
		player = new PlayerManager();
		
		//Socket Manager
		net = new SocketManager();
		
		tick = new Tick();
		render = new Render();
		
		//Listeners
		addMouseListener( new MouseInput() );
		addMouseMotionListener( new MouseMotionInput() );
		
	}
	
	synchronized void start() {
		
		if( running )
			return;
		
		running = true;
		thread = new Thread( this );
		thread.start();
		
	}
	
	synchronized void stop() {
		
		if( !running )
			return;
		
		running = false;
		try {
			thread.join();
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		System.exit( 1 );
		
	}

	public void run() {
		
		init();
		
		long lastTime = System.nanoTime();
		final double FPS = 60.0;
		double ns = 1000000000 / FPS;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while( running ) {
			
			long now = System.nanoTime();
			delta += ( now - lastTime ) / ns;
			lastTime = now;
			if( delta >= 1 ) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if( System.currentTimeMillis() - timer > 1000 ) {
				timer += 1000;
				frame.setTitle( "FPS: " + frames + ", Ticks: " + updates );
				updates = 0;
				frames = 0;
			}
			
		}
		
		stop();
		
	}
	
	public void tick() {
		
		tick.tick(); 
		
	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if( bs == null ) {
			
			createBufferStrategy( 3 );
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////
		
		render.render( g );
		
		//////////////////////////////////
		g.dispose();
		bs.show();
		
	}

}