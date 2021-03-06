package com.nico.hotwater.ships;

import com.badlogic.gdx.math.Vector2;
import com.nico.hotwater.Resources;
import com.nico.hotwater.Ship;

public class SurfaceShip extends Ship {
    public SurfaceShip(Vector2 position, Vector2 facing) {
        super(position, facing);
        this.maximumSpeed = 0.2f;
        this.decelerationRate = 0.1f;
        this.set(Resources.getInstance().enemyShip);
        this.scale(1.0f);
    }
}
