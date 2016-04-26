import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Controller{
	
	protected Viewer v;
	private int timeDelay = 4;
	private Duck[] duck = new Duck[1];
	private final int SCREENWIDTH = 800, SCREENHEIGHT = 800;
	private int xDirection = 1; //Right if positive, Left if negative
	private int yDirection = 1;// Down if positive, Up if negative
	private int x, y;
	private final int FLOOR = 300;
	private Scope scope;

	
	public Controller(Viewer v){
		
		this.v = v;
		for (int i = 0; i < duck.length; i++){
			duck[i] = new Duck((new Random()).nextInt(500), (new Random()).nextInt(FLOOR), Color.RED);
		}
		setScope(0,0);
	
	}

	public void paintModels(Graphics g) {
		for (int i = 0; i < duck.length; i++){
			duck[i].draw(g, v);
		}
		scope.draw(g);
	}

	public void moveDucks(){
		for (int i = 0; i < duck.length; i++){
			x = duck[i].getX();
			y = duck[i].getY();

			//Setting bounds
			if (y + yDirection + duck[i].getDiameter() >= FLOOR){
				yDirection = -1;
			}
			if (y <=0 && yDirection < 0){
				yDirection = 1;
			}
			if (x <= 1 && xDirection < 0){
				xDirection = 1;
			}
			if (x + xDirection + duck[i].getDiameter() >= SCREENWIDTH){
				xDirection = -1;

			}


			if (x + xDirection + duck[i].getDiameter() < SCREENWIDTH && xDirection > 0){
				duck[i].setX(x+xDirection);
				duck[i].setY(y+ yDirection);
				duck[i].duckMovesRight();
			}
			
			if  (x + xDirection  < SCREENWIDTH && xDirection < 0 && x>0){
				duck[i].setX(x + xDirection);
				duck[i].setY(y+ yDirection);
				duck[i].duckMovesLeft();
			}
		}
	}
	
	
	public Boolean duckHit(int eventX, int eventY){
		for (int i = 0; i < duck.length; i++){
			if ((eventX > duck[i].getX() && eventX < duck[i].getRightX())&& (eventY > duck[i].getY() && eventY < duck[i].getBottomY())){
				return true;
			}
		}
		return false;
		
	}
	
	public void setScope(int x, int y){
		scope = new Scope(x,y);
	}
	
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
