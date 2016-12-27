package it.unifi.selfbar.graphic.view;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.visitor.BillPrintVisitor;

public class BillView extends LJPanel {
 	private JButton btnCheckout = new JButton("Checkout");
 	private JTextArea billSummaryTextArea;
    private JScrollPane billSummaryScrollBar;
	private BillPrintVisitor bpv = new BillPrintVisitor();


	public BillView() {
		initializePanel();
		addButtonDestination(btnCheckout,GraphicGuide.SELECT_PAYMENT_METHOD);
	}

	protected void initializePanel(){
		GUIController.getMiddleware().getTable().getBill().accept(bpv);
 		billSummaryTextArea = new JTextArea(bpv.getBillSummary(),5,20);
		billSummaryScrollBar = new JScrollPane(billSummaryTextArea);
		this.add(billSummaryScrollBar,GridBagConstraints.CENTER);
		this.add(btnCheckout,GridBagConstraints.LAST_LINE_END);
		this.refresh();
	}
	


	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
     	mainGui.switchTo(this.nextView);		

	}
	
	 
}
