package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class sun {
        public static final int speed = 50;
        public static int Default_y = Gdx.graphics.getHeight();
        private static Texture texture;
        public float x,y;
        float  exist =0;
        public boolean remove = false;
    public boolean remove_take = false;

    public sun (float x)
        {
            this.y = Default_y;
            this.x = x;
            if(texture == null)
            {
                texture = new Texture("sun.png" );
            }
        }
    public sun (float x, float y)
    {
        this.y = y;
        this.x = x;
        if(texture == null)
        {
            texture = new Texture("sun.png" );
        }
    }
    public void update (float delta)
        {
            if(Gdx.input.justTouched()) {
                remove_take = true;
            }
            y-= speed*delta ;
            exist += delta;
            if( y< 0)
            {  y =  0;
            }
            if( y  == 0)
            {   if(exist > 1000*delta)
                {
                    remove = true;
                }
            }
        }
        public void render(SpriteBatch batch)
        {
            batch.draw(texture,x,y,100,100);
        }
}

