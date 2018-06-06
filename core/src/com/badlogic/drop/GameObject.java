package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;


public class GameObject {
    protected String name;
    protected float time=0.0f;
    protected ArrayList<Animation<TextureRegion>> animations = new ArrayList<Animation<TextureRegion>>(2);
    protected Animation<TextureRegion> actualAnimation = null;
    protected int animIndex = -1;

    protected Vector2 position;
    protected Vector2 speed;
    protected  Vector2 dimension;
    protected Vector2 origin;
    protected Rectangle bounds;

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

    public float getWidth() {
        return dimension.x;
    }

    public float getHeight() {
        return dimension.y;
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

    public void setWidth(float width) {
        dimension.x = width;
    }

    public void setHeight(float height) {
        dimension.y = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(float x, float y){
        origin = new Vector2(x,y);
    }

    public Rectangle getBoundaries(){
        return bounds;
    }

    public int addAnimation(TextureRegion tr, float time){
        addAnimation(new Animation<TextureRegion>(time, tr));
        return animations.size();
    }

    public int addAnimation(Animation<TextureRegion> animation){
        animations.add(animation);
        if(animIndex < 0){
            animIndex = 0;
            actualAnimation = animations.get(animIndex);
        }
        return animations.size();
    }

    public void changeAnimation(int index){
        animIndex = index;
        actualAnimation = animations.get(index);
        time = 0.0f;
    }

    public void setLoop(boolean loop, int animIndex){
        if(loop){
            animations.get(animIndex).setPlayMode(Animation.PlayMode.LOOP);
        }
        else{
            animations.get(animIndex).setPlayMode(Animation.PlayMode.NORMAL);
        }
    }

    public void setSpeed(Vector2 newSpeed){
        speed = newSpeed;
    }

    public boolean isPointInBounds(Vector2 point){

        return bounds.contains(point.x,point.y);
    }

    public boolean isObjectInBounds(GameObject other) {
        return bounds.overlaps(other.bounds);
    }
}
