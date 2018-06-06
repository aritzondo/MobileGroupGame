package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Restaurant_Food extends GameObject {

    private Sprite sprite;
    private Vector2 iniPos;
    private WorldController wc;
    private boolean clicked = false;

    Restaurant_Food(String name, float x, float y, float width, float height) {
        super(name, x, y, width, height);
    }

    Restaurant_Food (String name, float x, float y, float width, float height, Sprite sprite, WorldController wc){
        super(name, x, y);
        dimension = new Vector2(width, height);
        this.sprite = sprite;
        resizeSprite();
        bounds = sprite.getBoundingRectangle();
        iniPos = position;
        this.wc = wc;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(!clicked){
            if(wc.touching && bounds.contains(wc.currentTouch.x, wc.currentTouch.y)){
                clicked = true;
            }
        }
        else{
            if(wc.touching || wc.draging){
                setPosition(wc.currentTouch);
            }
           else if(wc.released){
                clicked= false;
                dropFood();
            }

        }
    }

    //check if can be drop on a table or return it to the initial position
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
