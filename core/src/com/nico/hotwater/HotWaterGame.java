package com.nico.hotwater;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nico.hotwater.screens.TitleScreen;

public class HotWaterGame extends Game {
	static public Skin gameSkin;
	public void create () {
		gameSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
		this.setScreen(new TitleScreen(this));
	}

	public void render () {
		super.render();
	}

	public void dispose () {
	}
}
