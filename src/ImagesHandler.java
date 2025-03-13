import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImagesHandler {

	BufferedImage[] images;
	
	ImagesHandler(){
		try {
			images = new BufferedImage[13];
			images[0] = ImageIO.read(getClass().getResourceAsStream("flag.png"));
			images[1] = ImageIO.read(getClass().getResourceAsStream("one.png"));
			images[2] = ImageIO.read(getClass().getResourceAsStream("two.png"));
			images[3] = ImageIO.read(getClass().getResourceAsStream("three.png"));
			images[4] = ImageIO.read(getClass().getResourceAsStream("four.png"));
			images[5] = ImageIO.read(getClass().getResourceAsStream("five.png"));
			images[6] = ImageIO.read(getClass().getResourceAsStream("six.png"));
			images[7] = ImageIO.read(getClass().getResourceAsStream("seven.png"));
			images[8] = ImageIO.read(getClass().getResourceAsStream("eight.png"));
			images[10] = ImageIO.read(getClass().getResourceAsStream("bomb.png"));
			images[11] = ImageIO.read(getClass().getResourceAsStream("tile.png"));
			images[12] = ImageIO.read(getClass().getResourceAsStream("hover.png"));
		}catch (IOException e) {
			
		}
	}
	
	
}
