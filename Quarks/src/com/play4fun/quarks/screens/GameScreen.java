package com.play4fun.quarks.screens;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.play4fun.quarks.World;
import com.play4fun.quarks.World.WorldListener;
import com.play4fun.quarks.WorldRenderer;
import com.play4fun.quarks.entities.Quark;

public class GameScreen implements Screen {
	static final int GAME_READY = 0;
	static final int GAME_RUNNING = 1;
	static final int GAME_PAUSED = 2;
	static final int GAME_LEVEL_END = 3;
	static final int GAME_OVER = 4;
	
	Game game;

	int state;
	float FPS;
	SpriteBatch batcher;
	World world;
	WorldListener worldListener;
	WorldRenderer renderer;
	float accumulator;

	public GameScreen (Game game) {
		ApplicationType appType = Gdx.app.getType();
		if (appType == ApplicationType.Android ) {
			FPS = 1f/120f;
		}else{
			FPS = 1f/60f;
		}

		this.game = game;

		state = GAME_READY;
		batcher = new SpriteBatch();
		worldListener = new WorldListener() {
			@Override
			public void jump () {
			}

			@Override
			public void highJump () {
			}

			@Override
			public void hit () {
			}

			@Override
			public void coin () {
			}
		};
		world = new World(worldListener);
		renderer = new WorldRenderer(batcher, world);

	}

	public void update (float deltaTime) {
		float total = 0.0F;
		updateRunning(Gdx.graphics.getDeltaTime());
		draw();
		while (total < 0.01666667f) {
			total += deltaTime;
			try { Thread.sleep(11L); } catch (Exception localException1) {}
		}
		
	    
	}

	private void updateRunning (float deltaTime) {
		ApplicationType appType = Gdx.app.getType();
		float dt = 0;
		while (dt < 0.01666667F) {
			dt += deltaTime;
			if(dt>0.01666667F) dt-=0.000005f;
			try { Thread.sleep(11L); } catch (Exception localException1) {}
		}
		
		if (appType == ApplicationType.Android ) {
			int x = (int)(Gdx.input.getX());
			if (!Gdx.input.isTouched()) world.quark.velocity.x *= 0.8f;
			else{				
				if(Gdx.input.justTouched() && x < 200) world.quark.moveLeft(deltaTime);
				if(Gdx.input.justTouched() && x > 200 && x < 400) world.quark.moveRight(deltaTime);
			}
			if( Gdx.input.justTouched() && x > (Gdx.app.getGraphics().getWidth()-200) && world.quark.getState()!=Quark.QUARK_STATE_JUMP) world.quark.Jump(8f);				
			world.update(deltaTime);
		}else{
			if (Gdx.input.justTouched()){
				world.quark.moveTo((float)Math.floor(Gdx.input.getX()/32), (float)Math.floor(Gdx.input.getY()/20));
			}else{
				if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) world.quark.moveLeft(deltaTime);
				else if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) world.quark.moveRight(deltaTime);
					else world.quark.velocity.x *= 0.8f;
			}
			if ((Gdx.input.isKeyPressed(Keys.DPAD_UP) || (Gdx.input.justTouched() && Gdx.input.getDeltaX()>Gdx.app.getGraphics().getWidth()-300)) && world.quark.getState()!=Quark.QUARK_STATE_JUMP) {
				world.quark.Jump(8f);
			}
			world.update(dt);			
		}
		
	}

	public void draw () {
	    GL20 gl = Gdx.graphics.getGL20();
	    gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
	    gl.glEnable(GL20.GL_TEXTURE_2D);
	    
	    renderer.render();
	}


	@Override
	public void render (float delta) {
		update(delta);
	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void show () {
	}

	@Override
	public void hide () {
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}
}