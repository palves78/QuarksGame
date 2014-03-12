package com.play4fun.quarks;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.play4fun.quarks.entities.Quark;

public class World {

    public static final float WORLD_WIDTH = 32f;
    public static final float WORLD_HEIGHT = 20f;
<<<<<<< HEAD
=======
    public static final int WORLD_STATE_RUNNING = 0;
    public static final int WORLD_STATE_NEXT_LEVEL = 1;
    public static final int WORLD_STATE_GAME_OVER = 2;
    public static final Vector2 gravity = new Vector2(0, -9.8f);
    public int state;
    public Vector2 teste;
>>>>>>> casa
    public final Quark quark;
    public final Rectangle floor;
    public final Rectangle tile;
    
    public TiledMap map;

<<<<<<< HEAD
    public World() {
        quark = new Quark(0,10);
        quark.setGravity(-30f);
        floor = new Rectangle(-5,0,WORLD_WIDTH+5,1);
=======
    public World(WorldListener listener) {
        this.quark = new Quark(0,5);
        this.listener = listener;
        this.floor = new Rectangle(-5,0,WORLD_WIDTH+5,2);
        this.tile = new Rectangle(2,4,1,1);
>>>>>>> casa
    }

	public void update(float deltaTime) {
		
		
		quark.update(deltaTime);
		checkCollisions();
		
		
	}
	
	private void checkCollisions(){
		if(quark.moving)
			if(floor.contains(quark.position)) {
				quark.position.y = quark.oldPosition.y;
				quark.canJump = true;
				quark.velocity.y = 0;
			}	
		
		if(quark.movingUp)
			if(tile.contains(quark.position.x,quark.position.y+Quark.QUARK_HEIGHT))
				quark.position.y = quark.oldPosition.y;
				
	}

}