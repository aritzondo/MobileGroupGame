package com.badlogic.drop;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class WorldRenderer {
    //private
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldController controller;
    private BitmapFont font;

    public WorldRenderer(WorldController wd){
        controller=wd;
        init();
        controller.setCamera(camera);
        font = new BitmapFont();
    }

    private void init(){
        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0,0,0);
        batch = new SpriteBatch();
        camera.update();
    }

    void render(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.end();

    }

    void renderPause(){
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        font.draw(batch,"Press the screen to resume",0,0);
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
