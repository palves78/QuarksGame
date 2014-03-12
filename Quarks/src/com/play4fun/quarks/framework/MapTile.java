package com.play4fun.quarks.framework;

public class MapTile {

	private Tile[][] map;
	
	public MapTile(int roomsCol, int roomsRow, int roomWidth, int roomHeight){
		Level level = new Level(roomsCol,roomsRow,roomWidth,roomHeight);
	}
}
