
package game;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author tienanhbui
 */ 
public class Main extends JFrame{
    Level_1 level;
    public Main(){
        initUI();
    } 
    
    public void initUI(){
        
        level = new Level_1();
        add(level);
        
        ImageIcon img = new ImageIcon("src/effect/Icon.png");
        setIconImage(img.getImage());
        setSize(1280, 720);
        setTitle(level.title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                Main play = new Main();
                play.setVisible(true);
            }
        });
    }
}
