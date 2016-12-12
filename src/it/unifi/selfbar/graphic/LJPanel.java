package it.unifi.selfbar.graphic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public abstract class LJPanel extends JPanel {
	private GridBagConstraints gridBagContraints;
	
	public LJPanel() {
		super(new GridBagLayout());
		gridBagContraints = new GridBagConstraints();
		}


}
