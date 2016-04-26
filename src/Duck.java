import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class Duck {
	
	private int xLeft;
	private int yTop;
	private static final int DIAMETER = 80;
	private static final int HEIGHT = 100;
	private ImageIcon duckImage;
	
	
	public Duck(int x, int y, Color color){
		
		xLeft = x;
		yTop = y;	
		duckImage =  new ImageIcon("duck .png");
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
	
	public int getDiameter(){
		return DIAMETER;
	}
	
	public int getHeight(){
		return HEIGHT;
	}
}
