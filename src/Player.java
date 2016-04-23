import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Player extends JPanel{
	private Bread[] bread = new Bread[10];
	private final int WIDTH = 600, HEIGHT = 100;
	private int x = WIDTH - 100;
	private int y = HEIGHT - 90;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int score;

	public Player(){

		this.setBackground(new Color(50,205,50));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(true);
		for (int i = 0; i < bread.length; i++){
			x += 8;
			bread[i] = new Bread(x, y);}
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.drawString("Score:" + Integer.toString(getScore()), 5, 30);
		g.drawString("Bread Left:", bread[0].getX() - 80, 30);
		for (int i = 0; i < bread.length; i++){
			bread[i].draw(g);
		}
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
