package com.play4fun.quarks.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapTile {

	private int[][] map;
	private Level level;
	private int colSize;
	private int rowSize;
	private Texture block;
	
	public MapTile(int roomsCol, int roomsRow, int roomWidth, int roomHeight) {

		colSize = roomsCol * roomWidth;
		rowSize = roomsRow * roomHeight;
		map = new int[colSize][rowSize];
		for(int j=0; j< rowSize; j++)
			for(int i=0; i< colSize; i++) map[i][j]=0;
		level = new Level(roomsCol, roomsRow, roomWidth, roomHeight);
		level.FillLevel(map);
		block = new Texture(Gdx.files.internal("assets/quark_blue.png"),true);
		block.setFilter(TextureFilter.Linear, TextureFilter.Linear);		

	}

	public void draw(SpriteBatch batch) {
		for (int mapR = 0; mapR < rowSize; mapR++)
			for (int mapC = 0; mapC < colSize; mapC++)
				if (map[mapC][mapR] == 1)
					batch.draw(block, mapC,mapR, 1f, 1f);
	}
	
	public int getCellType(int x, int y){
		return map[x][y];
	}
	
}
