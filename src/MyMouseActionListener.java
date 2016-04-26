import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseActionListener implements MouseListener {
	
	protected Controller c;
	protected Player p;

	public MyMouseActionListener(Controller c, Player p){
		
		this.c = c;
		this.p = p;
	}

	public void mouseClicked(MouseEvent e) {
		if(c.duckHit(e.getX(), e.getY())){
			p.awardPoints();
		}
		p.decreaseBread();
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
