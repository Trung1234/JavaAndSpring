
package game;

/**
 *
 * @author tienanhbui
 */
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.*;
 
public class Level_1 extends JPanel {
    public String title = "Phi thuyền không gian - màn 1";
    boolean inGame = true;
    Image Effect;
    private String[] imgFileNames = {
         "effect/defeat.png", "effect/victory.png"};
    private Image[] imgFrames;    // array of Images to be animated
    PhiThuyen pt;
    Boss boss;
    private int frameRate = 30;    // frame rate in frames per second
    private int currentFrame = 0; // current frame number
    private int currentFrameAlien = 0; // current frame numberr
    private int currentFrameBoss = 0; // current frame numberr
    private int currentFrameExp = 0; // current frame numberr
    ArrayList<AlienSpaceShip> ListAlien ;
    
    // Hieu ung
    Exp exp  = new Exp();
    Thread animationExp;
    Thread BOSS;
    
    Image backGround;
    int xbg, ybg = 0, ybg_loop = ybg - 810;
    double map_px = 0;
    String Gaming = "normal";
   
    private static Sequencer midiPlayer;
    
    public Level_1() {
        initGame();
    }
    
    
    private void initGame(){
        
        
        pt = new PhiThuyen(380, 600);
        initAliens(1, 1);
        
        // Setup animation
        setBackground(Color.BLACK);
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        loadBG("effect/bg_lv1_2.jpg");
        loadEffect(imgFileNames);
        Thread animationBackground = new Thread () {
            @Override
            public void run() {
                while (true) {
                    if(!inGame){
                        
                        return;
                    }
                    
                    ybg++;
                    ybg_loop++;
                    map_px ++;

                    if(ybg >= 720){
                        ybg = -810;
                    }
                    
                    if(ybg_loop >= 720){
                        ybg_loop = ybg - 810;
                    }
                    
                    if(map_px == 600) initAliens(0, 1);
                    
                    if(map_px == 1200) initAliens(3, 2);
                    
                    repaint();  // Refresh the display
                    try {
                        Thread.sleep(300 / frameRate); // delay and yield to other threads
                    } catch (InterruptedException ex) { }
                }
            }
        };
        animationBackground.start();  // start the thread to run animation
        
        // Sound
        //SoundEffect.init();
        //SoundEffect.volume = SoundEffect.Volume.LOW;  // un-mute
        startMidi("src/sound/xf0.mid");     // start the midi player
        
        // Gaming 
        Thread animationSpaceShip = new Thread () {
            @Override
            public void run() {
                while (true) {
                    if(!inGame){
                        
                        return;
                    }
                    
                    backgoundSound();
                    update();   // update the position and image
                    updateBullets();
                    pt.move();
                    repaint();  // Refresh the display
                    try {
                        Thread.sleep(300 / frameRate); // delay and yield to other threads
                    } catch (InterruptedException ex) { }
                }
            }
        };
        animationSpaceShip.start();  // start the thread to run animation
        
        Thread animationAlienSpaceShip = new Thread () {
            @Override
            public void run() {
                while (true) {
                    if(!inGame){
                        
                        return;
                    }
                    
                    updateAlien();   // update the position and image
                    //Alien1.move();
                    repaint();  // Refresh the display
                    try {
                        Thread.sleep(300 / frameRate); // delay and yield to other threads
                    } catch (InterruptedException ex) { }
                }
            }
        };
        animationAlienSpaceShip.start();  // start the thread to run animation
        
        
        BOSS = new Thread () {
            @Override
            public void run() {
                while (true) {
                    
                    updateBoss();   // update the position and image
                    repaint();  // Refresh the display
                    try {
                        Thread.sleep(300 / frameRate); // delay and yield to other threads
                    } catch (InterruptedException ex) { }
                }
            }
        };
        
        
        
        animationExp = new Thread () {
            @Override
            public void run() {
                while (true) {
                    
                    updateExp();   // update the position and image
                    repaint();  // Refresh the display
                    try {
                        Thread.sleep(300 / 5); // delay and yield to other threads
                    } catch (InterruptedException ex) { }
                }
            }
        };
          // start the thread to run animation
        animationExp.start();
    }
    
    public void backgoundSound(){
        if (!midiPlayer.isRunning()) {  // previous song finished
           midiPlayer.stop();
           midiPlayer.close();
           startMidi("src/sound/xf1.mid");
        }
    }
    
    private void startBoss() {
        boss = new Boss(600, -500);
        Gaming = "boss";
        BOSS.start();  // start the thread to run animation
    }
    
    private void loadEffect(String[] imgFileNames){
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
    }
    
    
    public void initAliens(int pos, int typeAlien) {
        ListAlien = new ArrayList<>();

        Random rand = new Random();
        int alien_x, alien_y;
//        for (int[] p : pos) {
//            ListAlien.add(new AlienSpaceShip(p[0], p[1]));
//        }
        if(typeAlien == 1){
            for (int xx = 0; xx < 40 ; xx ++) {
                alien_x = rand.nextInt(1200) + 1;
                alien_y = 0 - rand.nextInt(300) + (1);
                ListAlien.add(new AlienSpaceShip( alien_x, alien_y, pos, 1));
            }
        }else{
            for (int xx = 0; xx < 40 ; xx ++) {
                alien_x = rand.nextInt(1200) + 1;
                alien_y = 0 - rand.nextInt(300) + (1);
                ListAlien.add(new AlienSpaceShip(alien_x, alien_y, pos , 2));
            }
        }
        
 
    }
 
