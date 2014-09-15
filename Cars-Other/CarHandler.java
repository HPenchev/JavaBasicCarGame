package Cars;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class CarHandler extends GameLoop {

	@SuppressWarnings("null")
	public static void drawCar(Graphics g, int x,int y,int x2,  int y2, int y3, int x3) {//X is static atm will fix eventually.
		if (fSpawn) {
			g.setColor(Color.black);
			g.fillRect(x, y + 40, 20, 40);
		}
		if (sSpawn) {
			g.setColor(Color.black);
			g.fillRect(x2, y2 + 40, 20, 40);
		}
		if (tSpawn) {
			g.setColor(Color.black);
			g.fillRect(x3, y3 + 40, 20, 40);
		}
	}

	public static void spawnCar(int counter) { // Car spawned NOTE: Wont 2 cars
												// at same X
		if (counter % 3 == 0 && fSpawn == false) {
			fSpawn = true;
		}
		if (counter % 5 == 0 && sSpawn == false) {
			sSpawn = true;
		}
		if (counter < 0 && tSpawn == false) {
			tSpawn = true;
		}
	}
}
// }
// }
