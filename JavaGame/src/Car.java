import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Car extends Entity {

	static int velX = 0;

	public Car(int x, int y) {
		super(x, y);
	}

	public void update() {
		x += velX;
		if (x > 570) {
			x = 570;
		}
		else if (x < 200) {
			x = 200;
		}
	}

	//this will draw our car
	public void draw(Graphics2D g2d) { 
		g2d.drawImage(getPlayerImg(), x, y-30, null);
	}
	
	public void moveLane(Graphics2D g2d, int y, int x) { //Remove if background is selected.
		g2d.fillRect(x, y - 300, 5, 60);
		g2d.fillRect(x, y - 150, 5, 60);
		g2d.fillRect(x, y, 5, 60);
		g2d.fillRect(x, y + 150, 5, 60);
		g2d.fillRect(x, y + 300, 5, 60);
		g2d.fillRect(x, y + 450, 5, 60);
	}

	public void moveStreet(Graphics2D g2d, int y) { //Remove if background is selected.
		//moveLane(g2d, y, 200);;
		moveLane(g2d, y, 300);
		moveLane(g2d, y, 400);
		moveLane(g2d, y, 500);
	}
	
	public Image getPlayerImg() {

		ImageIcon icon = new ImageIcon("images/red-car.png");
		return icon.getImage();
	}

	public void keyPressed(KeyEvent keyPressed) {
		int key = keyPressed.getKeyCode();

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			velX = -2;
		} else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			velX = 2;
		}
	}

	public void keyReleased(KeyEvent keyPressed) {
		int key = keyPressed.getKeyCode();

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			velX = 0;
		} else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			velX = 0;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y-30, getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));
	}
}
