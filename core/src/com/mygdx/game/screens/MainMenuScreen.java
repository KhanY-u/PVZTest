package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.SpaceGame;
public class MainMenuScreen implements Screen {
    SpaceGame game;
    Texture playButtonActive;
    private Music music;
    public MainMenuScreen( SpaceGame game)
    {
        this.game = game;
        playButtonActive = new Texture("Menu.JPG");
        music = Gdx.audio.newMusic(Gdx.files.internal("plants_vs_zombies.wav"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();}
    @Override
    public void show() {
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(playButtonActive,0,0,1200,800);
        if(Gdx.input.getX() > 640 && Gdx.input.getX() < 1100 && Gdx.input.getY() > 120 && Gdx.input.getY() < 260 )
        {
            if(Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new MainGameScreen(game));
            }
        }
        if(Gdx.input.getX() > 1100 && Gdx.input.getX() < 1150 && Gdx.input.getY() > 670 && Gdx.input.getY() < 720 )
        {
            if(Gdx.input.isTouched()) {
                this.dispose();
                Gdx.app.exit();
            }
        }
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
