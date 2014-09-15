import javax.swing.*;

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
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setEnabled(true);

	}

}
