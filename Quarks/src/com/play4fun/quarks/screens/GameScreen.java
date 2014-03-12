package com.play4fun.quarks.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.play4fun.quarks.World;
import com.play4fun.quarks.WorldRenderer;
import com.play4fun.quarks.entities.Quark;

public class GameScreen implements Screen {

	SpriteBatch batcher;
	World world;
	WorldRenderer renderer;
<<<<<<< HEAD
	float accumulator;
	float time = 0;

	public GameScreen (Game game) {

		world = new World();
		renderer = new WorldRenderer(world);
		
		Gdx.gl.glDisable(GL20.GL_CULL_FACE);
		Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);		

	}

	private void processInput (float deltaTime) {
		if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) world.quark.moveLeft();
		else if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) world.quark.moveRight();
		else world.quark.velocity.x *= Quark.DAMP;
		if (Gdx.input.isKeyPressed(Keys.X) && world.quark.getState()!=Quark.QUARK_STATE_JUMP) world.quark.Jump();

	}

	public void draw () {
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    Gdx.gl.glClearColor(0f, 0.3f, 0.8f, 1);    
=======
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
	    
>>>>>>> casa
	    renderer.render();
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

	@Override
	public void render(float delta) {
		
		processInput(delta);
		world.update(delta);
		draw();
		
	}
	
}
