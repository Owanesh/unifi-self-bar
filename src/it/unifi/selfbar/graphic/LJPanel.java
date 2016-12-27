package it.unifi.selfbar.graphic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unifi.selfbar.constant.GraphicGuide;

public abstract class LJPanel extends JPanel implements ComponentInterface {
	private GridBagConstraints gridBagContraints;
	private GridBagLayout layout;
	protected String nextView;

	public LJPanel() {
		layout = new GridBagLayout();
		setLayout(layout);
		setBackground(GraphicGuide.BACKGROUND_TONE);
		gridBagContraints = new GridBagConstraints();
		gridBagContraints.weightx = 1;
		gridBagContraints.weighty = 1;
	}

	public void add(JLabel lbl, Color color, int size, int position) {
		prepareLabel(lbl, color, size);
		add(lbl, position);
	}

	public Component add(Component obj, int i) {
		gridBagContraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagContraints.anchor = i;
		layout.setConstraints(obj, gridBagContraints);
		this.add(obj, gridBagContraints);
		return obj;
	}

	private void prepareLabel(JLabel lbl, Color color, int size) {
		lbl.setForeground(color);
		lbl.setFont(new Font("Courier", Font.PLAIN, size));
		add(lbl);
	}

	public void refresh() {
		this.repaint();
		this.validate();
	}

	@Override
	public void reset() {
		this.removeAll();
		initializePanel();
	}

	protected abstract void initializePanel();

	protected abstract void goTo();

	protected void addButtonDestination(JButton btn, String destination) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nextView = destination;
				goTo();
			}
		});
	}
}
