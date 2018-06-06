package com.badlogic.drop;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Restaurant_Table extends GameObject {

    public Sprite sprite;

    private Minigame4 mGame;
    private ArrayList<Restaurant_Food> food = new ArrayList<Restaurant_Food>();

    Restaurant_Table(String name, float x, float y, float width, float height, Sprite sprite,Minigame4 game){
        super(name, x, y);
        dimension = new Vector2(width, height);
        this.sprite = new Sprite(sprite);
        resizeSprite();
        bounds = sprite.getBoundingRectangle();
        mGame = game;
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    private void resizeSprite(){
        float scaleX = dimension.x/sprite.getWidth();
        float scaleY = dimension.y/sprite.getHeight();

        sprite.setScale(scaleX, scaleY);

        sprite.setPosition(position.x-sprite.getWidth()/2,position.y-sprite.getHeight()/2);
    }

    public void setPosition(Vector2 newPos){
        super.setPosition(newPos.x, newPos.y);
        setSpritePosition();
    }

    private void setSpritePosition(){
        sprite.setPosition(position.x-sprite.getWidth()/2,position.y-sprite.getHeight()/2);
    }

}
