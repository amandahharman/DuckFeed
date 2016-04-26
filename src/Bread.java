import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Bread {
	
	private int x,y;
	
	public Bread(int x, int y){
		
		this.x = x;
		this.y = y;
		
	}
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		Rectangle slice = new Rectangle(x, y, 5, 40);
		
		g2.setColor(Color.YELLOW);
		g2.fill(slice);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
