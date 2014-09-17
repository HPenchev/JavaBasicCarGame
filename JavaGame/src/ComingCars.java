import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class ComingCars extends Entity {// coming cars is the class generating
										// falling cars

	int velY = 5;

	public ComingCars(int xX, int yY) {
		super(xX, yY);
	}

	public Image getPlayerImg() { //Change if() {images} to car frames.
//		Random rnd = new Random();
//		int chance = rnd.nextInt(100);
//		if (chance < 25) {
//			ImageIcon image = new ImageIcon("images/car-red.png");
//			return image.getImage();
//		} else if (chance < 50) {
//			ImageIcon image = new ImageIcon("images/car-yellow.png");
//			return image.getImage();
//		} else if (chance < 75) {
//			ImageIcon image = new ImageIcon("images/car-green.png");
//			return image.getImage();
//		} else {
			ImageIcon image = new ImageIcon("images/car-orange.png");
			return image.getImage();
//		}
	}

	public void update() {// here is the "speed" of our cars
		y += 2;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(), x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, getPlayerImg().getWidth(null),
				getPlayerImg().getHeight(null));
	}
}
