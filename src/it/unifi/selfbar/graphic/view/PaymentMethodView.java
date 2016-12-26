package it.unifi.selfbar.graphic.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
	private String nextView = GraphicGuide.GOODBYE_VIEW;
	private JButton btnNext = new JButton("Pay");

	public PaymentMethodView() {
		initializePanel();
		addButtonDestination(btnNext, "precheckout");

	}

	public void initializePanel() {
		addProductFromMap(panelTitle, AppSettings.getPaymentMethod());
		this.add(btnNext, gridBagContraints.LAST_LINE_END);
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
		this.add(title, GraphicGuide.RED_TONE, GraphicGuide.LABEL_FONTSIZE, gridBagContraints.LINE_START);
		compositeListFrom(listOfProducts);
		this.add(list, gridBagContraints.LINE_START);
	}

	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		String name = mainGui.sanitizeString(list.getSelectedValue().toString());
		String message = "";
		switch (name) {
			case "creditcard":
				CreditCardPaymentStrategy creditCard = new CreditCardPaymentStrategy();
				mainGui.getMiddleware().pay(creditCard);
				break;
			case "cash":
				CashPaymentStrategy cash = new CashPaymentStrategy();
				mainGui.getMiddleware().pay(cash);
				break;
			case "paypal":
				mainGui.getMiddleware().pay((double price) -> JOptionPane.showMessageDialog(this, "Payed using PayPal", "Payment Result",
						JOptionPane.INFORMATION_MESSAGE));
				break;
			case "bitcoin":
				mainGui.getMiddleware().pay((double price) -> JOptionPane.showMessageDialog(this, "Payed using Bitcoin", "Payment Result",
						JOptionPane.INFORMATION_MESSAGE));
				break;
		}

		if (mainGui.getMiddleware().getPayResult()) {
			message = "You have just spent : " + mainGui.getMiddleware().getTotal();
		} else {
			message = "System error, try later. You have to pay : " + mainGui.getMiddleware().getTotal();
		}
		JOptionPane.showMessageDialog(this, message, "Payment Result", JOptionPane.INFORMATION_MESSAGE);
		mainGui.switchTo(this.nextView);
	}

	@Override
	public void reset() {
		this.removeAll();
		list.clearSelection();
		initializePanel();
	}

	private void addButtonDestination(JButton btn, String destination) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goTo();
			}
		});
	}

}
