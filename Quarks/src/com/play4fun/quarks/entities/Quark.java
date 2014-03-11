package com.play4fun.quarks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.play4fun.quarks.World;
import com.play4fun.quarks.framework.DynamicGameObject;

public class Quark extends DynamicGameObject{
	
    public static final float QUARK_MOVEMENT = 4.5f;
    public static final float QUARK_JUMP_VELOCITY = 8f;    
    public static final float QUARK_MOVE_VELOCITY = 16f;
    public static final float QUARK_WIDTH = 1f; //32
    public static final float QUARK_HEIGHT = 1f;
    
    public Vector2 oldPosition;
    
    public boolean canJump, canDoubleJump;
    public boolean moving, movingLeft, movingRight, movingUp, movingDown;
    
    int state;
    
    public Quark(float x, float y) {
        super(x, y, QUARK_WIDTH, QUARK_HEIGHT);
        oldPosition = new Vector2(x,y);
        velocity.limit(QUARK_MOVE_VELOCITY);
        moving = false;
    }

    public void update(float deltaTime) {
    	
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
	}
	
	public void moveLeft(){
		velocity.x = -QUARK_MOVEMENT;
	}
	public void moveRight(){
		velocity.x = QUARK_MOVEMENT;
	}
	
}
