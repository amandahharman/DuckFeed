import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Creates bread graphic
 * @author amandaharman
 *
 */
public class Bread {
	
	private int x,y;
	/**
	 * Constructor for bread object
	 * @param x x-coord
	 * @param y y-coord
	 */
	public Bread(int x, int y){
		
		this.x = x;
		this.y = y;
		
	}
	/**
	 * Draws bread object
	 * @param g Graphics object
	 */
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		Rectangle slice = new Rectangle(x, y, 5, 40);
		
		g2.setColor(Color.YELLOW);
		g2.fill(slice);
	}
	
	/**
	 *
	 * @return current x-coord
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * 
	 * @return current y-coord
	 */
	public int getY(){
		return y;
	}
}
