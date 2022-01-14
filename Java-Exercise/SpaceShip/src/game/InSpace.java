
package game;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author tienanhbui
 */
public class InSpace extends JPanel{
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean vis;
    
    public InSpace(int x, int y) {
        this.x = x;
        this.y = y;
        vis = true;
    }
    
    public void setW(int w){
        this.width = w;
    }
    
    public void setH(int h){
        this.height = h;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        this.vis = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
