package com.play4fun.quarks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;
import com.play4fun.quarks.entities.Quark;
import com.play4fun.quarks.framework.MapTile;

public class World {

    public static final float WORLD_WIDTH = 32f;
    public static final float WORLD_HEIGHT = 20f;
    public final  MapTile map;
    public final Quark quark;
    
    public final Rectangle floor;
    private float accum;

    public World() {
        quark = new Quark(2,10);
        quark.setGravity(0f,-30f);
        floor = new Rectangle(-5,0,WORLD_WIDTH+5,1);
        map = new MapTile(1,1,32,20);
    }

	public void update(float deltaTime) {
		
		accum += Gdx.graphics.getDeltaTime();
		while (accum > 1.0f / 60.0f) {

			quark.update(deltaTime);
			processInput(deltaTime);
			checkCollisions();			
			accum -= 1.0f / 60.0f;
		}		
	}
	
	private void processInput(float deltaTime) {
		if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
			quark.moveLeft();
		else if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
			quark.moveRight();
		else
			quark.velocity.x *= Quark.DAMP;
		if (Gdx.input.isKeyPressed(Keys.X) && !quark.isState(Quark.JUMP) && !quark.isState(Quark.GROUND))
			quark.Jump();

	}
	
	private void checkCollisions(){
		if(quark.accel.y < 0 && map.getCellType((int)Math.floor(quark.position.x),(int)Math.ceil(quark.position.y))==1){
			quark.position.y=(int)Math.floor(quark.previousY);
			quark.velocity.y=0;
			quark.accel.y=0;
			quark.setState(Quark.GROUND);
		}
	}

}