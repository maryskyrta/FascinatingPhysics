import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopicsViewPanel extends JPanel {

	public TopicsViewPanel() {
		JLabel title = new JLabel("Теми");
		JButton returnToStart = new JButton("Назад");
		JButton prevTopic = new JButton();
		JButton nextTopic = new JButton();
		returnToStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().changePanel(new StartPanel());

			}
		});

		this.add(prevTopic);
		this.add(nextTopic);
		this.add(title);
		this.add(returnToStart);

	}

}
