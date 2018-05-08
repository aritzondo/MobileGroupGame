package com.badlogic.drop;

import com.badlogic.gdx.Game;

public class GameMain extends Game{
    @Override
    public void create(){
        setScreen(new MainMenuScreen(this));
    }
}
