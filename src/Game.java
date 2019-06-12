import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Masha. Class that starts the game
 *
 */
public class Game extends JFrame implements MouseListener {

	private boolean soundEnabled = true;
	private JFrame frame;
	private static BufferedImage logoImage;
	private JPanel panel;
	private static Game game = null;
	public static Topic[] topics = { new MechanicMovementTopic("Механічний рух", "static/mechanics.png"),
			new CircleMovementTopic("Рух по колу", "static/lock.png") };
	public static int currentTopic = 0;

	/**
	 * Game constructor
	 */
	private Game() {
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
		panel = new StartPanel();
		frame.add(panel);

	}

	/**
	 * 
	 * @return instance of a main frame
	 */
	public static Game getInstance() {
		if (game == null)
			game = new Game();
		return game;
	}

	/**
	 * Change panel to the new one
	 * 
	 * @param newPanel
	 */
	public void changePanel(JPanel newPanel) {
		frame.remove(panel);
		panel = newPanel;
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	public void visible() {
		frame.setVisible(true);
	}

	public void setSoundMode(boolean sound) {
		soundEnabled = sound;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
