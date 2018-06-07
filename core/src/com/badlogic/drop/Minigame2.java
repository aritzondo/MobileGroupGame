package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Input.Keys;
import java.util.Random;


public class Minigame2 extends BaseMinigame {

    FruitBox fruitBox;
    Handle handle;
    float currentTemperature;
    float addSpeed;
    Random random;
    int counterTemperature = 0;
    int counterOfRandomMovement = 0;
    int counterOfRemoveLifes = 0;

    Minigame2(WorldController wc) {
        super(wc);
        fruitBox = new FruitBox(wc, new Vector2(-4,-3), new Vector2(3,3));
        handle = new Handle(wc, new Vector2(3.7f,-3), new Vector2(4,3));
        objectsOfLevel.add(fruitBox);
        objectsOfLevel.add(handle);
        addSpeed = Constants.FRUITBOX_SPEED;
        random = new Random();
    }

    @Override
    public void GUI(SpriteBatch batch) {
        super.GUI(batch);
        batch.draw(Assets.getInstance().temperatureBar[1], 3.9f, -4.7f, 3.7f, 8 * (Constants.TOTAL_TEMPERATURE - currentTemperature)/Constants.TOTAL_TEMPERATURE);
        batch.draw(Assets.getInstance().temperatureBar[0], 3.9f, -4.8f, 3.7f, 8);
        batch.draw(Assets.getInstance().truck, -8,-5, 11,8);
    }

    @Override
    public void update(float elpasedTime) {
        super.update(elpasedTime);
        counterTemperature++;
        counterOfRandomMovement++;
        counterOfRemoveLifes++;

        if(counterTemperature > 100)
        {
            counterTemperature = 0;
            currentTemperature = random(8);
        }

        if(counterOfRandomMovement > 30)
        {
            fruitBox.addSpeed(Constants.FRUITBOX_SPEED_RANDOM*random(-1,1),0);
            counterOfRandomMovement=0;
        }

        if( (checkFruiBox() || checkTermostate()) && counterOfRemoveLifes > 80)
        {
            damage();
            counterOfRemoveLifes = 0;
        }
    }

    boolean checkFruiBox()
    {
        return  (fruitBox.position.x <= fruitBox.positiXClampedMin || fruitBox.position.x >= fruitBox.positiXClampedMax);
    }

    boolean checkTermostate()
    {
        return (((handle.position.y + 6) >= currentTemperature - 0.5f && (handle.position.y + 6) <= currentTemperature + 0.5f));
    }

    @Override
    public void checkDead() {
        if(life <= 0)
        {
            reset();
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
        if(keyCode == Keys.W)
        {
            handle.addSpeed(0,addSpeed);
        }
        if(keyCode == Keys.S)
        {
            handle.addSpeed(0,-addSpeed);
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

    @Override
    public void getAxis(int index, int axis, float value) {
        if(axis == 0 && index == 1){
            handle.addSpeed(0,-value * addSpeed);
        }
        if(axis == 1 && index == 0){
            fruitBox.addSpeed(value * addSpeed,0);
        }
    }
}
