package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by aritz on 06/06/2018.
 */

public class TestButton extends Button {

    public TestButton(String name, float x, float y, float width, float height, Sprite sprite) {
        super(name, x, y, width, height, sprite);
    }

    @Override
    public void clicked() {
        System.out.printf("This is a button of TestButton class");
    }
}
