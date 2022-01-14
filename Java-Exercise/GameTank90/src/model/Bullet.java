package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet extends Item {
	
	public static Image IMG_BULLET = new ImageIcon(
			Bullet.class.getResource("/images/bullet.png"))
			.getImage();
	
	int orientation;

	public Bullet(int id, int x, int y, int size, int orientation) {
		super(id, x, y, size);
		this.orientation = orientation;
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
