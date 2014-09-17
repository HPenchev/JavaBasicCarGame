import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;


public class Bonuses extends Entity{
	
	int velY = 5;
	Random randomGenerator = new Random();
	int chance = randomGenerator.nextInt(300);
	
	
	public Bonuses(int xX, int yY) {
		super(xX, yY);
	}

	public Image getPlayerImg() {
			ImageIcon icon = new ImageIcon("images/lives.png");
			return icon.getImage();
	}
	
	public void update() {
		y+=1;
	}
	
	public void draw(Graphics2D g2d) { 
		g2d.drawImage(getPlayerImg(), x, y,30,30, null);
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 30);
	}
}

    
    

