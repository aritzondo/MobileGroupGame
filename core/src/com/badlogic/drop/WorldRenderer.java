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
    }

    private void init(){
        camera.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0,0,0);

        camera.update();
    }

    void render(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        //menu
        batch.draw(Assets.getInstance().background, -Constants.WORLD_WIDTH/2 , -Constants.WORLD_HEIGHT/2, Constants.WORLD_WIDTH , Constants.WORLD_HEIGHT);



        //minigame2


        //minigame4

        for(int i = 0; i < wc.objects.size(); i++)
        {
            wc.objects.get(i).render(batch);
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
