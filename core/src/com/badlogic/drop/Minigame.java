package com.badlogic.drop;

import com.badlogic.gdx.Game;

import java.util.ArrayList;

/**
 * Created by aritz on 22/05/2018.
 */

public class Minigame extends GameScreen {

    WorldController controller;
    WorldRenderer renderer;
    ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public Minigame(Game game) {
        super(game);
    }
}
