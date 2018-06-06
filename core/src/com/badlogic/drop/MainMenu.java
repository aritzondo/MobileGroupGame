package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cristina on 06/06/2018.
 */

public class MainMenu extends BaseMinigame {
    BaseButton play;
    BaseButton exit;

    MainMenu(WorldController wc) {
        super(wc);
        play = new BaseButton("PLAY", this.wc, new Vector2(-Constants.VIEWPORT_WIDTH/2, 0), new Vector2(10,5)){
            @Override
            public void buttonClicked() {
                super.buttonClicked();
                System.out.print("clicooo");
                wC.scene = WorldController.Scene.Minigame1;
            }
        };
        objectsOfLevel.add(play);


        exit = new BaseButton("EXIT", this.wc, new Vector2(-Constants.VIEWPORT_WIDTH/2, -5f), new Vector2(10,5))
        {
            @Override
            public void buttonClicked() {
                super.buttonClicked();
                Gdx.app.exit();
            }
        };
        objectsOfLevel.add(exit);
    }


    @Override
    public void GUI(SpriteBatch batch) {

    }
}
