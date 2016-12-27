package it.unifi.selfbar.graphic.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.constant.AppSettings;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.order.*;

public class ProductListView extends LJPanel {
	private JLabel panelTitle = new JLabel(GraphicGuide.SELECT_PRODUCT_VIEW);
	private JLabel productsLabel = new JLabel(GraphicGuide.OUR_PRODUCTS_LABEL);
	private JLabel yourChoiceLabel = new JLabel(GraphicGuide.YOUR_CHOICE);
	private JList list = new JList();
	private JButton btnNext = new JButton(GraphicGuide.GO_ON);
	private JButton btnSelectSupplement = new JButton(GraphicGuide.SELECT_SUPPLEMENT_VIEW);

	public ProductListView() {
		initializePanel();
		addListner(list);
		addButtonDestination(btnSelectSupplement, "selectsupplement");
		addButtonDestination(btnNext, "precheckout");
	}

	public void initializePanel() {
		this.add(panelTitle, GraphicGuide.RED_TONE, 40, GridBagConstraints.FIRST_LINE_START);
		this.add(yourChoiceLabel, Color.WHITE, 10, GridBagConstraints.LAST_LINE_START);
		addProductFromMap(productsLabel, AppSettings.getProduct());
		this.add(btnSelectSupplement, GridBagConstraints.LAST_LINE_END);
		this.add(btnNext, GridBagConstraints.LAST_LINE_END);

		refresh();
	}

	private void compositeListFrom(ArrayList<String> hash) {
		list.setListData(hash.toArray());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);

	}

	private void addListner(JList list) {
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (list.getSelectedValue() != null) {
					if (!arg0.getValueIsAdjusting()) {
						yourChoiceLabel.setText(GraphicGuide.YOUR_CHOICE + " " + list.getSelectedValue().toString());
					}
				} else {
					list.clearSelection();
				}
			}
		});
	}

	private void addProductFromMap(JLabel title, ArrayList<String> listOfProducts) {
		this.add(title, GraphicGuide.RED_TONE, GraphicGuide.LABEL_FONTSIZE, GridBagConstraints.LINE_START);
		compositeListFrom(listOfProducts);
		this.add(list, GridBagConstraints.LINE_START);
	}

	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		String name = mainGui.sanitizeString(list.getSelectedValue().toString());
		switch (name) {
		case "arabic":
			Arabic arabic = new Arabic();
			mainGui.getMiddleware().prepareOrder(arabic);
			break;
		case "brasilian":
			Brasilian brasilian = new Brasilian();
			mainGui.getMiddleware().prepareOrder(brasilian);
			break;
		case "martini":
			Martini martini = new Martini();
			mainGui.getMiddleware().prepareOrder(martini);
			break;
		case "tequila":
			Tequila tequila = new Tequila();
			mainGui.getMiddleware().prepareOrder(tequila);
			break;
		}
		mainGui.switchTo(this.nextView);
	}

	@Override
	public void reset() {
		this.removeAll();
		list.clearSelection();
		initializePanel();
	}

}
