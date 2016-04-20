import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import java.awt.geom.Ellipse2D;

public class Scope{
	private Point point;
	private static final int RADIUS = 15;
	private static final int DIAMETER = 2*RADIUS;
	private static final Color scopeColor = Color.red;


	
	public Scope(Point point){
		this.point = point;
	}
		
	public void draw(Graphics g){
		
		new Ellipse2D.Double (point.getX() - RADIUS, point.getY() - RADIUS, DIAMETER, DIAMETER);
	}
	}
