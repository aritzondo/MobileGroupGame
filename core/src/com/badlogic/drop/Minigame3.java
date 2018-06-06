package com.badlogic.drop;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by aritz on 22/05/2018.
 */

public class Minigame3 extends BaseMinigame {

    Minigame3(WorldController wc) {
        super(wc);
        BaseButton play = new BaseButton("NEXT LEVEL", wc, new Vector2(-Constants.VIEWPORT_WIDTH/2, 0), new Vector2(10,5)){
            @Override
            public void buttonClicked() {
                super.buttonClicked();
                System.out.print("clicooo");
                wC.scene = WorldController.Scene.Minigame4;
            }
        };
        objectsOfLevel.add(play);
    }
}
