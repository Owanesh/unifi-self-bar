package it.unifi.selfbar.graphic.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
import it.unifi.selfbar.constant.ViewSets;
import it.unifi.selfbar.graphic.LJPanel;

public class ProductListView extends LJPanel {
	private JLabel panelTitle = new JLabel(GraphicGuide.SELECT_PRODUCT_VIEW);
	private JLabel productsLabel = new JLabel(GraphicGuide.OUR_PRODUCTS_LABEL);
 	private JLabel yourChoiceLabel = new JLabel(GraphicGuide.YOUR_CHOICE);

	public ProductListView() {
		this.add(panelTitle, GraphicGuide.RED_TONE, 40);
		this.add(yourChoiceLabel, Color.WHITE, 10);
  		addProductFromMap(productsLabel,ViewSets.getCoffeeProduct(),ViewSets.getCocktailProduct());
  		this.add(new JButton("Add Supplement"));
	}

	private JList compositeListFrom(HashMap hash, HashMap hash2){
		JList list = new JList();  
		list.setListData(hash.keySet().toArray());
		list.add(new JSeparator(SwingConstants.VERTICAL));
 		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);	
		addListner(list);
		return list;
	}
	
	private void addListner(JList list){
		list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	yourChoiceLabel.setText(GraphicGuide.YOUR_CHOICE+" "+list.getSelectedValue().toString());
                }
            } 
        });	    
	}
	
	private void addProductFromMap(JLabel title, HashMap list, HashMap list2){
		this.add(title, GraphicGuide.RED_TONE, GraphicGuide.LABEL_FONTSIZE);
 		this.add(compositeListFrom(list,list2));
	}
	
	
	@Override
	protected void goTo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
