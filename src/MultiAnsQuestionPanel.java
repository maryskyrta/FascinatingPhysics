import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 * @author Masha. Panel for choosing right answer from multiple choices
 *
 */
public class MultiAnsQuestionPanel extends JPanel {
	private boolean var1Wrong = false, var2Wrong = false, var3Wrong = false, var4Wrong = false;

	public MultiAnsQuestionPanel(TestQuestion question) {
		setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };
		gridBagLayout.columnWidths = new int[] { 720 };
		gridBagLayout.rowHeights = new int[] { 50, 400, 150 };
		setLayout(gridBagLayout);

		JButton returnToTheory = new JButton("Назад");
		returnToTheory.setToolTipText("Повернутись до теорії");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(5, 5, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		gbc_button.anchor = GridBagConstraints.WEST;
		returnToTheory.setBackground(new Color(0, 51, 153));
		returnToTheory.setForeground(new Color(255, 255, 255));
		returnToTheory.setFocusable(false);
		returnToTheory.setCursor(new Cursor(Cursor.HAND_CURSOR));
		returnToTheory.setBorderPainted(false);
		returnToTheory.setFont(new Font("Monospaced", Font.PLAIN, 14));
		returnToTheory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int cur = Game.currentTopic;
				Game.getInstance().changePanel(new TheoryPanel(Game.topics[cur].getName(), Game.theoryPaths[cur]));
			}
		});
		returnToTheory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				returnToTheory.setBackground(new Color(0, 43, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				returnToTheory.setBackground(new Color(0, 51, 153));
			}
		});
		add(returnToTheory, gbc_button);

		/*
		 * Question text
		 */
		JTextArea questionText = new JTextArea(question.getQuestion());
		questionText.setBackground(new Color(0, 0, 0));
		questionText.setEnabled(false);
		questionText.setBorder(null);
		questionText.setEditable(false);
		questionText.setForeground(new Color(255, 153, 102));
		questionText.setFont(new Font("Monospaced", Font.PLAIN, 22));
		GridBagConstraints gbc_questionText = new GridBagConstraints();
		gbc_questionText.insets = new Insets(0, 0, 5, 0);
		gbc_questionText.gridx = 0;
		gbc_questionText.gridy = 1;
		add(questionText, gbc_questionText);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(2, 2));

		/*
		 * Variant buttons
		 */
		JButton var1 = new JButton(question.getAns1());
		var1.setForeground(new Color(255, 204, 51));
		var1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		GridBagConstraints gbc_var1 = new GridBagConstraints();
		gbc_var1.gridx = 0;
		gbc_var1.gridy = 2;
		var1Wrong = false;
		var1.setBackground(new Color(255, 204, 0));
		var1.setForeground(new Color(255, 255, 255));
		var1.setFocusable(false);
		var1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		var1.setBorderPainted(false);
		var1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (var1.getText().equals(question.getCorrectAnswer()))
					Game.getInstance().changePanel(MechanicMovementTopic.getNextPanel(true));
				else {
					var1.setBackground(new Color(255, 0, 0));
					var1Wrong = true;
				}
			}
		});
		var1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!var1Wrong)
					var1.setBackground(new Color(230, 184, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!var1Wrong)
					var1.setBackground(new Color(255, 204, 0));
			}
		});
		panel.add(var1);

		JButton var2 = new JButton(question.getAns2());
		var2.setForeground(new Color(255, 204, 51));
		var2.setFont(new Font("Monospaced", Font.PLAIN, 18));
		GridBagConstraints gbc_var2 = new GridBagConstraints();
		gbc_var2.gridx = 1;
		gbc_var2.gridy = 2;
		var2.setBackground(new Color(255, 204, 0));
		var2.setForeground(new Color(255, 255, 255));
		var2.setFocusable(false);
		var2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		var2.setBorderPainted(false);
		var2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (var2.getText().equals(question.getCorrectAnswer()))
					Game.getInstance().changePanel(MechanicMovementTopic.getNextPanel(true));
				else {
					var2.setBackground(new Color(255, 0, 0));
					var2Wrong = true;
				}
			}
		});
		var2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!var2Wrong)
					var2.setBackground(new Color(230, 184, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!var2Wrong)
					var2.setBackground(new Color(255, 204, 0));
			}
		});
		panel.add(var2);

		JButton var3 = new JButton(question.getAns3());
		var3.setForeground(new Color(255, 204, 51));
		var3.setFont(new Font("Monospaced", Font.PLAIN, 18));
		GridBagConstraints gbc_var3 = new GridBagConstraints();
		gbc_var3.gridx = 0;
		gbc_var3.gridy = 3;
		var3.setBackground(new Color(255, 204, 0));
		var3.setForeground(new Color(255, 255, 255));
		var3.setFocusable(false);
		var3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		var3.setBorderPainted(false);
		var3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (var3.getText().equals(question.getCorrectAnswer()))
					Game.getInstance().changePanel(MechanicMovementTopic.getNextPanel(true));
				else {
					var3.setBackground(new Color(255, 0, 0));
					var3Wrong = true;
				}
			}
		});
		var3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!var3Wrong)
					var3.setBackground(new Color(230, 184, 0));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!var3Wrong)
					var3.setBackground(new Color(255, 204, 0));
			}
		});
		panel.add(var3);

		JButton var4 = new JButton(question.getAns4());
		var4.setForeground(new Color(255, 204, 51));
		var4.setFont(new Font("Monospaced", Font.PLAIN, 18));
		GridBagConstraints gbc_var4 = new GridBagConstraints();
		gbc_var4.gridx = 1;
		gbc_var4.gridy = 3;
		var4.setBackground(new Color(255, 204, 0));
		var4.setForeground(new Color(255, 255, 255));
		var4.setFocusable(false);
		var4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		var4.setBorderPainted(false);
		var4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (var4.getText().equals(question.getCorrectAnswer()))
					try {
						Game.getInstance().changePanel(MechanicMovementTopic.getNextPanel(true));
					} catch (IndexOutOfBoundsException ex) {

					}
				else {
					var4.setBackground(new Color(255, 0, 0));
					var4Wrong = true;
				}
			}
		});
		var4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!var4Wrong)
					var4.setBackground(new Color(230, 184, 0));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!var4Wrong)
					var4.setBackground(new Color(255, 204, 0));
			}
		});
		panel.add(var4);

	}

}
