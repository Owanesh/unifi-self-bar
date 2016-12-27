package it.unifi.selfbar.graphic.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import it.unifi.selfbar.constant.AppSettings;
import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;

public class WelcomeView extends LJPanel {

	private JLabel welcomeMessage = new JLabel(GraphicGuide.WELCOME_MESSAGE);
	private JLabel authors = new JLabel(GraphicGuide.AUTHORS);

	public WelcomeView() {
		initializePanel();

	}

	@Override
	protected void goTo() {
		// Go to another page after 5 Second
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
	protected void initializePanel() {
		initGui();
		goTo();
	}

	private void initGui() {
		welcomeMessage.setForeground(GraphicGuide.RED_TONE);
		welcomeMessage.setFont(new Font("Courier", Font.PLAIN, 60));
		authors.setForeground(GraphicGuide.RED_TONE);
		authors.setFont(new Font("Courier", Font.PLAIN, 40));
		// generric constraints
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gb = new GridBagConstraints();
		setLayout(layout);
		gb.weightx = 1;
		// welcome constraints
		gb.gridx = 0;
		gb.gridy = 0;
		layout.setConstraints(welcomeMessage, gb);
		add(welcomeMessage);
		// authors constraints
		gb.gridx = 0;
		gb.gridy = 2;
		layout.setConstraints(authors, gb);
		add(authors);
		this.refresh();

	}

}
