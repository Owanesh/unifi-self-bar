package it.unifi.selfbar.graphic.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;

public class SelectView extends LJPanel {
	private JButton btnCheckout;
	private JButton btnAnotherOrder;

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
		createButton();
		// generic constraints
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

	private void createButton() {
		btnCheckout = new JButton();
		btnAnotherOrder = new JButton();
		btnCheckout.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCheckout.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAnotherOrder.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAnotherOrder.setHorizontalTextPosition(SwingConstants.CENTER);

		try {
			Image img = Toolkit.getDefaultToolkit().createImage("img/pay_icon.png");

			btnCheckout.setIcon(new ImageIcon(img));
			btnCheckout.setText("Go to checkout");
			Image img1 = Toolkit.getDefaultToolkit().createImage("img/back_icon.png");
			btnAnotherOrder.setIcon(new ImageIcon(img1));
			btnAnotherOrder.setText("Select Another Product");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
