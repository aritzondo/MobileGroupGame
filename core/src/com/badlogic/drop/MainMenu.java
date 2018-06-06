package com.badlogic.drop;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cristina on 06/06/2018.
 */

public class MainMenu extends BaseMinigame {
    BaseButton play;
    BaseButton exit;

    MainMenu(WorldController wc)
    {
        this.wc = wc;
        play = new BaseButton("PLAY", wc, new Vector2(Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/6), new Vector2(1,1));
        wc.objects.add(play);
        exit = new BaseButton("EXIT", wc, new Vector2(Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/3), new Vector2(1,1));
        wc.objects.add(exit);
    }
}
