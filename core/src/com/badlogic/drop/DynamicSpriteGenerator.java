package com.badlogic.drop;


import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class DynamicSpriteGenerator {

    //Just create an empty cube
    public Sprite createCube(int x, int y){
        Pixmap pixmap = new Pixmap(10,10, Pixmap.Format.RGBA8888);
        pixmap.setColor(1,0,0,0.75f);
        pixmap.drawRectangle(0,0,10,10);
        Sprite sprite = new Sprite(new Texture(pixmap));
        sprite.setPosition(x,y);
        return sprite;
    }

    //Load an sprite with the first cloud of the cloudAtlas
    public Sprite spriteFromTexture(int x,int y) {
        Sprite sprite =  new Sprite(Assets.getInstance().cloudAtlas.findRegion("cloud",1));
        sprite.setPosition(x,y);
        sprite.setScale(0.5f,0.5f);
        return sprite;
    }

}
