import java.awt.Color;

import javax.swing.JFrame;

public class Mine {

	public static void main(String[] args) {
		JFrame frame = new JFrame("This is our game"); // msg in the upper left
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close the
		
		// application
		GameFrame gf = new GameFrame();
		frame.add(gf);
		// corner
		int boardWidth = 800;
		int boardHeight = 600;
		frame.setSize(boardWidth, boardHeight);
		frame.setTitle("Cars");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setEnabled(true);
	}

}
