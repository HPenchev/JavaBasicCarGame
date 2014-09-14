import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class ComingCars extends Entity{//coming cars is the class generating falling cars

	int velY = 5;
	
	public ComingCars(int xX, int yY) {
		super(xX, yY);
	}

	public Image getPlayerImg() {
		ImageIcon icon = new ImageIcon("car.resized");
		return icon.getImage();
	}
	
	public void update() {//here is the "speed" of our cars
		y+=1;
	}
	
	public void draw(Graphics2D g2d) { 
		g2d.drawImage(getPlayerImg(), x,  y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));
	}
}
