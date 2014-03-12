package com.play4fun.quarks.framework;

import com.badlogic.gdx.math.Vector2;

public class DynamicGameObject extends GameObject {
	public final Vector2 velocity;
	public final Vector2 accel;
	public Vector2 gravity;

	public DynamicGameObject (float x, float y, float width, float height) {
		super(x, y, width, height);
		velocity = new Vector2();
		accel = new Vector2();
	}
	
	public void setGravity(float gravityX,float gravityY){
		this.gravity = new Vector2(gravityX,gravityY);
	}
}
