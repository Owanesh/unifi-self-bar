package it.unifi.selfbar.graphic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
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
	private Image img;

	public LJPanel() {
		setBackgroundImage();
		layout = new GridBagLayout();
		setLayout(layout);
		setBackground(GraphicGuide.BACKGROUND_TONE);
		gridBagContraints = new GridBagConstraints();
		gridBagContraints.weightx = 1;
		gridBagContraints.weighty = 1;
	}

	private void setBackgroundImage() {
		String path = "img/selfbar_background.png";
		img = Toolkit.getDefaultToolkit().createImage(path);
		loadImage(img);
	}

	private void loadImage(Image img) {
		try {
			MediaTracker track = new MediaTracker(this);
			track.addImage(img, 0);
			track.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void paintComponent(Graphics g) {
		setOpaque(false);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		super.paintComponent(g);
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
