package com.play4fun.quarks.framework;

public class Room {

	private char[][] room;
	private int cols;
	private int rows;
	
	public Room(int cols, int rows){
		this.cols = cols;
		this.rows = rows;
		room = new char[cols][rows];
		inicialize();
	}
	
	/* Creates a room with all 4 solid edges */ 
	private void inicialize(){
		for(int row = 0; row < rows; row++)
			for(int col = 0; col < cols; col++){
				room[col][row] = '0';
			}
	}
	
	public int getRoomCols(){
		return cols;
	}
	
	public int geRows(){
		return rows;
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
	
	public void fillCeiling(int[] v, int index, int length){
		
		for(int row = 0; row < rows; row++){
			for(int col = 0; col < cols; col++){
				room[col][row] = v[index+col]>0 ? '1' : '0';
			}
			if (isEmpty(v,index,length)) row=rows;
			
		}		
	}
	
	public void fillGround(int[] v, int index, int length){
		
		for(int row = rows-1; row > 0; row--){
			for(int col = 0; col < cols; col++){
				room[col][row] = v[index+col]>0 ? '1' : '0';
			}
			if (isEmpty(v,index,length)) row=0;
			
		}		
	}	
	
	private boolean isEmpty(int[] v, int index,int length){
		int total = 0;
		for(int i=index; i < (index+length); i++){
			total += v[i];
			v[i] = v[i]>0 ? (v[i]-1):0;
		}
		return (total > 0) ? false : true;
	}

	public char getValue(int col, int row) {
		return room[col][row];
	}
	
}
