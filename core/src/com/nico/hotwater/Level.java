package com.nico.hotwater;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.nico.hotwater.ships.SurfaceShip;
import com.nico.hotwater.ships.Torpedo;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Vector;

public class Level {
    public int numberOfEnemies;
    public Vector<Ship> enemies;
    public int maxNumberOfEnemies;

    public Level(int numberOfEnemies, int maxNumberOfEnemies) {
        this.numberOfEnemies = numberOfEnemies;
        this.maxNumberOfEnemies = maxNumberOfEnemies;
        this.enemies = new Vector<>();
    }

    public boolean spawnEnemies() {
        if (enemies.size() <= maxNumberOfEnemies) {
            enemies.add(new SurfaceShip(new Vector2(0, 0), new Vector2(1, 1).setToRandomDirection()));
            return true;
        }
        return false;
    }

    public void removeDestroyed() {
        for(Ship enemy : enemies) {
            if (enemy.destroyed) enemies.remove(enemy);
        }
    }

    public void draw(Batch batch) {
        this.removeDestroyed();
        for (Ship enemy : enemies) {
            enemy.draw(batch);
        }

    }

    public void checkCollision(Ship ship, Torpedo torpedo) {
        // TODO: implement collision detection
    }

}
