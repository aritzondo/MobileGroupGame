package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Input.Keys;
import java.util.Random;


public class Minigame2 extends BaseMinigame {

    FruitBox fruitBox;
    Handle handle;
    Truck truck;
    float currentTemperature;
    float addSpeed;
    Random random;
    int counterTemperature = 0;
    int counterOfRandomMovement = 0;

    Minigame2(WorldController wc) {
        super(wc);
        fruitBox = new FruitBox(wc, this, new Vector2(-4,-3), new Vector2(3,3));
        handle = new Handle(wc, new Vector2(3.7f,-3), new Vector2(4,3));
        truck = new Truck(wc, new Vector2(-8,-5), new Vector2(11,8));
        objectsOfLevel.add(fruitBox);
        objectsOfLevel.add(handle);
        objectsOfLevel.add(truck);
        addSpeed = Constants.FRUITBOX_SPEED;
        random = new Random();
    }

    @Override
    public void GUI(SpriteBatch batch) {
        super.GUI(batch);
        batch.draw(Assets.getInstance().temperatureBar[1], 3.9f, -4.7f, 3.7f, 8 * (Constants.TOTAL_TEMPERATURE - currentTemperature)/Constants.TOTAL_TEMPERATURE);
        batch.draw(Assets.getInstance().temperatureBar[0], 3.9f, -4.8f, 3.7f, 8);
    }

    @Override
    public void update(float elpasedTime) {
        super.update(elpasedTime);
        counterTemperature++;
        int counterOfRandomMovement = 0;

        if(counterTemperature > 80)
        {
            counterTemperature = 0;
            currentTemperature = random(8);
        }



    }

    @Override
    public void checkDead() {
        if(life <= 0)
        {
            wc.changeScene(WorldController.Scene.Minigame3);
        }
    }

    @Override
    public void getInputDown(int keyCode) {
        super.getInputDown(keyCode);
        if(keyCode == Keys.A)
        {
            fruitBox.addSpeed(-addSpeed,0);
        }
        if(keyCode == Keys.D)
        {
            fruitBox.addSpeed(addSpeed,0);
        }
    }

    public int random (int range)
    {
        return random.nextInt(range + 1);
    }

    float random (float start, float end)
    {
        return start + random.nextFloat() * (end - start);
    }
}
