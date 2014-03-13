package com.play4fun.quarks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
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
        quark.setGravity(0f,0f);
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
		else if (Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
			quark.moveDown();
		else if (Gdx.input.isKeyPressed(Keys.DPAD_UP))
			quark.moveUp();		
		else
			quark.velocity.x *= Quark.DAMP;
		if (Gdx.input.isKeyPressed(Keys.X) && !quark.isState(Quark.JUMP) && !quark.isState(Quark.GROUND))
			quark.Jump();

	}
	
	private void checkCollisions(){
		
		if(quark.velocity.x<0){
			
		}else if (quark.velocity.x>0){
			Rectangle[] cell = new Rectangle[3];
			cell[0] = map.getCell((int)Math.ceil(quark.touchables[1].x)+1, (int)Math.ceil(quark.touchables[1].y));
			cell[1] = map.getCell((int)Math.ceil(quark.touchables[1].x)+1, (int)Math.ceil(quark.touchables[1].y)+1);
			cell[2] = map.getCell((int)Math.ceil(quark.touchables[2].x)+1, (int)Math.ceil(quark.touchables[2].y)-1);
			for(int i=0; i<3; i++)
				for(Vector2 point : quark.getPoints()){
					if(cell[i].contains(point) && map.getCellType((int)cell[i].x,(int) cell[i].y)==1){
						System.out.println(i+"-> "+cell[i].x + ","+cell[i].y);
						quark.position.x=quark.touchables[i].x;
						quark.velocity.y=0;
						quark.accel.y=0;
						return;
					}
				}			
		}
		
		if(quark.velocity.y>0){
			
		}else if(quark.velocity.y<0 && !quark.isState(Quark.GROUND)){
			Rectangle[] cell = new Rectangle[3];
			cell[0] = map.getCell((int)Math.ceil(quark.touchables[0].x)-1, (int)Math.ceil(quark.touchables[0].y)-1);
			cell[1] = map.getCell((int)Math.ceil(quark.touchables[0].x), (int)Math.ceil(quark.touchables[0].y)-1);
			cell[2] = map.getCell((int)Math.ceil(quark.touchables[1].x)+1, (int)Math.ceil(quark.touchables[1].y)-1);
			for(int i=0; i<3; i++)
				for(Vector2 point : quark.getPoints()){
					if(cell[i].contains(point) && map.getCellType((int)cell[i].x,(int) cell[i].y)==1){
						System.out.println(i+"-> "+cell[i].x + ","+cell[i].y);
						quark.position.y=quark.touchables[i].y;
						quark.velocity.y=0;
						quark.accel.y=0;
						quark.setState(Quark.GROUND);
						return;
					}
				}
		}
	}

}