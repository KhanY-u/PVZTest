package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.SpaceGame;
import jdk.nashorn.internal.parser.JSONParser;
import sun.security.provider.Sun;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.util.Random;

public class MainGameScreen implements Screen {
    public static final	float SPEED = 200f;
    public static final float SHIP_SPEED = 2f;
    public static final int SHIP_WIDTH = 100;
    public static  final int SHIP_HEIGHT = 100;
    public static final float WAIT_TIME_SHOOT=1.5f;
    public static final float WAIT_TIME_ZOMBIE_START = 5f;
    public static final float WAIT_TIME_SUN = 50f;
    Texture img = new Texture("yard.png");
    Animation[] rolls;
    int roll;
    float x,y;
    float sunTime;
    float stateTime;
    float rollTimer;
    float zombieTimer;
    float shootTimer;
    int total_zombie =15;
    Random random;
    Random sunlight;
    int TIME_START;
    int TIME_DROP;
    SpaceGame game;
    ArrayList<bullet> bullets;
    ArrayList<Zombie> zombie;
    ArrayList<sun> suns;
    ArrayList<Peashooter> peashooters;
    ArrayList<Sunflower> sunflowers;
    Texture card_sunflower;
    Texture card_peashooter;
    Texture card_wallnut;
    int sunScore = 150;
    final int card_1_x = 130;
    final int card_1_y = 697;
    private Music music;
    BitmapFont Sun_Score_Font;
    int score;
    public MainGameScreen(SpaceGame game)
    {   
        this.game = game;
        card_sunflower = new Texture("cards/card_sunflower.png");
        card_peashooter = new Texture("cards/card_peashooter.png");
        card_wallnut = new Texture("cards/card_wallnut.png");
        bullets = new ArrayList<bullet>();
        zombie = new ArrayList<Zombie>();
        suns = new ArrayList<sun>();
        peashooters = new ArrayList<Peashooter>();
        sunflowers = new ArrayList<Sunflower>();
        y = 50;
        random = new Random();
        sunlight = new Random();
        x = 50;
        roll = 0;
        sunTime =0;
        zombieTimer =0;
        rollTimer =0;
        shootTimer =0;
        //music
        music = Gdx.audio.newMusic(Gdx.files.internal("level2.wav"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();
        // font
        Sun_Score_Font = new BitmapFont(Gdx.files.internal("font_sun.fnt"));
        score = 0;
    }

    @Override
    public void show() {
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 2, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shootTimer += delta;
        zombieTimer += delta;
        sunTime += delta;
        stateTime += delta;
        if (sunTime >= WAIT_TIME_SUN) {
            suns.add(new sun(TIME_DROP = new Random().nextInt(1150)));
            sunTime = 0;
        }
        if( zombieTimer >= WAIT_TIME_ZOMBIE_START)
        {   zombieTimer =0;
            total_zombie -=1;
            zombie.add(new Zombie(TIME_START = random.nextInt(5)));
            if (total_zombie  < 12) {
                zombie.add(new Zombie(TIME_START = random.nextInt(5)));
                zombie.add(new Zombie(TIME_START = random.nextInt(5)));
                total_zombie -=1;
            } else if (total_zombie == 5)
            {
                zombie.add(new Zombie(TIME_START = random.nextInt(5)));
            }
            if(total_zombie == 0)
            {
                game.pause(10000);
            }
        }
        if(Gdx.app.getInput().isKeyJustPressed(Input.Keys.S))
        {
            peashooters.add(new Peashooter(TIME_START = random.nextInt(5)));
        }
        if(Gdx.app.getInput().isKeyJustPressed(Input.Keys.A))
        {
            sunflowers.add(new Sunflower(TIME_START = random.nextInt(5)));
        }
        ArrayList<Peashooter> PeashooterToRemove = new ArrayList<Peashooter>();
        for(Peashooter peashooter: peashooters) {
            for (Zombie zombies : zombie) {
                if (peashooter.getRect1().colliesSee(zombies.getRect1())) {
                    if (peashooter.getShoot_time() >= WAIT_TIME_SHOOT) {
                        peashooter.setShoot_time(0);
                        bullets.add(new bullet(peashooter.MyLand));
                    }
                    peashooter.Update(delta);
                    if (peashooter.remove) {
                        PeashooterToRemove.add(peashooter);
                    }
                }
            }
        }
        peashooters.removeAll(PeashooterToRemove);
        ArrayList<Sunflower> SunflowerToRemove = new ArrayList<Sunflower>();
        for(Sunflower Sunfl : sunflowers)
        {   if (Sunfl.getTIME_PRODUCE_SUN() >= WAIT_TIME_SHOOT)
            {
                Sunfl.setTIME_PRODUCE_SUN(0);
                suns.add(new sun(Sunfl.getX(), Sunfl.MyLand));
            }
            Sunfl.Update(delta);
            if(Sunfl.remove)
            {
                SunflowerToRemove.add(Sunfl);
            }
        }
        sunflowers.removeAll(SunflowerToRemove);
        ArrayList<Zombie> ZombieToRemove = new ArrayList<Zombie>();
        for(Zombie Zombies : zombie)
        {
            Zombies.Update(delta);
            if(Zombies.remove)
            {
                ZombieToRemove.add(Zombies);

            }
        }
        ArrayList<bullet> bulletsToRemove = new ArrayList<bullet>();
        for(bullet Bullet: bullets)
        {
            Bullet.update(delta);
            if(Bullet.remove)
            {
                bulletsToRemove.add(Bullet);

            }
        }
        ArrayList<sun> sunToRemove = new ArrayList<sun>();
        for(sun Sun: suns)
        {
            Sun.update(delta);
            if(Sun.remove_take)
            {   score += 50;
                sunToRemove.add(Sun);
            }
        }

        for(bullet Bullets: bullets)
        {
            for(Zombie zombies: zombie)
            {
                if(Bullets.getRect().colliesWith(zombies.getRect()))
                {
                    bulletsToRemove.add(Bullets);
                    zombies.ChangeHealth();
                }
            }
        }
        for(Peashooter peashooter: peashooters)
        {
            for(Zombie zombies: zombie)
            {
                if(peashooter.getRect1().colliesWith(zombies.getRect1()))
                {
                    peashooter.health -= 20;
                    zombies.collision = true;
                }
                else{
                    zombies.collision = false;
                }
            }
        }
        zombie.removeAll(ZombieToRemove);
        peashooters.removeAll(PeashooterToRemove);
        bullets.removeAll(bulletsToRemove);
        suns.removeAll(sunToRemove);
        game.batch.begin();
        game.batch.draw(img,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.batch.draw(card_sunflower,card_1_x,card_1_y,70,95);
        game.batch.draw(card_peashooter,card_1_x+70,card_1_y,70,95);
        game.batch.draw(card_wallnut,card_1_x+70*2,card_1_y,70,95);
        for(Peashooter peashooter :peashooters)
        {
            peashooter.render(game.batch);
        }
        for(bullet Bullet:bullets)
        {
            Bullet.render(game.batch);
        }
        for(Zombie zombies:zombie)
        {
            zombies.render(game.batch);
        }
        for(sun Sun: suns)
        {
            Sun.render(game.batch);
        }
        for(Sunflower sunfl: sunflowers)
        {
            sunfl.render(game.batch);
        }
        GlyphLayout scoreLayout = new GlyphLayout(Sun_Score_Font, "" +score);
        Sun_Score_Font.draw(game.batch, scoreLayout ,70,720);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    music.dispose();
    }
}
