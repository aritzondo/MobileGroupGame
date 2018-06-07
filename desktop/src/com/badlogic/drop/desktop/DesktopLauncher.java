package com.badlogic.drop.desktop;

import com.badlogic.drop.GameMain;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		Graphics.DisplayMode desktop = LwjglApplicationConfiguration.getDesktopDisplayMode();
		config.setFromDisplayMode(desktop);
		config.fullscreen = true;

		config.title = "Drop";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new GameMain(), config);
	}
}