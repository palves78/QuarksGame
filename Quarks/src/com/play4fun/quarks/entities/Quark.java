package com.play4fun.quarks.entities;

import com.badlogic.gdx.math.Vector2;
import com.play4fun.quarks.World;
import com.play4fun.quarks.framework.DynamicGameObject;

public class Quark extends DynamicGameObject{
    public static final int QUARK_STATE_JUMP = 0;
    public static final int QUARK_STATE_FALL = 1;
    public static final int QUARK_STATE_HIT = 2;
    public static final int QUARK_STATE_GROUNDED = 3;
    public static final int QUARK_STATE_MOVETO = 4;
    public static final float QUARK_MOVEMENT = 5f;
    public static final float QUARK_JUMP_VELOCITY = 2.5f;    
    public static final float QUARK_MOVE_VELOCITY = 16f;
    public static final float QUARK_WIDTH = 1f;
    public static final float QUARK_HEIGHT = 1f;
    public static final float QUARK_MASS = 5f;
    
	static final float ACCELERATION = 20f;
	static final float JUMP_VELOCITY = 10f;
	static final float GRAVITY = 20.0f;
	static final float MAX_VEL = 6f;
	public static final float DAMP = 0.90f;    
    
    
    int state;
    float stateTime;
    Vector2 accel;
    public float targetX = 0;
    
    public Quark(float x, float y) {
        super(x, y, QUARK_WIDTH, QUARK_HEIGHT);
        accel = new Vector2();
        state = QUARK_STATE_FALL;
        stateTime = 0;
    }

    public void update(float deltaTime) {
    	
		accel.y = World.gravity.y;
		accel.scl(deltaTime);
		velocity.add(accel.x, accel.y);
		if (accel.x == 0) velocity.x *= DAMP;
		if (velocity.x > MAX_VEL) velocity.x = MAX_VEL;
		if (velocity.x < -MAX_VEL) velocity.x = -MAX_VEL;
		velocity.scl(deltaTime);
		
		if (state == QUARK_STATE_MOVETO) moveTo();
		if (state == QUARK_STATE_MOVETO && velocity.x<=0) {velocity.x=0;state = QUARK_STATE_GROUNDED;} 
		position.x += velocity.x;
		position.y += velocity.y;
		velocity.scl(1.0f / deltaTime);
		
    }
    
	public void Jump () {
		state = QUARK_STATE_JUMP;
		velocity.y = JUMP_VELOCITY;
	}
	
	public void moveLeft(float dt){
		accel.x = ACCELERATION * -1;
	}
	public void moveRight(float dt){
		accel.x = ACCELERATION * 1;
	}
	
	public void setState(int state){
		this.state = state; 
	}
	
	public int getState(){
		return state; 
	}
	
	public void moveTo(){
		Vector2 mouse = new Vector2(targetX,0);
		Vector2 dir = mouse.sub(position);
	    dir.nor();
	    dir.scl(0.5f);
	    accel = dir;
	    velocity.x += accel.x;
	}
	
}
