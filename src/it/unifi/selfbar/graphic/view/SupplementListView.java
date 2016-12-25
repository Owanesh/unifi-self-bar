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
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.*;

public class SupplementListView extends LJPanel {
	private JLabel panelTitle = new JLabel(GraphicGuide.SELECT_SUPPLEMENT_VIEW);
	private JLabel supplementLabel = new JLabel("Our Supplements");
 	private JLabel yourChoiceLabel = new JLabel(GraphicGuide.YOUR_CHOICE);
 	private JButton btnCheckout=new JButton("Go to checkout");
 	private JList supplementList = new JList();  
	private String nextView;
 	private int selectBetweenCoffeeOrCocktail;
 	
 	public void setTypeOfSupplement(int i){
 		selectBetweenCoffeeOrCocktail=i;
 	}
 	
 	public void setYourChoiceLabel(JLabel ycl){
 		this.yourChoiceLabel=ycl;
 	}
 	public void setYourChoiceLabel(String ycl){
 		this.yourChoiceLabel.setText(ycl);
 	}
 	
	public SupplementListView() {
		initializePanel();
	}

	public void initializePanel(){
		this.add(panelTitle, GraphicGuide.RED_TONE, 40, gridBagContraints.FIRST_LINE_START);
		this.add(yourChoiceLabel, Color.WHITE, 10, gridBagContraints.LAST_LINE_START);
  		addProductFromMap(supplementLabel,ViewSets.getCoffeeSupplement(),supplementList);
   		this.add(btnCheckout, gridBagContraints.LAST_LINE_END);
		addButtonDestinatino(btnCheckout,"precheckout");
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
            	if(list.getSelectedValue()!=null){
	                if (!arg0.getValueIsAdjusting()) {
	                		yourChoiceLabel.setText(GraphicGuide.YOUR_CHOICE+" "+list.getSelectedValue().toString());              		
	                } 
            	}else{
            		list.clearSelection();
            	}
            } 
        });	    
	}
	
	private void addProductFromMap(JLabel title, HashMap hashmap,JList list){
		this.add(title, GraphicGuide.RED_TONE, GraphicGuide.LABEL_FONTSIZE, gridBagContraints.LINE_START);
		compositeListFrom(hashmap,list);
 		this.add(list,gridBagContraints.LINE_START);
	}	
	
	private void addProductFromMap(HashMap hashmap,JList list){
		compositeListFrom(hashmap,list);
 		this.add(list,gridBagContraints.LINE_START);
	}
	
	
	@Override
	protected void goTo() {
		GUIController mainGui = GUIController.getInstance();
		String name= supplementList.getSelectedValue().toString().toLowerCase().trim();
		Order dynamicOrder = mainGui.getMiddleware().getPreparedOrder();
     	switch(name){
    		case "ice":
    			Ice ice = new Ice(dynamicOrder);
    			mainGui.getMiddleware().prepareOrder(ice);
    			break;
    		case "milk":
    			Milk milk = new Milk((Coffee)dynamicOrder);
    			mainGui.getMiddleware().prepareOrder(milk);
    			break;  
    		case "cream":
    			Cream cream = new Cream((Coffee)dynamicOrder);
    			mainGui.getMiddleware().prepareOrder(cream);
    			break;
    		case "soda":
    			Soda soda = new Soda((Cocktail)dynamicOrder);
    			mainGui.getMiddleware().prepareOrder(soda);
    			break;
    		case "appetizer":
				Appetizer appetizer = new Appetizer((Appetizer)dynamicOrder);
				mainGui.getMiddleware().prepareOrder(appetizer);
				break;
			}
     	mainGui.switchTo(this.nextView);		
	}


	@Override
	public void reset() {
		this.removeAll();
		initializePanel();
	}
	
	private void addButtonDestinatino(JButton btn,String destination){
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
