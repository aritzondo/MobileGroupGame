package com.badlogic.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Minigame1 extends Minigame {

    public Minigame1(Game game) {
        super(game);
        Restaurant_Food test = new Restaurant_Food("test",0,0,1,1);
        System.out.printf("Ship in %f, %f\n", test.getX(),test.getY());
        test.addAnimation(Assets.getInstance().playerIdle);
        test.setLoop(true,0);
        objects.add(test);
    }

    @Override
    public void show () {
        Gdx.app.debug("Game", "main menu created");
        controller = new WorldController1(this);
        renderer = new WorldRenderer1(controller,objects);
    }

    @Override
    public void render (float delta) {
        controller.update(delta);
        for(GameObject object : objects){
            object.update(delta);
        }
        renderer.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            game.setScreen(new Minigame2(game));
        }
    }

    @Override
    public void hide () {
        Gdx.app.debug("Game", "dispose main menu");
        renderer.dispose();
    }
}