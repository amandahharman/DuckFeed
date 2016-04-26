import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Specifies actions for mouse events
 * @author amandaharman
 *
 */
public class MyMouseActionListener implements MouseListener {
	
	protected Controller c;
	protected Player p;

	/**
	 * Constructor
	 * @param c Controller class
	 * @param p Player class
	 */
	public MyMouseActionListener(Controller c, Player p){
		
		this.c = c;
		this.p = p;
	}

	/**
	 * Awards points if duck is clicked on, decreases bread on every click
	 */
	public void mouseClicked(MouseEvent e) {
		if (p.getCounter() > 0){
		if(c.duckHit(e.getX(), e.getY())){
			p.awardPoints();
		}
		p.decreaseBread();
		}
		p.mouseClicked();

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
