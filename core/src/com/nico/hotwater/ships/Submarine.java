package com.nico.hotwater.ships;

import com.badlogic.gdx.math.Vector2;
import com.nico.hotwater.Resources;
import com.nico.hotwater.Ship;

public class Submarine extends Ship {
    public boolean canSubmerge;

    public Submarine(Vector2 position, Vector2 facing) {
        super(position, facing);
        this.set(Resources.getInstance().playerSubmarine);
    }
}
