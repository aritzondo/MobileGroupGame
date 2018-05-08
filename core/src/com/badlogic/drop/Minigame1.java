package com.badlogic.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import java.util.ArrayList;

public class Minigame1 extends GameScreen {

    WorldController controller;
    WorldRenderer renderer;
    ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public Minigame1(Game game) {
        super(game);
        GameObject test = new GameObject("test",0,0,1,1);
        test.addAnimation(Assets.getInstance().playerIdle);
        test.setLoop(true,0);
        objects.add(test);
    }

    @Override
    public void show () {
        Gdx.app.debug("Game", "main menu created");
        controller = new WorldController();
        renderer = new WorldRenderer(controller,objects);
    }

    @Override
    public void render (float delta) {
        controller.update(delta);
        for(GameObject object : objects){
            object.update(delta);
        }
        renderer.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY) || Gdx.input.justTouched()) {
            game.setScreen(new MainMenuScreen(game));
        }
    }

    @Override
    public void hide () {
        Gdx.app.debug("Game", "dispose main menu");
        renderer.dispose();
    }
}