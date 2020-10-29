package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sunflower{
    private int health = 100;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private int x = 50;
    public int MyLand;// DEFAULT_Y;
    public boolean remove = false;
    private Texture texture;
    CollisionBulletsVsZombies rect;
    private float TIME_PRODUCE_SUN = 0;
    public Sunflower(int lane)
    {
        switch (lane){
            case 0: {this.MyLand = 40;break;}
            case 1: {this.MyLand = 180; break;}
            case 2: {this.MyLand = 320; break;}
            case 3: {this.MyLand = 460; break;}
            case 4: {this.MyLand = 600; break;}
        }
        this.rect = new CollisionBulletsVsZombies(x,MyLand,WIDTH,HEIGHT);
        if(texture == null)
        {
            texture = new Texture("plants/sunflower.gif");
        }

    }
    public void Update(float delta)
    {   TIME_PRODUCE_SUN += delta/10;
        if(health  == 0)
        {
            remove = true;
        }
        rect.move(x,MyLand);
    }

    public void render(SpriteBatch batch)
    {
        batch.draw(texture,50,MyLand);
    }
    public CollisionBulletsVsZombies getRect()
    {
        return rect;
    }
    public void setTIME_PRODUCE_SUN(float TIME_PRODUCE_SUN) {
        this.TIME_PRODUCE_SUN = TIME_PRODUCE_SUN;
    }
    public float getTIME_PRODUCE_SUN() {
        return TIME_PRODUCE_SUN;
    }
    public int getX() {
        return x+10;
    }
}
