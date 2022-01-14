package manage;

import model.Images;
import model.Item;
import model.MyTank;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ItemManager {
    private ArrayList<Item> items;
    private MyTank myTank;
    long currentTimeFireMyTank = 0;
    long currentMoveEnemy;
    long currentfireEnemyTank;
    Item home;

    public ItemManager() {
        items = new ArrayList<>();
        int x = 20 * 10;
        int y = 25 * 20;
        int orientation = MyTank.UP;
        int id = Images.ID_TANKS[orientation];
        myTank = new MyTank(id, x, y, 35, orientation);
        readFile();
    }

    private void readFile() {
        String path = getClass().getResource("/map/map1.txt")
                .getPath();
        path = path.replaceAll("%20", " ");
        File file = new File(path);
        try {
            RandomAccessFile rd =
                    new RandomAccessFile(file, "rw");
            String content = rd.readLine();
            int index = 0;
            while (content != null ){
                for ( int i = 0; i < content.length(); i++ ) {
                    int id = content.charAt(i) - '0';
                    if ( id == 0 ) {
                        continue;
                    }
                    int x = i * 20;
                    int y = index * 20;
                    Item item;
                    if ( id == 9 ) {
                        item = new Item(id, x, y, 40);
                        home = item;
                    }else {
                        item = new Item(id, x, y, 20);
                    }

                    items.add(item);

                }
                index++;
                content = rd.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void drawAll(Graphics2D g2d ) {
        for ( int i = 0; i < items.size(); i++ ) {
            Item item = items.get(i);
            item.draw(g2d);
        }
    }
    public void drawMyTank(Graphics2D g2d) {
        myTank.draw(g2d);
    }

    public void moveMyTank(int orientation) {
        myTank.move(orientation, items);
    }

}
