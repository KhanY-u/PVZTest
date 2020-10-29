package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.SpaceGame;
import org.w3c.dom.Text;

public class yard implements Screen {
    SpaceGame game;
    Texture img;
    Texture card_sunflower;
    Texture card_cherrybomb;
    Texture card_wallnut;
    final int card_1_x = 130;
    final int card_1_y = 697;
    public yard(SpaceGame game)
    {
    this.game = game;
    img = new Texture("yard.png");
    card_sunflower = new Texture("cards/card_sunflower.png");
    card_cherrybomb = new Texture("cards/card_cherrybomb.png");
    card_wallnut = new Texture("cards/card_wallnut.png");
    }
    
    @Override
    public void show() {

    }
    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(img,0,0,1200,800);
        game.batch.draw(card_sunflower,card_1_x,card_1_y,70,95);
        game.batch.draw(card_cherrybomb,card_1_x+70,card_1_y,70,95);
        game.batch.draw(card_wallnut,card_1_x+70*2,card_1_y,70,95);
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

    }
}
