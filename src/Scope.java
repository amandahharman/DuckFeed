import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Ellipse2D;

/**
 * Creates scope object
 * @author amandaharman
 *
 */
public class Scope{
	private int x,y;
	private static final int RADIUS = 15;
	private static final int DIAMETER = 2*RADIUS;
	
	/**
	 * Constructor
	 * @param x x-coord
	 * @param y y-coord
	 */
	public Scope(int x, int y){
		
		this.x = x;
		this.y = y;
	}
		
	/**
	 * Scope draw method
	 * @param g Graphics
	 */
	public void draw(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		Ellipse2D.Double scope = new Ellipse2D.Double (x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);
		g2.draw(scope);
	}
	

	
	}
