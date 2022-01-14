
package game;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author tienanhbui
 */
public class Boss extends Alien{
    
    public int heath = 80;
    private ArrayList<BossBullets> bullets= new ArrayList<BossBullets>();
    int count_MoveY;
    String trangThaiDiChuyen = "";
    double timeLife, timeLifeCount;
    private String[] imgFilenames = {
         "aliens/boss-blue.png", "aliens/boss-green.png"};
    private Image[] imgFrames;    // array of Images to be animated
    private int currentFrame = 0; // current frame number
    private int imgWidth, imgHeight;    // width and height of the image
    private int xp, yp; // plate with animation
    private final int INITIAL_X = 1280;
    private final int INITIAL_Y = 720;
    
    public Boss(int x, int y) {
        super(x, y);
        count_MoveY = y;
        loadImages(imgFilenames);
        timeLife = System.currentTimeMillis();
        super.setW(imgWidth);
        super.setH(imgHeight);
        
    }   
    public void move() {
        
        timeLifeCount = System.currentTimeMillis() - timeLife;

        if(timeLifeCount > 200){
            fire();
            timeLife = System.currentTimeMillis();

        }


        if(trangThaiDiChuyen == "RIGHT"){
            super.x -= 3;
        }else{
            super.x += 3;
        }

        if(super.x > INITIAL_X - 300){
            trangThaiDiChuyen = "RIGHT";
        }

        if(super.x < 0){
            trangThaiDiChuyen = "LEFT";
        }

        if(super.y - count_MoveY < 180) {
            super.y += 2;
            count_MoveY ++;
        }else{
            
        }

    }
    
    public Image[] getImgf(){
        return imgFrames;
    }
    
    public int getCrrentF(){
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

    public ArrayList getBullets() {
        return bullets;
    }

    private void fire() {
        bullets.add(new BossBullets(super.x +130, super.y + 350));

    }
    
}
