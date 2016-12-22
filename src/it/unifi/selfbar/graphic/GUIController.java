package it.unifi.selfbar.graphic;

import javax.swing.*;
 

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.constant.ViewSets;
import it.unifi.selfbar.exception.ErrorMessages;
import it.unifi.selfbar.graphic.view.WelcomeView;

import java.awt.*;
import java.util.HashMap;

public class GUIController extends JFrame implements ComponentInterface{

	/* Fields */
	JPanel oldPnl;
	JPanel currentPnl;
	private ViewSets viewManager = new ViewSets();
 	private static GUIController instance = null;
	
	/* Singleton */
 	public static  GUIController getInstance() {
	      if(instance == null) {
	         instance = new GUIController();
	      }
	      return instance;
	   }
	
 	/* Constructor */
	protected GUIController() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(GraphicGuide.WINDOW_WIDTH, GraphicGuide.WINDOW_HEIGHT));
		configureBasicLayout(); //look and feel by system
		switchTo(GraphicGuide.WELCOME_VIEW); //initial view
		refresh();
		this.setVisible(true);
	} 
	
	public void setCurrentPanel(JPanel newPanel) {
		if(oldPnl!=null)
			this.remove(oldPnl);
		this.oldPnl = this.currentPnl;
		this.currentPnl = newPanel;
  		this.add(currentPnl);
		this.refresh();
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


	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	
	private String sanitizeString(String key){
		key = key.toLowerCase();
		key = key.replace(" ",""); //remove spaces
		key = key.trim();
		return key;
	}
	
	/**
	 * This method, Allows rapid switch across panels. Transition, using titleName of Destination
	 */
	public void switchTo(String key)  throws IllegalArgumentException {
		key = sanitizeString(key);
		if(viewManager.getView().containsKey(key)){
			setCurrentPanel((LJPanel)viewManager.getView().get(key));
		}
		else{
			throw new IllegalArgumentException(ErrorMessages.INVALID_VIEWKEY);
		}
	}
	
	
	
	/**
	 * This method, set default LookAndFeel (from system)
	 */
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
		this.setLayout(new GridBagLayout());

	}
 
 
}
