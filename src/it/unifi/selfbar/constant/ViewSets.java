package it.unifi.selfbar.constant;

import java.util.HashMap;

import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.graphic.view.*;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.*;

public class ViewSets {

	private static HashMap<String, LJPanel> view;
	private static HashMap<String, Class> product;
	private static HashMap<String, Class> coffeeSupplements;
	private static HashMap<String, Class> cocktailSupplements;
	private static HashMap<String, Class> genericSupplements;

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

	public static HashMap getCoffeeSupplement() {
		if (coffeeSupplements == null) {
			coffeeSupplements = initializeProducts();
		}
		return coffeeSupplements;
	}

	public static HashMap getCocktailSupplement() {
		if (cocktailSupplements == null) {
			cocktailSupplements = initializeProducts();
		}
		return cocktailSupplements;
	}

	public static HashMap getGenericSupplement() {
		if (genericSupplements == null) {
			genericSupplements = initializeProducts();
		}
		return genericSupplements;
	}

	private static HashMap<String, Class> initializeProducts() {
		product = new HashMap<>();
		product.put(Arabic.class.getSimpleName(), Arabic.class.getClass());
		product.put(Brasilian.class.getSimpleName(), Brasilian.class.getClass());
		product.put(Martini.class.getSimpleName(), Martini.class.getClass());
		product.put(Tequila.class.getSimpleName(), Tequila.class.getClass());
		return product;
	}

	
	private static HashMap<String, Class> initializeCoffeeSupplement() {
		coffeeSupplements = new HashMap<>();
		coffeeSupplements.put(Cream.class.getSimpleName(), Cream.class.getClass());
		coffeeSupplements.put(Milk.class.getSimpleName(), Milk.class.getClass());
 		return coffeeSupplements;
	}
	private static HashMap<String, Class> initializeCocktailSupplement() {
		cocktailSupplements = new HashMap<>();
		cocktailSupplements.put(Soda.class.getSimpleName(), Soda.class.getClass());
		cocktailSupplements.put(Appetizer.class.getSimpleName(), Appetizer.class.getClass());
 		return cocktailSupplements;
	}
	private static HashMap<String, Class> initializeGenericSupplement() {
		genericSupplements = new HashMap<>();
		genericSupplements.put(Ice.class.getSimpleName(), Ice.class.getClass());
		return genericSupplements;
	}
	
	
	private static HashMap<String, LJPanel> initializeViews() {
		view = new HashMap<>();
		view.put("welcome", new WelcomeView());
		view.put("selectproduct", new ProductListView());
		view.put("selectsupplement", new SupplementListView());
		view.put("precheckout", new SelectView());
		view.put("checkbill", new BillView());
		view.put("paymentmethod", new PaymentMethodView());
		view.put("goodbye", new GoodbyeView());
		return view;
	}

}
