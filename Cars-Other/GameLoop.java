package Cars;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

@SuppressWarnings("serial")
public class GameLoop extends Applet implements Runnable, KeyListener {

	public int ourCarX, ourCarY, speed, level = 1, score, lives, counter,
			trafficX, car2Y, car1Y, car3Y, carSpeed;
	public Image offscreen;
	public Graphics d;
	public static boolean left, right, fSpawn, sSpawn, tSpawn, foSpawn,
			fvSpawn, spawned;
	public Random rnd = new Random();

	public void run() {
		counter = 0;
		carSpeed = 10;
		car1Y = 0;
		while (true) {
			if (fSpawn) {
				car1Y += carSpeed;
				if (car1Y >= Game.height) {
					fSpawn = false;
					car1Y = 0;
				}
			}
			if (sSpawn) {
				car2Y += carSpeed;
				if (car2Y >= Game.height) {
					sSpawn = false;
					car2Y = 0;
				}
			}
			if (tSpawn) {
				car3Y += carSpeed;
				if (car3Y >= Game.height) {
					sSpawn = false;
					car3Y = 0;
				}
			}
			counter = rnd.nextInt(60);
			CarHandler.spawnCar(counter);
			setSpeed(speed);
			if (left == true) {
				if (ourCarX > 20) {
					ourCarX -= 40;
				}
			}
			if (right == true) {
				if (ourCarX < Game.width - 50) {
					ourCarX += 40;
				}
			}
			if (GG(ourCarX, 10, 240, car1Y) || GG(ourCarX, 50, 240, car2Y)) { // 10 is first car X 50 is second car X
				break;
			}
			repaint();
		}
	}

	// Car control
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			GameLoop.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			GameLoop.right = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			GameLoop.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			GameLoop.right = false;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	// Car Speed
	private void setSpeed(int speed) {
		if (speed == 0) {
			speed = 100;
		}
		speed -= level * 10;
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Collision
	public boolean GG(int x, int x2, int y, int y2) {
		if (Game.width - x > Game.width - x2 && y <= y2 + 35) {
			return true;
		} else {
			return false;
		}
	}
}
