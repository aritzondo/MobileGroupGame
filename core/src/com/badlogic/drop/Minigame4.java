package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

public class Minigame4 extends BaseMinigame {

    public enum FoodType{
        Apple,
        Banana,
        Orange,
        Count
    }
    public ArrayList<Client_Table> clients = new ArrayList<Client_Table>();
    public ArrayList<Restaurant_Food> food = new ArrayList<Restaurant_Food>();

    private float foodSpawnTime = 5;
    private float nextSpawnTime = 0;

    private int maxFoodOnTable = 3;

    Minigame4(WorldController wc) {
        super(wc);
        Restaurant_Table table = new Restaurant_Table("table",0,-5,16,4,Assets.getInstance().tableSprite,this);
        objectsOfLevel.add(table);
        iniClients();
    }

    public void iniClients(){
        Client_Table client1 = new Client_Table("client1",-5,3,4,4,Assets.getInstance().tableSprite,this);
        objectsOfLevel.add(client1);
        clients.add(client1);
        client1 = new Client_Table("client2",0,3,4,4,Assets.getInstance().tableSprite,this);
        objectsOfLevel.add(client1);
        clients.add(client1);
        client1 = new Client_Table("client3",5,3,4,4,Assets.getInstance().tableSprite,this);
        objectsOfLevel.add(client1);
        clients.add(client1);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        nextSpawnTime-=dt;
        if(nextSpawnTime <= 0){
            spawnFood();
            nextSpawnTime = foodSpawnTime;
        }
    }

    private void spawnFood(){
        FoodType type = Minigame4.FoodType.values()[MathUtils.random(0, Minigame4.FoodType.Count.ordinal()-1)];
        Sprite spr = Assets.getInstance().getFoodOfType(type);
        if(food.size() < maxFoodOnTable){
            float xPos = -5 + 5 * food.size();
            Restaurant_Food newFood = new Restaurant_Food("food",xPos,-2,1,1,spr,wc,this,type);
            objectsOfLevel.add(newFood);
            food.add(newFood);
        }
        else{
            int free;
            if((free = getFirtFree())>=0){
                food.get(free).changeFood(spr,type);
            }
        }
    }

    private int getFirtFree(){
        for(int i = 0; i < food.size() ; i++){
            if(!food.get(i).active) return i;
        }
        return -1;
    }
}