    public void update() {
        ++currentFrame;    // display next frame
        if (currentFrame >= pt.getImgf().length) {
            currentFrame = 0;
        }
    } 
    
    public void updateBoss() {
        if(!boss.isVisible()){
            return;
        }
        
        ++currentFrameBoss;    // display next frame
        if (currentFrameBoss >= boss.getImgf().length) {
            currentFrameBoss = 0;
        }
        
        boss.move();
        ArrayList bullets_boss = boss.getBullets();

        for (int i = 0; i < bullets_boss.size(); i++) {

            BossBullets m = (BossBullets) bullets_boss.get(i);

            if (m.isVisible()) {

                m.move();
            } else {

                bullets_boss.remove(i);
            }
        }
    } 

    public void updateExp() {
          currentFrameExp = exp.getCF();
    } 
    
    public void updateAlien() {
        if (ListAlien.isEmpty()) {
            return;
        }
        
        ++currentFrameAlien;    // display next frame
        if (currentFrameAlien >= ListAlien.get(0).getImgf().length) {
            currentFrameAlien = 0;
        }

        for (int i = 0; i < ListAlien.size(); i++) {

            AlienSpaceShip a = ListAlien.get(i);
            if (a.isVisible() && a.getY() < 710) {
                a.move();
            } else {
                if(currentFrameExp>=13){
                    ListAlien.remove(i);
                }
            }
            
            ArrayList bullets_Alien = a.getBullets();

            for (int j = 0; j < bullets_Alien.size(); j++) {

                AlienBullets m = (AlienBullets) bullets_Alien.get(j);

                if (m.isVisible()) {
                    m.move();
                } else {
                    bullets_Alien.remove(j);
                }
            }
            
        }
    }
    
