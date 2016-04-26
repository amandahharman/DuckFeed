import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main set up for game. Feed the ducks! Don't waste bread!
 * All audio clips are from http://www.bigsoundbank.com 
 * @author amandaharman
 *
 */
public class Viewer extends JFrame{

	private static final long serialVersionUID = 1L;
	protected Controller controller;
	protected Player player;
	protected AudioClip begin;

	/**
	 * Starts game
	 * @param args
	 */
	public static void main(String[] args) {
		new Viewer();

	}

	/**
	 * Constructor. Sets up frame. Instantiates player, controller, panels
	 */
	public Viewer(){
		
		super("My Duck Feed");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 800));

	
		player = new Player();
		controller = new Controller(this);
		this.begin = player.getAudioClip("duckBegin.wav");
		begin.play();
		ViewPanel panel = new ViewPanel();

		
		getContentPane().setLayout(new BorderLayout());  
		getContentPane().add("Center", panel);
		getContentPane().add("South", player);

		pack();
		setVisible(true);
	}

	/**
	 * Sets up main panel
	 * @author amandaharman
	 *
	 */
	private class ViewPanel extends JPanel {
		
		private static final long serialVersionUID = 8651888917167259520L;

		private ImageIcon sun;
		private ImageIcon tree;

		/**
		 * Constructor. Basic set up of panel. Adds mouse listeners
		 */
		public ViewPanel() {
			setPreferredSize(new Dimension(800, 800));
			setBackground(new Color(64, 224,208));
			setFocusable(true);
			addMouseMotionListener(new MyMotionListener(controller));
			addMouseListener(new MyMouseActionListener(controller, player));
			

		}

		/**
		 * paints background and models. Starts the frames rolling once set up is done.
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			sun = new ImageIcon("sunny.png");
			tree = new ImageIcon("tree.png");

			sun.paintIcon(this, g, 530, 40);
			tree.paintIcon(this, g, 30, 200);
			
			
			controller.paintModels(g);

			if (player.getGameOver() == false){
		
			controller.rollFrames();}
		}
	}
}

	
	

