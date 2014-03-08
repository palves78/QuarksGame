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
    public static final float QUARK_MOVEMENT = 4f;
    public static final float QUARK_JUMP_VELOCITY = 10f;    
    public static final float QUARK_MOVE_VELOCITY = 16f;
    public static final float QUARK_WIDTH = 1.5f; //32
    public static final float QUARK_HEIGHT = 1.5f;
    public static final float QUARK_MASS = 5f;
    
    
    int state;
    float stateTime;
    Vector2 acceleration;
    
    public Quark(float x, float y) {
        super(x, y, QUARK_WIDTH, QUARK_HEIGHT);
        velocity.limit(QUARK_MOVE_VELOCITY);
        state = QUARK_STATE_FALL;
        stateTime = 0;
    }

    public void update(float deltaTime) {
    	if(state !=QUARK_STATE_GROUNDED) velocity.add(World.gravity.x * deltaTime, World.gravity.y * deltaTime);
    	position.add(velocity.x * deltaTime, (velocity.y * deltaTime));
		bounds.x = position.x - bounds.width / 2;
		bounds.y = position.y - bounds.height / 2;
        stateTime += deltaTime;
    }
    
	public void Jump () {
		state = QUARK_STATE_JUMP;
		velocity.add(0,QUARK_JUMP_VELOCITY);
	}
	
	public void moveLeft(float dt){
		velocity.x = -QUARK_MOVEMENT;
	}
	public void moveRight(float dt){
		velocity.x = QUARK_MOVEMENT;
	}
	
	public void setState(int state){
		this.state = state; 
	}
	
	public int getState(){
		return state; 
	}
	
}
