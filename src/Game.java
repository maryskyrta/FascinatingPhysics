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

	private JFrame frame;
	private static BufferedImage logoImage;
	private JPanel panel;

	/**
	 * Game constructor
	 */
	public Game() {
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

	public static void main(String[] args) {
		Game game = new Game();
		game.setVisible(true);
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
