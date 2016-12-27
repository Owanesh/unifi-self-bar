package it.unifi.selfbar.graphic.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.constant.AppSettings;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.payment.CashPaymentStrategy;
import it.unifi.selfbar.payment.CreditCardPaymentStrategy;

public class PaymentMethodView extends LJPanel {
	private JLabel panelTitle = new JLabel(GraphicGuide.SELECT_PAYMENT_METHOD);
	private JList list = new JList();
	private JButton btnNext = new JButton("Pay");

	public PaymentMethodView() {
		nextView = GraphicGuide.GOODBYE_VIEW;
		initializePanel();
		addButtonDestination(btnNext, "goodbye");
	}

	public void initializePanel() {
		addProductFromMap(AppSettings.getPaymentMethod());
		initGui();
		refresh();
	}

	private void initGui() {
		foregroundAndFont();
		// generic constraints
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gb = new GridBagConstraints();
		setLayout(layout);
		gb.weightx = 1;
		gb.weighty = 1;
		// panel title
		gb.anchor = GridBagConstraints.NORTHWEST;
		gb.gridx = 0;
		gb.gridy = 0;
		layout.setConstraints(panelTitle, gb);
		add(panelTitle);
		// JList
		gb.anchor = GridBagConstraints.CENTER;
		gb.gridx = 1;
		gb.gridy = 1;
		layout.setConstraints(list, gb);
		add(list);
		// btn
		gb.gridx = 2;
		gb.gridy = 2;
		layout.setConstraints(btnNext, gb);
		add(btnNext);
	}

	private void foregroundAndFont() {
		panelTitle.setForeground(GraphicGuide.RED_TONE);
		panelTitle.setFont(new Font("Courier", Font.PLAIN, 40));
	}

	/**
	 * inizializza la JList
	 * 
	 * @param listOfProducts
	 */
	private void addProductFromMap(ArrayList<String> listOfProducts) {
		list.setListData(listOfProducts.toArray());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		String name = null;
		try {
			name = mainGui.sanitizeString(list.getSelectedValue().toString());
		} catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(this, "Please select one payment method.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String message = "";
		switch (name) {
		case "creditcard":
			CreditCardPaymentStrategy creditCard = new CreditCardPaymentStrategy();
			mainGui.getMiddleware().pay(creditCard);
			alertAboutPaymentMethod("Credit Card", mainGui.getMiddleware().getTotal());
			break;
		case "money":
			CashPaymentStrategy cash = new CashPaymentStrategy();
			mainGui.getMiddleware().pay(cash);
			alertAboutPaymentMethod("Money", mainGui.getMiddleware().getTotal());
			break;
		case "paypal":
			mainGui.getMiddleware().pay((price) -> alertAboutPaymentMethod("Pay Pal", price));
			break;
		case "bitcoin":
			mainGui.getMiddleware().pay((price) -> alertAboutPaymentMethod("Bit Coin", price));
			break;
		}
		mainGui.switchTo(this.nextView);
	}

	private void alertAboutPaymentMethod(String payMethod, double price) {
		String message = "You have just spent : " + String.format("%.2f", price) + "\n";
		JOptionPane.showMessageDialog(this, message + "Payed using " + payMethod, "Payment Result",
				JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public void reset() {
		this.removeAll();
		list.clearSelection();
		initializePanel();
	}

}
