import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author Masha. Game start panel.
 *
 */
public class StartPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		this.setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		JButton startGame = new JButton("Почати гру");
		startGame.setFont(new Font("Monospaced", Font.PLAIN, 22));
		startGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				startGame.setBackground(new Color(46, 184, 46));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startGame.setBackground(new Color(51, 204, 51));
			}
		});
		startGame.setFocusable(false);
		startGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startGame.setBorderPainted(false);
		startGame.setToolTipText("Натисніть щоб почати вивчати фізику");
		startGame.setBackground(new Color(51, 204, 51));
		startGame.setForeground(Color.WHITE);
		startGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.getInstance().changePanel(new TopicsViewPanel());

			}
		});

		JLabel lblFascinatinphysics = new JLabel("Fascinating Physics");
		lblFascinatinphysics.setForeground(new Color(255, 255, 255));
		lblFascinatinphysics.setFont(new Font("Monospaced", Font.PLAIN, 34));
		GridBagConstraints gbc_lblFascinatinphysics = new GridBagConstraints();
		gbc_lblFascinatinphysics.insets = new Insets(10, 10, 10, 10);
		gbc_lblFascinatinphysics.gridx = 0;
		gbc_lblFascinatinphysics.gridy = 0;
		add(lblFascinatinphysics, gbc_lblFascinatinphysics);

		GridBagConstraints gbc_startGame = new GridBagConstraints();
		gbc_startGame.anchor = GridBagConstraints.CENTER;
		gbc_startGame.insets = new Insets(10, 10, 10, 10);
		gbc_startGame.gridx = 0;
		gbc_startGame.gridy = 1;

		this.add(startGame, gbc_startGame);

		// JButton userInfo = new JButton("");
		JButton settings = new JButton("Налаштування");
		settings.setFont(new Font("Monospaced", Font.PLAIN, 22));
		settings.setFocusable(false);
		settings.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settings.setBorderPainted(false);
		settings.setToolTipText("Натисніть щоб перейти до налаштувань");
		settings.setBackground(new Color(255, 153, 0));
		settings.setForeground(Color.WHITE);
		settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				settings.setBackground(new Color(230, 138, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				settings.setBackground(new Color(255, 153, 0));
			}
		});
		settings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().changePanel(new SettingsPanel());

			}
		});
		GridBagConstraints gbc_settings = new GridBagConstraints();
		gbc_settings.anchor = GridBagConstraints.CENTER;
		gbc_settings.insets = new Insets(10, 10, 10, 10);
		gbc_settings.gridx = 0;
		gbc_settings.gridy = 2;
		this.add(settings, gbc_settings);
		JButton exit = new JButton("Вийти");
		exit.setFont(new Font("Monospaced", Font.PLAIN, 22));
		exit.setFocusable(false);
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exit.setBorderPainted(false);
		exit.setToolTipText("Натисніть щоб вийти з застосунку");
		exit.setBackground(new Color(255, 0, 0));
		exit.setForeground(Color.WHITE);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				exit.setBackground(new Color(230, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exit.setBackground(new Color(255, 0, 0));
			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(StartPanel.this, "Are you sure you want to exit the game?",
						"Exit", JOptionPane.OK_CANCEL_OPTION);
				if (choice == JOptionPane.OK_OPTION)
					Game.getInstance().dispatchEvent(new WindowEvent(Game.getInstance(), WindowEvent.WINDOW_CLOSING));
			}
		});
		GridBagConstraints gbc_exit = new GridBagConstraints();
		gbc_exit.anchor = GridBagConstraints.CENTER;
		gbc_exit.gridx = 0;
		gbc_exit.gridy = 3;
		gbc_exit.insets = new Insets(10, 10, 10, 10);
		this.add(exit, gbc_exit);
	}

}
