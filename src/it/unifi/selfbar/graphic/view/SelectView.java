package it.unifi.selfbar.graphic.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		initGui();
		refresh();
	}

	private void initGui() {
		// generic constraints
		btnAnotherOrder.setPreferredSize(new Dimension(200, 100));
		btnCheckout.setPreferredSize(new Dimension(200, 100));
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gb = new GridBagConstraints();
		setLayout(layout);
		gb.weightx = 1;
		gb.weighty = 1;
		// btnCheckout
		gb.gridx = 0;
		gb.gridy = 0;
		layout.setConstraints(btnCheckout, gb);
		add(btnCheckout);
		// btnAnotherOrder
		gb.gridx = 0;
		gb.gridy = 1;
		layout.setConstraints(btnAnotherOrder, gb);
		add(btnAnotherOrder);
	}
}
