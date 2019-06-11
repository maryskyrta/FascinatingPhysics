

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;


public class LoosePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private int height;
	private int width;
	private String message;
	
	public LoosePanel() {
		setBackground(new Color(0, 0, 0));
		
       message = "Пробачте. Ваша відповідь не вірна.";
		
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
				Game.getInstance().changePanel(new Level());
			}
		});

		
		JButton button_1 = new JButton("Спробувати ще");
		button_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().changePanel(new Level());
			}
		});
		
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
