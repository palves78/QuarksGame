package com.play4fun.quarks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
		this.cam.position.set(FRUSTUM_WIDTH / 2, (FRUSTUM_HEIGHT / 2)-3, 0);
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

		batchDebug.begin(ShapeType.Filled);
		batchDebug.setProjectionMatrix(cam.combined);
		//batchDebug.rect((float)Math.floor(world.quark.position.x-Quark.QUARK_WIDTH/2),(float)Math.floor(world.quark.position.y-Quark.QUARK_HEIGHT/2),1f,1f);
		//Left
		batchDebug.rect((float)Math.floor(world.quark.position.x+Quark.QUARK_WIDTH),(float)Math.floor(world.quark.position.y+Quark.QUARK_HEIGHT/2),1f,1f);
		//Bottom
		batchDebug.rect((float)Math.floor(world.quark.position.x),(float)Math.floor(world.quark.position.y-Quark.QUARK_HEIGHT),1f,1f);
		//Right
		batchDebug.rect((float)Math.floor(world.quark.position.x-Quark.QUARK_WIDTH),(float)Math.floor(world.quark.position.y+Quark.QUARK_HEIGHT/2),1f,1f);
		//Top
		batchDebug.rect((float)Math.floor(world.quark.position.x),(float)Math.floor(world.quark.position.y+Quark.QUARK_HEIGHT),1f,1f);
		batchDebug.end();
		
		batch.begin();
		renderQuark();
		batch.end();

	}

	private void renderQuark () {
		batch.draw(quarkTexture, world.quark.position.x, world.quark.position.y,Quark.QUARK_WIDTH,Quark.QUARK_HEIGHT);		
	}

}
