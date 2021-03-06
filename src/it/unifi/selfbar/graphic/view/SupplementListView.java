package it.unifi.selfbar.graphic.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unifi.selfbar.constant.GraphicGuide;
import it.unifi.selfbar.constant.AppSettings;
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.*;

public class SupplementListView extends LJPanel {
	private JLabel panelTitle = new JLabel(GraphicGuide.SELECT_SUPPLEMENT_VIEW);
	private JLabel supplementLabel = new JLabel("Our Supplements");
	private JLabel yourChoiceLabel = new JLabel(GraphicGuide.YOUR_CHOICE);
	private JButton btnCheckout = new JButton("Go to checkout");
	private JList supplementList = new JList();
	private ArrayList<String> listOfSupplements = new ArrayList<String>();
	public SupplementListView() {
		initializePanel();
		addButtonDestination(btnCheckout, "precheckout");

	}

	public void initializePanel() {
		listOfSupplements.clear();
		this.add(panelTitle, GraphicGuide.RED_TONE, 40, GridBagConstraints.FIRST_LINE_START);
		this.add(yourChoiceLabel, GraphicGuide.RED_TONE, 20, GridBagConstraints.LAST_LINE_START);
		Order o = GUIController.getMiddleware().getPreparedOrder();
		if (o instanceof Coffee) {
			listOfSupplements.addAll(AppSettings.getCoffeeDecoration());
		} else if (o instanceof Cocktail) {
			listOfSupplements.addAll(AppSettings.getCocktailDecoration());
		} else {
			listOfSupplements = new ArrayList<String>();
		}
		listOfSupplements.addAll(AppSettings.getGenericDecoration());
		addProductFromMap(supplementLabel, listOfSupplements, supplementList);
		this.add(btnCheckout, GridBagConstraints.LAST_LINE_END);
	}

	private void compositeListFrom(ArrayList<String> hash, JList jlist) {
		jlist.setListData(hash.toArray());
		jlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		addListner(jlist);
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

	private void addProductFromMap(JLabel title, ArrayList<String> hashmap, JList list) {
		this.add(title, GraphicGuide.RED_TONE, GraphicGuide.LABEL_FONTSIZE, GridBagConstraints.LINE_START);
		compositeListFrom(hashmap, list);
		this.add(list, GridBagConstraints.LINE_START);
	}

	private void addProductFromMap(ArrayList<String> hashmap, JList list) {
		compositeListFrom(hashmap, list);
		this.add(list, GridBagConstraints.LINE_START);
	}
	
	

	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		List<String> selectedValueList = (supplementList.getSelectedValuesList());
		Order dynamicOrder;
		for (String name : selectedValueList) {
			dynamicOrder = mainGui.getMiddleware().getPreparedOrder();
			name = mainGui.sanitizeString(name);
			switch (name) {
			case "ice":
				Ice ice = new Ice(dynamicOrder);
				mainGui.getMiddleware().prepareOrder(ice);
				break;
			case "milk":
				Milk milk = new Milk((Coffee) dynamicOrder);
				mainGui.getMiddleware().prepareOrder(milk);
				break;
			case "cream":
				Cream cream = new Cream((Coffee) dynamicOrder);
				mainGui.getMiddleware().prepareOrder(cream);
				break;
			case "soda":
				Soda soda = new Soda((Cocktail) dynamicOrder);
				mainGui.getMiddleware().prepareOrder(soda);
				break;
			case "appetizer":
				Appetizer appetizer = new Appetizer((Cocktail) dynamicOrder);
				mainGui.getMiddleware().prepareOrder(appetizer);
				break;
			}
		}
		mainGui.switchTo(this.nextView);
	}

}
