package it.unifi.selfbar.graphic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;

public class BillView extends LJPanel {
	private String nextView = "checkout";
	private JButton btnCheckout = new JButton("Checkout");
	
	public BillView() {
		initializePanel();
	}

	protected void initializePanel(){
		JTextArea commentTextArea = 
		         new JTextArea("This is a Swing tutorial "
		         +"to make GUI application in Java.",5,20);

		      JScrollPane scrollPane = new JScrollPane(commentTextArea);    

				this.add(scrollPane,gridBagContraints.CENTER);
				this.add(btnCheckout,gridBagContraints.CENTER);
				addButtonDestination(btnCheckout,GraphicGuide.SELECT_PAYMENT_METHOD);
			this.refresh();
	}
	


	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
     	mainGui.switchTo(this.nextView);		

	}
	
	private void addButtonDestination(JButton btn,String destination){
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
