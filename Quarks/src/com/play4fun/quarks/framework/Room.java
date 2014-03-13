package com.play4fun.quarks.framework;

public class Room {

	private char[][] room;
	public int[] ceilling;
	public int[] ground;	
	private int cols;
	private int rows;
	
	public Room(int cols, int rows){
		this.cols = cols;
		this.rows = rows;
		room = new char[cols][rows];
		ceilling = new int[cols];
		ground = new int[cols];
		inicialize();
	}
	
	private void inicialize(){
		for(int row = 0; row < rows; row++)
			for(int col = 0; col < cols; col++){
				room[col][row] = ' ';
			}
	}
	
	public void showRoom(){
		for(int row = 0; row < rows; row++){
			for(int col = 0; col < cols; col++){
				System.out.print(room[col][row]);
			}
		}
	}
	
	public void showRoomCols(int row){
		for(int col = 0; col < cols; col++){
			System.out.print(room[col][row]);
		}
	}	
	
	public void fillCeiling(int[] ceil){
		
		for(int row = 0; row < rows; row++){
			for(int col = 0; col < cols; col++){
				room[col][row] = ceil[col]>0 ? '1' : ' ';
			}
			if (isEmpty(ceil)) row=rows;
		}
	}
	
	public void fillGround(int[] ground){
		
		for(int row = rows-1; row > 0; row--){
			for(int col = 0; col < cols; col++){
				room[col][row] = ground[col]>0 ? '1' : ' ';
			}
			if (isEmpty(ground)) row=0;
		}
			
	}
	
	private boolean isEmpty(int[] v){
		int total = 0;
		for(int i=0; i < cols; i++){
			total += v[i];
			v[i] = v[i]>0 ? (v[i]-1):0;
		}
		return (total > 0) ? false : true;
	}	

	public char getValue(int col, int row) {
		return room[col][row];
	}

	public int getCols() {
		return cols;
	}
	
	
	public int getRows(){
		return rows;
	}	
	
}
