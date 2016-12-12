package it.unifi.selfbar.constant;

import java.util.HashMap;

import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.graphic.view.*;
 
public class ViewSets {

	private static  HashMap<String, LJPanel> map;
		
	private static HashMap<String, LJPanel> initializeMap(){
		map = new HashMap<>();
		map.put("welcome", new WelcomeView());
		map.put("selectproduct", new ProductListView());
		map.put("selectsupplement", new WelcomeView());
		map.put("precheckout", new WelcomeView());
		map.put("checkbill", new WelcomeView());
		map.put("paymentmethod", new WelcomeView());
		map.put("goodbye", new WelcomeView());
		return map;
	}
	
	public static  HashMap map(){
	 if(map == null) {
		 map = initializeMap();
	 }
	 return map;
	}


}
