package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cristina on 06/06/2018.
 */

public class Truck extends GameObject{

    Texture truck;

    Truck(WorldController wc, Vector2 position, Vector2 dimension) {
        truck = Assets.getInstance().truck;
        this.wc = wc;
        this.position = position;
        this.dimension = dimension;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(truck, position.x, position.y, dimension.x, dimension.y);
    }
}
