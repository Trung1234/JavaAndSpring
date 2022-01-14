package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import model.Item;
import ui.GUI;


public class MyTank extends Item {
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;

	int orientation;
	ArrayList<Bullet> bullets;

	public MyTank(int id, int x, int y, int size, int orientation) {
		super(id, x, y, size);
		this.orientation = orientation;
		bullets = new ArrayList<Bullet>();
	}

	public void move(int orientation, ArrayList<Item> items) {
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

	public void fireBullet() {
		int sizeB = 7;
		int orB = orientation;
		int xB;
		int yB;
		switch (orientation) {
		case LEFT:
			xB = x -  sizeB;
			yB = y + ( size - sizeB )/2;
			break;
		case RIGHT:
			xB = x +  size;
			yB = y + ( size - sizeB )/2;
			break;
		case UP:
			xB = x +  ( size - sizeB )/2;
			yB = y - sizeB;
			break;
		
		default:
			xB = x +  ( size - sizeB )/2;
			yB = y + size;
			break;
		}
		
		Bullet bullet = new Bullet(Images.BULLET_ID, 
				xB, yB, sizeB, orB);
		bullets.add(bullet);
	}

	public void drawAllBullet(Graphics2D g2d) {
		for ( int i = 0; i < bullets.size(); i++ ) {
			Bullet bullet = bullets.get(i);
			bullet.draw(g2d);
		}
		
	}

	public void moveAllBullet() {
		for ( int i = 0; i< bullets.size(); i++ ) {
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

	public boolean killEnemyTank(EnemyTank enemyTank) {
		Rectangle rect1 = new Rectangle(enemyTank.x, enemyTank.y, enemyTank.size, enemyTank.size);
		for ( int i = 0; i < bullets.size(); i++ ) {
			Bullet bullet = bullets.get(i);
			Rectangle rect2 = new Rectangle(bullet.x, bullet.y, bullet.size, bullet.size);
			if ( rect1.intersects(rect2)) {
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
			if ( rect1.intersects(rect2) ) {
				return true;
			}
		}
		return false;
	}
	
	

	//
}
