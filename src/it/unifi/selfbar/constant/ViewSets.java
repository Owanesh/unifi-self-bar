package it.unifi.selfbar.constant;

import java.util.HashMap;

import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.graphic.view.*;
import it.unifi.selfbar.order.*;

public class ViewSets {

	private static HashMap<String, LJPanel> view;
	private static HashMap<String, Class> product;

	public static HashMap getView() {
		if (view == null) {
			view = initializeViews();
		}
		return view;
	}

	public static HashMap getProduct() {
		if (product == null) {
			product = initializeProducts();
		}
		return product;
	}

	private static HashMap<String, Class> initializeProducts() {
		product = new HashMap<>();
		product.put(Arabic.class.getSimpleName(), Arabic.class.getClass());
		product.put(Brasilian.class.getSimpleName(), Brasilian.class.getClass());
		product.put(Martini.class.getSimpleName(), Martini.class.getClass());
		product.put(Tequila.class.getSimpleName(), Tequila.class.getClass());
		return product;
	}

	private static HashMap<String, LJPanel> initializeViews() {
		view = new HashMap<>();
		view.put("welcome", new WelcomeView());
		view.put("selectproduct", new ProductListView());
		view.put("selectsupplement", new WelcomeView());
		view.put("precheckout", new WelcomeView());
		view.put("checkbill", new WelcomeView());
		view.put("paymentmethod", new WelcomeView());
		view.put("goodbye", new WelcomeView());
		return view;
	}

}
