package com.nico.hotwater;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity extends Sprite {
    public Vector2 position;
    public Vector2 facing;


    public Entity() {
        super();
    }

    @Override
    public void draw(Batch batch) {
        this.setRotation(facing.angle());
        this.setPosition(position.x, position.y);
        this.update();
        super.draw(batch);
    }

    public abstract void update();
}
