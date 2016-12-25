package it.unifi.selfbar.constant;

import java.util.ArrayList;
import java.util.HashMap;

import it.unifi.selfbar.graphic.GUIController;
import it.unifi.selfbar.graphic.LJPanel;
import it.unifi.selfbar.graphic.view.*;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.*;

public class AppSettings {

	private static HashMap<String, LJPanel> view;
	private static ArrayList<String> product;
  	private static ArrayList<String> genericDecoration;
	private static ArrayList<String> cocktailDecoration;
	private static ArrayList<String> coffeeDecoration;
	private static ArrayList<String> paymentMethod;

	public static  HashMap<String,LJPanel> getView() {
		if (view == null) {
			view = initializeViews();
		}
		return view;
	}

	public static  ArrayList<String> getProduct() {
		if (product == null) {
			product = initializeProducts();
		}
		return product;
	}
	public static  ArrayList<String> getPaymentMethod() {
		if (paymentMethod == null) {
			paymentMethod = initializePaymentMethod();
		}
		return paymentMethod;
	}

	public static  ArrayList<String> getCoffeeDecoration() {
		if (coffeeDecoration == null) {
			coffeeDecoration = initializeCoffeeDecoration();
		}
		return coffeeDecoration;
	}

	public static  ArrayList<String> getCocktailDecoration() {
		if (cocktailDecoration == null) {
			cocktailDecoration = initializeCocktailDecoration();
		}
		return cocktailDecoration;
	}

	public static  ArrayList<String> getGenericDecoration() {
		if (genericDecoration == null) {
			genericDecoration = initializeProducts();
		}
		return genericDecoration;
	}

	private static  ArrayList<String> initializeCocktailDecoration() {
		cocktailDecoration = new ArrayList<String>();
		cocktailDecoration.add("Soda");
		cocktailDecoration.add("Appetizer");
		return cocktailDecoration;
	}
	private static  ArrayList<String> initializeCoffeeDecoration() {
		coffeeDecoration = new ArrayList<String>();
		coffeeDecoration.add("Milk");
		coffeeDecoration.add("Cream");
		return coffeeDecoration;
	}	

	private static ArrayList<String> initializePaymentMethod(){
		paymentMethod = new ArrayList<String>();
		paymentMethod.add("Money");
		paymentMethod.add("Credit card");
		return paymentMethod;
	}
	
	private static  ArrayList<String> initializeGenericDecoration() {
		genericDecoration = new ArrayList<String>();
		genericDecoration.add("Ice");
		return genericDecoration;
	}
	
	private static  ArrayList<String> initializeProducts() {
		product = new ArrayList<String>();
		product.add("Arabic");
		product.add("Brasilian");
		product.add("Martini");
		product.add("Tequila");
		return product;
	}

 	private static  HashMap<String, LJPanel> initializeViews() {
		view = new HashMap<>();
		view.put("welcome", new WelcomeView());
		view.put("selectproduct",new ProductListView());
		view.put("selectsupplement",new SupplementListView());
		view.put("precheckout",new SelectView());
		view.put("goodbye",new GoodbyeView());
		view.put("paymentmethod",new PaymentMethodView());
		view.put("checkout", new BillView());
		return view;
	}
}