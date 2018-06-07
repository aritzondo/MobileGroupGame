package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class FruitBox extends GameObject{

    Texture fruitBox;
    int positiXClampedMin;
    int positiXClampedMax;
    private boolean clicked = false;

    FruitBox(WorldController wc,Vector2 position, Vector2 dimension) {
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
        bounds = new Rectangle(position.x ,position.y,dimension.x,dimension.y);

        //Mobile
        if (!clicked)
        {
            if (wc.touching && bounds.contains(wc.currentTouch.x, wc.currentTouch.y)){
                clicked = true;
                System.out.print("he clicao");
            }
        }
        else
        {
            if (wc.touching || wc.draging){
                setPosition(wc.currentTouch.x, position.y);
            } else if (wc.released){
                clicked = false;
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(fruitBox, position.x, position.y, dimension.x, dimension.y);
    }

}
