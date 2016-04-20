import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Duck {
	private int xLeft;
	private int yTop;
	private Color duckColor;
	private static final int DIAMETER = 20;

	
	/**
	 * Constructs a ring.
	 * @param x , the x-coordinate for the top-left corner of the Ellipse object
	 * @param y , the y-coordinate for the top-left corner of the Ellipse object
	 * @param color , the color for the circle to be drawn in
	 */
	public Duck(int x, int y, Color color)
	{
		xLeft = x;
		yTop = y;	
		duckColor = color;
	}
	/**
	 * Draws the ring
	 * @param g2 , the graphics context
	 */
	public void draw(Graphics g)
	{
//		Ellipse2D.Double duck = new Ellipse2D.Double(xLeft, yTop, DIAMETER, DIAMETER);
		
		g.setColor(duckColor);
		g.fillOval(xLeft, yTop, DIAMETER, DIAMETER);


	}
	public int getX() {
		return xLeft;
	}
	
	public int getY() {
		return yTop;
	}
	
	public void setX(int x){
		xLeft = x;
	}

	public void setY(int y){
		yTop= y;
	}
	
	public int getDiameter(){
		return DIAMETER;
	}

}
