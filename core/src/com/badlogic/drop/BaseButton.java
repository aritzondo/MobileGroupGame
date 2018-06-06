package com.badlogic.drop;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cristina on 06/06/2018.
 */

public class BaseButton extends GameObject {

    private Texture buttonImage;
    public String buttonText;
    public BitmapFont font;
    protected WorldController wC;

    public BaseButton(String buttonText, WorldController wc, Vector2 position, Vector2 dimension){
        font = new BitmapFont();
        this.buttonText = buttonText;
        this.wC = wc;
        this.position = new Vector2(position);
        this.dimension = new Vector2(dimension);

        this.buttonImage = Assets.getInstance().button;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(buttonImage, position.x, position.y, dimension.x, dimension.y);
        font.setColor(Color.WHITE);
        font.getData().setScale(dimension.x*0.01f, dimension.y*0.02f);
        font.draw(batch, buttonText, position.x+dimension.x/5, position.y+dimension.y*2/3);
    }

    @Override
    public void update(float elpasedTime) {
        Vector2 currentTouch = wC.getCurrentTouch();
        if(currentTouch.x > position.x && currentTouch.y > position.y && currentTouch.x < position.x + dimension.x && currentTouch.y < position.y + dimension.y)
        {
            buttonClicked();
        }
    }

    public void buttonClicked() {

    }
}
