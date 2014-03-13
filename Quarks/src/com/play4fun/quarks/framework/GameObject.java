package com.play4fun.quarks.framework;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	public final Vector2 position;
	public final Rectangle bounds = new Rectangle();

	public GameObject (float x, float y, float width, float height) {
		this.position = new Vector2(x, y);
		this.bounds.width = width;
		this.bounds.height = height;
		this.bounds.x = x + 0.2f;
		this.bounds.y = y;
	}
}
