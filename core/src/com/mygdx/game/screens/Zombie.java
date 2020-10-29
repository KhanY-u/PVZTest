package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class Zombie {
    private int health = 200;
    private int spd = 10;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private int x = Gdx.graphics.getWidth();
    public int MyLand;// DEFAULT_Y;
    public boolean remove = false;
    private boolean Shoot = true;
    public boolean collision = false;
    private Texture texture;
    CollisionBulletsVsZombies rect;
    CollisionZombiesVsPlants rect1;
    public Zombie(int lane)
    {
        switch (lane){
            case 0: {this.MyLand = 40;break;}
            case 1: {this.MyLand = 180; break;}
            case 2: {this.MyLand = 320; break;}
            case 3: {this.MyLand = 460; break;}
            case 4: {this.MyLand = 600; break;}
        }
        this.rect = new CollisionBulletsVsZombies(x,MyLand,WIDTH,HEIGHT);
        this.rect1 = new CollisionZombiesVsPlants(x,MyLand,WIDTH,HEIGHT);
        if(texture == null)
        {
            texture = new Texture("zombies/zombie1.png");
        }
    }
    public void Update(float deltaTime)
    {
        if(collision == false)
        {
            x -= spd*deltaTime;
        }

        if(x == 0 || health  == 0)
        {
            remove = true;
        }
        rect.move(x,MyLand);
        rect1.move(x,MyLand);
    }
    public void ChangeHealth()
    {
        health -=40;
    }
    public void render(SpriteBatch batch)
    {
        batch.draw(texture,x,MyLand);
    }
    public CollisionBulletsVsZombies getRect()
    {
        return rect;
    }

    public CollisionZombiesVsPlants getRect1() {
        return rect1;
    }
}
