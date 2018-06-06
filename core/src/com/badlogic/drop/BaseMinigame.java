package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Cristina on 06/06/2018.
 */

public abstract class BaseMinigame extends GameObject {

    protected ArrayList<GameObject> objectsOfLevel = new ArrayList<GameObject>();
    protected WorldController wc;

    protected float dt = 0;
    protected boolean nextLevel = false;

    private BaseButton buttonBackToMenu = new BaseButton("BACK", wc, new Vector2(0,0),new Vector2(1,1)){
        @Override
        public void buttonClicked() {
            wc.changeScene(WorldController.Scene.Menu);
        }
    };


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

        buttonBackToMenu.render(batch);
        /*time.getData().setScale(Gdx.graphics.getWidth()*0.0015f);
        time.draw(batch, "Time: "+((int)elapsedTime), Constants.WIDTH_RATIO*(3.9f), Constants.dimension(0, 4.6f).y);*/
    }

    public void reset(){

    }
}
