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
	int tick=0;
	
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

	private void update(float deltaTime) {
		if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) world.quark.moveLeft();
		else if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) world.quark.moveRight();
			else world.quark.velocity.x *= 0.9f;
		if (Gdx.input.isKeyPressed(Keys.X) && world.quark.canJump) world.quark.Jump();

		float total = 0.0F;
		while (total < 0.01666667F) {
			total += Gdx.graphics.getDeltaTime();
			try {
				Thread.sleep(1L);
			} catch (Exception localException1) {
			}
		}
		world.update(total);
		draw();
		
	}

	public void draw () {
		GL20 gl = Gdx.graphics.getGL20();
	    gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
