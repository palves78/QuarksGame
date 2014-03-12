package com.play4fun.quarks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.play4fun.quarks.screens.GameScreen;

public class QuarksGame extends Game {
  
    int state;
    SpriteBatch batcher;    
    World world;
    WorldRenderer renderer;

	@Override
	public void create() {
		setScreen(new GameScreen(this));		
	}

	@Override
	public void dispose() {
		super.dispose();
		getScreen().dispose();
		Assets.manager.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
