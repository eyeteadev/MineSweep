import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileManager {
	Tile[][] tiles;
	GamePanel gp;
	static int amountOfBombs;
	int rows = 22;
	int cols = 36;

	
	TileManager(MouseHandler mh, GamePanel gp, ImagesHandler ih){
		TileManager.amountOfBombs = 158;
		
			
		this.gp = gp;
		tiles = new Tile[rows][cols];
		
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[i].length; j++) {
				tiles[i][j] = new Tile(i,j, this, mh, ih);
				
				gp.add(tiles[i][j]);
			}
		}
		layOutBombs();
		
		for (int i = 0; i < tiles.length; i++) {
	        for (int j = 0; j < tiles[i].length; j++) {
	            tiles[i][j].checkLocalTile();  // Now it can safely check neighboring tiles
	        }
	    }
		
	}
	
	public void drawTiles(Graphics2D g2) {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[i].length; j++) {
				tiles[i][j].draw(g2);
			}
		}
	}
	public void updateTiles() {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[i].length; j++) {
				tiles[i][j].update();
			}
		}
	}
	
	public void layOutBombs() {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[i].length; j++) {
				tiles[i][j].setBomb();
			}
		}
	}
	
	//public voi
}
