package it.unifi.selfbar.graphic.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import it.unifi.selfbar.bill.AbsoluteDiscount;
import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.bill.NightDiscount;
import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.visitor.BillPrintVisitor;

public class BillView extends LJPanel {
	private JButton btnCheckout = new JButton();
	private JTextArea billSummaryTextArea = new JTextArea();
	private JScrollPane billSummaryScrollBar;
	private BillPrintVisitor bpv = new BillPrintVisitor();
	private Bill bill;

	public BillView() {
		initializePanel();
		addButtonDestination(btnCheckout, GraphicGuide.SELECT_PAYMENT_METHOD);
	}

	@Override
	protected void initializePanel() {
		initGui();
		bill = GUIController.getMiddleware().getTable().getBill();
		if (bill.getTotal() > 0) {
			checkDiscount();
			GUIController.getMiddleware().getTable().setBill(bill);
		}
		bill.accept(bpv);
		billSummaryTextArea.setText("");
		billSummaryTextArea.setText(bpv.getBillSummary());

		this.refresh();
	}

	private void initGui() {
		// generic constraints
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gb = new GridBagConstraints();
		setLayout(layout);
		gb.weightx = 1;
		gb.weighty = 1;
		// txtArea
		billSummaryTextArea.setEditable(false);
		billSummaryScrollBar = new JScrollPane(billSummaryTextArea);
		gb.fill = GridBagConstraints.BOTH;
		gb.insets = new Insets(20, 20, 20, 0);
		gb.gridx = 0;
		gb.gridy = 0;
		layout.setConstraints(billSummaryScrollBar, gb);
		add(billSummaryScrollBar);
		// btnCheckout
		try {
			Image img = Toolkit.getDefaultToolkit().createImage("img/pay_icon.png");

			btnCheckout.setIcon(new ImageIcon(img));
			Image img1 = Toolkit.getDefaultToolkit().createImage("img/back_icon.png");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		gb.insets = new Insets(0, 0, 0, 0);
		gb.fill = GridBagConstraints.NONE;
		gb.gridx = 1;
		gb.gridy = 0;
		layout.setConstraints(btnCheckout, gb);
		add(btnCheckout);
	}

	private void checkDiscount() {
		GregorianCalendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String dayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		if (dayName.equals("martedì")) {
			bill = new AbsoluteDiscount(bill, 5);// 5€
		}
		if (hour >= 0 && hour <= 6) {
			bill = new NightDiscount(bill, 0.05);// 5%
		}
	}

	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		mainGui.switchTo(this.nextView);
	}

}
