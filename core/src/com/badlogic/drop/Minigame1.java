package com.badlogic.drop;

import com.badlogic.gdx.math.Vector2;

public class Minigame1 extends BaseMinigame {

    Minigame1(WorldController wc) {
        super(wc);
        BaseButton play = new BaseButton("NEXT LEVEL", wc, new Vector2(-Constants.VIEWPORT_WIDTH/2, 0), new Vector2(10,5)){
            @Override
            public void buttonClicked() {
                super.buttonClicked();
                System.out.print("clicooo");
                wC.scene = WorldController.Scene.Minigame2;
            }
        };
        objectsOfLevel.add(play);
    }
}