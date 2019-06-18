import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NameInputPanel extends JPanel {
	private JTextField textField;
	private String nameRegex = "[А-Я,І][а-я,ї,і]{2,8}";

	/**
	 * Create the panel.
	 */
	public NameInputPanel() {
		setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 1.0 };
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 200, 150, 240 };
		/*
		 * gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		 * gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		 */
		setLayout(gridBagLayout);

		JTextArea welcomeTxt = new JTextArea();
		welcomeTxt.setEditable(false);
		welcomeTxt.setBackground(new Color(0, 0, 0));
		welcomeTxt.setForeground(new Color(0, 255, 153));
		welcomeTxt.setAlignmentX(CENTER_ALIGNMENT);
		welcomeTxt.setAlignmentY(BOTTOM_ALIGNMENT);
		welcomeTxt.setFont(new Font("Monospaced", Font.PLAIN, 24));
		welcomeTxt.setText("Будь ласка, введіть своє ім'я, щоб почати гру");

		GridBagConstraints gbc_txtrWelcomeToThe = new GridBagConstraints();
		gbc_txtrWelcomeToThe.fill = GridBagConstraints.BOTH;
		gbc_txtrWelcomeToThe.gridx = 0;
		gbc_txtrWelcomeToThe.gridy = 0;
		gbc_txtrWelcomeToThe.insets = new Insets(120, 80, 0, 0);
		gbc_txtrWelcomeToThe.anchor = GridBagConstraints.SOUTH;
		add(welcomeTxt, gbc_txtrWelcomeToThe);

		textField = new JTextField();
		JButton startGame = new JButton("Почати");
		textField.setFont(new Font("Monospaced", Font.PLAIN, 22));
		textField.setMinimumSize(new Dimension(200, 40));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);

		startGame.setFont(new Font("Monospaced", Font.PLAIN, 22));
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 2;
		gbc_btnStart.anchor = GridBagConstraints.NORTH;
		add(startGame, gbc_btnStart);

		startGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				startGame.setBackground(new Color(0, 204, 122));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startGame.setBackground(new Color(0, 230, 138));
			}
		});
		startGame.setFocusable(false);
		startGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startGame.setBorderPainted(false);
		startGame.setToolTipText("Перейти до гри");
		startGame.setBackground(new Color(0, 230, 138));
		startGame.setForeground(Color.WHITE);
		startGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				if (name.matches(nameRegex)) {
					Game.name = name;
					Game.getInstance().changePanel(new StartPanel());
				} else
					JOptionPane.showMessageDialog(null,
							"Введене ім'я містить некоректні символи або має некоректну довжину. \nБудь ласка, напишіть ім'я українською мовою і використовуйте лише літери.",
							"Неправильне ім'я", JOptionPane.OK_OPTION);

			}
		});

	}

}
