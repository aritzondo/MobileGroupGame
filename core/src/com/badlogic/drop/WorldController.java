package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class WorldController implements InputProcessor {

    protected OrthographicCamera camera;

    //inputs
    Vector2 currentTouch = new Vector2(0,0);
    boolean touching = false;
    boolean draging = false;
    boolean released = false;
    int currentLife = Constants.TOTAL_LIFE;

    public enum Scene
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
    Scene scene;

    public WorldController(){
        scene = Scene.Menu;
        Gdx.input.setInputProcessor(this);
        init();
    }

    void init()
    {
        menu = new MainMenu(this);
        minigame1 = new Minigame1(this);
        minigame2 = new Minigame2(this);
        minigame3 = new Minigame3(this);
        minigame4 = new Minigame4(this);
        currentTouch = new Vector2();
    }

    public void update(float dt)
    {
        switch (scene){
            case Menu:
                menu.update(dt);
                break;
            case Minigame1:
                minigame1.update(dt);
                break;
            case Minigame2:
                minigame2.update(dt);
                break;
            case Minigame3:
                minigame3.update(dt);
                break;
            case Minigame4:
                minigame4.update(dt);
                break;
        }

        touching = false;
        released = false;
        camera.update();
    }

    void reset(){
        switch (scene){
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

    public int getCurrentLife()
    {
        return currentLife;
    }

    public void changeScene(Scene scene){
         this.scene = scene;
    }


   @Override
    public boolean keyDown(int keycode) {
       return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == (Keys.A)) {
            if(scene == Scene.Minigame2)
            {
                minigame2.getInput(keycode);
            }
            return true;
        }
        if(keycode == (Keys.D)) {
            return true;
        }
        if(keycode == (Keys.W)) {
            return true;
        }
        if(keycode == (Keys.S)) {
            return true;
        }
        if(keycode == (Keys.P))
        {
            changeScene(Scene.Minigame4);
            return true;
        }
        if(keycode == (Keys.M))
        {
            changeScene(Scene.Minigame2);
            System.out.print("presiono m");
            return true;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 touchPos3 = camera.unproject(new Vector3(screenX, screenY, 0));
        currentTouch = new Vector2(touchPos3.x, touchPos3.y);
        touching = true;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        currentTouch = new Vector2(0,0);
        touching = false;
        draging = false;
        released = true;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector3 touchPos3 = camera.unproject(new Vector3(screenX, screenY, 0));
        currentTouch = new Vector2(touchPos3.x, touchPos3.y);
        touching = false;
        draging = true;
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
