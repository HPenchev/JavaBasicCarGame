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
	
	ArrayList<Bonuses> bonusesList = new ArrayList<Bonuses>();//we manage our falling bonuses in the list
	ArrayList<ComingCars> carsComing = new ArrayList<ComingCars>();//we manage our falling cars in the list

	public GameFrame() {
		setFocusable(true);
		setBackground(Color.DARK_GRAY);
		int boardWidth = 800;
		int boardHeight = 600;
		car = new Car(boardWidth/2, boardHeight - 60);
		addKeyListener(new PressedKeys(car));
		mainTimer = new Timer(5 , this); // parameter for controlling the speed of moving
		mainTimer.start();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		car.draw(g2d);
		
		for (ComingCars upcomingCar : carsComing) {
			upcomingCar.draw(g2d);
		}
		for (Bonuses bonus : bonusesList) {
			bonus.draw(g2d);
		}
		

	}
	
	public void actionPerformed(ActionEvent arg0) {
		carsGenerator();
		for (int i = 0; i< carsComing.size(); i++) {
			carsComing.get(i).update();//we update each falling car 
		}
	    
		bonusGenerator();
		for (int i = 0; i< bonusesList.size(); i++) {
			bonusesList.get(i).update();//we update each falling bonus 
		}
		
		if(checkCollision()){ 
			// car crashes
		}
		if(checkBonusCollision()){
			// receive bonus
		}
		car.update();
		repaint(); //function from JPanel, repainting the window 
		
		for(int i = 0; i< carsComing.size(); i++){
			if (carsComing.get(i).y>820) 
				{
					carsComing.remove(i);//deleting cars 
				}
		}
		for(int i = 0; i< bonusesList.size(); i++){
			if (bonusesList.get(i).y>820) 
				{
					bonusesList.remove(i);//deleting bonuses 
				}
		}
		
	}

	private void carsGenerator() {//we generate new cars here
		Random rnd = new Random();
		int chance = rnd.nextInt(100);
		if (chance < 2) {
			int startPosition = rnd.nextInt(370)+200;
			comingCar = new ComingCars(startPosition, 0);
			carsComing.add(comingCar);
		}

	}
	private void bonusGenerator() {//we generate new cars here
		Random rnd = new Random();
		int chance = rnd.nextInt(100);
		
		if (chance < 1) {
			int startPosition = rnd.nextInt(370)+200;
			comingBonus = new Bonuses(startPosition, 0);
			bonusesList.add(comingBonus);
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
