package com.mygdx.game.screens;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class sound {
    Clip clip;

    {
        try {
            clip = AudioSystem.getClip();
            AudioInputStream music = AudioSystem.getAudioInputStream(new File("plants_vs_zombies.wav"));
            clip.open(music);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

}
