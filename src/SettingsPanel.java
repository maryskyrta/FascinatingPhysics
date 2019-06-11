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
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class SettingsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SettingsPanel() {
		setBackground(new Color(0, 0, 0));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 540, 100 };
		gridBagLayout.rowHeights = new int[] { 60, 460, 0, 70 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0 };
		setLayout(gridBagLayout);
		JLabel title = new JLabel("Налаштування");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Monospaced", Font.PLAIN, 26));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.anchor = GridBagConstraints.CENTER;
		gbc_title.insets = new Insets(15, 15, 5, 5);
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
		gbc_returnToStart.insets = new Insets(0, 0, 5, 5);
		gbc_returnToStart.anchor = GridBagConstraints.NORTHWEST;
		gbc_returnToStart.gridx = 0;
		gbc_returnToStart.gridy = 0;
		this.add(returnToStart, gbc_returnToStart);

		JRadioButton soundOn = new JRadioButton("Увімкнути звук");
		soundOn.setFont(new Font("Monospaced", Font.PLAIN, 20));
		soundOn.setForeground(Color.WHITE);
		soundOn.setBackground(Color.BLACK);
		soundOn.setSelected(true);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 1;
		add(soundOn, gbc_rdbtnNewRadioButton);
		soundOn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSoundMode(soundOn.isSelected());
			}
		});

	}

}
