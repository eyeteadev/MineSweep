import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	Thread gameThread;
	TileManager tm;
	MouseHandler mh;
	ImagesHandler ih;
	static int tileSize = 20;
	static int boardWidth = tileSize * 37; // 576
	static int boardHeight = tileSize * 22; // 352
	
	
	GamePanel(){
		this.setBounds(0, 40, boardWidth, boardHeight);
		ih = new ImagesHandler();
		mh = new MouseHandler();
		tm = new TileManager(mh,this,ih);
		this.setLayout(null);
		this.setFocusable(true);
		//tm.layOutBombs();
		//this.addMouseListener(mh);
		
		this.setBackground(Color.LIGHT_GRAY);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int FPS = 60;
		double interval = 1_000_000_000 / FPS;
		double delta = 0;
		long currentTime;
		long previousTime = System.nanoTime();
		long timer = 0;
		int drawCount = 0;
	
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - previousTime) / interval;
			timer = timer + ( currentTime - previousTime);
			previousTime = currentTime;
			
			if(delta >= 1) {	
				update();
				repaint();
				drawCount++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				//System.out.println("FPS: " + drawCount);// keep this here for the future.
				drawCount = 0;
				timer = 0;
			}
		}

	}
	
	public void update() {
		tm.updateTiles();
		if(mh.click) {
			mh.click = false;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		//draw
		tm.drawTiles(g2);
		
		
		//dispose
		g2.dispose();
		
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
}
