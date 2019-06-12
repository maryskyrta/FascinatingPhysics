import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopicPreviewPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TopicPreviewPanel(Topic topic) {
		setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 250, 70 };
		gridBagLayout.columnWeights = new double[] { 0.0 };
		gridBagLayout.rowWeights = new double[] { Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel logo = new JLabel("");
		logo.setBackground(new Color(0, 0, 0));
		logo.setIcon(new ImageIcon(Game.topics[Game.currentTopic].getImagePath()));
		GridBagConstraints gbc_logo = new GridBagConstraints();
		gbc_logo.insets = new Insets(0, 0, 5, 0);
		gbc_logo.gridx = 0;
		gbc_logo.gridy = 0;
		add(logo, gbc_logo);

		JLabel lblNewLabel = new JLabel(Game.topics[Game.currentTopic].getName());
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 26));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.CENTER;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

	}

}
