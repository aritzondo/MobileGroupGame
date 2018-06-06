package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cristina on 06/06/2018.
 */

public class Handle extends GameObject{

    Texture handle;
    private boolean clicked = false;

    Handle(WorldController wc, Vector2 position, Vector2 dimension) {
        handle = Assets.getInstance().handle;
        this.wc = wc;
        this.position = position;
        this.dimension = dimension;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        position.y = MathUtils.clamp(position.y, -5, 1);
        bounds = new Rectangle(position.x ,position.y,dimension.x,dimension.y);

        super.update(delta);
        if(!clicked){
            if(wc.touching && bounds.contains(wc.currentTouch.x, wc.currentTouch.y)){
                clicked = true;
            }
        }
        else{
            if(wc.touching || wc.draging){
                setPosition(position.x , wc.currentTouch.y);
            }
            else if(wc.released){
                clicked= false;
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(handle, position.x, position.y, dimension.x, dimension.y);
    }
}
