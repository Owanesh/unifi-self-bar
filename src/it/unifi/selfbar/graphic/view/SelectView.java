package it.unifi.selfbar.graphic.view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;

public class SelectView extends LJPanel {
 	private JButton btnCheckout=new JButton("Go to checkout");
 	private JButton btnAnotherOrder=new JButton("Select Another Product");
 	
 	private String nextView;
 	
	public SelectView() {
		initializePanel();
		addButtonListener(btnCheckout,GraphicGuide.SELECT_PAYMENT_METHOD);
		addButtonListener(btnAnotherOrder,"selectproduct");
	}

 

	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		mainGui.getMiddleware().confirmOrder();
		mainGui.switchTo(this.nextView);	
	}
	
	private void addButtonListener(JButton btn,String destination){
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



	@Override
	protected void initializePanel() {
		gridBagContraints.fill=GridBagConstraints.HORIZONTAL;
		this.add(btnCheckout,gridBagContraints.CENTER);
		this.add(btnAnotherOrder,gridBagContraints.CENTER);
		refresh();		
	}
}
