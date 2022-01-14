package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class EnemyTank extends Item {
	int orientation;
	ArrayList<Bullet> bullets;

	public EnemyTank(int id, int x, int y, int size, int orientation) {
		super(id, x, y, size);
		this.orientation = orientation;
		bullets = new ArrayList<Bullet>();
	}

	public void move(ArrayList<Item> items) {
		switch (orientation) {
		case MyTank.LEFT:
			x = x - 1;
			boolean isIntesect = interactWithItems(items);
			if (isIntesect == true) {
				x = x + 1;
				changeOri(items);
			}else {
				Random rd = new Random();
				int rdInt = rd.nextInt(10000);
				if ( rdInt > 9889 ) {
					changeOri(items);
				}
			}
			break;
		case MyTank.RIGHT:
			x = x + 1;
			isIntesect = interactWithItems(items);
			if (isIntesect == true) {
				x = x - 1;
				changeOri(items);
			}else {
				Random rd = new Random();
				int rdInt = rd.nextInt(10000);
				if ( rdInt > 9889 ) {
					changeOri(items);
				}
			}
			break;
		case MyTank.UP:
			y = y - 1;
			isIntesect = interactWithItems(items);
			if (isIntesect == true) {
				y = y + 1;
				changeOri(items);
			}else {
				Random rd = new Random();
				int rdInt = rd.nextInt(10000);
				if ( rdInt > 9889 ) {
					changeOri(items);
				}
			}
			break;
		case MyTank.DOWN:
			y = y + 1;
			isIntesect = interactWithItems(items);
			if (isIntesect == true) {
				y = y - 1;
				changeOri(items);
			}else {
				Random rd = new Random();
				int rdInt = rd.nextInt(10000);
				if ( rdInt > 9889 ) {
					changeOri(items);
				}
			}
			break;
		}
	}

	boolean interactWithItems(ArrayList<Item> items) {
		Rectangle rect1 = new Rectangle(x, y, size, size);
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if (item.id == Images.TREE_ID) {
				continue;
			}

			Rectangle rect2 = new Rectangle(item.x, item.y, item.size,
					item.size);
			if (rect1.intersects(rect2) == true) {
				return true;
			}

		}
		return false;
	}

	public void fireBullet() {
		int sizeB = 7;
		int orB = orientation;
		int xB;
		int yB;
		switch (orientation) {
		case MyTank.LEFT:
			xB = x - sizeB;
			yB = y + (size - sizeB) / 2;
			break;
		case MyTank.RIGHT:
			xB = x + size;
			yB = y + (size - sizeB) / 2;
			break;
		case MyTank.UP:
			xB = x + (size - sizeB) / 2;
			yB = y - sizeB;
			break;

		default:
			xB = x + (size - sizeB) / 2;
			yB = y + size;
			break;
		}

		Bullet bullet = new Bullet(Images.BULLET_ID, xB, yB, sizeB, orB);
		bullets.add(bullet);
	}

	public void changeOri(ArrayList<Item> items) {
		Random rd = new Random();
		int i = rd.nextInt(3) + 1;
		int ori = (orientation + i) % 4;
		orientation = ori;
		int id = Images.ID_ENEMY_TANKS[orientation];
		img = Images.getImage(id);
	}

	public void drawAllBullet(Graphics2D g2d) {
		for ( int i = 0; i < bullets.size(); i++ ) {
			Bullet bullet = bullets.get(i);
			bullet.draw(g2d);
		}
		
	}

	public void moveAllBullet() {
		for ( int i = 0; i < bullets.size(); i++ ) {
			Bullet bullet = bullets.get(i);
			bullet.move();
		}
		
	}
	
	public void interactBullet(ArrayList<Item> items) {
		for ( int i = 0; i < bullets.size(); i++ ) {
			Bullet bullet = bullets.get(i);
			Rectangle rect1 = 
					new Rectangle(bullet.x, bullet.y, 
							bullet.size, bullet.size);
			for ( int j = 0 ; j < items.size(); j++ ){
				Item item = items.get(j);
				if ( item.id == Images.TREE_ID ) {
					continue;
				}
				if ( item.id == Images.WATER_ID ) {
					continue;
				}
				
				Rectangle rect2 = 
						new Rectangle(item.x, item.y, 
								item.size, item.size);
				if ( rect1.intersects(rect2) == true ) {
					if ( item.id == Images.ROCK_ID ) {
						bullets.remove(i);
						return;
					}
					
					if ( item.id == Images.BRICK_ID ) {
						bullets.remove(i);
						items.remove(j);
						return;
					}
				}
			}
		}
		
	}

	public boolean killMyTank(MyTank myTank) {
		Rectangle rect1 = new Rectangle(myTank.x, myTank.y, myTank.size, myTank.size);
		for ( int i = 0; i < bullets.size(); i++ ) {
			Bullet bullet = bullets.get(i);
			Rectangle rect2 = new Rectangle(bullet.x, bullet.y, bullet.size, bullet.size);
			if (rect1.intersects(rect2) ) {
				return true;
			}
		}
		return false;
		
	}

	public boolean killHome(Item home) {
		Rectangle rect1 = new Rectangle(home.x, home.y, home.size, home.size);
		for ( int i = 0; i < bullets.size(); i++ ) {
			Bullet bullet = bullets.get(i);
			Rectangle rect2 = new Rectangle(bullet.x, bullet.y, bullet.size, bullet.size);
			if (rect1.intersects(rect2) ) {
				return true;
			}
		}
		return false;
	}

}
