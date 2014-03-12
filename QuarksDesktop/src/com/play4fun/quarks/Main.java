package com.play4fun.quarks;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Quarks";
		cfg.useGL30 = false;
		cfg.width = 1024;
		cfg.height = 640;
		cfg.vSyncEnabled = true;
		cfg.foregroundFPS=0;
		new LwjglApplication(new QuarksGame(), cfg);
	}
}
