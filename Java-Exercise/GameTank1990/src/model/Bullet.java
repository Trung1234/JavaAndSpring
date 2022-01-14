package model;

public class Bullet extends Item {
    int orientation;

    public Bullet(int id, int x, int y, int size, int orientation) {
        super(id, x, y, size);
    }
    public void move() {
        switch (orientation) {
            case MyTank.LEFT:
                x = x - 2;
                break;
            case MyTank.RIGHT:
                x = x + 2;
                break;
            case MyTank.UP:
                y = y - 2;
                break;
            case MyTank.DOWN:
                y = y + 2;
                break;
            default:
                break;
        }

    }
}
