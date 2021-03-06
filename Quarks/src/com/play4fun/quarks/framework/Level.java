package com.play4fun.quarks.framework;

import java.util.Random;

public class Level {

	private Room[][] rooms;
	
	int cols;
	int rows;
	private int roomRows;
	private int roomCols;
	
	public Level(int levelCols, int levelRows, int roomCols, int roomRows){
		
		cols = levelCols;
		rows = levelRows;
		this.roomRows = roomRows;
		this.roomCols = roomCols;
		
		rooms = new Room[roomCols][roomRows];
		
		for(int row = 0; row < rows; row++)
			for(int col = 0; col < cols; col++){
				rooms[col][row] = new Room(roomCols,roomRows);
				generateGroundCeiling(rooms[col][row].ceilling,1,1,1,1);
				generateGroundCeiling(rooms[col][row].ground,1,5,1,3);
			}		
		populateRooms();
	}
	
	public void FillLevel(int[][] map){
		int r=(rows*roomRows)-1;
		int c=0;
		for(int row = 0; row < rows; row++){
			for(int rr = 0; rr < roomRows ; rr++ ){
				for(int col = 0; col < cols; col++){
					for(int col1 = 0; col1 < roomCols; col1++){
						map[c][r] = rooms[col][row].getValue(col1, rr)=='1' ? 1 : 0;
						c++;
					}
				}
				r-=1;
				c=0;
			}
		}
	}
	
	public void showLevel(){
		for(int row = 0; row < rows; row++){
			for(int rr = 0; rr < roomRows ; rr++ ){
				for(int col = 0; col < cols; col++){
					rooms[col][row].showRoomCols(rr);
				}
				System.out.println("");
			}
		}
	}
	
	public Room getRoom(int col, int row){
		
		return rooms[col][row];
	}
	
	private void populateRooms(){
		
		for(int row = 0; row < rows; row++)
			for(int col = 0; col < cols; col++){
				Room room = getRoom(col,row);
				room.fillCeiling(room.ceilling);
				room.fillGround(room.ground);
			}
	}
	
	public Room getRandomRoom(){
		
		Random randRoom = new Random();
		int room = randRoom.nextInt(16);
		return getRoom(room % cols,room / rows);
	}

	public void generateGroundCeiling(int[] cg,int minl, int maxl, int minh, int maxh){

		int accumulator = 0;
		int length;
		int height;
		int col =0;
		for(int i = 0; i < cg.length; i++ ){
			Random randNumer = new Random();
			length = minl + randNumer.nextInt(maxl);
			height = minh + randNumer.nextInt(maxh);
			accumulator += length;
			if(accumulator > cg.length){ 
				length=cg.length-(accumulator-length);
				i = cg.length;
			}
			for(int j=0;j<length;j++){
				cg[col] = height;
				col++;
			}
		}
	}
}
