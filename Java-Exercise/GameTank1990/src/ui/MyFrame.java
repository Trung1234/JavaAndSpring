package ui;

import model.Item;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends JFrame {
    public static final int WIDTH_FRAME = 28 * 20;
    public static final int HEIGHT_FRAME = 29 * 20;

    String gongFile = "src/sound/xf0.mid";

    MyPanel myPanel;

    public MyFrame() {
        setTitle("Game Tank 1990");

        //set kich thuoc cho khung tranh
        setSize(WIDTH_FRAME, HEIGHT_FRAME);

        //show ra giua man hinh
        setLocationRelativeTo(null);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        init();
        Item.playSound(gongFile);

    }


    private void init() {
        myPanel = new MyPanel();
        add(myPanel);
    }

}
