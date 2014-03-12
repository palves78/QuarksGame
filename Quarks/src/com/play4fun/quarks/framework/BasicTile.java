package com.play4fun.quarks.framework;


public class BasicTile{
	
	public static enum Type{EMPTY,SOLID};
	private char type;
	
	private int col;
	private int row;
	
	public BasicTile(){
		
	}
	
	public BasicTile(int col, int row){
		set(col,row);
	}
	
	public BasicTile(int col, int row, char type){
		set(col,row);
		this.type = type;
	}
	
	public void setCol(int col){
		this.col = col;
	}

	public int getCol(){
		return col;
	}	
	
	public int getRow(){
		return row;
	}	
	
	public void setRow(int row){
		this.row = row;
	}
	
	public void set(int col, int row){
		this.col = col;
		this.row = row;
	}
	
	public void setType(char c){
		this.type = c;
	}
	
	public char getType(){
		return type;
	}
	
	public BasicTile getTile(){
		return this;
	}
	
}
