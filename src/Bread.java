import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Bread {
	
	public Bread(){
		
	}
	public void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		Rectangle slice = new Rectangle(500, 10, 5, 40);
		
		g2.setColor(Color.YELLOW);
		g2.fill(slice);
	}
}
