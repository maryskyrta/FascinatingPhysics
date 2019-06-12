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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TheoryPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TheoryPanel(String name, String imagePath) {
		setBackground(new Color(0, 0, 0));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 80, 640, 50 };
		gridBagLayout.rowHeights = new int[] { 60, 400, 60 };
		gridBagLayout.columnWeights = new double[] { Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { Double.MIN_VALUE, 0.0 };
		setLayout(gridBagLayout);
		JButton returnToTopics = new JButton("Назад");
		returnToTopics.setToolTipText("Назад до тем");
		returnToTopics.setBackground(new Color(0, 51, 153));
		returnToTopics.setForeground(new Color(255, 255, 255));
		returnToTopics.setFocusable(false);
		returnToTopics.setCursor(new Cursor(Cursor.HAND_CURSOR));
		returnToTopics.setBorderPainted(false);
		returnToTopics.setFont(new Font("Monospaced", returnToTopics.getFont().getStyle(), 14));
		returnToTopics.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().changePanel(new TopicsViewPanel());
			}
		});
		returnToTopics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				returnToTopics.setBackground(new Color(0, 43, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				returnToTopics.setBackground(new Color(0, 51, 153));
			}
		});
		GridBagConstraints gbc_returnToStart = new GridBagConstraints();
		gbc_returnToStart.insets = new Insets(5, 5, 5, 5);
		gbc_returnToStart.anchor = GridBagConstraints.NORTHWEST;
		gbc_returnToStart.gridx = 0;
		gbc_returnToStart.gridy = 0;
		this.add(returnToTopics, gbc_returnToStart);
		JLabel title = new JLabel(name);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Monospaced", Font.PLAIN, 34));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.anchor = GridBagConstraints.CENTER;
		gbc_title.insets = new Insets(0, 0, 5, 5);
		gbc_title.gridx = 1;
		gbc_title.gridy = 0;
		this.add(title, gbc_title);

		JLabel topicInfo = new JLabel("");
		topicInfo.setIcon(new ImageIcon(imagePath));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		gbc_label.anchor = GridBagConstraints.CENTER;
		gbc_label.fill = GridBagConstraints.BOTH;
		add(topicInfo, gbc_label);

		JButton button = new JButton("Перейти до практики");
		button.setToolTipText("Почати проходження рівнів");
		button.setBackground(new Color(255, 153, 51));
		button.setForeground(new Color(255, 255, 255));
		button.setFocusable(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setBorderPainted(false);
		button.setFont(new Font("Monospaced", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Game.currentTopic == 0)
					Game.getInstance().changePanel(MechanicMovementTopic.getNextPanel());
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
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 2;
		add(button, gbc_button);

	}

}
