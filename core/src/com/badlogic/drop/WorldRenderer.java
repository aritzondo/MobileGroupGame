package com.badlogic.drop;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;


public class WorldRenderer {
    //private
    OrthographicCamera camera;
    SpriteBatch batch;
    WorldController wc;
    BitmapFont font;

    public WorldRenderer(WorldController wc){
        this.wc = wc;
        batch = new SpriteBatch();
        font = new BitmapFont();

        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        init();
        font.getData().setScale(1/Constants.VIEWPORT_WIDTH);
    }

    private void init(){
        camera.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0,0,0);

        camera.update();
        wc.camera = camera;

    }

    void render(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        //menu
        batch.draw(Assets.getInstance().background, -Constants.WORLD_WIDTH/2 , -Constants.WORLD_HEIGHT/2, Constants.WORLD_WIDTH , Constants.WORLD_HEIGHT);

        switch (wc.scene)
        {
            case Menu:
                wc.menu.render(batch);
                break;
            case Minigame1:
                wc.minigame1.render(batch);
                break;
            case Minigame2:
                wc.minigame2.render(batch);
                break;
            case Minigame3:
                wc.minigame3.render(batch);
                break;
            case Minigame4:
                wc.minigame4.render(batch);
                break;
        }

        batch.end();
    }

    public void resize(int width, int height){
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT/height)*width;
        camera.update();
    }

    void dispose(){
        font.dispose();
        batch.dispose();
    }
}
