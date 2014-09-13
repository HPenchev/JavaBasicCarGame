import javax.swing.*;
import java.awt.*;

public class Mine {

	public static void main(String[] args) {

		JFrame frame = new JFrame("This is our game"); // msg in the upper left corner

		
		int boardWidth = 800;
		int boardHeight = 600;
		frame.setSize(boardWidth, boardHeight);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close the application 
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(new GameFrame());
	}

}
