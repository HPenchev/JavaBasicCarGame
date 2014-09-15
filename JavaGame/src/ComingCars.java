import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;


public class ComingCars extends Entity{//coming cars is the class generating falling cars

	int velY = 5;
	
	public ComingCars(int xX, int yY) {
		super(xX, yY);
	}

	public Image getPlayerImg() {
		ImageIcon [] images = new ImageIcon[4];
		Random rnd = new Random();
		int chance = rnd.nextInt(100);
		if(chance<25)
		{
			images[0] = new ImageIcon("cars/car-orange.png");
			return images[0].getImage();
		}
		else if(chance<50)
		{
			images[1] = new ImageIcon("cars/car-yellow.png");
			return images[1].getImage();
		}
		else if(chance<75)
		{
			images[2] = new ImageIcon("cars/car-green.png");
			return images[2].getImage();
		}
		else
		{
			images[3] = new ImageIcon("cars/car-red.png");
			return images[3].getImage();
		}
	}
	
	public void update() {//here is the "speed" of our cars
		y+=2;
	}
	
	public void draw(Graphics2D g2d) { 
		g2d.drawImage(getPlayerImg(), x,  y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));
	}
}
