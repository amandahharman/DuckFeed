import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Player extends JPanel{
	
	private ArrayList<Bread> bread = new ArrayList<Bread>();
	private final int WIDTH = 800, HEIGHT = 100;
	private int x = WIDTH - 100;
	private int y = HEIGHT - 90;
	private int counter = 10;
	private static final long serialVersionUID = 1L;
	private int score;
	private Boolean gameOver = false;
	private Font myFont;


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
		myFont = new Font("Ariel", Font.BOLD, 20);
		g.setFont(myFont);
		g.drawString("Score:  " + Integer.toString(getScore()), 5, 30);
		g.drawString("Bread:", bread.get(0).getX() - 80, 30);

		

		for (int i = 0; i < counter; i++){
			bread.get(i).draw(g);
		}
		if(counter <= 0){
			summary(g);
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

	
	public Boolean getGameOver(){
		return gameOver;
	}
	
	public int getCounter(){
		return counter;
	}
	
	public void summary(Graphics g){
		g.setColor(Color.RED);
		g.setFont(myFont);
		g.drawString("GAME OVER", 320, 40);
		g.drawString("SCORE:  " + score, 325, 60);
	}
}
