package com.play4fun.quarks.entities;

import com.badlogic.gdx.math.Vector2;
import com.play4fun.quarks.framework.DynamicGameObject;

public class Quark extends DynamicGameObject{
    public static final int JUMP = 0;
    public static final int FALL = 1;
    public static final int HIT = 2;
    public static final int GROUND = 3;
    public static final int MOVETO = 4;

    public static final float WIDTH = 1.25f;
    public static final float HEIGHT = 1.25f;
    
	static final float ACCELERATION = 25f;
	static final float JUMP_VELOCITY = 14f;
	static final float MAX_VEL = 9f;
	public static final float DAMP = 0.9f;    
    
    int state;
    private Vector2 target;
    public float previousX=0;
    public float previousY=0;
    
    public Quark(float x, float y) {
        super(x, y, WIDTH*0.8f, HEIGHT);
        state = FALL;
        target = new Vector2(); 
    }

    public void update(float deltaTime) {
    	
    	previousX = bounds.x-0.2f;
    	previousY = bounds.y;
    	
		accel.y = gravity.y;
		accel.x = accel.x+gravity.x;
		accel.scl(deltaTime);
		velocity.add(accel.x, accel.y);
		if (accel.x == 0) velocity.x *= DAMP;
		if (velocity.x > MAX_VEL) velocity.x = MAX_VEL;
		if (velocity.x < -MAX_VEL) velocity.x = -MAX_VEL;
		velocity.scl(deltaTime);
		
		bounds.x += velocity.x;
		bounds.y += velocity.y;
		position.x = bounds.x - 0.2f;
		position.y = bounds.y;		
		
		velocity.scl(1f / deltaTime);
		
    }
    
	public void Jump () {
		state = JUMP;
		velocity.y = JUMP_VELOCITY;
	}
	
	public void moveLeft(){
		accel.x = ACCELERATION * -1;
	}
	public void moveRight(){
		accel.x = ACCELERATION * 1;
	}
	
	public void setState(int state){
		this.state = state; 
	}
	
	public int getState(){
		return state; 
	}
	
	public void setTarget(float x, float y){
		target.x = x;
		target.y = y;
	}
	
	public void moveTo(){
		//Vector2 mouse = new Vector2(target.x,target.y);
		Vector2 dir = target.sub(position);
	    dir.nor();
	    dir.scl(0.5f);
	    accel.x = dir.x;
	    velocity.x += accel.x;
	}
	
	public boolean isState(int state){
		return this.state==state;
	}
	
}
