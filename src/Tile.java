import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Tile extends JComponent{
	
	int col,row;
	int x, y;
	
	boolean isBomb;
	boolean flagged = false;
	boolean clicked;
	boolean hover = false;
	boolean cleared = false;
	int number = 0;
	
	BufferedImage image;
	MouseHandler mh;
	TileManager tm;
	ImagesHandler ih;
	
	Tile(int row, int col, TileManager tm, MouseHandler mh, ImagesHandler ih){
		this.ih = ih;
		this.tm = tm;
		this.mh = mh;
		this.addMouseListener(mh);
		this.row = row;
		this.col = col;
		this.x = col * GamePanel.tileSize;
		this.y = row * GamePanel.tileSize;
		
		this.setFocusable(true);
		//this.setF
		this.setVisible(true);
		
		image = ih.images[11];
		this.setVisible(true);
		
		
		//setBomb();
		this.setBounds(x,y,GamePanel.tileSize,GamePanel.tileSize);
		//checkLocalTile();
	}
	
	public void checkLocalTile() {
		// get this row and column, make sure to check within array bounds. get the number of bombs around the tile.
		//end of bounds is 		0,0			0,35
		//						21,0		21,35
		//
		//
		if(this.row > 0) {
			number += checkRow(this.row - 1, col);
		}
		
		number += checkRowExcludeMiddle(this.row, col);
		
		if(this.row < tm.rows-1) {
			number += checkRow(this.row + 1, col);
		}
		
		
	}
	
	public void clearNeighbours() {
		for(int i = Math.max(0, row-1); i <= Math.min(tm.rows-1, row+1);i++) {
			for(int j = Math.max(0,col -1); j <= Math.min(tm.cols -1, col + 1); j++) {
				
				if(i == this.row && j == this.col) {
					continue;
				}
				
				Tile neighbour = tm.tiles[i][j];
				
				if(neighbour.cleared || neighbour.flagged || neighbour.isBomb || neighbour.clicked ) {
					continue;
				}
				
				neighbour.clear();
				
				if(neighbour.number == 0) {
					clearNeighbours();
				}
			}
		}
	}
	public int checkRowExcludeMiddle(int row, int colPosition) {
		int bombs = 0;
		
		if(colPosition > 0) {
			if(tm.tiles[row][colPosition - 1].isBomb) {
				bombs++;
			}
		}
		if(colPosition < tm.cols - 1){
			if(tm.tiles[row][colPosition + 1].isBomb) {
				bombs++;
			}
		}
		
		return bombs;
	}
	
	public int checkRow(int row, int colPosition) {
		int bombs = 0;
		// max colPosition is 35, lowest 0;
		// max row is 21, lowest 0;
		int startCol = Math.max(colPosition - 1, 0);
		int endCol = Math.min(colPosition + 1, tm.cols - 1);
		for(int i = startCol; i <= endCol; i++) {
			if(tm.tiles[row][i].isBomb) {
				bombs++;
			}
		}
		
		return bombs;
	}
	
	
	public void update() {
		
	}
	
	
	
	public void draw(Graphics2D g2) {
		g2.drawImage(image,x,y,GamePanel.tileSize,GamePanel.tileSize,null);
	}
	
	public void setBomb() {
		Random random = new Random();
		int decide = random.nextInt(5);
		if(decide == 0 && TileManager.amountOfBombs > 0) {
			this.isBomb = true;
			TileManager.amountOfBombs--;
		}
	}
	
	//main clearing function.
	// 0 to 
	public void clear() {
		if(tm.firstClick) {
			tm.firstClick = false;
			if(this.isBomb) {
				this.isBomb = false;
				
			}
		}
		
		if(!this.clicked) {
			this.clicked = true;
		
			if(this.isBomb) {
				//System.exit(0);
				thisImage(10);
				mh.canClick = false;
			}else {
				//System.out.println(this.number);
				if(number  == 0) {
					thisImage(12);
					clearNeighbours();
				}else {
					switch(number) {
					case 1:
						thisImage(1);
						break;
					case 2:
						thisImage(2);
						break;
					case 3:
						thisImage(3);
						break;
					case 4:
						thisImage(4);
						break;
					case 5:
						thisImage(5);
						break;
					case 6:
						thisImage(6);
						break;
					case 7:
						thisImage(7);
						break;
					case 8:
						thisImage(8);
						break;
					}
				}
			}
		}
		this.cleared = true;
	}
	
	
	public void thisImage(int index) {
		this.image = ih.images[index];
	}
	
	public void showLoc() {
		System.out.println(this.isBomb);
		System.out.println(this.number);
		System.out.println(this.cleared);
	}
	
}
