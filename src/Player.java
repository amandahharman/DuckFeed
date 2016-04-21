import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Player extends JPanel{
	private Bread bread;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int score;
	private final int WIDTH = 600, HEIGHT = 100;

	public Player(){

		this.setBackground(new Color(50,205,50));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(true);
		bread = new Bread();
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.drawString("Score:" + Integer.toString(getScore()), 5, 30);
		bread.draw(g);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
