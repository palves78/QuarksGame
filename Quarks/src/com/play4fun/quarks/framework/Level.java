package com.play4fun.quarks.framework;

import java.util.Random;

public class Level {

	private Room[][] rooms;
	
	private int[] ceiling;
	private int[] ground;
	
	
	int cols;
	int rows;
	private int roomRows;
	private int roomCols;
	
	public Level(int levelCols, int levelRows, int roomCols, int roomRows){
		
		cols = levelCols;
		rows = levelRows;
		this.roomCols = roomCols;
		this.roomRows = roomRows;
		
		rooms = new Room[roomCols][roomRows];
		ceiling = new int[roomCols * cols * rows];
		ground = new int[roomCols * cols * rows];
		
		for(int row = 0; row < rows; row++)
			for(int col = 0; col < cols; col++)
				rooms[col][row] = new Room(roomCols,roomRows);
		
		generateGroundCeiling(ceiling,1,2,0,2);
		generateGroundCeiling(ground,1,2,0,2);
		
		populateRooms(roomCols);
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
	
	public void showGroundCeiling(){
		for(int i= 0; i < ceiling.length; i++) {
			System.out.print(ceiling[i]);
		}
		System.out.println("");
		for(int i= 0; i < ground.length; i++) {
			System.out.print(ground[i]);
		}
		
	}
	
	public Room getRoom(int row, int col){
		
		return rooms[row][col];
	}
	
	private void populateRooms(int length){
		
		int index = 0;
		
		for(int row = 0; row < rows; row++)
			for(int col = 0; col < cols; col++){
				Room r = getRoom(col,row);
				r.fillCeiling(ceiling,index,length);
				r.fillGround(ground,index,length);
				index += length;
			}
	}
	
	public void getRandomRoom(){
		
		Random randRoom = new Random();
		int room = randRoom.nextInt(16);
		int col = room % cols;
		int row = room / rows;
		
		System.out.println("Room " + (room+1) + " located at (" + col + "," + row + ")");
	}

	public void generateGroundCeiling(int[] ceiling,int minl, int maxl, int minh,int maxh){
		
		int groundLength = roomCols * cols * rows;
		int accumulator = 0;
		int length;
		int height;
		
		int col =0;
		for(int i = 0; i < groundLength; i++ ){
			Random randNumer = new Random();
			if (accumulator < groundLength){
				length = minl + randNumer.nextInt(maxl);
				height = minh + randNumer.nextInt(maxh);
				accumulator += length;
				if(accumulator > groundLength){ length=groundLength-(accumulator-length); i = groundLength;}
				for(int j=0;j<length;j++){
					ceiling[col] = height;
					col++;
				}
			}
		}
	}
}
