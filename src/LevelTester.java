import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelTester extends JFrame {

		public static String name;
		public static TheoryPanel theoryPanel;
		private boolean soundEnabled = true;
		private static JFrame frame;
		private static BufferedImage logoImage;
		private static JPanel panel;
		private static Game game = null;
		// Game topics
		public static Topic[] topics = { new MechanicMovementTopic("Механічний рух", "static/mechanics.png"),
				new CircleMovementTopic("Рух по колу", "static/lock.png"),
				new FluctuationsMovementTopic("Коливальний рух", "static/lock.png") };
		// Paths to theory images
		public static String[] theoryPaths = { "static/mechmovtheory.png" };
		public static int currentTopic = 0;

		/**
		 * Game constructor
		 */
		private LevelTester() {
			frame = this;
			frame.setBounds(100, 100, 750, 600);
			frame.setResizable(true);
			frame.setTitle("Fascinating Physics");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			try {
				logoImage = ImageIO.read(new File("static/phlogo.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			frame.setIconImage(logoImage);
			// panel = new StartPanel())
			MechanicMovementTopic.levelUp();
			int currentInputTask = 4;
			panel = new Level(MechanicMovementTopic.inputAnswerTasks[currentInputTask], MechanicMovementTopic.levelImages[currentInputTask],
					MechanicMovementTopic.rightAnswers[currentInputTask]);
			frame.add(panel);

		}


		/**
		 * Change panel to the new one
		 * 
		 * @param newPanel
		 */
		public static void changePanel(JPanel newPanel) {
			frame.remove(panel);
			panel = newPanel;
			panel.setVisible(true);
			frame.add(panel);
			frame.setVisible(true);
		}
		
		public static void visible() {
			frame.setVisible(true);
		}
	public static void main(String[] args) {
		LevelTester lt = new LevelTester();
		lt.setVisible(true);
	}

}
