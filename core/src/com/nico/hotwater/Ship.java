package com.nico.hotwater;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ship extends Sprite {
    public Vector2 position;
    public Vector2 facing;
    public float speed = 5;
    public int team;

    public Ship(Vector2 position, Vector2 facing) {
        super();

        this.facing = facing;
        this.position = position;
    }

    @Override
    public void draw(Batch batch) {
        this.setRotation(facing.angle());
        this.setPosition(position.x, position.y);

        position = new Vector2(facing.x * speed + position.x, facing.y * speed + position.y);

        super.draw(batch);
    }
}
