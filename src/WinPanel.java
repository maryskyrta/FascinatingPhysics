
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WinPanel extends JPanel {
	
	private int height;
	private int width;
	private String message;

	WinPanel(int height, int width){
		setBackground(new Color(0, 0, 0));
		this.height = height;
		this.width = width;
		message = "Вітаємо! Ваша відповідь вірна.";
		
		setPreferredSize(new Dimension(750, 600));
		
		JTextPane txtpnSomeText = new JTextPane();
		txtpnSomeText.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtpnSomeText.setForeground(new Color(255, 255, 255));
		txtpnSomeText.setBackground(new Color(0, 0, 0));
		txtpnSomeText.setText(message);
		
		JButton button = new JButton("Меню");
		button.setFont(new Font("Monospaced", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().changePanel(new StartPanel());
			}
		});
		
		JButton button_1 = new JButton("Наступний рівень");
		button_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LevelChenger.levelUp();
				LevelChenger.goLevel();;
			}
		});
		
		button.setBackground(new Color(255, 153, 0));
		button.setFocusable(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setBorderPainted(false);
		button.setForeground(Color.WHITE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(new Color(230, 138, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(new Color(255, 153, 0));
			}
		});
		
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button_1.setBackground(new Color(46, 184, 46));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button_1.setBackground(new Color(51, 204, 51));
			}
		});
		button_1.setFocusable(false);
		button_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button_1.setBorderPainted(false);
		button_1.setBackground(new Color(51, 204, 51));
		button_1.setForeground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(txtpnSomeText, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(126, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addGap(96)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(82))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(172)
					.addComponent(txtpnSomeText, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(98)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		setVisible(true);
	}



}
