package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by aritz on 06/06/2018.
 */

public class Client_Table extends GameObject {

    private Sprite sprite;
    private int foodRequestedType = -1;
    private Sprite foodRequested = null;
    private Vector2 foodOffset = new Vector2(0,1.5f);
    private Minigame4 mGame;
    private float timeToLeave = 30;
    private float timeLeft;
    private float timeToComeBack= 15;

    Client_Table(String name, float x, float y, float width, float height, Sprite sprite, Minigame4 game){
        super(name, x, y);
        dimension = new Vector2(width, height);
        this.sprite = new Sprite(sprite);
        resizeSprite();
        bounds = sprite.getBoundingRectangle();
        mGame = game;
        timeLeft = timeToLeave;
        askForFood();
    }

    @Override
    public void render(SpriteBatch batch) {

        sprite.draw(batch);
        if(foodRequested != null){
            foodRequested.draw(batch);
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
    }

    private void askForFood(){
        foodRequestedType = MathUtils.random(0, Minigame4.FoodType.Count.ordinal()-1);
        Sprite food = Assets.getInstance().getFoodOfType(Minigame4.FoodType.values()[foodRequestedType]);
        foodRequested = food;

        resizeFood();
    }

    private void resizeFood(){
        float scaleX = dimension.x/foodRequested.getWidth();
        float scaleY = dimension.y/foodRequested.getHeight();

        foodRequested.setScale(scaleX/6, scaleY/6);

        foodRequested.setPosition(position.x-foodRequested.getWidth()/2+foodOffset.x,position.y-foodRequested.getHeight()/2+foodOffset.y);
    }

    public boolean checkDrop(Restaurant_Food drop){
        return bounds.overlaps(drop.bounds)  && foodRequestedType == drop.mType.ordinal();
    }

}
