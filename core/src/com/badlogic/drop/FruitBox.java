package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cristina on 06/06/2018.
 */

public class FruitBox extends GameObject{
    Texture fruitBox;
    FruitBox(WorldController wc, Vector2 position, Vector2 dimension) {
        fruitBox = Assets.getInstance().fruitBox;
        this.wc = wc;
        this.position = position;
        this.dimension = dimension;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(fruitBox, position.x, position.y, dimension.x, dimension.y);
    }
}
