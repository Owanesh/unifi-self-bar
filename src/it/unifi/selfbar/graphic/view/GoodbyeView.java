package it.unifi.selfbar.graphic.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;

public class GoodbyeView extends LJPanel {
	private JLabel goodbyeMessage = new JLabel(GraphicGuide.GOODBYE_MESSAGE);
	private JButton btnResetAll = new JButton("Leave Table");
	private String nextView = "welcome";

	public GoodbyeView() {
		initializePanel();
		addButtonDestination(btnResetAll, this.nextView);
	}

	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		mainGui.getMiddleware().resetMiddleware();
		mainGui.switchTo(this.nextView);
	}

	@Override
	protected void initializePanel() {
		initGui();
		this.refresh();
	}

	private void initGui() {
		goodbyeMessage.setForeground(GraphicGuide.RED_TONE);
		goodbyeMessage.setFont(new Font("Courier", Font.PLAIN, 60));
		// generric constraints
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gb = new GridBagConstraints();
		setLayout(layout);
		gb.weightx = 1;
		// welcome constraints
		gb.gridx = 0;
		gb.gridy = 0;
		layout.setConstraints(goodbyeMessage, gb);
		add(goodbyeMessage);	
		gb.gridx = 0;
		gb.gridy = 1;
		layout.setConstraints(btnResetAll, gb);
		add(btnResetAll);
		this.refresh();

	}
}
