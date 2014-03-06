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
    public static final float QUARK_MOVEMENT = 25f;
    public static final float QUARK_JUMP_VELOCITY = 32f;    
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
		velocity.add(World.gravity.x * deltaTime, World.gravity.y * deltaTime);
    	position.add(velocity.x * deltaTime*0.9f, (velocity.y * deltaTime)*QUARK_MASS*0.9f);
		/*bounds.x = position.x - bounds.width / 2;
		bounds.y = position.y - bounds.height / 2;*/
        stateTime += deltaTime;
    }
    
	public void Jump (float dt) {
		state = QUARK_STATE_JUMP;
		velocity.y = QUARK_JUMP_VELOCITY / dt;
	}
	
	public void moveLeft(float dt){
		velocity.x = -QUARK_MOVEMENT * QUARK_MOVE_VELOCITY * dt;
	}
	public void moveRight(float dt){
		velocity.x = QUARK_MOVEMENT * QUARK_MOVE_VELOCITY * dt;
	}
	
	public void setState(int state){
		this.state = state; 
	}
	
	public int getState(){
		return state; 
	}
	
	public void moveTo(float x, float y){
		
		Vector2 mouse = new Vector2(x,y);
		Vector2 dir = mouse.sub(position);
	    dir.nor();
	    dir.scl(0.5f);
	    acceleration = dir;
	    velocity.add(dir);
	    System.out.println(dir.x);
	    velocity.limit(QUARK_MOVE_VELOCITY);
	    //position.add(velocity);		
	}
	
}
