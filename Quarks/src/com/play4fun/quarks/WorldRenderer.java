package com.play4fun.quarks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.play4fun.quarks.entities.Quark;

public class WorldRenderer {
	static final float FRUSTUM_WIDTH = 32;
	static final float FRUSTUM_HEIGHT = 20;
	World world;
	OrthographicCamera cam;
	SpriteBatch batch;
	ShapeRenderer batchDebug;
	Texture quarkTexture;

	public WorldRenderer (World world) {
		this.world = world;
		this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		this.cam.position.set(FRUSTUM_WIDTH / 2, (FRUSTUM_HEIGHT / 2), 0);
		batch = new SpriteBatch();
		batchDebug = new ShapeRenderer();
		batchDebug.setColor(Color.RED);
		batchDebug.setProjectionMatrix(cam.combined);		
		quarkTexture = new Texture(Gdx.files.internal("assets/quark_green.png"),true);
		quarkTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}

	public void render () {
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		renderObjects();
		//cam.translate(world.quark.position.x,world.quark.position.y);
		cam.position.set(world.quark.position.x,world.quark.position.y,0);
	}

	public void renderObjects () {
		batch.enableBlending();		
		batch.begin();
		world.map.draw(batch);
		renderQuark();
		batch.end();

	}

	private void renderQuark () {
		batch.draw(quarkTexture, world.quark.position.x, world.quark.position.y,Quark.WIDTH,Quark.HEIGHT);		
	}

}
