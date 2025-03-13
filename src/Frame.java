import javax.swing.JFrame;

public class Frame extends JFrame{
	
	GamePanel gp;
	TopBar tb;
	
	Frame(){
		this.setTitle("MineSweeper");
		this.setSize(GamePanel.boardWidth, GamePanel.boardHeight + 80);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		gp = new GamePanel();
		tb = new TopBar(gp);
		
		this.add(gp);
		this.add(tb);
		gp.startGameThread();
		this.setVisible(true);
	}
}
