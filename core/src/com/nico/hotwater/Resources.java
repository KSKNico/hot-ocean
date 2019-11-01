package com.nico.hotwater;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Resources {
    public static Resources instance;

    public Sprite playerSubmarine = new Sprite(new Texture(Gdx.files.internal("sprites/submarines/player-submarine.png")));
    public Sprite background = new Sprite(new Texture(Gdx.files.internal("sprites/backgrounds/water-background.png")));
    public Sprite enemyShip = new Sprite(new Texture(Gdx.files.internal("sprites/surfaceships/enemy-ship-destroyer.png")));
    // public Sprite torpedo = new Sprite(new Texture(Gdx.files.internal(""));


    public static Resources getInstance() {
        if (instance == null) {
            instance = new Resources();
        }
        return instance;
    }
}
