package it.unifi.selfbar.graphic.view;

import java.awt.GridBagConstraints;

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
		this.add(goodbyeMessage, GraphicGuide.RED_TONE, 40, GridBagConstraints.CENTER);
		this.add(btnResetAll, GridBagConstraints.LAST_LINE_END);

		this.refresh();
	}

}