    private void updateBullets() {

        ArrayList bullets = pt.getBullets();

        for (int i = 0; i < bullets.size(); i++) {

            SpaceShipBullets m = (SpaceShipBullets) bullets.get(i);

            if (m.isVisible()) {

                m.move();
            } else {

                bullets.remove(i);
            }
        }

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            pt.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            pt.keyPressed(e);
        }
    }
 
    /** Custom painting codes on this JPanel */
    @Override
    public void paintComponent(Graphics g) throws ConcurrentModificationException, ArrayIndexOutOfBoundsException{
        super.paintComponent(g);  // paint background
  
        Graphics2D g2d = (Graphics2D) g;
        
        checkCollisions();
        
        g.drawImage(backGround, 5, ybg, null);
        g.drawImage(backGround, 0, (ybg_loop), null);

        // Draw bullets
        ArrayList bullets = pt.getBullets();
        for (int bullets_run = 0; bullets_run < bullets.size(); bullets_run ++) {
            
            Object m1 = bullets.get(bullets_run);
            
            SpaceShipBullets m = (SpaceShipBullets) m1;
            g.drawImage(m.getImage(), m.getX() + 5,m.getY(), this);
        }
        
        // Draw SpaceShip
        
        g.drawImage(pt.getImgf()[currentFrame], pt.getX(), pt.getY(), this);
        if(!pt.isVisible()){
            g.drawImage(exp.getImgf()[currentFrameExp], pt.getX() - 10, pt.getY() -10, this);
        }
        
        
        
        g2d.setColor(Color.WHITE);
        
        int persentHeath = Math.round((float) ((float)pt.heath / (float)20 * (float)100));
               
        g2d.drawString("Sinh lực : "+persentHeath+" % ", 20, 45);
        // Game road
        
        if(ListAlien.size() == 0 && Gaming == "prepa_boss"){
            startBoss();
        }
        
        // Draw Alien 1
        for (int ListAlien_run = 0; ListAlien_run < ListAlien.size(); ListAlien_run ++) {
            
            AlienSpaceShip a = ListAlien.get(ListAlien_run);
            
            if(a.typeAlien == 2){
                
                g2d.setColor(Color.WHITE);
                
                g2d.drawString("Tàu địch còn lại : "+ListAlien.size()+"", 20, 30);
                
                Gaming = "prepa_boss";
            }
                     
            g.drawImage(a.getImgf()[currentFrameAlien], a.getX(), a.getY(), this);
            
            ArrayList bullets_Alien = a.getBullets();
            
            for (int bullets_run = 0; bullets_run < bullets_Alien.size(); bullets_run ++) {
            
                Object m1 = bullets_Alien.get(bullets_run);
                AlienBullets m = (AlienBullets) m1;
                g.drawImage(m.getImage(), m.getX() + 5,m.getY(), this);
            }
            

            if(!a.isVisible()){
                g.drawImage(exp.getImgf()[currentFrameExp], a.getX() - 10, a.getY() -10, this);
            }
        }
        
        
        if(Gaming == "boss"){
                
            g.drawImage(boss.getImgf()[currentFrame], boss.getX(), boss.getY(), this);
            if(!boss.isVisible()){
                g.drawImage(exp.getImgf()[currentFrameExp], boss.getX() - 10, boss.getY() + 100, this);
                g.drawImage(exp.getImgf()[currentFrameExp], boss.getX() + 100, boss.getY() + 150, this);
                g.drawImage(exp.getImgf()[currentFrameExp], boss.getX() + 120, boss.getY() -10, this);
                g.drawImage(exp.getImgf()[currentFrameExp], boss.getX() + 200, boss.getY() +130, this);
            }
            
            // Draw bullets_boss
            ArrayList bullets_boss = boss.getBullets();
            for (int bullets_run = 0; bullets_run < bullets_boss.size(); bullets_run ++) {

                Object m1 = bullets_boss.get(bullets_run);

                BossBullets m = (BossBullets) m1;
                g.drawImage(m.getImage(), m.getX() + 5,m.getY(), this);
            }

            if(!boss.isVisible()){
                g.drawImage(imgFrames[1], 330, 20, this);
            }

        }
        
        
        if(!inGame){
            
            g.drawImage(imgFrames[0], 330, 20, this);
        }
        
    }
   
    public void checkCollisions() {
        
        if(!inGame){

            return;
        }
        
        Rectangle r3 = pt.getBounds();
        
        for (int ListAlien_run =0; ListAlien_run < ListAlien.size(); ListAlien_run ++) {
            
            AlienSpaceShip alien = ListAlien.get(ListAlien_run);
            
            Rectangle r2 = alien.getBounds();
            
            if (r3.intersects(r2)) {
                pt.heath --;
                if(pt.heath <= 0){
                    pt.setVisible(Boolean.FALSE);
                    inGame = false;
                }
                alien.setVisible(Boolean.FALSE);
            }
            
            ArrayList<AlienBullets> ms = alien.getBullets();
        
            for (AlienBullets m : ms) {

                Rectangle r4 = m.getBounds();

                if (r4.intersects(r3) && pt.isVisible()) {
                    pt.heath --;
                    if(pt.heath <= 0){
                        pt.setVisible(Boolean.FALSE);
                        inGame = false;
                    }
                    m.setVisible(Boolean.FALSE);
                    //SoundEffect.EXPLODE.play();
                }
            }
        }

        ArrayList<SpaceShipBullets> ms = pt.getBullets();
        
        for (SpaceShipBullets m : ms) {

            Rectangle r1 = m.getBounds();

            for (int ListAlien_run =0; ListAlien_run < ListAlien.size(); ListAlien_run ++) {
            
                AlienSpaceShip alien = ListAlien.get(ListAlien_run);

                Rectangle r2 = alien.getBounds();

                if (r1.intersects(r2) && alien.isVisible()) {
                    currentFrameExp =0;
                    alien.heath --;
                    if(alien.heath <= 0){
                        alien.setVisible(Boolean.FALSE);
                    }
                    m.setVisible(Boolean.FALSE);
                }
            }
        }
        
        
        if(Gaming == "boss"){
            ArrayList<BossBullets> ms_boss = boss.getBullets();
        
            for (BossBullets m : ms_boss) {

                Rectangle r1 = m.getBounds();

                    if (r1.intersects(r3)) {
                        currentFrameExp =0;
                        pt.heath -= 2;
                        if(pt.heath <= 0){
                            pt.setVisible(Boolean.FALSE);
                            inGame = false;
                        }
                        m.setVisible(Boolean.FALSE);
                    }
            }
            
            
            for (SpaceShipBullets m : ms) {
                Rectangle r1 = m.getBounds();
                Rectangle r2 = boss.getBounds();

                if (r1.intersects(r2) ) {
                    currentFrameExp =0;
                    boss.heath --;
                    if(boss.heath == 0){
                        boss.setVisible(Boolean.FALSE);
                    }
                    m.setVisible(Boolean.FALSE);
                }
            }
        }
    }
        
    
    public static void startMidi(String midFilename) {
      try {
         File midiFile = new File(midFilename);
         Sequence song = MidiSystem.getSequence(midiFile);
         midiPlayer = MidiSystem.getSequencer();
         midiPlayer.open();
         midiPlayer.setSequence(song);
         midiPlayer.setLoopCount(0); // repeat 0 times (play once)
         midiPlayer.start();
      } catch (MidiUnavailableException e) {
         e.printStackTrace();
      } catch (InvalidMidiDataException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
    
    private void loadBG(String name){
        URL imgUrl = null;
        imgUrl = getClass().getClassLoader().getResource(name);
        if (imgUrl == null) {
            System.err.println("Couldn't find file: ");
        } else {
            try {
                backGround = ImageIO.read(imgUrl);  // load image via URL
            } catch (IOException ex) {
            }
        }
    }
}