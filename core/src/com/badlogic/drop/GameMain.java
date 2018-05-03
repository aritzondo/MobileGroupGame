package com.badlogic.drop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;


public class GameMain implements ApplicationListener{
    //private
    private static final GameMain instance = new GameMain();
    private WorldController controller;
    private WorldRenderer renderer;
    private State state;
    //public
    public enum State
    {
        PAUSE,
        RUN,
        RESUME
    }

    private GameMain(){

    }

    public static GameMain getInstance(){
        return instance;
    }

    @Override
    public void create() {
        controller = new WorldController(new Vector2(2,1));
        renderer = new WorldRenderer(controller);
        state = State.RUN;
        Gdx.input.setInputProcessor(controller);

    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    @Override
    public void render() {
        switch(state){
            case RUN:
                runUpdate();
                break;
            case PAUSE:
                pauseMenu();
                break;
            case RESUME:
                pauseMenu();
                break;
        }
    }

    private void runUpdate(){
        float dt = Gdx.graphics.getDeltaTime();
        controller.update(dt);
        renderer.render();
    }

    private  void pauseMenu(){
        renderer.render();
        renderer.renderPause();
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) || Gdx.input.isTouched()) {
            state=State.RUN;
        }
    }

    @Override
    public void pause() {
        state = State.PAUSE;
    }

    @Override
    public void resume() {
        state = State.RESUME;
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    public void reset(){
        create();
    }

}
