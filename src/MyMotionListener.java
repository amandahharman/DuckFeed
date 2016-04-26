import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyMotionListener implements MouseMotionListener {
	
	protected Player p;
	protected Controller c;

	
	public MyMotionListener(Controller c, Player p){
		this.c = c;
		this.p = p;

	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		c.setScope(e.getX(), e.getY());
		System.out.println("X = " + e.getX() + "     Y = " + e.getY());

	}

}
