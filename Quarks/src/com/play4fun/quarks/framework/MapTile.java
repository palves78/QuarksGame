package com.play4fun.quarks.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.play4fun.quarks.framework.BasicTile.Type;

public class MapTile {

	private Tile[][] map;
	private Level level;
	private int colSize;
	private int rowSize;
	private Texture block;
	
	public MapTile(int roomsCol, int roomsRow, int roomWidth, int roomHeight) {

		colSize = roomsCol * roomWidth;
		rowSize = roomsRow * roomHeight;
		map = new Tile[colSize][rowSize];
		for(int j=0; j< rowSize; j++)
			for(int i=0; i< colSize; i++) map[i][j]=new Tile(i,j);
		level = new Level(roomsCol, roomsRow, roomWidth, roomHeight);
		level.FillLevel(map);
		block = new Texture(Gdx.files.internal("assets/quark_blue.png"),true);
		block.setFilter(TextureFilter.Linear, TextureFilter.Linear);		

	}

	public void draw(SpriteBatch batch) {
		for (int mapR = 0; mapR < rowSize; mapR++)
			for (int mapC = 0; mapC < colSize; mapC++)
				if (map[mapC][mapR].getType() == Type.SOLID)
					batch.draw(block, map[mapC][mapR].getCol(),
							map[mapC][mapR].getRow(), 1f, 1f);
	}
}
