package com.badlogic.drop;

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

    protected float dt = 0;
    protected boolean nextLevel = false;

    BitmapFont text;

    BaseMinigame(WorldController wc){
        this.wc = wc;
        objectsOfLevel = new ArrayList<GameObject>();
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

    private void levelUpdate()
    {

    }

    public void checkDead()
    {
        if(lives <= 0)
        {
            //System.out.print("muero");//muero y siguiente nivel
        }
    }

    public void GUI(SpriteBatch batch)
    {
        batch.draw(Assets.getInstance().header, -9, 3.2f, 20, 1.8f);
        batch.draw(Assets.getInstance().lifeBar[0], 0, 0f, 1, 1);
        batch.draw(Assets.getInstance().lifeBar[1], 0, 0,1,1);
        BaseButton buttonBackToMenu = new BaseButton("BACK", wc, new Vector2(-8,3.3f),new Vector2(2,1.5f)){
            @Override
            public void buttonClicked() {
                wc.changeScene(WorldController.Scene.Menu);
            }
        };
        buttonBackToMenu.render(batch);


        //text
        text.draw(batch, "Minigame: " + wc.scene, -6, 3.3f);

/*
        time.getData().setScale(Gdx.graphics.getWidth()*0.0015f);
        time.draw(batch, "Time: "+((int)elapsedTime), Constants.WIDTH_RATIO*(3.9f), Constants.dimension(0, 4.6f).y);*/
    }

    public void reset(){

    }
}
