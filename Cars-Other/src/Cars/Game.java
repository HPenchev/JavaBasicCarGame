package Cars;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Game extends GameLoop {
	public static int width = 200, height = 310; // Road size

	public void init() {
		setSize(width, height);
		ourCarX = width / 2 - 20; // Set car in middle at start of game
		Thread thread = new Thread(this);
		thread.start();
		offscreen = createImage(width, height);
		d = offscreen.getGraphics();
		d.setColor(Color.LIGHT_GRAY);
		addKeyListener(this);
	}

	public void paint(Graphics g) { // Main draw method
		d.setColor(Color.LIGHT_GRAY);
		d.fillRect(0, 0, width, height);
		d.setColor(Color.black); // Car Start Draw
		d.fillOval(ourCarX - 1, height - 25, 10, 15); // left Headlight
		d.fillOval(ourCarX + 30, height - 25, 10, 15); // right headlight
		d.fillRect(ourCarX, height - 20, 40, 35); // Car body
		d.setColor(Color.DARK_GRAY);
		d.fillRect(ourCarX + 10, height - 20, 20, 5); // Front Bumper
		d.setColor(Color.black); // Black border and stats
		d.fillRect(0, 0, width, 50);
		d.setColor(Color.white);
		d.drawString("Level: " + Integer.toString(level), 0, 10);
		d.drawString("Score: " + Integer.toString(score), 0, 20);
		d.drawString("Repairs: " + Integer.toString(lives), 0, 30);
		d.drawString("Speed: " + Integer.toString(speed), 0, 40);
		CarHandler.drawCar(d, 10, car1Y, 50, car2Y, 90, car3Y);
		g.drawImage(offscreen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}
}
