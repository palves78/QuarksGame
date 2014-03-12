package com.play4fun.quarks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.play4fun.quarks.framework.DynamicGameObject;

public class Quark extends DynamicGameObject{
<<<<<<< HEAD
    public static final int QUARK_STATE_JUMP = 0;
    public static final int QUARK_STATE_FALL = 1;
    public static final int QUARK_STATE_HIT = 2;
    public static final int QUARK_STATE_GROUNDED = 3;
    public static final int QUARK_STATE_MOVETO = 4;

    public static final float QUARK_WIDTH = 1.5f;
    public static final float QUARK_HEIGHT = 1.5f;
    
	static final float ACCELERATION = 25f;
	static final float JUMP_VELOCITY = 14f;
	static final float MAX_VEL = 9f;
	public static final float DAMP = 0.9f;    
=======
	
    public static final float QUARK_MOVEMENT = 4.5f;
    public static final float QUARK_JUMP_VELOCITY = 8f;    
    public static final float QUARK_MOVE_VELOCITY = 16f;
    public static final float QUARK_WIDTH = 1f; //32
    public static final float QUARK_HEIGHT = 1f;
    
    public Vector2 oldPosition;
>>>>>>> casa
    
    public boolean canJump, canDoubleJump;
    public boolean moving, movingLeft, movingRight, movingUp, movingDown;
    
    int state;
<<<<<<< HEAD
    float stateTime;
    public Vector2 accel;
    public float targetX = 0;
    
    public Quark(float x, float y) {
        super(x, y, QUARK_WIDTH, QUARK_HEIGHT);
        accel = new Vector2();
        state = QUARK_STATE_FALL;
        stateTime = 0;
=======
    
    public Quark(float x, float y) {
        super(x, y, QUARK_WIDTH, QUARK_HEIGHT);
        oldPosition = new Vector2(x,y);
        velocity.limit(QUARK_MOVE_VELOCITY);
        moving = false;
>>>>>>> casa
    }

    public void update(float deltaTime) {
    	
<<<<<<< HEAD
		accel.y = gravity;
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
=======
    	movingLeft = false;
    	movingRight = false;
    	movingUp = false;
    	movingDown = false;
    	
    	// apply gravity
    	velocity.add(0, World.gravity.y * deltaTime);
    	
    	// store previous XY position
    	oldPosition.x = position.x;
    	oldPosition.y = position.y;
    	
    	// update XY position
    	position.add(velocity.x * deltaTime, velocity.y * deltaTime);
    	
    	if(velocity.x < 0) movingLeft = moving = true;
    	else if(velocity.x > 0) movingRight = moving = true;
    	else if(velocity.y > 0) movingUp = moving = true;
    	else if(velocity.y < 0) movingDown = moving = true;
    	else moving = false;
    }
    
	public void Jump () {
		canJump = false;
		velocity.add(0,QUARK_JUMP_VELOCITY);
>>>>>>> casa
	}
	
	public void moveLeft(){
		velocity.x = -QUARK_MOVEMENT;
	}
<<<<<<< HEAD
	
	public void moveTo(){
		Vector2 mouse = new Vector2(targetX,0);
		Vector2 dir = mouse.sub(position);
	    dir.nor();
	    dir.scl(0.5f);
	    accel = dir;
	    velocity.x += accel.x;
=======
	public void moveRight(){
		velocity.x = QUARK_MOVEMENT;
>>>>>>> casa
	}
	
}
