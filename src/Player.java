import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Player extends JPanel{
	
	private ArrayList<Bread> bread = new ArrayList<Bread>();
	private final int WIDTH = 600, HEIGHT = 100;
	private int x = WIDTH - 100;
	private int y = HEIGHT - 90;
	private int counter = 10;
	private static final long serialVersionUID = 1L;
	private int score;
	private Boolean gameOver = false;


	public Player(){

		this.setBackground(new Color(50,205,50));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(true);

		for (int i = 0; i < 10 ;i++){
			x += 8;
			bread.add(new Bread(x,y));
				}

	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.drawString("Score:" + Integer.toString(getScore()), 5, 30);
		g.drawString("Bread Left:", bread.get(0).getX() - 80, 30);

		for (int i = 0; i < counter; i++){
			bread.get(i).draw(g);
		}

	}
	
	public int getScore() {
		return score;
	}
	
	public void awardPoints() {
		this.score += 10;
	}
	
	public void decreaseBread(){
		counter -= 1;
	}
	
	public void mouseClicked(){
		System.out.println("Clicked");
	}
	
	public void gameStatus(){
		if (counter == 0){
			gameOver = true;
		}
	}
	
	public Boolean getGameOver(){
		return gameOver;
	}
}
