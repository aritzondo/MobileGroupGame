package com.badlogic.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.ArrayList;

public class MainMenuScreen extends GameScreen {

    WorldController controller;
    WorldRenderer renderer;
    ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public MainMenuScreen(Game game) {
        super(game);
        GameObject button = new GameObject("button",0,0,1,1);
        button.addAnimation(Assets.getInstance().playerShoot);
        button.setLoop(true,0);
        objects.add(button);
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

        if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            game.setScreen(new Minigame1(game));
        }
    }

    @Override
    public void hide () {
        Gdx.app.debug("Game", "dispose main menu");
        renderer.dispose();
    }
}
