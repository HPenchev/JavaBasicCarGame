import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class GameFrame extends JPanel implements ActionListener {
	
	Timer mainTimer;
	Car car;
	
	
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


	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		car.update();
		repaint(); //function from JPanel, repainting the window
		
	}
	
	
}
