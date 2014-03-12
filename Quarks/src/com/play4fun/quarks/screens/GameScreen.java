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
