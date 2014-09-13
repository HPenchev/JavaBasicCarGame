import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PressedKeys extends KeyAdapter {

	Car p;
	
	public PressedKeys(Car car){
		p = car;
	}
	
	public void keyPressed(KeyEvent key){
		p.keyPressed(key);
	}
	
	public void keyReleased(KeyEvent key){
		p.keyReleased(key);
	}
	
}
