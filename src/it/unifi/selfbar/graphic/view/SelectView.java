package it.unifi.selfbar.graphic.view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;

public class SelectView extends LJPanel {
	private JButton btnCheckout = new JButton("Go to checkout");
	private JButton btnAnotherOrder = new JButton("Select Another Product");

	public SelectView() {
		initializePanel();
		addButtonDestination(btnCheckout, "checkout");
		addButtonDestination(btnAnotherOrder, "selectproduct");
	}

	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		mainGui.getMiddleware().confirmOrder();
		mainGui.switchTo(this.nextView);
	}

	@Override
	protected void initializePanel() {
		this.add(btnCheckout, GridBagConstraints.CENTER);
		this.add(btnAnotherOrder, GridBagConstraints.CENTER);
		refresh();
	}
}
