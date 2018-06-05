package com.badlogic.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by aritz on 22/05/2018.
 */

public class Minigame4 extends Minigame {

    public Minigame4(Game game) {
        super(game);
        Restaurant_Food test = new Restaurant_Food("test", 0, 0, 1, 1);
        test.addAnimation(Assets.getInstance().playerIdle);
        test.setLoop(true, 0);
        objects.add(test);
    }

    @Override
    public void show() {
        Gdx.app.debug("Game", "main menu created");
        controller = new WorldController4(this);
        Gdx.input.setInputProcessor(controller);
        renderer = new WorldRenderer4(controller, objects);
    }

    @Override
    public void render(float delta) {
        controller.update(delta);
        for (GameObject object : objects) {
            object.update(delta);
        }
        renderer.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            game.setScreen(new MainMenuScreen(game));
        }
    }

    @Override
    public void hide() {
        Gdx.app.debug("Game", "dispose main menu");
        renderer.dispose();
    }
}