package com.nico.hotwater;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import java.lang.Math;

public class Ship extends Sprite {
    public Vector2 position;
    public Vector2 facing;
    public Vector2 targetPosition;
    public Vector2 targetVector;
    public float speed = 1;
    public float turningRate = 1f;
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
        if (targetPosition != null) {
            this.moveToTarget();
            if(this.reachedTarget()) {
                targetPosition = null;
            }
        } else {
            speed -= 0.1;
        }

        if (speed < 0) {
            speed = 0;
        } else if (speed > 5) {
            speed = 5;
        }
        position = new Vector2(facing.x * speed + position.x, facing.y * speed + position.y);

    }

    public void moveToTarget() {
        this.targetVector = new Vector2( targetPosition.x - position.x, targetPosition.y - position.y );
        if (Math.abs(targetVector.angle()-facing.angle()) > 2) {
            facing.rotate(Math.signum(targetVector.dot((facing.cpy()).rotate90(1))) * turningRate);
        }
        speed += 0.01;
    }

    public boolean reachedTarget() {
        if (Vector2.dst(position.x, position.y, targetPosition.x, targetPosition.y) < 10) {
            return true;
        } else {
            return false;
        }
    }
}
