package it.unifi.selfbar.graphic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;

public class BillView extends LJPanel {
	private String nextView = "checkout";
	private JButton btnCheckout = new JButton("Checkout");
	
	public BillView() {
		initializePanel();
	}

	private void initializePanel(){
			this.add(btnCheckout,gridBagContraints.CENTER);
			addButtonDestinatino(btnCheckout,"checkout");
			this.refresh();
	}
	
	@Override
	public void reset() {
		this.removeAll();
		this.initializePanel();
	}

	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
     	mainGui.switchTo(this.nextView);		

	}
	
	private void addButtonDestinatino(JButton btn,String destination){
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
		  {
			nextView=destination;
		    goTo();
		  }
		});
	}
}
