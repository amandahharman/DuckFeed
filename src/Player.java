import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Creates the player panel. 
 * @author amandaharman
 *
 */
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
	protected AudioClip clapping;
	protected AudioClip breadThrown;

	/**
	 * Sets up player panel.
	 */
	public Player(){

		this.setBackground(new Color(50,205,50));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(true);

		for (int i = 0; i < 10 ;i++){
			x += 8;
			bread.add(new Bread(x,y));
				}
		this.clapping = getAudioClip("0814.wav");
		this.breadThrown = getAudioClip("0735.wav");


	}
	
	/**
	 * Draws the necessary strings and objects for player panel. Prints summary when game is over
	 */
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
			gameOver = true;
			summary(g);
		}
		
		
	}
	
	/**
	 * @return score 
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Awards points
	 */
	public void awardPoints() {
		this.score += 10;
	}
	
	/**
	 * Decreases bread
	 */
	public void decreaseBread(){
		counter -= 1;
		breadThrown.play();
	}
	
	/**
	 * Testing method. Prints to console that mouse has been clicked
	 */
	public void mouseClicked(){
		System.out.println("Clicked");
	}

	
	/**
	 * 
	 * @return true when game is over
	 */
	public Boolean getGameOver(){
		return gameOver;
	}
	
	/**
	 * @return counter (the amount of bread left)
	 */
	public int getCounter(){
		return counter;
	}
	
	/**
	 * Draw instructions for end of game summary
	 * @param g
	 */
	public void summary(Graphics g){
		clapping.play();
		g.setColor(Color.RED);
		g.setFont(myFont);
		g.drawString("GAME OVER", 320, 40);
		g.drawString("SCORE:  " + score, 325, 60);
	}
	
	/**
	 * reads in audiofile from URL
	 * ***Borrowed from Jack Tompkins, UNCW professor****
	 * @param filename
	 * @return safe audioclip object
	 */
    public AudioClip getAudioClip(String filename) {
        URL url = null;
        try {
            File file = new File(filename);
            if (file.canRead()) url = file.toURI().toURL();
        }
        catch (MalformedURLException e) { e.printStackTrace(); }
        if (url == null) 
        	throw new RuntimeException("audio " + filename + " not found");
        return Applet.newAudioClip(url);
    }
}
