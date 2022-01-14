package ui;

import manage.ItemManager;
import model.MyTank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyPanel extends JPanel implements Runnable {
    private ItemManager managerItem;
    private Thread thread;
    private boolean isLeft;
    private boolean isRight;
    private boolean isUp;
    private boolean isDown;
    private boolean isFire;

    public MyPanel() {
        ///
        setSize(MyFrame.WIDTH_FRAME, MyFrame.HEIGHT_FRAME);
        setLocation(0, 0);
        setBackground(Color.DARK_GRAY);
        managerItem = new ItemManager();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                switch (key) {
                    case KeyEvent.VK_A:
                        isLeft = true;
                        break;
                    case KeyEvent.VK_D:
                        isRight = true;
                        break;
                    case KeyEvent.VK_W:
                        isUp = true;
                        break;
                    case KeyEvent.VK_S:
                        isDown = true;
                        break;
                    case KeyEvent.VK_ENTER:
                        isFire = true;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_A:
                        isLeft = false;
                        break;
                    case KeyEvent.VK_D:
                        isRight = false;
                        break;
                    case KeyEvent.VK_W:
                        isUp = false;
                        break;
                    case KeyEvent.VK_S:
                        isDown = false;
                        break;
                    case KeyEvent.VK_ENTER:
                        isFire = false;
                        break;
                }
            }

        });

        setRequestFocusEnabled(true);
        setFocusable(true);

        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // noi de ve
        // Graphics la but ve

        Graphics2D g2d = (Graphics2D) g;


        managerItem.drawMyTank(g2d);
//        managerItem.drawEnemyAllTank(g2d);
//        managerItem.drawBulletOfMyTank(g2d);
//        managerItem.drawAllBulletEnemyTank(g2d);
        managerItem.drawAll(g2d);

    }

    @Override
    public void run() {
        //chay khi goi thread.start
        ///
        ///
        //
        while (true) {
            try {
                Thread.sleep(12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            moveMyTank();
//            moveBulletOfTank();
//            fireOfMyTank();
//            managerItem.interactBulletOfMyTank();
//            managerItem.moveAllEnemyTank();
//            managerItem.moveAllBulletEnemyTank();
//            managerItem.fireEnemyTank();
//            managerItem.interactBulletOfAllEnemyTank();
//            managerItem.killEnemyTank();
//            if ( managerItem.checkGameOver()) {
//                JOptionPane.showMessageDialog(MyPanel.this, "Game Over");
//                break;
//            }
//            if ( managerItem.checkWin() ) {
//                JOptionPane.showMessageDialog(MyPanel.this, "Win");
//                break;
//            }
            repaint();

        }

    }

//
//    private void moveBulletOfTank() {
//        managerItem.moveBulletOfMyTank();
//
//    }
//
//    void fireOfMyTank(){
//        if ( isFire ){
//            managerItem.fireBullet();
//        }
//    }

    void moveMyTank() {
        if (isDown) {
            managerItem.moveMyTank(MyTank.DOWN);

        }
        if (isUp) {
            managerItem.moveMyTank(MyTank.UP);

        }
        if (isRight) {
            managerItem.moveMyTank(MyTank.RIGHT);

        }
        if (isLeft) {
            managerItem.moveMyTank(MyTank.LEFT);

        }





    }
}
