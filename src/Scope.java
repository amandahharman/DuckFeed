import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Ellipse2D;

public class Scope{
	private int x,y;
	private static final int RADIUS = 15;
	private static final int DIAMETER = 2*RADIUS;
	
	public Scope(int x, int y){
		
		this.x = x;
		this.y = y;
	}
		
	public void draw(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		Ellipse2D.Double scope = new Ellipse2D.Double (x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);
		g2.draw(scope);
	}
	

	
	}
