import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * Creates duck object
 * @author amandaharman
 *
 */
public class Duck {
	
	private int xLeft;
	private int yTop;
	private int xRight;
	private int yBottom;
	private static final int DIAMETER = 80;
	private static final int HEIGHT = 70;
	private ImageIcon duckImage;
	private int xDirection; //Right if positive, Left if negative
	private int yDirection; // Down if positive, Up if negative
	
	/**
	 * Constructs duck object 
	 * @param x left x-coord
	 * @param y top y-coord
	 * 
	 */
	public Duck(int x, int y){
		
		xLeft = x;
		yTop = y;	
		duckImage =  new ImageIcon("duckFlipped.png");
		xDirection = 1;
		yDirection = 1;
	}

	/**
	 * Ducks draw method
	 * @param g Graphics
	 * @param v Viewer class
	 */
	public void draw(Graphics g, Viewer v)
	{
		duckImage.paintIcon(v, g, xLeft, yTop);
	}
	
	/**
	 * 
	 * @return current left x-coord
	 */
	public int getX() {
		return xLeft;
	}
	
	/**
	 * @return current to y-coord
	 */
	public int getY() {
		return yTop;
	}
	
	/**
	 * @param x set left x-coord
	 */
	public void setX(int x){
		xLeft = x;
	}

	/**
	 * @param y set top y-coord
	 */
	public void setY(int y){
		yTop= y;
	}
	
	/**
	 * @return right x-coord
	 */
	public int getRightX(){
		xRight = Math.abs(xLeft + DIAMETER);
		return xRight;
	}
	
	/**
	 * 
	 * @return bottom y-coord
	 */
	public int getBottomY(){
		yBottom = Math.abs(yTop + HEIGHT);
		return yBottom;
	}
	
	/**
	 * @return diameter of duck
	 */
	public int getDiameter(){
		return DIAMETER;
	}
	
	/**
	 * @return height of duck
	 */
	public int getHeight(){
		return HEIGHT;
	}
	
	/**
	 * sets duck image as moving right
	 */
	public void duckMovesRight(){
		duckImage = new ImageIcon("duckFlipped.png");
	}

	/**
	 * sets duck image as moving left
	 */
	public void duckMovesLeft(){
		duckImage = new ImageIcon("duck .png");
	}
	
	public void setXDirection(int x) {
		xDirection = x;
		
	}
	
	public void setYDirection(int y) {
		yDirection = y;
		
	}
	
	public int getXDirection(){
		return xDirection;
	}
	public int getYDirection(){
		return yDirection;
	}


	
}
