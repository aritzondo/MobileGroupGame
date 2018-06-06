package com.badlogic.drop;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;


public class WorldController implements InputProcessor {

    protected OrthographicCamera camera;

    //inputs
    Vector2 currentTouch;

    //Objects
    ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public enum ScreenMode
    {
        Menu,
        Minigame1,
        Minigame2,
        Minigame3,
        Minigame4
    }

    MainMenu menu;
    Minigame1 minigame1;
    Minigame2 minigame2;
    Minigame3 minigame3;
    Minigame4 minigame4;
    ScreenMode screenMode;


    public WorldController(){
        screenMode = ScreenMode.Menu;
        init();
    }

    void init()
    {
        menu = new MainMenu(this);
        minigame1 = new Minigame1();
        minigame2 = new Minigame2(this);
        minigame3 = new Minigame3();
        minigame4 = new Minigame4();
        currentTouch = new Vector2();
    }

    public void update(float dt)
    {
        switch (screenMode){
            case Menu:
                menu.update(dt);
                break;
            case Minigame1:
                break;
            case Minigame2:
                minigame2.update(dt);
                break;
            case Minigame3:
                break;
            case Minigame4:
                minigame4.update(dt);
                break;
        }

        camera.update();
    }

    void reset(){
        switch (screenMode){
            case Menu:
                menu.reset();
                break;
            case Minigame1:
                minigame1.reset();
                break;
            case Minigame2:
                minigame2.reset();
                break;
            case Minigame3:
                minigame3.reset();
                break;
            case Minigame4:
                minigame4.reset();
                break;
        }
    }

    public Vector2 getCurrentTouch()
    {
        return currentTouch;
    }

   @Override
    public boolean keyDown(int keycode) {
       if(keycode == (Input.Keys.A)) {
           return true;
       }
       if(keycode == (Input.Keys.D)) {
           return true;
       }
       if(keycode == (Input.Keys.W)) {
           return true;
       }
       if(keycode == (Input.Keys.S)) {
           return true;
       }

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
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        currentTouch = new Vector2(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        currentTouch = new Vector2(screenX, screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
