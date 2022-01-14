
package game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author tienanhbui
 */
/** Animating image frames. Each frame has its own file */

@SuppressWarnings("serial")
public class PhiThuyen extends InSpace{
    
    int heath = 20;
    // Khai báo thuộc tính //
    private String[] imgFilenames = {
         "phithuyen/pt1.png", "phithuyen/pt2.png"};
    
    private String[] imgFilenames_left = {
         "phithuyen/pt3.png", "phithuyen/pt4.png"};
    
    private String[] imgFilenames_right = {
         "phithuyen/pt5.png", "phithuyen/pt6.png"};
    
    private String[] imgFilenames_down = {
         "phithuyen/pt7.png"};
    
    private String[] imgFilenames_forward = {
         "phithuyen/pt8.png", "phithuyen/pt9.png"};
    
    
    private Image[] imgFrames;    // array of Images to be animated
    private int currentFrame = 0; // current frame number
    private int imgWidth, imgHeight;    // width and height of the image
    private int xp, yp; // plate with animation
    private ArrayList<SpaceShipBullets> bullets= new ArrayList<SpaceShipBullets>();

    public PhiThuyen(int x, int y) {
        super(x, y);
        loadImages(imgFilenames);
        super.setW(30);
        super.setH(30);
    }
    
    public void move() {
        super.x += xp;
        super.y += yp;
    }
    
    public Image[] getImgf(){
        return imgFrames;
    }
    
    public int getCrrentF(){
        return currentFrame;
    }
    
    public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            loadImages(imgFilenames);

            if (key == KeyEvent.VK_LEFT) {
                xp = 0;
            }

            if (key == KeyEvent.VK_RIGHT) {
                xp = 0;
            }

            if (key == KeyEvent.VK_UP) {
                yp = 0;
            }

            if (key == KeyEvent.VK_DOWN) {
                yp = 0;
            }
        }

        public void keyPressed(KeyEvent e) {
            
            int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_SPACE) {
                fire();
            }

            if (key == KeyEvent.VK_LEFT) {
                xp = -2;
                loadImages(imgFilenames_left);
            }

            if (key == KeyEvent.VK_RIGHT) {
                xp = 2;
                loadImages(imgFilenames_right);
            }

            if (key == KeyEvent.VK_UP) {
                yp = -2;
                loadImages(imgFilenames_forward);
            }

            if (key == KeyEvent.VK_DOWN) {
                yp = 2;
                loadImages(imgFilenames_down);
            }
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
        bullets.add(new SpaceShipBullets(super.x - 3, super.y - 3));
    }
}// END CLASS
