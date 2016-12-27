package it.unifi.selfbar.graphic.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		addListner(list);
		initializePanel();
		addButtonDestination(btnSelectSupplement, "selectsupplement");
		addButtonDestination(btnNext, "precheckout");
	}

	public void initializePanel() {
		addProductFromMap(AppSettings.getProduct());
		initGui();
		refresh();
	}

	private void initGui() {
		foregroundAndFont();
		// generic constraints
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gb = new GridBagConstraints();
		setLayout(layout);
		gb.weightx = 1;
		gb.weighty = 1;
		// panel title
		gb.anchor = GridBagConstraints.NORTH;
		gb.gridx = 0;
		gb.gridy = 0;
		layout.setConstraints(panelTitle, gb);
		add(panelTitle);

		// productsLabel
		gb.anchor = GridBagConstraints.CENTER;
		gb.gridx = 1;
		gb.gridy = 1;
		layout.setConstraints(productsLabel, gb);
		add(productsLabel);

		// JList
		gb.gridx = 2;
		gb.gridy = 1;
		layout.setConstraints(list, gb);
		add(list);
		// yourChoiceLabel
		gb.anchor = GridBagConstraints.SOUTH;
		gb.gridx = 0;
		gb.gridy = 2;
		gb.gridwidth = 2;
		layout.setConstraints(yourChoiceLabel, gb);
		add(yourChoiceLabel);
		// btnSelectSupplements
		gb.gridwidth = 1;
		gb.gridx = 2;
		gb.gridy = 2;
		layout.setConstraints(btnSelectSupplement, gb);
		add(btnSelectSupplement);
		// btnNext
		gb.gridx = 3;
		gb.gridy = 2;
		layout.setConstraints(btnNext, gb);
		add(btnNext);
	}

	private void foregroundAndFont() {
		panelTitle.setForeground(GraphicGuide.RED_TONE);
		panelTitle.setFont(new Font("Courier", Font.PLAIN, 40));
		yourChoiceLabel.setForeground(GraphicGuide.RED_TONE);
		yourChoiceLabel.setFont(new Font("Courier", Font.PLAIN, 20));
		productsLabel.setForeground(GraphicGuide.RED_TONE);
		productsLabel.setFont(new Font("Courier", Font.PLAIN, 40));
	}

	/**
	 * inizializza la JList
	 * 
	 * @param listOfProducts
	 */
	private void addProductFromMap(ArrayList<String> listOfProducts) {
		list.setListData(listOfProducts.toArray());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

	@Override
	public void reset() {
		this.removeAll();
		list.clearSelection();
		initializePanel();
	}

}
