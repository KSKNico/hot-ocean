package com.nico.hotwater;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.nico.hotwater.screens.GameScreen;
import com.nico.hotwater.ships.Destroyer;
import com.nico.hotwater.ships.SurfaceShip;
import com.nico.hotwater.ships.Torpedo;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Vector;

public class Level {
    public int numberOfEnemies;
    public Vector<Ship> enemies;
    public int maxNumberOfEnemies;
    public int spawnedEnemies = 0;
    public HashMap<String, Integer> enemyMap;

    public Level(int numberOfEnemies, int maxNumberOfEnemies, HashMap<String, Integer> enemyMap ) {
        this.numberOfEnemies = numberOfEnemies;
        this.maxNumberOfEnemies = maxNumberOfEnemies;
        this.enemies = new Vector<>();
        this.enemyMap = enemyMap;
    }

    public boolean spawnEnemies() {
        if (enemies.size() < maxNumberOfEnemies) {
            if (enemyMap.get("destroyer") > 0) {
                enemies.add(new Destroyer(new Vector2(0, 0), new Vector2(1, 1).setToRandomDirection()));

            }
            spawnedEnemies++;
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
            enemy.targetPosition = GameScreen.player.position;
            enemy.draw(batch);
        }

    }

    public void checkCollision(Ship ship, Torpedo torpedo) {
        // TODO: implement collision detection
    }

}
