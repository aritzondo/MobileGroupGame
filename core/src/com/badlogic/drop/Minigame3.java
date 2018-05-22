package com.badlogic.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by aritz on 22/05/2018.
 */

public class Minigame3 extends Minigame {
    public Minigame3(Game game) {
        super(game);
        Restaurant_Food test = new Restaurant_Food("test",0,0,1,1);
        System.out.printf("Ship in %f, %f\n", test.getX(),test.getY());
        test.addAnimation(Assets.getInstance().cloudAnimation);
        test.setLoop(true,0);
        objects.add(test);
    }

    @Override
    public void show () {
        Gdx.app.debug("Game", "main menu created");
        controller = new WorldController3(this);
        renderer = new WorldRenderer3(controller,objects);
    }

    @Override
    public void render (float delta) {
        controller.update(delta);
        for(GameObject object : objects){
            object.update(delta);
        }
        renderer.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            game.setScreen(new Minigame4(game));
        }
    }

    @Override
    public void hide () {
        renderer.dispose();
    }
}
