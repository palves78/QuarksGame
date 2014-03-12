package com.play4fun.quarks.framework;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	public final Vector2 position;
	public final Vector2 previous;
	public final Rectangle bounds;

	public GameObject (float x, float y, float width, float height) {
		this.position = new Vector2(x, y);
		this.previous = position;
		this.bounds = new Rectangle(x - width / 2, y - height / 2, width, height);
	}
}
