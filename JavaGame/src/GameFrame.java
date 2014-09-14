import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;
import java.util.Stack;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class GameFrame extends JPanel implements ActionListener {
	
	Timer mainTimer;
	Car car;
	ComingCars comingCar;

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
		

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		carsGenerator();
		for (int i = 0; i< carsComing.size(); i++) {
			carsComing.get(i).update();//we update each falling car 
		}
	    
		
		car.update();
		
		repaint(); //function from JPanel, repainting the window 
		for(int i = 0; i< carsComing.size(); i++){
			if (carsComing.get(i).y>820) carsComing.remove(i);//deleting cars 
		}
		
	}

	private void carsGenerator() {//we generate new cars here
		Random rnd = new Random();
		int chance = rnd.nextInt(100);
		if (chance < 2) {
			
		
		int startPosition = rnd.nextInt(601);
		

			comingCar = new ComingCars(startPosition, 0);

		
		carsComing.add(comingCar);
		}

	}

//	private boolean0 checkCollision(ComingCars comingCar2) {
//		for (ComingCars currentCar : carsComing) {
//			if (comingCar.getBounds().intersects(currentCar.getBounds())) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	
	
}
