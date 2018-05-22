package com.badlogic.drop;

/**
 * Created by aritz on 22/05/2018.
 */

public class Restaurant_Food extends GameObject {
    Restaurant_Food(String name, float x, float y) {
        super(name, x, y);
    }

    Restaurant_Food(String name, float x, float y, float width, float height) {
        super(name, x, y, width, height);
    }

    Restaurant_Food(String name, float x, float y, float width, float height, float centerX, float centerY) {
        super(name, x, y, width, height, centerX, centerY);
    }

    //check if the table that is below the food is the correct wants that food
    //if not, return it's origin
    public void dropFood(Restaurant_Table table){

    }

    //return the food to it's origin
    public void dropFood(){

    }
}
