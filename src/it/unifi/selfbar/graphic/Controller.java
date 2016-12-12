package it.unifi.selfbar.graphic;

import javax.swing.*;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.constant.GraphicGuide;

import java.awt.*;

public class Controller extends JFrame {

	JPanel oldPnl;
	JPanel currentPnl;

	public Controller(Dimension dmn) {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(dmn);
		configureBasicLayout();
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

	public void configureBasicLayout() {
		getContentPane().setBackground(Color.darkGray);
		this.setTitle(Constants.APPLICATION_NAME);
		this.setLocationRelativeTo(this);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}
}
