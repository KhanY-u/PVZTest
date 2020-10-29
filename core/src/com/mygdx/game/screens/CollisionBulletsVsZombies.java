package com.mygdx.game.screens;

public class CollisionBulletsVsZombies {
    float x,y;
    int height, width;
    public CollisionBulletsVsZombies(float x, float y, int height, int width){
        this.x =x;
        this.y = y;
        this.height = height;
        this.width =  width;
    }
    public void move (float x, float y)
    {
        this.x  =x;
        this.y = y;
    }
    public boolean colliesWith (CollisionBulletsVsZombies rect)
    {
        return (x < rect.x + rect.width  && y < rect.y + rect.height && x+ width > rect.x && y +height > rect.y);
    }
}
