package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cristina on 06/06/2018.
 */

public class FruitBox extends GameObject{

    Texture fruitBox;
    int positiXClampedMin;
    int positiXClampedMax;
    FruitBox(WorldController wc, Vector2 position, Vector2 dimension) {
        fruitBox = Assets.getInstance().fruitBox;
        this.wc = wc;
        this.position = position;
        this.dimension = dimension;

        positiXClampedMin = -6;
        positiXClampedMax = -2;
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        position.x = MathUtils.clamp(position.x, positiXClampedMin, positiXClampedMax);
        if(position.x <= positiXClampedMin || position.x >= positiXClampedMax)
        {
            damage();
        }

        if(life <= 0)
        {
            wc.changeScene(WorldController.Scene.Minigame3);
        }

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(fruitBox, position.x, position.y, dimension.x, dimension.y);
    }

}
