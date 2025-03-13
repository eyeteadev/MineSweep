import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButton extends JButton{
	
	MyButton(GamePanel gp){
		this.setBounds(10,10,20,20);
		this.setFocusable(true);
		
		this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         
            }
        });
	}
}
