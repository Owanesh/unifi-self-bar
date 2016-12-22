package it.unifi.selfbar.graphic.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;

public class ProductListView extends LJPanel {
	private JLabel panelTitle = new JLabel(GraphicGuide.SELECT_PRODUCT_VIEW);
	private JLabel productsLabel = new JLabel(GraphicGuide.OUR_PRODUCTS_LABEL);
 	private JLabel yourChoiceLabel = new JLabel(GraphicGuide.YOUR_CHOICE);
	private JList list = new JList();  

	private String nextView;
	private JButton btnNext = new JButton(GraphicGuide.GO_ON);
	private JButton btnSelectSupplement = new JButton(GraphicGuide.SELECT_SUPPLEMENT_VIEW);
	
	public ProductListView() {
		this.add(panelTitle, GraphicGuide.RED_TONE, 40, gridBagContraints.FIRST_LINE_START);
		this.add(yourChoiceLabel, Color.WHITE, 10, gridBagContraints.LAST_LINE_START);
  		addProductFromMap(productsLabel,ViewSets.getProduct());
  		this.add(btnSelectSupplement, gridBagContraints.LAST_LINE_END);
		addButtonListener(btnSelectSupplement,"selectsupplement");
  		this.add(btnNext, gridBagContraints.LAST_LINE_END);
		addButtonListener(btnNext,"precheckout");

	}

	private void compositeListFrom(HashMap hash, JList jlist){

		jlist.setListData(hash.keySet().toArray());
		jlist.add(new JSeparator(SwingConstants.VERTICAL));
		jlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		jlist.setVisibleRowCount(-1);	
		addListner(jlist);
	
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
	
	private void addProductFromMap(JLabel title, HashMap hashmap){
		this.add(title, GraphicGuide.RED_TONE, GraphicGuide.LABEL_FONTSIZE, gridBagContraints.LINE_START);
		compositeListFrom(hashmap,list);
 		this.add(list,gridBagContraints.LINE_START);
	}
	
	
	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		mainGui.switchTo(this.nextView);		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	private void addButtonListener(JButton btn,String destination){
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
		  {
			nextView=destination;
		    goTo();
		  }
		});
	}

}
