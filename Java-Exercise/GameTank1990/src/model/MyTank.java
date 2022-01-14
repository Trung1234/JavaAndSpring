package model;

import java.awt.*;
import java.util.ArrayList;

public class MyTank extends Item {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    String gongFile = "src/sound/explosion.wav";

    int orientation;
    public MyTank(int id, int x, int y, int size, int orientation) {
        super(id, x, y, size);
        this.orientation = orientation;
    }
    public void move(int orientation, ArrayList<Item> items){
        id = Images.ID_TANKS[orientation];
        img = Images.getImage(id);
        this.orientation = orientation;
        switch (orientation) {
            case LEFT:
                x = x - 1;
                boolean isIntesect = interactWithItems(items);
                if ( isIntesect == true ) {
                    x = x + 1;
                }
                break;
            case RIGHT:
                x = x + 1;
                isIntesect = interactWithItems(items);
                if ( isIntesect == true ) {
                    x = x - 1;
                }
                break;
            case UP:
                y = y - 1;
                isIntesect = interactWithItems(items);
                if ( isIntesect == true ) {
                    y = y + 1;
                }
                break;
            case DOWN:
                y = y + 1;
                isIntesect = interactWithItems(items);
                if ( isIntesect == true ) {
                    y = y - 1;
                }
                break;
        }
    }
    boolean interactWithItems(ArrayList<Item> items) {
        Rectangle rect1 =
                new Rectangle(x, y, size, size);
        for ( int i = 0; i < items.size(); i++ ) {
            Item item = items.get(i);
            if ( item.id == Images.TREE_ID ) {
                continue;
            }

            Rectangle rect2 =
                    new Rectangle(item.x, item.y,
                            item.size, item.size);
            if ( rect1.intersects(rect2) == true) {
                return true;
            }

        }
        return false;
    }
}
