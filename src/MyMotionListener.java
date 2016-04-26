import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Specifies actions based on mouse movements
 * @author amandaharman
 *
 */
public class MyMotionListener implements MouseMotionListener {

	protected Controller c;

	/**
	 * constructor
	 * @param c controller class
	 */
	public MyMotionListener(Controller c){
		this.c = c;


	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	/**
	 * Sets scope to mouse location
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		c.setScope(e.getX(), e.getY());
		System.out.println("X = " + e.getX() + "     Y = " + e.getY());

	}

}
