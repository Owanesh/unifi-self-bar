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

public class SupplementListView extends LJPanel {
	private JLabel panelTitle = new JLabel(GraphicGuide.SELECT_SUPPLEMENT_VIEW);
	private JLabel supplementLabel = new JLabel("Our Supplements");
 	private JLabel yourChoiceLabel = new JLabel(GraphicGuide.YOUR_CHOICE);
 	private JButton btnCheckout=new JButton("Go to checkout");
 	private JButton btnNext=new JButton("Next");
	private JList supplementList = new JList();  
	private JList genericSupplementList = new JList();  

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
		this.add(panelTitle, GraphicGuide.RED_TONE, 40, gridBagContraints.FIRST_LINE_START);
		this.add(yourChoiceLabel, Color.WHITE, 10, gridBagContraints.LAST_LINE_START);
  		addProductFromMap(supplementLabel,ViewSets.getCoffeeSupplement(),supplementList);
  		addProductFromMap(ViewSets.getGenericSupplement(),genericSupplementList);
  		this.add(btnCheckout, gridBagContraints.LAST_LINE_END);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
