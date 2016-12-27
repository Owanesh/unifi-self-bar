package it.unifi.selfbar.graphic;

import javax.swing.*;

import it.unifi.selfbar.constant.*;
import it.unifi.selfbar.exception.ErrorMessages;
import it.unifi.selfbar.middleware.Middleware;

import java.awt.*;

public class GUIController extends JFrame implements ComponentInterface {

	/* Fields */
	LJPanel oldPnl;
	LJPanel currentPnl;
	private AppSettings viewManager = new AppSettings();
	private static GUIController instance = null;
	private static Middleware middleware = null;

	public static Middleware getMiddleware() {
		if (middleware == null) {
			middleware = new Middleware();
		}
		return middleware;
	}

	/* Singleton */
	public static GUIController getInstance() {
		if (instance == null) {
			instance = new GUIController();
		}
		return instance;
	}

	/* Constructor */
	private GUIController() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(GraphicGuide.WINDOW_WIDTH, GraphicGuide.WINDOW_HEIGHT));
		configureBasicLayout(); // look and feel by system
		switchTo(GraphicGuide.WELCOME_VIEW); // initial view
		middleware = getMiddleware();
		refresh();
		this.setVisible(true);
	}

	public void setCurrentPanel(LJPanel newPanel) {
		newPanel.reset();
		if (oldPnl != null) {
			this.remove(oldPnl);
		}
		currentPnl = newPanel;
		oldPnl = currentPnl;
		currentPnl = newPanel;
		this.add(currentPnl, BorderLayout.CENTER);
		currentPnl.refresh();
		this.refresh();
	}

	public void resetLastPanel() {
		LJPanel temp = currentPnl;
		currentPnl = oldPnl;
		oldPnl = temp;
		this.refresh();
	}

	public void refresh() {
		this.repaint();
		this.validate();
	}

	public String sanitizeString(String key) {
		key = key.toLowerCase();
		key = key.replace(" ", ""); // remove spaces
		key = key.trim();
		return key;
	}

	/**
	 * This method, Allows rapid switch across panels. Transition, using
	 * titleName of Destination
	 */
	public void switchTo(String key) throws IllegalArgumentException {
		key = sanitizeString(key);
		if (viewManager.getView().containsKey(key)) {
			setCurrentPanel((LJPanel) viewManager.getView().get(key));
		} else {
			throw new IllegalArgumentException(ErrorMessages.INVALID_VIEWKEY);
		}
	}

	/**
	 * This method, set default LookAndFeel (from system)
	 */
	private void configureBasicLayout() {
		this.setTitle(Constants.APPLICATION_NAME);
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - GraphicGuide.WINDOW_WIDTH) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - GraphicGuide.WINDOW_HEIGHT) / 2);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.setLayout(new BorderLayout());
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

}
