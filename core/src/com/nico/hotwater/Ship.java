package com.nico.hotwater;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ship extends Sprite {
    public Vector2 position;
    public Vector2 facing;
    public Vector2 targetPosition;
    public Vector2 targetVector;
    public float speed = 3;
    public int team;

    public Ship(Vector2 position, Vector2 facing) {
        super();

        this.facing = facing.nor();
        this.position = position;
    }

    @Override
    public void draw(Batch batch) {
        this.setRotation(facing.angle());
        this.setPosition(position.x, position.y);
        this.update();
        super.draw(batch);
    }

    public void update() {
        this.moveToTarget();
        position = new Vector2(facing.x * speed + position.x, facing.y * speed + position.y);
        speed -= 0.01;
        if (speed < 0) {
            speed = 0;
        }
    }
    public void moveToTarget() {
        if (targetPosition != null) {
            this.targetVector = new Vector2( targetPosition.x - position.x, targetPosition.y - position.y );
            if (targetVector.angle()-facing.angle() > 2) {
                facing.rotate(0.5f);
            }
        }
    }
}
