import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class Duck {
	
	private int xLeft;
	private int yTop;
	private int xRight;
	private int yBottom;
	private static final int DIAMETER = 80;
	private static final int HEIGHT = 70;
	private ImageIcon duckImage;
	
	
	public Duck(int x, int y, Color color){
		
		xLeft = x;
		yTop = y;	
		duckImage =  new ImageIcon("duckFlipped.png");
	}

	public void draw(Graphics g, Viewer v)
	{
		duckImage.paintIcon(v, g, xLeft, yTop);
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
	
	public int getRightX(){
		xRight = Math.abs(xLeft + DIAMETER);
		return xRight;
	}
	
	public int getBottomY(){
		yBottom = Math.abs(yTop + HEIGHT);
		return yBottom;
	}
		
	public int getDiameter(){
		return DIAMETER;
	}
	
	public int getHeight(){
		return HEIGHT;
	}
	
	public void duckMovesRight(){
		duckImage = new ImageIcon("duckFlipped.png");
	}
	public void duckMovesLeft(){
		duckImage = new ImageIcon("duck .png");
	}
}
