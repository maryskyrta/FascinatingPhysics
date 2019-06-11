package LevelParts;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Level extends JPanel {
	private JTextField userAnswer;
	static String taskStr = "Щоб доїхати од магазину потрібно здолати 2500 м, в до музичного театру в тому самому напрямку --"
			+ "6700 м. Який шлях проїде машина від магазину до театру?";

	/**
	 * Create the panel.
	 */
	public Level() {

		JTextPane task = new JTextPane();
		task.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task.setText(taskStr);

		userAnswer = new JTextField();
		userAnswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userAnswer.setColumns(10);

		JLabel expectedLabel = new JLabel("x =");
		expectedLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton sendAnswer = new JButton("Відповісти");
		sendAnswer.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel im = new JPanel();
		sendAnswer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				im.removeAll();
				try {
					double ans = Double.parseDouble(userAnswer.getText());
					if (ans < 0)
						throw new NumberFormatException();
					ActionAfterAnswer act = new ActionAfterAnswer(201, 457, ans, 420);
					im.add(act);
					act.repaint();
					TestLevel.visible();
				} catch (NumberFormatException ex) {
					
				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(98)
								.addComponent(expectedLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(userAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(sendAnswer))
						.addGroup(groupLayout.createSequentialGroup().addGap(28)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(im, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(task, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))))
				.addContainerGap(15, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(22)
				.addComponent(task, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(im, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(userAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(sendAnswer).addComponent(expectedLabel))
				.addGap(45)));
		setLayout(groupLayout);

		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("static/2.png"));
			Image dimg = myPicture.getScaledInstance(457, 201, Image.SCALE_SMOOTH);
			JLabel picLabel = new JLabel(new ImageIcon(dimg));
			im.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
