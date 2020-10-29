package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Peashooter{
    int health = 100;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    public int MyLand;// DEFAULT_Y;
    public boolean remove = false;
    private Texture texture;
    CollisionZombiesVsPlants rect1;
    private float shoot_time = 0;
    public Peashooter(int lane)
    {
        switch (lane){
            case 0: {this.MyLand = 40;break;}
            case 1: {this.MyLand = 180; break;}
            case 2: {this.MyLand = 320; break;}
            case 3: {this.MyLand = 460; break;}
            case 4: {this.MyLand = 600; break;}
        }
        this.rect1 = new CollisionZombiesVsPlants(150,MyLand,WIDTH,HEIGHT);

        if(texture == null)
        {
            texture = new Texture("plants/peashooter.gif");
        }
    }

    public void Update(float deltaTime)
    {   shoot_time +=  deltaTime;
        if(health  == 0)
        {
            remove = true;
        }
    }

    public void render(SpriteBatch batch)
    {
        batch.draw(texture,150,MyLand);
    }
    public CollisionZombiesVsPlants getRect1()
    {
        return rect1;
    }
    public float getShoot_time() {
        return shoot_time;
    }

    public void setShoot_time(float shoot_time) {
        this.shoot_time = shoot_time;
    }
}

