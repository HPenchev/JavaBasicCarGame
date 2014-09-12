import javax.swing.*;
import java.awt.*;

public class JavaGameMineClass {

	public static void main(String[] args) {

		JFrame frame = new JFrame("This is our game"); // msg in the upper left corner
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(new GameFrame());
		frame.setVisible(true);
			}

}
