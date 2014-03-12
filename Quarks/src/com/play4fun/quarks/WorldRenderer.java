package com.play4fun.quarks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
<<<<<<< HEAD
=======
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
>>>>>>> casa
import com.play4fun.quarks.entities.Quark;

public class WorldRenderer {
	static final float FRUSTUM_WIDTH = 32;
	static final float FRUSTUM_HEIGHT = 20;
	World world;
	OrthographicCamera cam;
	SpriteBatch batch;
	ShapeRenderer debug;
	Texture quarkTexture;

	public WorldRenderer (World world) {
		this.world = world;
		this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		this.cam.position.set(FRUSTUM_WIDTH / 2, FRUSTUM_HEIGHT / 2, 0);
<<<<<<< HEAD
		batch = new SpriteBatch();
		quarkTexture = new Texture(Gdx.files.internal("assets/quark_green.png"),true);
		quarkTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
=======
		this.batch = batch;
		quarkTexture = new Texture(Gdx.files.internal("quark_blue.png"),true);
		quarkTexture.setFilter(TextureFilter.Nearest, TextureFilter.Linear);
		debug = new ShapeRenderer();
>>>>>>> casa
	}

	public void render () {
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		renderObjects();
	}

	public void renderObjects () {
<<<<<<< HEAD
=======
		/*GL20 gl = Gdx.graphics.getGL20();
		gl.glEnable(GL20.GL_BLEND);
		gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		*/
        
>>>>>>> casa
		batch.enableBlending();
		batch.begin();
		renderQuark();
		batch.end();
		debug.begin(ShapeType.Line);
		debug.setProjectionMatrix(cam.combined);
		debug.setColor(Color.RED);
		debug.rect(world.quark.bounds.x, world.quark.bounds.y,Quark.QUARK_WIDTH,Quark.QUARK_HEIGHT);
		debug.rect(world.floor.x,world.floor.y,world.floor.width,world.floor.height);
		debug.rect(world.tile.x,world.tile.y,world.tile.width,world.tile.height);
		debug.end();
		
	}

	private void renderQuark () {
		batch.draw(quarkTexture, world.quark.position.x, world.quark.position.y,Quark.QUARK_WIDTH,Quark.QUARK_HEIGHT);
	}

}
