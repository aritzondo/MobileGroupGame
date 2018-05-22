package com.badlogic.drop;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by aritz on 22/05/2018.
 */

public class WorldController3 extends WorldController {
    private Minigame3 mGame;

    WorldController3(Minigame3 game){
        mGame = game;
    }

    void setCamera(OrthographicCamera cam){

        camera=cam;
    }

    void update(float delta){

        camera.update();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {return false;}

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {return false;}

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {return false;}

    @Override
    public boolean mouseMoved(int screenX, int screenY) {return false;}

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
