package com.badlogic.drop;

public class Minigame4 extends BaseMinigame {

<<<<<<< HEAD
public class Minigame4 extends Minigame {

    public TestButton tButton;
    public Restaurant_Table table;

    public Minigame4(Game game) {
        super(game);
        Restaurant_Food test = new Restaurant_Food("test", 5, 5, 1, 1,Assets.getInstance().appleSprite);
        objects.add(test);
        table = new Restaurant_Table("table",0,-5,4,4,Assets.getInstance().tableSprite);
        objects.add(table);
        tButton = new TestButton("testButton",0,0,2,2,Assets.getInstance().buttonImg);
        objects.add(tButton);
=======
    public Minigame4() {
        Restaurant_Food test = new Restaurant_Food("test", 0, 0, 1, 1, Assets.getInstance().appleSprite);
        //objects.add(test);
        Restaurant_Table table = new Restaurant_Table("table",0,0,1,1,Assets.getInstance().tableSprite);
        //objects.add(table);
>>>>>>> 58c13583b5f4e5056f04c0c6a3666ded843645c5
    }
/*
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
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void hide() {
        Gdx.app.debug("Game", "dispose main menu");
        renderer.dispose();
    }*/
}