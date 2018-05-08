package com.badlogic.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen extends GameScreen {

    SpriteBatch batch;
    WorldController controller;
    WorldRenderer renderer;

    public MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show () {
        Gdx.app.debug("Game", "main menu created");
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);
        controller = new WorldController();
        renderer = new WorldRenderer(controller);
    }

    @Override
    public void render (float delta) {
        update(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.end();
    }

    @Override
    public void hide () {
        Gdx.app.debug("Game", "dispose main menu");
        batch.dispose();
    }

    private void update(float delta){
        controller.update(delta);
        renderer.render();
    }

}
