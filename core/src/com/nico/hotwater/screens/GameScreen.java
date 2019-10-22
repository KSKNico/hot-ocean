package com.nico.hotwater.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.nico.hotwater.HotWaterGame;
import com.nico.hotwater.Resources;
import com.nico.hotwater.Ship;
import com.nico.hotwater.ships.Submarine;


public class GameScreen implements Screen {

    private Stage stage;
    private Game game;
    public Batch gameBatch;
    public Ship player;

    public GameScreen(Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());

        gameBatch = new SpriteBatch();
        player = new Submarine(new Vector2(5 , 5), new Vector2(5, 5));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        delta = Math.min(0.06f, delta);

        gameBatch.begin();

        Resources.getInstance().background.draw(gameBatch);
        player.draw(gameBatch);

        gameBatch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
