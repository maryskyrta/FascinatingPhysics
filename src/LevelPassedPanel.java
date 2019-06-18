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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelPassedPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LevelPassedPanel() {
		setBackground(new Color(0, 0, 0));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Вітаємо, " + Game.name + "! Ви успішно вивчили тему");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 26));
		lblNewLabel.setForeground(new Color(255, 153, 51));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(Game.topics[Game.currentTopic].getName());
		lblNewLabel_1.setFont(new Font("Monospaced", Font.PLAIN, 26));
		lblNewLabel_1.setForeground(new Color(255, 153, 51));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		JButton button = new JButton("До наступної теми");
		button.setToolTipText("Перейти до наступної теми");
		button.setBackground(new Color(255, 153, 51));
		button.setForeground(new Color(255, 255, 255));
		button.setFocusable(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setBorderPainted(false);
		button.setFont(new Font("Monospaced", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.passedTopics[Game.currentTopic] = true;
				Game.currentTopic++;
				if (Game.currentTopic == 1)
					Game.topics[Game.currentTopic].setImagePath("static/circles.jpg");
				else if (Game.currentTopic == 2)
					Game.topics[Game.currentTopic].setImagePath("static/fluct.png");
				else
					Game.currentTopic = 0;
				Game.getInstance().changePanel(new TopicsViewPanel());
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(new Color(255, 128, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(new Color(255, 153, 51));
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 0;
		gbc_button.gridy = 2;
		add(button, gbc_button);

	}

}
