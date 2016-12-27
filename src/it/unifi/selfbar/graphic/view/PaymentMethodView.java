package it.unifi.selfbar.graphic.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
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
		addProductFromMap(panelTitle, AppSettings.getPaymentMethod());
		this.add(btnNext, GridBagConstraints.LAST_LINE_END);
		refresh();
	}

	private void compositeListFrom(ArrayList<String> hash) {
		list.setListData(hash.toArray());
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1); // select only one element
		list.ensureIndexIsVisible(-1); // deselect all element
	}

	private void addProductFromMap(JLabel title, ArrayList<String> listOfProducts) {
		this.add(title, GraphicGuide.RED_TONE, GraphicGuide.LABEL_FONTSIZE, GridBagConstraints.LINE_START);
		compositeListFrom(listOfProducts);
		this.add(list, GridBagConstraints.LINE_START);
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
		String message = "You have just spent : " + price + "\n";
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
