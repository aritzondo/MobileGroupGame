package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Restaurant_Food extends GameObject {

    private Sprite sprite;

    Restaurant_Food(String name, float x, float y, float width, float height) {
        super(name, x, y, width, height);
    }

    Restaurant_Food(String name, float x, float y, float width, float height,Sprite spr) {
        super(name, x, y, width, height);
        sprite = spr;
    }

    //check if the table that is below the food is the correct wants that food
    //if not, return it's origin
    public void dropFood(Restaurant_Table table){

    }

    //return the food to it's origin
    public void dropFood(){

    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
