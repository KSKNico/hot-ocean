package com.nico.hotwater;

import com.badlogic.gdx.math.Vector2;
import java.lang.Math;

public class Ship extends Entity {
    public Vector2 targetPosition;
    public Vector2 targetVector;
    public float speed = 1;
    public float turningRate = 1f;
    public float maximumSpeed;
    public float decelerationRate;
    public boolean destroyed = false;
    public boolean reachedTarget = false;
    public int team;

    public Ship(Vector2 position, Vector2 facing) {
        super();

        this.facing = facing.nor();
        this.position = position;
    }

    public void update() {
        if (targetPosition != null && reachedTarget == false) {
            this.moveToTarget();
            if(reachedTarget) {
                targetPosition = null;
            }
        } else {
            speed -= decelerationRate;
        }

        if (speed < 0) {
            speed = 0;
        } else if (speed > maximumSpeed) {
            speed = maximumSpeed;
        }
        reachedTarget();
        position = new Vector2(facing.x * speed + position.x, facing.y * speed + position.y);

    }

    public void moveToTarget() {
        this.targetVector = new Vector2( targetPosition.x - position.x, targetPosition.y - position.y );
        if (Math.abs(targetVector.angle()-facing.angle()) > 2) {
            facing.rotate(Math.signum(targetVector.dot((facing.cpy()).rotate90(1))) * turningRate * speed * speed);
        }
        speed += 0.01;
    }

    public void reachedTarget() {
        if (targetPosition != null) {
            if (Vector2.dst(position.x, position.y, targetPosition.x, targetPosition.y) < 10) {
                reachedTarget = true;
            } else {
                reachedTarget = false;
            }
        }
    }

    public void findTarget(Ship player) {

    }
}
