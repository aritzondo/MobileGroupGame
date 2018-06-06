package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Cristina on 06/06/2018.
 */

public abstract class BaseMinigame extends GameObject {
/*
    public enum LevelState
    {
        Playing,
        Dead
    }*/

    private ArrayList<GameObject> objectsOfLevel;
    protected WorldController wc;
    private BaseButton buttonBackToMenu;
    protected float dt = 0;
    protected boolean nextLevel = false;
    //protected LevelState levelState;


    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void update(float elpasedTime) {
/*
        switch (levelState)
        {
            case Playing:
                checkDead();
                levelUpdate();
                break;
            case Dead:
                buttonBackToMenu.update(elpasedTime);
                break;
        }*/
    }

    private void levelUpdate() {
    }

    public void checkDead(){
        if(lives <= 0)
        {
            //muero y siguiente nivel
        }
    }

    public void drawHeader(SpriteBatch batch)
    {
        GUI(batch);
        //Cabecera
        batch.draw(Assets.getInstance().header, 2f, 2f, 1, 1);
        batch.draw(Assets.getInstance().lifeBar[0], 2f, 2f, 1, 1);
        batch.draw(Assets.getInstance().lifeBar[1], 2, 2,1,1);
        buttonBackToMenu.render(batch);
       /* time.getData().setScale(Gdx.graphics.getWidth()*0.0015f);
        time.draw(batch, "Time: "+((int)elapsedTime), Constants.WIDTH_RATIO*(3.9f), Constants.dimension(0, 4.6f).y);*/
    }

    public void GUI(SpriteBatch batch) {

    }

    public void reset(){

    }


}
