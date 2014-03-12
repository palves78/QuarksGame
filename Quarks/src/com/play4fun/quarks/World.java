package com.play4fun.quarks;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.play4fun.quarks.entities.Quark;

public class World {
	
    public interface WorldListener {
        public void jump();

        public void highJump();

        public void hit();

        public void coin();
    }

    public static final float WORLD_WIDTH = 32f;
    public static final float WORLD_HEIGHT = 20f;
    public static final int WORLD_STATE_RUNNING = 0;
    public static final int WORLD_STATE_NEXT_LEVEL = 1;
    public static final int WORLD_STATE_GAME_OVER = 2;
    public static final Vector2 gravity = new Vector2(0, -30f);
    public int state;
    public Vector2 teste;
    public final Quark quark;
    public final Rectangle floor;
    
    public TiledMap map;

    public World() {
        this.quark = new Quark(0,1);
        this.floor = new Rectangle(-5,0,WORLD_WIDTH+5,1);
    }


	public void update(float deltaTime) {
		
		quark.update(deltaTime);
		checkCollisions();
		
	}
	
	public void setState(Vector2 state){
		teste = state;
	}
	
	private void checkCollisions(){
		if(quark.position.y <floor.y+floor.height) {
			quark.position.y = floor.y+floor.height;
			if(quark.getState()!=Quark.QUARK_STATE_MOVETO) quark.setState(Quark.QUARK_STATE_GROUNDED);
		}
	}

}