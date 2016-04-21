import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class Controller{
	private Viewer v;
	private int frameRate = 72; // frames per second
	private int timeDelay = 300 / frameRate;//  milliseconds per frame
	private Duck[] duck = new Duck[1];
//	private Duck duck2;
	private final int SCREENWIDTH = 600, SCREENHEIGHT = 600;
	private int xDirection = 1; //Right if positive, Left if negative
	private int yDirection = 1;// Down if positive, Up if negative
	private int x, y;
	private final int FLOOR = 300;


	

	public Controller(Viewer v){
		this.v = v;
		for (int i = 0; i < duck.length; i++){
			duck[i] = new Duck((new Random()).nextInt(500), (new Random()).nextInt(FLOOR), Color.RED);
		}

		
		rollFrames();
	}
	
	public void paintModels(Graphics g) {
		for (int i = 0; i < duck.length; i++){
		duck[i].draw(g, v);}



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

		
		if (x + xDirection + duck[i].getDiameter() < SCREENWIDTH && xDirection > 0 && Math.random() >.5){
			duck[i].setX(x+xDirection);
			duck[i].setY(y+ yDirection);

			}
		if (x + xDirection + duck[i].getDiameter() < SCREENWIDTH && xDirection > 0 && Math.random() <=.5){
			duck[i].setX(x+xDirection);
			duck[i].setY(y+ yDirection);}
		

		if  (x + xDirection  < SCREENWIDTH && xDirection < 0 && x>0 && Math.random() >.5){
			duck[i].setX(x + xDirection);
			duck[i].setY(y+ yDirection);
		}
		if  (x + xDirection  < SCREENWIDTH && xDirection < 0 && x>0 && Math.random() <=.5){
			duck[i].setX(x + xDirection);
			duck[i].setY(y + yDirection);
		}

			
	}}
	
	public int getRandom(int[] rand){
		return rand[(new Random()).nextInt(rand.length)];
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
