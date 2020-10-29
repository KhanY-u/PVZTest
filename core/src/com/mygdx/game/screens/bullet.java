package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class bullet {
    public static final int speed = 200;
    public static final int Default_x = 150;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 40;
    private static Texture texture;
    float x,y;
    public boolean remove = false;
    CollisionBulletsVsZombies rect;
    public bullet(float y)
    {
        this.y = y;
        this.x = Default_x;
        this.rect = new CollisionBulletsVsZombies(x,y,WIDTH,HEIGHT);
        if(texture == null)
        {
            texture = new Texture("pea.png" );
        }
    }
    public void update (float delta)
    {
        x+= speed*delta ;
        if( x == Gdx.graphics.getWidth())
        {
            remove = true;
        }
        rect.move(x,y);
    }
    public void render(SpriteBatch batch)
    {
        batch.draw(texture,x,y+40);
    }
    public CollisionBulletsVsZombies getRect()
    {
        return rect;
    }

}
