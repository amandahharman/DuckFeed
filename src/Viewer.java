import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Viewer extends JFrame{

	/**
	 * 
	 */
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

		ViewPanel panel = new ViewPanel();
		Player player = new Player();
		getContentPane().setLayout(new BorderLayout());  
		getContentPane().add("Center", panel);
		getContentPane().add("South", player);

		controller = new Controller(this);

		
		pack();
	    setVisible(true);
		
	}

	private class ViewPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8651888917167259520L;

		public ViewPanel() {
			setPreferredSize(new Dimension(600, 600));
			setBackground(new Color(64, 224,208));
			setFocusable(true);

	
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			controller.paintModels(g);
			controller.rollFrames();
		}

	}
	}

	
	

