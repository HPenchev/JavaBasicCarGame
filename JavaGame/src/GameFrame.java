import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GameFrame extends JPanel implements ActionListener {

	Timer mainTimer;
	Car car;
	ComingCars comingCar;
	Bonuses comingBonus;

	ArrayList<Bonuses> bonusesList = new ArrayList<Bonuses>();// we manage our falling bonuses in the list
	ArrayList<ComingCars> carsComing = new ArrayList<ComingCars>();// we manage our falling cars in the list

	public GameFrame() {
		setFocusable(true);
		setBackground(Color.DARK_GRAY);
		int boardWidth = 800;
		int boardHeight = 600;
		car = new Car(boardWidth / 2, boardHeight - 60); // Centers car in middle of board
		addKeyListener(new PressedKeys(car));
		mainTimer = new Timer(5, this); // parameter for controlling the speed of moving
		mainTimer.start();
	}

	public int y = 600;
	public int carIntegrity = 200; //car health 
	public int wonned = 0; //value for condition to make win = true;
	public boolean GameOver = false, bonusGet = false,bonusSpawned = true, win = false;

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if (win) {
			g2d.setColor(Color.black);
			g2d.fillRect(0, 0, 800, 600); // Add Game Over Image Here and remove all else
			g2d.setColor(Color.white);
			g2d.drawString("GG EASY", 380, 300);
		}else if (GameOver) {
			g2d.setColor(Color.black);
			g2d.fillRect(0, 0, 800, 600); // Add Game Over Image Here and remove all else
			g2d.setColor(Color.white);
			g2d.drawString("Game Over", 380, 300);
		} else {
			Car.drawStreet(g2d); //Black borders on the sides Remove if background selected.
			g2d.setColor(Color.GRAY);
			car.moveStreet(g2d, y);//street lines moving Remove if background selected.
			y += 3; // Speed of lane aka moving lines.
			if (y > 300) {
				y = 0;
			}
			car.draw(g2d);
			for (ComingCars upcomingCar : carsComing) {
				upcomingCar.draw(g2d);
			}
			for (Bonuses bonus : bonusesList) {
				bonus.draw(g2d);
			}
			//Progress text on top left?
			g.setColor(Color.white);
			g.drawString("Car integrity: " + carIntegrity/2 +"%", 0, 10);
			g.drawString("Overcharge: "+wonned*25+"%", 0, 30);
		}
	}

	public void actionPerformed(ActionEvent arg0) { //Main game loop where the magic happens.
		if (checkCollision()) { //If our car is hit reduce health by 1 per tick.
			carIntegrity -= 1;
			if (carIntegrity <= 0) { //If car health is 0 car goes boom boom.
				GameOver = true; //Go to bad ending
			}
		}
		if (checkBonusCollision()) {
			bonusGet = true;		//Bonus Control Wont spawn more than 1 on screen. Controls removal.
			bonusSpawned = true;	//Bonus Control Wont spawn more than 1 on screen. Controls spawning.
			carIntegrity += 20;		// Bonus hp recieved per bonus gain.
			if (carIntegrity >= 200) {//If hp is full and you gain a heart or 
				carIntegrity=200;	  //a heart puts you over HP threshold you gain +1 towards victory
				wonned+=1;
				if (wonned==3) { //If above happens N times you win.
					win=true; // go to good ending
				}
			}
		}
		carsGenerator();
		for (int i = 0; i < carsComing.size(); i++) {
			carsComing.get(i).update();// we update each falling car
		}

		bonusGenerator();
		for (int i = 0; i < bonusesList.size(); i++) {
			bonusesList.get(i).update();// we update each falling bonus
		}
		car.update();
		repaint(); // function from JPanel, repainting the window

		for (int i = 0; i < carsComing.size(); i++) {
			if (carsComing.get(i).y > 820) {
				carsComing.remove(i);// deleting cars
			}
		}
		for (int i = 0; i < bonusesList.size(); i++) {
			if (bonusesList.get(i).y > 600 || bonusGet) { //default 820
				bonusesList.remove(i);// deleting bonuses
				if (i>=bonusesList.size()-1) {
					bonusGet=false;
				}
			}
		}
	}

	private void carsGenerator() {// we generate new cars here
		Random rnd = new Random();
		int chance = rnd.nextInt(100);
		if (chance < 2) { //2% chance to spawn a car
			int startPosition = rnd.nextInt(370) + 200;
			comingCar = new ComingCars(startPosition, 0);
			carsComing.add(comingCar);
		}

	}

	private void bonusGenerator() {// we generate new bonuses here
		Random rnd = new Random();		// Random my ass...
		int chance = rnd.nextInt(1000); //Increase to prolong game time -.-
		if (chance == 0 && bonusSpawned) { //Game isn't fps locked and spawns a bonus every N ticks.
			int startPosition = rnd.nextInt(370) + 200; // Push car onto road.
			comingBonus = new Bonuses(startPosition, 0);
			bonusesList.add(comingBonus);
			bonusSpawned=false;
		}

	}

	private boolean checkCollision() {
		for (ComingCars currentCar : carsComing) {
			if (currentCar.getBounds().intersects(car.getBounds())) {
				return true;
			}
		}
		return false;
	}

	private boolean checkBonusCollision() {
		for (Bonuses bonus : bonusesList) {
			if (bonus.getBounds().intersects(car.getBounds())) {
				return true;
			}
		}
		return false;
	}
}
