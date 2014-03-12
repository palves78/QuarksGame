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
	private int roomWidth;
	private int roomHeight;
	private Texture block;
	
	public MapTile(int roomsCol, int roomsRow, int roomWidth, int roomHeight) {

		colSize = roomsCol * roomWidth;
		rowSize = roomsRow * roomHeight;
		this.roomWidth = roomWidth;
		this.roomHeight = roomHeight;
		
		map = new Tile[colSize][rowSize];

		level = new Level(roomsCol, roomsRow, roomWidth, roomHeight);
		createMap(level);
		block = new Texture(Gdx.files.internal("assets/quark_blue.png"),true);
		block.setFilter(TextureFilter.Linear, TextureFilter.Linear);		

	}

	private void createMap(Level level) {
		int mapC=0;
		int mapR=0;
		int col=0;
		int row=0;
		for(int roomRow=0; roomRow < level.rows; roomRow++){
			for(int roomCol=0; roomCol < level.cols; roomCol++){
				Room r = level.getRoom(roomCol, roomRow);
				for(row=0; row < r.getRows(); row++){
					for(col=0; col < r.getCols(); col++){
						Type t = r.getValue(col, row)=='1' ? Type.SOLID : Type.EMPTY;
						System.out.println(mapC+","+mapR);
						map[mapC][mapR] = new Tile(mapC, mapR);
						map[mapC][mapR].setType(t);
						mapC++;
					}
					mapR++;
				}
				mapC+=col;
				mapR=0;
			}
			if(mapC+1>colSize) mapC=0;
		}
	}

	public void draw(SpriteBatch batch) {
		for (int mapR = 0; mapR < rowSize; mapR++)
			for (int mapC = 0; mapC < colSize; mapC++)
				if (map[mapC][mapR].getType() == Type.SOLID)
					batch.draw(block, map[mapC][mapR].getCol(),
							map[mapC][mapR].getRow(), 1f, 1f);
	}
}
