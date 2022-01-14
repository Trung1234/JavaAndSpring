package model;

import javax.swing.*;

import java.awt.*;


public class Images {

	public static final int TREE_ID = 4;
	public static final int ROCK_ID = 5;
	public static final int BRICK_ID = 1;
	public static final int WATER_ID = 2;
	public static final int HOME_ID = 9;
	public static final int BULLET_ID = 11;

	public static final int[] ID_TANKS = new int[] { 6, 7, 8, 10 };

	public static final int[] ID_ENEMY_TANKS = new int[] { 12, 13, 14, 15 };

	public static final Image TREE = new ImageIcon(
			Images.class.getResource("/images/tree.png")).getImage();

	public static final Image ROCK = new ImageIcon(
			Images.class.getResource("/images/rock.png")).getImage();

	public static final Image WATER = new ImageIcon(
			Images.class.getResource("/images/water.png")).getImage();

	public static final Image BRICK = new ImageIcon(
			Images.class.getResource("/images/brick.png")).getImage();
	public static final Image HOME = new ImageIcon(
			Images.class.getResource("/images/bird.png")).getImage();

	public static final Image MY_TANK_LEFT = new ImageIcon(
			Images.class.getResource("/images/bossyellow_left.png")).getImage();
	public static final Image MY_TANK_RIGHT = new ImageIcon(
			Images.class.getResource("/images/bossyellow_right.png"))
			.getImage();
	public static final Image MY_TANK_UP = new ImageIcon(
			Images.class.getResource("/images/bossyellow_up.png")).getImage();
	public static final Image MY_TANK_DOWN = new ImageIcon(
			Images.class.getResource("/images/bossyellow_down.png")).getImage();

	public static final Image ENEMY_TANK_LEFT = new ImageIcon(
			Images.class.getResource("/images/player_green_left.png"))
			.getImage();
	
	public static final Image ENEMY_TANK_RIGHT = new ImageIcon(
			Images.class.getResource("/images/player_green_right.png"))
			.getImage();
	
	public static final Image ENEMY_TANK_UP = new ImageIcon(
			Images.class.getResource("/images/player_green_up.png"))
			.getImage();
	
	public static final Image ENEMY_TANK_DOWN = new ImageIcon(
			Images.class.getResource("/images/player_green_down.png"))
			.getImage();

	public static final Image BULLET = new ImageIcon(
			Images.class.getResource("/images/bullet.png")).getImage();

	public static Image getImage(int id) {
		switch (id) {
		case TREE_ID:
			return TREE;
		case ROCK_ID:
			return ROCK;
		case WATER_ID:
			return WATER;
		case BRICK_ID:
			return BRICK;
		case HOME_ID:
			return HOME;
		case 6:
			return MY_TANK_LEFT;
		case 7:
			return MY_TANK_RIGHT;
		case 8:
			return MY_TANK_UP;
		case 10:
			return MY_TANK_DOWN;
		case BULLET_ID:
			return BULLET;
		case 12:
			return ENEMY_TANK_LEFT;
		case 13: 
			return ENEMY_TANK_RIGHT;
		case 14:
			return ENEMY_TANK_UP;
		case 15: 
			return ENEMY_TANK_DOWN;
			
		default:
			return null;
		}
	}

}
