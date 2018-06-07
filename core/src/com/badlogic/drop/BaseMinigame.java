package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Cristina on 06/06/2018.
 */

public abstract class BaseMinigame extends GameObject {

    protected ArrayList<GameObject> objectsOfLevel;
    protected WorldController wc;
    protected BaseButton buttonBackToMenu;

    BitmapFont text;
    BitmapFont currentTime;

    protected int life = Constants.TOTAL_LIFE;
    public void setLives(int lives){this.life = lives;}
    public int getLives(){return life;}
    public void damage()
    {
        life--;
        wc.setCurrentLife(life);
    }

    BaseMinigame(WorldController wc){
        this.wc = wc;
        objectsOfLevel = new ArrayList<GameObject>();
        text = new BitmapFont();
        text.setColor(Color.WHITE);
        currentTime = new BitmapFont();
        currentTime.setColor(Color.WHITE);
        buttonBackToMenu = new BaseButton("B A C  K", wc, new Vector2(-8,3.3f),new Vector2(2,1.5f)){
            @Override
            public void buttonClicked() {
                wC.changeScene(WorldController.Scene.Menu);
            }

            @Override
            public void render(SpriteBatch batch) {
                batch.draw(buttonImage, position.x, position.y, dimension.x, dimension.y);
                font.setColor(Color.WHITE);
                font.getData().setScale(0.05f,0.05f);
                font.draw(batch, buttonText, position.x+dimension.x/5, position.y+dimension.y*2/3);
            }
        };
        objectsOfLevel.add(buttonBackToMenu);
    }

    @Override
    public void render(SpriteBatch batch)
    {
        GUI(batch);
        for(int i = 0; i < objectsOfLevel.size(); i++)
        {
            objectsOfLevel.get(i).render(batch);
        }
    }

    @Override
    public void update(float elpasedTime)
    {
        checkDead();

        for(int i = 0; i < objectsOfLevel.size(); i++)
        {
            objectsOfLevel.get(i).update(elpasedTime);
        }

    }

    public void checkDead()
    {

    }

    public void GUI(SpriteBatch batch)
    {
        batch.draw(Assets.getInstance().header, -9, 3.2f, 22, 1.8f);
        batch.draw(Assets.getInstance().lifeBar[0], -3, 3.5f, 7f, 1.1f);
        batch.draw(Assets.getInstance().lifeBar[1], -3, 3.5f, 7f*(Constants.TOTAL_LIFE - wc.getCurrentLife())/Constants.TOTAL_LIFE, 1.1f);

        buttonBackToMenu.render(batch);


        //text
        ///text.draw(batch, "Minigame: " + wc.scene, -6, 3.3f);
        //text.getData().setScale(Gdx.graphics.getWidth()*0.0015f, Gdx.graphics.getHeight()*0.0015f);

        //

        //currentTime.getData().setScale(currentTime.getScaleX()/10);
        //currentTime.draw(batch, "Time: "+((int)dt), 0, 3.5f);
    }

    public void reset(){
        wc.setCurrentLife(10);
        life = Constants.TOTAL_LIFE;
    }

    public void getInputDown(int keyCode)
    {

    }

    public void getInputUp(int keyCode)
    {

    }

    public void getButtonUp(int buttonCode){

    }

    public void getButtonDown(int buttonCode){

    }

    public void getAxis(int index, int axis, float value){

    }
}
