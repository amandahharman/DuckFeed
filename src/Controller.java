import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Controlls the main game panel
 * @author amandaharman
 *
 */
public class Controller{
	
	protected Viewer v;
	private int timeDelay = 4;
	private Duck[] duck = new Duck[4];
	private final int SCREENWIDTH = 800, SCREENHEIGHT = 800;
	private final int FLOOR = 300;
	private Scope scope;


	/**
	 * Constructor for controller. Creates ducks and sets scope.
	 * @param v Viewer class
	 */
	public Controller(Viewer v){
		
		this.v = v;
		for (int i = 0; i < duck.length; i++){
			duck[i] = new Duck((new Random()).nextInt(500), (new Random()).nextInt(FLOOR));
		}
		setScope(0,0);
	
	}

	/**
	 * Calls draw methods of objects to be put on main game panel.
	 * @param g Graphics object
	 */
	public void paintModels(Graphics g) {
		for (int i = 0; i < duck.length; i++){
			duck[i].draw(g, v);
		}
		scope.draw(g);
	}

	/**
	 * Moves ducks
	 */
	public void moveDucks(){
		for (int i = 0; i < duck.length; i++){

			//Setting bounds
			if (duck[i].getY() + duck[i].getYDirection() + duck[i].getDiameter() >= FLOOR){
				duck[i].setYDirection(-1);
			}
			if (duck[i].getY() <=0 && duck[i].getYDirection() < 0){
				duck[i].setYDirection(1);
			}
			if (duck[i].getX() <= 1 && duck[i].getXDirection() < 0){
				duck[i].setXDirection(1);
			}
			if (duck[i].getX() + duck[i].getXDirection() + duck[i].getDiameter() >= SCREENWIDTH){
				duck[i].setXDirection(-1);

			}


			if (duck[i].getX() + duck[i].getXDirection() + duck[i].getDiameter() < SCREENWIDTH && duck[i].getXDirection() > 0){
				duck[i].setX(duck[i].getX() + duck[i].getXDirection());
				duck[i].setY(duck[i].getY()+ duck[i].getYDirection());
				duck[i].duckMovesRight();
			}
			
			if  (duck[i].getX() + duck[i].getXDirection()  < SCREENWIDTH && duck[i].getXDirection() < 0 && duck[i].getX() >0){
				duck[i].setX(duck[i].getX() + duck[i].getXDirection());
				duck[i].setY(duck[i].getY()+ duck[i].getYDirection());
				duck[i].duckMovesLeft();
			}
		}
	}
	
	/**
	 * Returns boolean on whether the duck is hit or not.
	 * 
	 * @param eventX clicked x-coord
	 * @param eventY clicked y-coord
	 * @return true or false
	 */
	public Boolean duckHit(int eventX, int eventY){
		for (int i = 0; i < duck.length; i++){
			if ((eventX > duck[i].getX() && eventX < duck[i].getRightX())&& (eventY > duck[i].getY() && eventY < duck[i].getBottomY())){
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Sets scope to given integers
	 * @param x x-coord
	 * @param y y-coord
	 */
	public void setScope(int x, int y){
		scope = new Scope(x,y);
	}
	
	/**
	 * Calls repaint after specified delay
	 */
	public void rollFrames() {
		try {
			Thread.sleep(timeDelay);
			moveDucks();
			v.repaint();
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
	}
}
