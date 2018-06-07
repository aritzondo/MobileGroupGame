package com.badlogic.drop;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

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

    private float foodSpawnTime = 4;
    private float nextSpawnTime = 0;

    private int maxFoodOnTable = 3;

    private Restaurant_Food foodSelected;
    private Client_Table clientSelected;
    private  boolean foodClicked = false;
    private boolean waitingForFood = true;

    Minigame4(WorldController wc) {
        super(wc);
        Restaurant_Table table = new Restaurant_Table("table",0,-5,16,4,Assets.getInstance().tableSprite);
        objectsOfLevel.add(table);
        iniFood();
        iniClients();
    }

    private void iniFood(){
        FoodType type = Minigame4.FoodType.values()[MathUtils.random(0, Minigame4.FoodType.Count.ordinal()-1)];
        Sprite spr = Assets.getInstance().getFoodOfType(type);
        float xPos = -5 + 5 * food.size();
        Restaurant_Food newFood = new Restaurant_Food("food1",xPos,-2,1,1,spr,wc,this,type);
        objectsOfLevel.add(newFood);
        food.add(newFood);
        newFood.active = false;
        int i = 2;
        while(food.size() < maxFoodOnTable){
            type = Minigame4.FoodType.values()[MathUtils.random(0, Minigame4.FoodType.Count.ordinal()-1)];
            spr = Assets.getInstance().getFoodOfType(type);
            xPos = -5 + 5 * food.size();
            newFood = new Restaurant_Food("food"+i,xPos,-2,1,1,spr,wc,this,type);
            i++;
            objectsOfLevel.add(newFood);
            food.get(food.size()-1).next = newFood;
            food.add(newFood);
            newFood.active = false;
        }
        food.get(food.size()-1).next = food.get(0);
    }

    public void iniClients(){
        Client_Table client1 = new Client_Table("client1",-5,1,4,4,Assets.getInstance().tableSprite,this);
        objectsOfLevel.add(client1);
        clients.add(client1);

        Client_Table client2 = new Client_Table("client2",0,1,4,4,Assets.getInstance().tableSprite,this);
        objectsOfLevel.add(client2);
        clients.add(client2);
        client1.next = client2;

        Client_Table client3 = new Client_Table("client3",5,1,4,4,Assets.getInstance().tableSprite,this);
        objectsOfLevel.add(client3);
        clients.add(client3);
        client2.next = client3;
        client3.next = client1;
        clientSelected = client1;
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        nextSpawnTime-=dt;
        if(nextSpawnTime <= 0){
            spawnFood();
            nextSpawnTime = foodSpawnTime;
        }
        if(foodSelected != null){
            foodSelected.colorTint = new Vector3(1,0f,0f);
        }
    }

    @Override
    public void checkDead() {
        if(life <= 0)
        {
            wc.changeScene(WorldController.Scene.Menu);
        }
    }

    private void spawnFood(){
        FoodType type = Minigame4.FoodType.values()[MathUtils.random(0, Minigame4.FoodType.Count.ordinal()-1)];
        Sprite spr = Assets.getInstance().getFoodOfType(type);
        int free;
        if((free = getFirstFree())>=0){
            food.get(free).changeFood(spr,type);
            if(waitingForFood){
                waitingForFood = false;
                foodSelected = food.get(free);
            }
        }
    }

    private int getFirstFree(){
        for(int i = 0; i < food.size() ; i++){
            if(!food.get(i).active) return i;
        }
        return -1;
    }

    @Override
    public void getButtonDown(int buttonCode) {
        if(buttonCode == 0){
            if(!foodClicked){
                foodClicked = !waitingForFood;
            }
            else{
                if(clientSelected.checkDrop(foodSelected)){
                    foodSelected.dropFood(clientSelected);
                    System.out.printf("Drop %s in %s\n",foodSelected.name,clientSelected.name);
                    nextFood(foodSelected);
                    foodClicked = false;
                }
            }
        }
        if(buttonCode == 8){
            buttonBackToMenu.buttonClicked();
        }
    }

    @Override
    public void getAxis(int index, int axis, float value) {
        if(index == 0) {
            if (axis == 1 && value == 1) {
                if (foodClicked) {
                    clientSelected = clientSelected.next;
                    System.out.printf("Selected %s\n", clientSelected.name);
                } else {
                    nextFood(foodSelected);
                    System.out.printf("Selected %s\n", foodSelected.name);
                }
            }
        }
    }

    private boolean nextFood(Restaurant_Food food){
        if(someActive()){
            waitingForFood = true;
            return false;
        }
        if(food.next.active){
            foodSelected =  food.next;
            return true;
        }
        else{
            return nextFood(food.next);
        }
    }

    private boolean someActive(){
        for(Restaurant_Food food1 : food){
            if (food1.next.active) {
                return true;
            }
        }
        return false;
    }
}