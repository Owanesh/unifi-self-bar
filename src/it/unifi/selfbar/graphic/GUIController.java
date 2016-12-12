package it.unifi.selfbar.graphic;

import javax.swing.*;
 

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.constant.ViewSets;
import it.unifi.selfbar.graphic.view.WelcomeView;

import java.awt.*;
import java.util.HashMap;

public class GUIController extends JFrame implements ComponentInterface{

	/* Fields */
	JPanel oldPnl;
	JPanel currentPnl;
	private HashMap viewList;
	
	private static GUIController instance = null;
	
	/* Singleton */
 	public static  GUIController getInstance() {
	      if(instance == null) {
	         instance = new GUIController();
	      }
	      return instance;
	   }
	
	protected GUIController() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(GraphicGuide.WINDOW_WIDTH, GraphicGuide.WINDOW_HEIGHT));
		configureBasicLayout();
		this.add(new WelcomeView());
		refresh();
		this.setVisible(true);
	} 
	
	public void setCurrentPanel(JPanel newPnl) {
		this.oldPnl = this.currentPnl;
		this.currentPnl = newPnl;
		this.refresh();
	}

	public JPanel getLastPanel() {
		return oldPnl;
	}

	public JPanel getCurrentPanel() {
		return currentPnl;
	}

	public void resetLastPanel() {
		JPanel temp = currentPnl;
		currentPnl = oldPnl;
		oldPnl = temp;
		this.refresh();
	}

	public void refresh() {
		this.pack();
		this.repaint();
		this.validate();
	}

	private void configureBasicLayout() {
		getContentPane().setBackground(GraphicGuide.BACKGROUND_TONE);
		this.setTitle(Constants.APPLICATION_NAME);
		this.setLocationRelativeTo(this);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	private void defineViewSet(){
		this.viewList = ViewSets.map();
	}
	
 
}
