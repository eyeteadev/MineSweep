import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class MouseHandler implements MouseListener{
	
	boolean click = false;
	boolean canClick = true;
	
	//MouseHandler()
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		click = true;
		//if(canClick) {
			if(e.getSource() instanceof Tile && click == true) {
				Tile tile = (Tile) e.getSource();
				
				//left first then right.
				if (SwingUtilities.isLeftMouseButton(e)) {
					//System.out.println("Left click detected");
					tile.showLoc();
					if(!tile.flagged && !tile.cleared) {
						tile.clear();
						tile.clicked = true;
						
						//System.out.println(tile.col);
						//System.out.println(tile.row);
						//tile.cleared = true;
					}
					
					//System.out.println(tile.image);
					
	            } else if (SwingUtilities.isRightMouseButton(e)) {
	            	if(tile.flagged) {
	            		tile.thisImage(11);
	            		tile.flagged = false;
	            	}else if(!tile.cleared){
	            		tile.thisImage(0); //flag it
	                	tile.flagged = true;
	            	}
	      
	            }
				
			}
		}
//	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		/*
		if(e.getSource() instanceof Tile) {
			//System.out.println("ENTERS");
			Tile tile = (Tile) e.getSource();
			
			if(!tile.flagged) {
				tile.changeToHover();
			}else {
				tile.changeToTile();
				tile.changeToNotHover();
				System.out.println("FLAGGED");
			}
			
		}
		*/
	}

	@Override
	public void mouseExited(MouseEvent e) {}

}
