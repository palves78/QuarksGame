package com.play4fun.quarks.framework;


public class MapTile {

	private Tile[][] map;
	private Level level;
	private int colSize;
	private int rowSize;
	
	public MapTile(int roomsCol, int roomsRow, int roomWidth, int roomHeight){
		
		colSize = roomsCol * roomWidth;
		rowSize = roomsRow * roomHeight;
		
		level = new Level(roomsCol,roomsRow,roomWidth,roomHeight);
		//level.showLevel();
		
		createMap(level);
/*		for(int mapR = 0; mapR < rowSize; mapR++){
			for(int mapC = 0; mapC < colSize; mapC++){
				switch(map[mapC][mapR].getType()){
				case '1':
					System.out.print("S");
					break;
				case '0':
					System.out.print("E");
					break;
				default:
					break;
				}
			}
			System.out.println();
		}
*/		
	}
	
	private void createMap(Level level){

		
		map = new Tile[colSize][rowSize];
		
		for(int mapR = 0; mapR < rowSize; mapR++)
			for(int mapC = 0; mapC < colSize; mapC++)
				for(int row = 0;row < level.rows; row++)
					for(int col = 0;col < level.cols; col++){
						Room r = level.getRoom(col, row);
						map[mapC][mapR] = new Tile(mapC,mapR);
						switch(r.getValue(col, row)){
						case '1':
							map[mapC][mapR].setType('1');
							break;
						case '0':
							map[mapC][mapR].setType('0');
							break;
						};
					}
	}
}
