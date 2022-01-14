
package game;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author tienanhbui
 */
public class BossBullets extends Bullets{
    int MISSILE_SPEED_X = 2;
    int MISSILE_SPEED_Y = 5;
    final int BOARD_HEIGHT = 800;
    private int imgWidth, imgHeight;    // width and height of the image
    Image Bullets;
    int turn;
    
    public BossBullets(int x, int y){
        super(x, y);
        loadBullets("bullets/exp1-1.png");
        super.setW(imgWidth);
        super.setH(imgHeight);
        
        Random rand = new Random();
        MISSILE_SPEED_X = rand.nextInt(5) + 1;
        MISSILE_SPEED_Y = rand.nextInt(5) + 3;
        turn = rand.nextInt(3) + 1;
    }
    
    
    private void loadBullets(String name){
        URL imgUrl = null;
        imgUrl = getClass().getClassLoader().getResource(name);
        if (imgUrl == null) {
            System.err.println("Couldn't find file: ");
        } else {
            try {
                Bullets = ImageIO.read(imgUrl);  // load image via URL
            } catch (IOException ex) {
            }
        }
        imgWidth = Bullets.getWidth(null);
        imgHeight = Bullets.getHeight(null);
    }
    
    public Image getImage(){
        return Bullets;
    }
    
    public void move() {
        
        super.y += MISSILE_SPEED_Y;
        if(turn == 1){
            super.x += MISSILE_SPEED_X;
        }else if(turn == 2){
            super.x -= MISSILE_SPEED_X;
        }
       
        
        if (y > BOARD_HEIGHT) {
            vis = false;
        }
    }
}
