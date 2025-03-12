package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = 640;
		config.height = 360;
		config.pauseWhenMinimized = true;
		config.resizable = false;
		config.title = "NeedForSpeedBall";
		config.addIcon("badlogic.jpg", Files.FileType.Internal);
		new LwjglApplication(new MyGdxGame(), config);
	}

}
