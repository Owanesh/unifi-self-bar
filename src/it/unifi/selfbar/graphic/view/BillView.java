package it.unifi.selfbar.graphic.view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

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
	private JButton btnCheckout = new JButton("Checkout");
	private JTextArea billSummaryTextArea;
	private JScrollPane billSummaryScrollBar;
	private BillPrintVisitor bpv = new BillPrintVisitor();
	private Bill bill = GUIController.getMiddleware().getTable().getBill();

	public BillView() {
		checkDiscount();
		GUIController.getMiddleware().getTable().setBill(bill);
		initializePanel();
		addButtonDestination(btnCheckout, GraphicGuide.SELECT_PAYMENT_METHOD);
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
	protected void initializePanel() {

		bill.accept(bpv);
		billSummaryTextArea = new JTextArea(bpv.getBillSummary(), 5, 20);
		billSummaryScrollBar = new JScrollPane(billSummaryTextArea);
		this.add(billSummaryScrollBar, GridBagConstraints.CENTER);
		this.add(btnCheckout, GridBagConstraints.LAST_LINE_END);
		this.refresh();
	}

	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		mainGui.switchTo(this.nextView);

	}

}
