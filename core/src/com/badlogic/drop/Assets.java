package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by aritz on 06/03/2018.
 */

public class Assets {
    /*
    *private
     */
    //single instance of the class
    private static Assets instance = null;

    /*
    *public
     */
    //HUD
    public Texture header;
    public Texture[] lifeBar;
    public Texture background;
    public Texture button;
    //Minigame2
    public Texture fruitBox;
    public Texture handle;
    public Texture temperatureBar;
    public Texture truck;

    //Sprites
    public Sprite appleSprite;
    public Sprite bananaSprite;
    public Sprite orangeSprite;
    public Sprite tableSprite;


    private Assets(){
        appleSprite = new Sprite(new Texture(Gdx.files.internal("apple.png")));
        bananaSprite = new Sprite(new Texture(Gdx.files.internal("banana.png")));
        orangeSprite = new Sprite(new Texture(Gdx.files.internal("orange.png")));
        tableSprite = new Sprite(new Texture(Gdx.files.internal("mesa.png")));

        //HUD
        header = new Texture(Gdx.files.internal("header.png"));

        lifeBar = new Texture[2];
        lifeBar[0] = new Texture(Gdx.files.internal("lifeBar.png"));
        lifeBar[1] = new Texture(Gdx.files.internal("lifeBarRemove.png"));

        background = new Texture(Gdx.files.internal("background.png"));
        button = new Texture(Gdx.files.internal("button.png"));

        //minigame2
        fruitBox = new Texture(Gdx.files.internal("minigame2/boxFruit.png"));
        handle = new Texture(Gdx.files.internal("minigame2/handle.png"));
        temperatureBar = new Texture(Gdx.files.internal("minigame2/temperatureBar.png"));
        truck = new Texture(Gdx.files.internal("minigame2/truck.png"));
    }

    public static Assets getInstance(){

        if(instance == null){
            instance = new Assets();
        }
        return instance;
    }
}
