
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
public class AlienSpaceShip extends Alien{
    
    public int heath = 4;
    private ArrayList<AlienBullets> bullets= new ArrayList<AlienBullets>();
    int typeMove = 0;
    int typeAlien;
    int count_MoveY;
    double timeLife, timeLifeCount;
    String trangThaiDiChuyen = "";
    private String[] imgFilenames = {
         "aliens/alien2-1.png", "aliens/alien2-2.png"};
    private String[] imgFilenames_2 = {
         "aliens/alien1-1.png", "aliens/alien1-2.png", "aliens/alien1-3.png"};
    private Image[] imgFrames;    // array of Images to be animated
    private int currentFrame = 0; // current frame number
    private int imgWidth, imgHeight;    // width and height of the image
    private int xp, yp; // plate with animation
    private final int INITIAL_X = 1280;
    private final int INITIAL_Y = 720;
    
    public AlienSpaceShip(int x, int y, int typeMove, int typeAlien) {
        super(x, y);
        count_MoveY = y;
        this.typeAlien = typeAlien;
        if(typeAlien == 1){
            loadImages(imgFilenames);
        }else{
            loadImages(imgFilenames_2);
        }
        timeLife = System.currentTimeMillis();
        super.setW(imgWidth);
        super.setH(imgHeight);
        this.typeMove = typeMove;
      
        
    }
    
    public void move() {
        if(typeMove == 0){
            if (super.y > 720) {
                super.y = 0;
            }

            if (super.x < 0) {
                super.x = INITIAL_X;
            }

            super.y += 3;
        }
        
        if(typeMove == 1){
            if (super.y > 720) {
                super.y = 0;
            }

            if (super.x < 0) {
                super.x = INITIAL_X;
            }

            super.y += 2;
            //super.x += 1;
        }
        if(typeMove == 3){
            
            timeLifeCount = System.currentTimeMillis() - timeLife;
        
            if(timeLifeCount > 2000){
                fire();
                timeLife = System.currentTimeMillis();
               
            }
        
            
            if(trangThaiDiChuyen == "RIGHT"){
                super.x -= 3;
            }else{
                super.x += 3;
            }
            
            if(super.x > INITIAL_X - 50){
                trangThaiDiChuyen = "RIGHT";
            }
            
            if(super.x < 0){
                trangThaiDiChuyen = "LEFT";
            }
            
            if(super.y - count_MoveY < 200) {
                super.y += 2;
                count_MoveY ++;
            }
           
            
            
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
        bullets.add(new AlienBullets(super.x - 3, super.y - 3));
    }
    
}
