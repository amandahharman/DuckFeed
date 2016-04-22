import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyMotionListener implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("X = " + e.getX() + "     Y = " + e.getY());

	}

}
