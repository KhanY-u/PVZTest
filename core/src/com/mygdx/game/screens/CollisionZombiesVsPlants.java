package com.mygdx.game.screens;

public class CollisionZombiesVsPlants {
        float x,y;
        int height, width;
        private int spd = 10;
        public CollisionZombiesVsPlants(float x, float y, int height, int width){
            this.x =x;
            this.y = y;
            this.height = height;
            this.width =  width;
        }
        public void move (float x, float y)
        {
            this.x = x;
            this.y = y ;
        }
        public boolean colliesWith (CollisionZombiesVsPlants rect1)
        {
            return (y  == rect1.y && x + width == rect1.x );
        }
    public boolean colliesSee (CollisionZombiesVsPlants rect1)
    {
        return (y  == rect1.y );
    }

}
