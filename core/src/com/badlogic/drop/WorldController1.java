package com.badlogic.drop;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by aritz on 16/05/2018.
 */

public class WorldController1 extends WorldController implements InputProcessor{

    private OrthographicCamera camera;
    private Minigame1 mGame;

    private boolean isFoodSelected = false;
    private Restaurant_Food foodSlected;

    WorldController1(Minigame1 game){
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
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        Vector3 touchPos3 = camera.unproject(new Vector3(screenX, screenY, 0));
        Vector2 touchPos = new Vector2(touchPos3.x,touchPos3.y);
        //check if fruit is selected
        for (GameObject object : mGame.objects ) {
            if(object.isPointInBounds(touchPos)){
                if(object.getClass() == Restaurant_Food.class){
                    isFoodSelected = true;
                    foodSlected = (Restaurant_Food) object;
                }
            }
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        if(isFoodSelected){
            Vector3 touchPos3 = camera.unproject(new Vector3(screenX, screenY, 0));
            Vector2 touchPos = new Vector2(touchPos3.x,touchPos3.y);
            //check if the fruit is above a table
            for (GameObject object : mGame.objects ) {
                if(object.isPointInBounds(touchPos)){
                    if(object.getClass() == Restaurant_Table.class){
                        isFoodSelected = false;
                        foodSlected.dropFood((Restaurant_Table)object);
                        return true;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        isFoodSelected = false;
        foodSlected.dropFood();

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        Vector3 touchPos3 = camera.unproject(new Vector3(screenX, screenY, 0));
        Vector2 touchPos = new Vector2(touchPos3.x,touchPos3.y);

        if(isFoodSelected){
            foodSlected.position = touchPos;
        }

        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Vector3 touchPos3 = camera.unproject(new Vector3(screenX, screenY, 0));
        Vector2 touchPos = new Vector2(touchPos3.x,touchPos3.y);
        System.out.printf("Mouse %d, %d",touchPos.x,touchPos.y);
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

