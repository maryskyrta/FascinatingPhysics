import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartPanel extends JPanel {

	public StartPanel() {
		// Go to game playing panel
		JButton startGame = new JButton("Почати гру");
		startGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.getInstance().changePanel(new TopicsViewPanel());

			}
		});

		// JButton userInfo = new JButton("");
		JButton settings = new JButton("Налаштування");
		settings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().changePanel(new SettingsPanel());

			}
		});
		JButton exit = new JButton("Вийти");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(StartPanel.this, "Are you sure you want to exit the game?",
						"Exit", JOptionPane.OK_CANCEL_OPTION);
				if (choice == JOptionPane.OK_OPTION)
					Game.getInstance().dispatchEvent(new WindowEvent(Game.getInstance(), WindowEvent.WINDOW_CLOSING));
			}
		});
		this.add(startGame);
		this.add(settings);
		this.add(exit);

	}

}
