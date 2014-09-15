import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.Graphics2D;
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
		if(chance<20)
		{
			ImageIcon icon = new ImageIcon("lives.png");
			return icon.getImage();
		}
		else if(chance<50)
		{
			ImageIcon icon = new ImageIcon("Biodiesel.jpg");
			return icon.getImage();
		}
		else
		{
			return null;
		}
	}
	
	public void update() {
		y+=1;
	}
	
	public void draw(Graphics2D g2d) { 
		g2d.drawImage(getPlayerImg(), x, y,30,30, null);
	}
}

    
    

