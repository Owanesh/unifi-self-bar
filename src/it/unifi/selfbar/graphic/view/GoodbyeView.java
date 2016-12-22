 package it.unifi.selfbar.graphic.view;

import javax.swing.JLabel;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.graphic.LJPanel;

public class GoodbyeView extends LJPanel {
	private JLabel goodbyeMessage = new JLabel(GraphicGuide.GOODBYE_MESSAGE);

	public GoodbyeView() {
		this.add(goodbyeMessage, GraphicGuide.RED_TONE, 40, gridBagContraints.CENTER);
 		this.refresh();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void goTo() {
		// TODO Auto-generated method stub

	}

}
