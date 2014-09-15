import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Car extends Entity {

	int velX = 0;

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

	public Image getPlayerImg() {

		ImageIcon icon = new ImageIcon("car.resized");
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
}
