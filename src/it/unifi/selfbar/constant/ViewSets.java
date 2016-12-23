package it.unifi.selfbar.constant;

import java.util.HashMap;

import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.graphic.view.*;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.*;

public class ViewSets {

	private static  HashMap<String, LJPanel> view;
	private static  HashMap<String, Class> product;
	private static  HashMap<String, Class> coffeeSupplements;
	private static  HashMap<String, Class> cocktailSupplements;
	private static  HashMap<String, Class> genericSupplements;

	public static  HashMap<String,LJPanel> getView() {
		if (view == null) {
			view = initializeViews();
		}
		return view;
	}

	public static  HashMap<String,Class> getProduct() {
		if (product == null) {
			product = initializeProducts();
		}
		return product;
	}

	public static  HashMap<String,Class> getCoffeeSupplement() {
		if (coffeeSupplements == null) {
			coffeeSupplements = initializeProducts();
		}
		return coffeeSupplements;
	}

	public static  HashMap<String,Class> getCocktailSupplement() {
		if (cocktailSupplements == null) {
			cocktailSupplements = initializeProducts();
		}
		return cocktailSupplements;
	}

	public static  HashMap<String,Class> getGenericSupplement() {
		if (genericSupplements == null) {
			genericSupplements = initializeProducts();
		}
		return genericSupplements;
	}

	private static  HashMap<String, Class> initializeProducts() {
		product = new HashMap<>();
		product.put(Arabic.class.getSimpleName(), Arabic.class.getClass());
		product.put(Brasilian.class.getSimpleName(), Brasilian.class.getClass());
		product.put(Martini.class.getSimpleName(), Martini.class.getClass());
		product.put(Tequila.class.getSimpleName(), Tequila.class.getClass());
		return product;
	}

 
	
	
	private static  HashMap<String, LJPanel> initializeViews() {
		view = new HashMap<>();
		view.put("welcome", new WelcomeView());
		view.put("selectproduct",new ProductListView());
 
		return view;
	}

}
