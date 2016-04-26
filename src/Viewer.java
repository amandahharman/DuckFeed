import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Viewer extends JFrame{

	private static final long serialVersionUID = 1L;
	protected Controller controller;
	protected Player player;



	public static void main(String[] args) {
		new Viewer();

	}

	public Viewer(){
		
		super("My Duck Feed");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(600, 600));
		
		player = new Player();
		controller = new Controller(this);

		ViewPanel panel = new ViewPanel();

		
		getContentPane().setLayout(new BorderLayout());  
		getContentPane().add("Center", panel);
		getContentPane().add("South", player);

		pack();
		setVisible(true);
	}

	private class ViewPanel extends JPanel {
		
		private static final long serialVersionUID = 8651888917167259520L;
		private ImageIcon cloud;
		private ImageIcon sun;

		public ViewPanel() {
			setPreferredSize(new Dimension(600, 600));
			setBackground(new Color(64, 224,208));
			setFocusable(true);
			addMouseMotionListener(new MyMotionListener(controller, player));
			addMouseListener(new MyMouseActionListener(controller, player));

		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			cloud = new ImageIcon("cloud 3.png");
			sun = new ImageIcon("sun.png");
			cloud.paintIcon(this, g, 30,30);
			sun.paintIcon(this, g, 400, 40);
			
			controller.paintModels(g);
//			if (player.getGameOver()){
//				g.drawString("GAME OVER", 300, 300 );
//				g.drawString("SCORE: " + player.getScore(), 400, 300);
//			}

			controller.rollFrames();
		}
	}
}

	
	

