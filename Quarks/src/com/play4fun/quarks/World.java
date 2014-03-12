package com.play4fun.quarks;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.play4fun.quarks.entities.Quark;

public class World {

    public static final float WORLD_WIDTH = 32f;
    public static final float WORLD_HEIGHT = 20f;
    public final Quark quark;
    public final Rectangle floor;
    
    public TiledMap map;

    public World() {
        quark = new Quark(0,10);
        quark.setGravity(-30f);
        floor = new Rectangle(-5,0,WORLD_WIDTH+5,1);
    }

	public void update(float deltaTime) {
		
		quark.update(deltaTime);
		checkCollisions();
		
	}
	
	private void checkCollisions(){
		if(quark.position.y <floor.y+floor.height) {
			quark.position.y = floor.y+floor.height;
			quark.setState(Quark.QUARK_STATE_GROUNDED);
		}
	}

}