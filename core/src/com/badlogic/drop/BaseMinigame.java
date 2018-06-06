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
    private BaseButton buttonBackToMenu = new BaseButton("BACK", wc, new Vector2(0,0),new Vector2(1,1)){
        @Override
        public void buttonClicked() {
            super.buttonClicked();
            //wc.changeScene(wc.Scene.Menu);
        }
    };
    protected float dt = 0;
    protected boolean nextLevel = false;

    @Override
    public void render(SpriteBatch batch) {
        drawHeader(batch);
        for(int i = 0; i < objectsOfLevel.size(); i++){
            objectsOfLevel.get(i).render(batch);
        }
    }

    @Override
    public void update(float elpasedTime) {
        checkDead();
    }

    private void levelUpdate() {

    }

    public void checkDead(){
        if(lives <= 0)
        {
            //System.out.print("muero");//muero y siguiente nivel
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
