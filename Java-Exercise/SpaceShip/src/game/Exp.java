
package game;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author tienanhbui
 */
public class Exp {
    
    private String[] imgFilenamesEXP = {
        "effect/exp1-1.png", 
        "effect/exp1-2.png", 
        "effect/exp1-3.png", 
        "effect/exp1-4.png", 
        "effect/exp1-5.png", 
        "effect/exp1-6.png", 
        "effect/exp1-7.png", 
        "effect/exp1-8.png", 
        "effect/exp1-9.png", 
        "effect/exp1-10.png", 
        "effect/exp1-11.png", 
        "effect/exp1-12.png",
        "effect/exp1-13.png",
        "effect/exp1-14.png"
    };
     
    private Image[] imgFrames;    // array of Images to be animated
    private int currentFrame = 0; // current frame number
    private int imgWidth, imgHeight;    // width and height of the image
    private int xp, yp; // plate with animation

    public Exp() {
        loadImages(imgFilenamesEXP);
    }

    
    public Image[] getImgf(){
        return imgFrames;
    }
    
    public int getCrrentF(){
        return currentFrame;
    }
    
    public int getCF() {
        ++currentFrame;    // display next frame
        if (currentFrame >= imgFrames.length) {
            currentFrame = 0;
        }
        return currentFrame;
    }
    
    private void loadImages(String[] imgFileNames) {
        int numFrames = imgFileNames.length;
        imgFrames = new Image[numFrames];  // allocate the array
        URL imgUrl = null;
        for (int i = 0; i < numFrames; ++i) {
            imgUrl = getClass().getClassLoader().getResource(imgFileNames[i]);
            if (imgUrl == null) {
                System.err.println("Couldn't find file: " + imgFileNames[i]);
            } else {
                try {
                    imgFrames[i] = ImageIO.read(imgUrl);  // load image via URL
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        imgWidth = imgFrames[0].getWidth(null);
        imgHeight = imgFrames[0].getHeight(null);
    }

    
}
