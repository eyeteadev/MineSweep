import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class TopBar extends JPanel{
	
	MyButton button1;
	
	TopBar(GamePanel gp){
		this.setBounds(0,0,GamePanel.boardWidth, 80);
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		button1 = new MyButton(gp);
		
		this.add(button1);
	}
}
