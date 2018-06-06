package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by aritz on 06/06/2018.
 */

public class Button extends GameObject {

    Sprite sprite;

    public Button(String name, float x, float y) {
        super(name, x, y);
    }

    public Button(String name, float x, float y, float width, float height, Sprite sprite){
        super(name, x, y);
        dimension = new Vector2(width, height);
        this.sprite = sprite;
        resizeSprite();
        bounds = sprite.getBoundingRectangle();
    }

    private void resizeSprite(){
        float scaleX = dimension.x/sprite.getWidth();
        float scaleY = dimension.y/sprite.getHeight();

        sprite.setScale(scaleX, scaleY);

        sprite.setPosition(position.x-sprite.getWidth()/2,position.y-sprite.getHeight()/2);
    }

    public void clicked(){
        System.out.printf("%s has been clicked\n",name);
    }

    @Override
    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }
}
