
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Cursor;

public class Level extends JPanel {
	private JTextField userAnswer;
	static String taskStr = "Щоб доїхати до магазину від дому потрібно здолати 2500 м, в до музичного театру в тому самому напрямку -- "
			+ "6700 м. Який шлях проїде машина від магазину до театру?";

	/**
	 * Create the panel.
	 */
	public Level() {
		setBackground(Color.BLACK);

		JTextPane task = new JTextPane();
		task.setForeground(new Color(255, 255, 255));
		task.setBackground(new Color(0, 0, 0));
		task.setFont(new Font("Monospaced", Font.BOLD, 16));
		task.setText(taskStr);

		userAnswer = new JTextField();
		userAnswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userAnswer.setColumns(10);

		JLabel expectedLabel = new JLabel("x =");
		expectedLabel.setForeground(Color.WHITE);
		expectedLabel.setFont(new Font("Monospaced", Font.BOLD, 18));

		JButton sendAnswer = new JButton("Відповісти");
		sendAnswer.setForeground(new Color(0, 0, 0));
		sendAnswer.setFont(new Font("Monospaced", Font.BOLD, 18));
		sendAnswer.setFocusable(false);
		sendAnswer.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sendAnswer.setBorderPainted(false);
		sendAnswer.setBackground(new Color(0, 255, 127));
		sendAnswer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				sendAnswer.setBackground(new Color(50, 205, 50));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				sendAnswer.setBackground(new Color(0, 255, 127));
			}
		});

		JPanel im = new JPanel();
		im.setBackground(new Color(0, 0, 0));
		

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(im, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(task, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(208)
					.addComponent(expectedLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(userAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(sendAnswer)
					.addContainerGap(186, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(task, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(im, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(expectedLabel)
						.addComponent(userAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sendAnswer))
					.addGap(79))
		);
		setLayout(groupLayout);

		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("static/3.png"));
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
					if (ans < 0) throw new NumberFormatException();
					im.removeAll();
					sendAnswer.setVisible(false);
					im.setVisible(true);
					Game.getInstance().visible();
					im.add(new ActionAfterAnswer(ans, 4200));
					
				} catch (NumberFormatException ex) {
					 JOptionPane.showMessageDialog(null, "Будь ласка. введіть чилсо, яке більше або дорівнює 0.",
								"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}
}
