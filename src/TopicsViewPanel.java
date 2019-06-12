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
import javax.swing.SwingConstants;

public class TopicsViewPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TopicsViewPanel() {
		setBackground(new Color(0, 0, 0));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 540, 100 };
		gridBagLayout.rowHeights = new int[] { 60, 460, 70 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		setLayout(gridBagLayout);
		JButton prevTopic = new JButton();
		prevTopic.setToolTipText("До попередньої теми");
		prevTopic.setFont(new Font("Monospaced", Font.BOLD, 50));
		prevTopic.setText("<");
		prevTopic.setBackground(new Color(0, 0, 0));
		prevTopic.setForeground(new Color(204, 0, 255));
		prevTopic.setFocusable(false);
		prevTopic.setCursor(new Cursor(Cursor.HAND_CURSOR));
		prevTopic.setBorderPainted(false);
		if (Game.currentTopic == 0)
			prevTopic.setVisible(false);
		prevTopic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				prevTopic.setForeground(new Color(143, 0, 179));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				prevTopic.setForeground(new Color(204, 0, 255));
			}
		});
		prevTopic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.currentTopic--;
				Game.getInstance().changePanel(new TopicsViewPanel());

			}
		});

		GridBagConstraints gbc_prevTopic = new GridBagConstraints();
		gbc_prevTopic.anchor = GridBagConstraints.WEST;
		gbc_prevTopic.insets = new Insets(0, 0, 5, 5);
		gbc_prevTopic.gridx = 0;
		gbc_prevTopic.gridy = 1;
		this.add(prevTopic, gbc_prevTopic);

		JPanel chooseTopicPanel = new TopicPreviewPanel(Game.topics[Game.currentTopic]);
		chooseTopicPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chooseTopicPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Game.getInstance().changePanel(chooseTopicPanel));
				Game.getInstance().changePanel(new TheoryPanel());
				// Game.getInstance().changePanel(new Level());
			}
		});
		GridBagConstraints gbc_ChooseTopicPanel = new GridBagConstraints();
		gbc_ChooseTopicPanel.insets = new Insets(0, 0, 0, 0);
		gbc_ChooseTopicPanel.fill = GridBagConstraints.BOTH;
		gbc_ChooseTopicPanel.gridx = 1;
		gbc_ChooseTopicPanel.gridy = 1;
		add(chooseTopicPanel, gbc_ChooseTopicPanel);
		JButton nextTopic = new JButton();
		nextTopic.setToolTipText("До наступної теми");
		nextTopic.setFont(new Font("Monospaced", Font.BOLD, 50));
		nextTopic.setText(">");
		nextTopic.setBackground(new Color(0, 0, 0));
		nextTopic.setForeground(new Color(204, 0, 255));
		nextTopic.setFocusable(false);
		nextTopic.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nextTopic.setBorderPainted(false);
		if (Game.currentTopic == Game.topics.length - 1)
			nextTopic.setVisible(false);
		nextTopic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				nextTopic.setForeground(new Color(143, 0, 179));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				nextTopic.setForeground(new Color(204, 0, 255));
			}
		});
		nextTopic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.currentTopic++;
				Game.getInstance().changePanel(new TopicsViewPanel());

			}
		});
		GridBagConstraints gbc_nextTopic = new GridBagConstraints();
		gbc_nextTopic.insets = new Insets(0, 0, 5, 0);
		gbc_nextTopic.anchor = GridBagConstraints.EAST;
		gbc_nextTopic.gridx = 2;
		gbc_nextTopic.gridy = 1;
		this.add(nextTopic, gbc_nextTopic);
		JLabel title = new JLabel("Теми");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Monospaced", Font.PLAIN, 34));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.anchor = GridBagConstraints.CENTER;
		gbc_title.insets = new Insets(0, 0, 5, 5);
		gbc_title.gridx = 1;
		gbc_title.gridy = 0;
		this.add(title, gbc_title);
		JButton returnToStart = new JButton("Назад");
		returnToStart.setToolTipText("Назад до меню");
		returnToStart.setBackground(new Color(0, 51, 153));
		returnToStart.setForeground(new Color(255, 255, 255));
		returnToStart.setFocusable(false);
		returnToStart.setCursor(new Cursor(Cursor.HAND_CURSOR));
		returnToStart.setBorderPainted(false);
		returnToStart.setFont(new Font("Monospaced", returnToStart.getFont().getStyle(), 14));
		returnToStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().changePanel(new StartPanel());
			}
		});
		returnToStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				returnToStart.setBackground(new Color(0, 43, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				returnToStart.setBackground(new Color(0, 51, 153));
			}
		});
		GridBagConstraints gbc_returnToStart = new GridBagConstraints();
		gbc_returnToStart.insets = new Insets(5, 5, 5, 5);
		gbc_returnToStart.anchor = GridBagConstraints.NORTHWEST;
		gbc_returnToStart.gridx = 0;
		gbc_returnToStart.gridy = 0;
		this.add(returnToStart, gbc_returnToStart);

	}

}
