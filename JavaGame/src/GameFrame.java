import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameFrame extends JPanel implements ActionListener {
	
	Timer mainTimer;
	
	
	public GameFrame() {
		setFocusable(true);
		mainTimer = new Timer(10 , this); 
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString("This is the gameGG", 150, 100);
		ImageIcon icon = new ImageIcon("ShipImg");
		Image img = icon.getImage();
		g2d.drawImage(img, 500, 200, null);


	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint(); //function from JPanel, repainting the window
		
	}
	
	
}
