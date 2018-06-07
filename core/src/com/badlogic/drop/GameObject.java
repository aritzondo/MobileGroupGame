package com.badlogic.drop;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;


public abstract class GameObject {

    protected String name;
    protected float time=0.0f;
    protected ArrayList<Animation<TextureRegion>> animations = new ArrayList<Animation<TextureRegion>>(2);
    protected Animation<TextureRegion> actualAnimation = null;
    protected int animIndex = -1;

    protected Vector2 position;
    protected Vector2 speed = new Vector2();
    protected Vector2 dimension;
    protected Vector2 origin;
    protected Rectangle bounds;

    WorldController wc;

    protected int score = 0;

    public GameObject(String name,float x, float y){
        this.name = name;
        position = new Vector2(x,y);
        origin = position;
        speed = Vector2.Zero;
    }

    public GameObject(String name, float x, float y, float width, float height){
        this.name = name;
        position = new Vector2(x,y);
        dimension = new Vector2(width,height);

        origin = position;
        bounds = new Rectangle(origin.x-dimension.x/2,origin.y-dimension.y/2,dimension.x,dimension.y);
        speed = Vector2.Zero;
    }

    public GameObject(String name, float x, float y, float width, float height, float centerX, float centerY){
        this.name = name;
        position = new Vector2(x,y);
        dimension = new Vector2(width,height);

        origin = new Vector2(centerX, centerY);
        bounds = new Rectangle(origin.x-dimension.x/2,origin.y-dimension.y/2,dimension.x,dimension.y);
        speed = Vector2.Zero;
    }

    public void render(SpriteBatch batch){
        if(actualAnimation!=null){
            TextureRegion tr = actualAnimation.getKeyFrame(time);
            batch.draw(tr,position.x - dimension.x/2,position.y - dimension.y/2,dimension.x,dimension.y);
        }
    }

    public void update(float delta){
        time+=delta;
        position = new Vector2(position.x + speed.x * delta , position.y + (speed.y * delta));
    }

    public float getX(){
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public String getName() {
        return name;
    }

    public void setX(float x) {
        position.x = x;
    }

    public void setY(float y) {
        position.y = y;
    }

    public void setPosition(float x, float y){
        position = new Vector2(x,y);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSpeed(float x, float y){
        speed.add(x,y);
    }
    public boolean isPointInBounds(Vector2 point){

        return bounds.contains(point.x,point.y);
    }

    public GameObject(){
        bounds = new Rectangle();
    }
}
