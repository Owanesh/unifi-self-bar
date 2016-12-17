package it.unifi.selfbar.constant;

import java.util.HashMap;

import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.graphic.view.*;
import it.unifi.selfbar.order.*;

public class ViewSets {

	private static HashMap<String, LJPanel> view;
	private static HashMap<String, Class> coffeeProduct;
	private static HashMap<String, Class> cocktailProduct;

	public static HashMap getView() {
		if (view == null) {
			view = initializeViews();
		}
		return view;
	}

	public static HashMap getCoffeeProduct() {
		if (coffeeProduct == null) {
			coffeeProduct = initializeCoffeeProducts();
		}
		return coffeeProduct;
	}

	public static HashMap getCocktailProduct() {
		if (cocktailProduct == null) {
			cocktailProduct = initializeCocktailProducts();
		}
		return cocktailProduct;
	}

	private static HashMap<String, Class> initializeCoffeeProducts() {
		coffeeProduct = new HashMap<>();
		coffeeProduct.put(Arabic.class.getSimpleName(), Arabic.class.getClass());
		coffeeProduct.put(Brasilian.class.getSimpleName(), Brasilian.class.getClass());
 		return coffeeProduct;
	}

	private static HashMap<String, Class> initializeCocktailProducts() {
		cocktailProduct = new HashMap<>();
		cocktailProduct.put(Martini.class.getSimpleName(), Martini.class.getClass());
		cocktailProduct.put(Tequila.class.getSimpleName(), Tequila.class.getClass());
		return cocktailProduct;
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
