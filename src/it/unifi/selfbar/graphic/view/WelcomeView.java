package it.unifi.selfbar.graphic.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;

public class WelcomeView extends LJPanel{

	private JLabel welcomeMessage = new JLabel(GraphicGuide.WELCOME_MESSAGE);
	
	public WelcomeView() {
		this.add(welcomeMessage, GraphicGuide.RED_TONE, 40, gridBagContraints.CENTER);
 		this.refresh();
 		goTo();
 		
	}

	@Override
	protected void goTo() {
		//Go to another page after 5 Second
		Timer t = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUIController mainGui = GUIController.getInstance();
        		mainGui.switchTo(GraphicGuide.SELECT_PRODUCT_VIEW);
        		}
        });
        t.setRepeats(false);
        t.start();
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
 

}
