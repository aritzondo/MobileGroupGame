package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Restaurant_Food extends GameObject {

    private Sprite sprite;
    private Vector2 iniPos;

    Restaurant_Food(String name, float x, float y, float width, float height) {
        super(name, x, y, width, height);
    }

    Restaurant_Food (String name, float x, float y, float width, float height, Sprite sprite){
        super(name, x, y);
        dimension = new Vector2(width, height);
        this.sprite = sprite;
        resizeSprite();
        bounds = sprite.getBoundingRectangle();
        iniPos = position;
    }

    //check if the table that is below the food is the correct wants that food
    //if not, return it's origin
    public void dropFood(Restaurant_Table table){

    }

    //return the food to it's origin
    public void dropFood(){
        setPosition(iniPos);
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
