package com.badlogic.drop;

public class Minigame4 extends BaseMinigame {

    private WorldController wc;

    Minigame4(WorldController wc) {
        super(wc);
        Restaurant_Food test = new Restaurant_Food("test", 0, 0, 1, 1,Assets.getInstance().appleSprite,wc);
        objectsOfLevel.add(test);
        Restaurant_Table table = new Restaurant_Table("table",0,-5,16,4,Assets.getInstance().tableSprite);
        objectsOfLevel.add(table);
    }
}