package com.play4fun.quarks.entities;

import com.badlogic.gdx.math.Vector2;
import com.play4fun.quarks.framework.DynamicGameObject;

public class Quark extends DynamicGameObject{
    public static final int QUARK_STATE_JUMP = 0;
    public static final int QUARK_STATE_FALL = 1;
    public static final int QUARK_STATE_HIT = 2;
    public static final int QUARK_STATE_GROUNDED = 3;
    public static final int QUARK_STATE_MOVETO = 4;

    public static final float QUARK_WIDTH = 1f;
    public static final float QUARK_HEIGHT = 1f;
    
	static final float ACCELERATION = 25f;
	static final float JUMP_VELOCITY = 14f;
	static final float MAX_VEL = 9f;
	public static final float DAMP = 0.9f;    
    
    int state;
    private Vector2 target;
    
    public Quark(float x, float y) {
        super(x, y, QUARK_WIDTH, QUARK_HEIGHT);
        state = QUARK_STATE_FALL;
        target = new Vector2(); 
    }

    public void update(float deltaTime) {
    	
    	previous.x = position.x;
    	previous.y = position.y;
    	
		accel.y = gravity.y;
		accel.x = accel.x+gravity.x;
		accel.scl(deltaTime);
		velocity.add(accel.x, accel.y);
		if (accel.x == 0) velocity.x *= DAMP;
		if (velocity.x > MAX_VEL) velocity.x = MAX_VEL;
		if (velocity.x < -MAX_VEL) velocity.x = -MAX_VEL;
		velocity.scl(deltaTime);
		position.x += velocity.x;
		position.y += velocity.y;
		velocity.scl(1f / deltaTime);
		
    }
    
	public void Jump () {
		state = QUARK_STATE_JUMP;
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
	
}
