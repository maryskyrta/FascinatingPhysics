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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SettingsPanel extends JPanel {
	private JTextField textField;
	private String nameRegex = "[А-Я,І][а-я,ї,і]{2,8}";

	/**
	 * Create the panel.
	 */
	public SettingsPanel() {
		setBackground(new Color(0, 0, 0));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 540, 100 };
		gridBagLayout.rowHeights = new int[] { 60, 70, 50, 50, 50, 50, 70 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 };
		setLayout(gridBagLayout);
		JLabel title = new JLabel("Налаштування");
		title.setForeground(new Color(153, 204, 255));
		title.setFont(new Font("Monospaced", Font.PLAIN, 28));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.anchor = GridBagConstraints.CENTER;
		gbc_title.insets = new Insets(70, 5, 5, 20);
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

		JLabel label = new JLabel("Ім'я:");
		label.setForeground(new Color(153, 204, 255));
		label.setFont(new Font("Monospaced", Font.PLAIN, 20));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(5, 0, 0, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		add(label, gbc_label);

		textField = new JTextField();
		textField.setText(Game.name);
		// textField.setMinimumSize(new Dimension(250, 40));
		textField.setFont(new Font("Monospaced", Font.PLAIN, 20));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 5, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(15);

		JButton button = new JButton("Змінити ім'я");
		button.setFont(new Font("Monospaced", Font.PLAIN, 20));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 5, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 3;
		add(button, gbc_button);

		button.setFocusable(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setBorderPainted(false);
		button.setToolTipText("Натисніть, щоб змінити ім'я");
		button.setBackground(new Color(128, 191, 255));
		button.setForeground(Color.WHITE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(new Color(102, 179, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(new Color(128, 191, 255));
			}
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				if (name.matches(nameRegex)) {
					Game.name = name;
				} else
					JOptionPane.showMessageDialog(null,
							"Введене ім'я містить некоректні символи або має некоректну довжину. \nБудь ласка, напишіть ім'я українською мовою і використовуйте лише літери.",
							"Неправильне ім'я", JOptionPane.OK_OPTION);

			}
		});

		JRadioButton soundOn = new JRadioButton("Увімкнути звук");
		soundOn.setFont(new Font("Monospaced", Font.PLAIN, 20));
		soundOn.setForeground(new Color(153, 204, 255));
		soundOn.setBackground(Color.BLACK);
		soundOn.setSelected(true);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 4;
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.NORTH;
		add(soundOn, gbc_rdbtnNewRadioButton);
		soundOn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSoundMode(soundOn.isSelected());
			}
		});

	}

}
