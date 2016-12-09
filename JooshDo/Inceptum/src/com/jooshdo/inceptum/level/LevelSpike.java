package com.jooshdo.inceptum.level;

import java.awt.Color;
import java.awt.Graphics;

import com.jooshdo.inceptum.level.block.Block;
import com.jooshdo.inceptum.main.Game;
import com.jooshdo.inceptum.util.Scale;

public class LevelSpike extends Level {

	private Block[][] blocks;

	public LevelSpike() {
		
		blocks = LoadImageLevel( Game.tex.getLevels().get( 0 ) );
		
	}
	
	public void tick() {

	}
	
	public void render( Graphics g ) {
		
		g.translate( 0, -4 );
		
		//Background
		g.setColor( new Color( 35, 35, 35 ) );
		g.fillRect( 0, 0, Scale.width( 1920 ), Scale.height( 1080 ) );
		
		//Blocks
		for( Block[] block : blocks ) {
			for( Block b : block ) {
				b.render(g);
			}
		}
		
	}
	
	public Block[][] getBlocks() {
		return blocks;
	}
	
}
