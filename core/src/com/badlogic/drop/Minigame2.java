package com.badlogic.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by aritz on 22/05/2018.
 */

public class Minigame2 extends Minigame {
    public Minigame2(Game game) {
        super(game);
        GameObject test = new GameObject("test",0,0,1,1);
        System.out.printf("Ship in %f, %f\n", test.getX(),test.getY());
        test.addAnimation(Assets.getInstance().walkAnimation);
        test.setLoop(true,0);
        objects.add(test);
    }

    @Override
    public void show () {
        Gdx.app.debug("Game", "main menu created");
        controller = new WorldController2(this);
        renderer = new WorldRenderer2(controller,objects);
    }

    @Override
    public void render (float delta) {
        controller.update(delta);
        for(GameObject object : objects){
            object.update(delta);
        }
        renderer.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            game.setScreen(new Minigame3(game));
        }
    }

    @Override
    public void hide () {
        renderer.dispose();
    }
}
