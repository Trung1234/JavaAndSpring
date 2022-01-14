package model;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Item {
    Image img;
    int id;
    int x, y;
    int size;

    public Item(int id, int x, int y, int size) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.size = size;
        this.img = Images.getImage(this.id);
    }
    public void draw(Graphics2D g2d){
        g2d.drawImage(img,
                x, y,
                size, size,
                null);
    }
    public static void playSound(String gongFile) {
        // open the sound file as a Java input stream

        InputStream in = null;
        try {
            in = new FileInputStream(gongFile);
            AudioStream audioStream = new AudioStream(in);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
