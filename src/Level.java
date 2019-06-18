
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Level extends JPanel {
	private JTextField userAnswer;
	private static String taskString;
	private static String img;
	private double rightAnswer;

	/**
	 * Create the panel.
	 */
	public Level(String taskString, String img, double rightAnswer) {
		this.taskString = taskString;
		this.img = img;
		this.rightAnswer = rightAnswer;

		setBackground(Color.BLACK);

		JTextPane task = new JTextPane();
		task.setForeground(new Color(255, 255, 255));
		task.setBackground(new Color(0, 0, 0));
		task.setFont(new Font("Monospaced", Font.PLAIN, 16));
		task.setText(this.taskString);

		userAnswer = new JTextField();
		userAnswer.setFont(new Font("Monospaced", Font.PLAIN, 16));
		userAnswer.setColumns(10);

		JLabel expectedLabel = new JLabel("x =");
		expectedLabel.setForeground(Color.WHITE);
		expectedLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));

		JButton sendAnswer = new JButton("Відповісти");
		sendAnswer.setForeground(new Color(255, 255, 255));
		sendAnswer.setFont(new Font("Monospaced", Font.PLAIN, 18));
		sendAnswer.setFocusable(false);
		sendAnswer.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sendAnswer.setBorderPainted(false);
		sendAnswer.setBackground(new Color(0, 204, 0));
		sendAnswer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				sendAnswer.setBackground(new Color(0, 179, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				sendAnswer.setBackground(new Color(0, 204, 0));
			}
		});

		JPanel im = new JPanel();
		im.setBackground(new Color(0, 0, 0));

		JButton hint = new JButton();
		JLabel label = new JLabel();
		hint.setIcon(new ImageIcon("static/lamp.png"));
		hint.setBackground(Color.BLACK);
		hint.setFocusable(false);
		hint.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hint.setBorderPainted(false);
		hint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String message = "";
				if (Game.currentTopic == 0)
					message = MechanicMovementTopic.getHint();
				else if (Game.currentTopic == 1)
					message = PathTopic.getHint();
				JOptionPane.showMessageDialog(null, message, "Підказка", JOptionPane.OK_OPTION);
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(208)
								.addComponent(expectedLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(userAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(sendAnswer))
						.addGroup(groupLayout.createSequentialGroup().addGap(28).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addComponent(im, GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(task, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(hint, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(37, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(26, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(task, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(hint, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(im, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(userAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(sendAnswer))
								.addComponent(expectedLabel))
						.addGap(59)));
		setLayout(groupLayout);

		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File(this.img));
			Image dimg = myPicture.getScaledInstance(688, 301, Image.SCALE_SMOOTH);
			JLabel picLabel = new JLabel(new ImageIcon(dimg));
			im.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sendAnswer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double ans = Double.parseDouble(userAnswer.getText());
					if (ans < 0)
						throw new NumberFormatException();
					im.removeAll();
					sendAnswer.setVisible(false);
					im.setVisible(true);
					// Game.getInstance().visible();
					im.add(new ActionAfterAnswer(ans, rightAnswer));
					// LevelTester

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Будь ласка. введіть чилсо, яке більше або дорівнює 0.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}
}
