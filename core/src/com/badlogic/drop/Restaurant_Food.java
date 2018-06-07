package com.badlogic.drop;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;


public class Restaurant_Food extends GameObject {

    public Minigame4.FoodType mType;
    public boolean active = true;

    private Sprite sprite;
    private Vector2 iniPos;
    private WorldController wc;
    private boolean clicked = false;
    private Minigame4 mGame;

    public Vector3 colorTint = new Vector3(1,1,1);
    public Restaurant_Food next = this;

    Restaurant_Food(String name, float x, float y, float width, float height) {
        super(name, x, y, width, height);
    }

    Restaurant_Food (String name, float x, float y, float width, float height, Sprite sprite, WorldController wc, Minigame4 game, Minigame4.FoodType type){
        super(name, x, y);
        dimension = new Vector2(width, height);
        this.sprite = new Sprite(sprite);
        resizeSprite();
        bounds = this.sprite.getBoundingRectangle();
        iniPos = position;
        this.wc = wc;
        mGame = game;
        mType = type;
    }

    @Override
    public void update(float delta) {
        if(active) {
            super.update(delta);
            if (!clicked) {
                if (wc.touching && bounds.contains(wc.currentTouch.x, wc.currentTouch.y)) {
                    clicked = true;
                }
            } else {
                if (wc.touching || wc.draging) {
                    setPosition(wc.currentTouch);
                } else if (wc.released) {
                    clicked = false;
                    dropFood();
                }

            }
        }
    }

    //check if can be drop on a table or return it to the initial position
    public void dropFood(){
        for (Client_Table client : mGame.clients){
            if(client.checkDropInBounds(this)){
                dropFood(client);
                break;
            }
        }
        setPosition(iniPos);
    }

    public void dropFood(Client_Table client){
        clicked = false;
        active = false;
        client.serveFood();
    }

    @Override
    public void render(SpriteBatch batch) {
        if(active) {
            sprite.draw(batch);
        }
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
        bounds = sprite.getBoundingRectangle();
    }

    public void changeFood(Sprite spr, Minigame4.FoodType type){
        sprite = new Sprite(spr);
        resizeSprite();

        mType = type;

        active = true;
    }

    public void setScale(float scale){
        float scaleX = scale*sprite.getWidth();
        float scaleY = scale*sprite.getHeight();

        sprite.setScale(scaleX, scaleY);

        sprite.setPosition(position.x-sprite.getWidth()/2,position.y-sprite.getHeight()/2);
    }
}
