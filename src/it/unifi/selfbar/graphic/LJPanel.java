package it.unifi.selfbar.graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unifi.selfbar.constant.GraphicGuide;

public abstract class LJPanel extends JPanel implements ComponentInterface {
	protected GridBagConstraints gridBagContraints;
	
	public LJPanel() {
		super(new GridBagLayout());
		setBackground(GraphicGuide.BACKGROUND_TONE);
		gridBagContraints = new GridBagConstraints();
	}

	public void add(JLabel lbl, Color color, int size){
		prepareLabel( lbl, color, size);
		this.add(lbl);
	}
	
	public void prepareLabel(JLabel lbl, Color color, int size){
		lbl.setForeground(color);
		lbl.setFont(new Font("Courier", Font.PLAIN , size));
		add(lbl);
	}
	
	public void refresh() {
		this.repaint();
		this.validate();
	}
	
	protected abstract void goTo();
}
