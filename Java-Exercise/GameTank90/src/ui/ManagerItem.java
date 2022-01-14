package ui;

import model.EnemyTank;
import model.Images;
import model.Item;
import model.MyTank;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class ManagerItem {
    private ArrayList<Item> items;
    private MyTank myTank;
    long currentTimeFireMyTank = 0;
    ArrayList<EnemyTank> enemyTanks;
    long currentMoveEnemy;
    long currentfireEnemyTank;
    Item home;

    public ManagerItem() {
        items = new ArrayList<>();
        int x = 20 * 10;
        int y = 25 * 20;
        int orientation = MyTank.UP;
        int id = Images.ID_TANKS[orientation];
        myTank = new MyTank(id, x, y, 35, orientation);
        enemyTanks = new ArrayList<EnemyTank>();
        createEnemy();
        readFile();
    }
    
    void createEnemy(){
    	int x1 = 20;
    	int y1 = 20;
    	int ori1 = MyTank.DOWN;
    	int size1 = 36;
  
    	EnemyTank enemyTank1 = new EnemyTank(Images.ID_ENEMY_TANKS[ori1], 
    			x1, y1, size1, ori1);
    	
    	enemyTanks.add(enemyTank1);
    	
    	int x2 = 8*20;
    	int y2 = 20;
    	int ori2 = MyTank.DOWN;
    	int size2 = 36;
  
    	EnemyTank enemyTank2 = new EnemyTank(Images.ID_ENEMY_TANKS[ori2], 
    			x2, y2, size2, ori2);
    	enemyTanks.add(enemyTank2);
    	
       	int x3 = 20*20;
    	int y3 = 20;
    	int ori3 = MyTank.DOWN;
    	int size3 = 36;
  
    	EnemyTank enemyTank3 = new EnemyTank(Images.ID_ENEMY_TANKS[ori3], 
    			x3, y3, size3, ori3);
    	
    	enemyTanks.add(enemyTank3);
    	
    	int x4 = 13*20;
    	int y4 = 80;
    	int ori4 = MyTank.DOWN;
    	int size4 = 36;
  
    	EnemyTank enemyTank4 = new EnemyTank(Images.ID_ENEMY_TANKS[ori4], 
    			x4, y4, size4, ori4);
    	
    	enemyTanks.add(enemyTank4);
    	
    	
    	int x5 = 4*20;
    	int y5 = 14*20;
    	int ori5 = MyTank.RIGHT;
    	int size5 = 36;
  
    	EnemyTank enemyTank5 = new EnemyTank(Images.ID_ENEMY_TANKS[ori5], 
    			x5, y5, size5, ori5);
    	
    	enemyTanks.add(enemyTank5);
    	
    	
    	int x6 = 21*20;
    	int y6 = 16*20;
    	int ori6 = MyTank.RIGHT;
    	int size6 = 36;
  
    	EnemyTank enemyTank6 = new EnemyTank(Images.ID_ENEMY_TANKS[ori6], 
    			x6, y6, size6, ori6);
    	
    	enemyTanks.add(enemyTank6);
    }
    
    public void drawEnemyAllTank(Graphics2D g2d) {
    	for ( int i = 0; i < enemyTanks.size(); i++ ) {
    		EnemyTank enemyTank = enemyTanks.get(i);
    		enemyTank.draw(g2d);
    	}
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

	public void fireBullet() {
		long time = System.currentTimeMillis();
		if ( time - currentTimeFireMyTank > 500 ) {
			myTank.fireBullet();
			currentTimeFireMyTank = time;
		}
	}

	public void drawBulletOfMyTank(Graphics2D g2d) {
		myTank.drawAllBullet(g2d);
		
	}

	public void moveBulletOfMyTank() {
		myTank.moveAllBullet();
		
	}

	public void interactBulletOfMyTank() {
		myTank.interactBullet(items);
		
	}
	
	public void interactBulletOfAllEnemyTank(){
		for ( int i = 0; i < enemyTanks.size(); i++ ) {
			EnemyTank enemyTank = enemyTanks.get(i);
			enemyTank.interactBullet(items);
		}
	}

	public void moveAllEnemyTank() {
		long current = System.currentTimeMillis();
		if ( current - currentMoveEnemy < 25 ) {
			return;
		}
		currentMoveEnemy = current;
		for ( int i = 0; i < enemyTanks.size(); i++ ) {
			EnemyTank enemyTank = enemyTanks.get(i);
			enemyTank.move(items);
		}
		
		
		
	}

	public void fireEnemyTank() {
		long time = System.currentTimeMillis();
		if  ( time - currentfireEnemyTank < 3500 ) {
			return;
		}
		currentfireEnemyTank = time;
		for ( int i = 0; i < enemyTanks.size(); i++ ) {
			EnemyTank enemyTank = enemyTanks.get(i);
			enemyTank.fireBullet();
		}
	}
	
	public void drawAllBulletEnemyTank(Graphics2D g2d) {
		for ( int i = 0; i < enemyTanks.size(); i++ ) {
			EnemyTank enemyTank = enemyTanks.get(i);
			enemyTank.drawAllBullet(g2d);
		}
	}

	public void moveAllBulletEnemyTank() {
		for ( int i = 0; i < enemyTanks.size(); i++ ) {
			EnemyTank enemyTank = enemyTanks.get(i);
			enemyTank.moveAllBullet();
		}
	}
	
	public void killEnemyTank() {
		for ( int i = 0; i < enemyTanks.size(); i++ ) {
			EnemyTank enemyTank = enemyTanks.get(i);
			boolean isKill = myTank.killEnemyTank(enemyTank);
			if ( isKill ) {
				enemyTanks.remove(i);
				i--;
			}
		}
	}
	
	public boolean checkGameOver(){
		for ( int i = 0; i < enemyTanks.size(); i++ ) {
			EnemyTank enemyTank = enemyTanks.get(i);
			boolean isKill = enemyTank.killMyTank(myTank);
			if ( isKill ) {
				return true;
			}
		}
		
		if ( killHome() ) {
			return true;
		}
		
		return false;
	}

	public boolean checkWin() {
		if ( enemyTanks.size() == 0 ) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean killHome() {
		boolean killFromMyTank = myTank.killHome(home);
		if (killFromMyTank ) {
			return true;
		}
		for ( int i = 0; i < enemyTanks.size(); i++ ) {
			EnemyTank enemyTank = enemyTanks.get(i);
			if ( enemyTank.killHome(home) ) {
				return true;
			}
		}
		
		return false;
	}
	
	
}
