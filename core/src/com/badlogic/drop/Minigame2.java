package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by aritz on 22/05/2018.
 */

public class Minigame2 extends BaseMinigame {

    WorldController wc;
    FruitBox fruitBox;
    Handle handle;
    Truck truck;
    Texture termostate;
    Minigame2(WorldController wc) {
        super(wc);
        fruitBox = new FruitBox(wc, new Vector2(0,0), new Vector2(3,3));
        handle = new Handle(wc, new Vector2(0,0), new Vector2(3,3));
        truck = new Truck(wc, new Vector2(0,0), new Vector2(3,3));
        termostate = Assets.getInstance().temperatureBar;

        objectsOfLevel.add(fruitBox);
        objectsOfLevel.add(handle);
        objectsOfLevel.add(truck);

    }

    @Override
    public void GUI(SpriteBatch batch) {
        super.GUI(batch);
        batch.draw(termostate, 5, 0);
    }


}
