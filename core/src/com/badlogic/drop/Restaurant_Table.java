package com.badlogic.drop;

import com.badlogic.drop.GameObject;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Restaurant_Table extends GameObject {

    public Sprite sprite;

    Restaurant_Table(String name, float x, float y, float width, float height,Sprite spr) {
        //super(name, x, y, width, height);
        sprite = spr;
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void update(float elpasedTime) {

    }

}
