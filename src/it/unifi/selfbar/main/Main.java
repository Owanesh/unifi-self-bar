package it.unifi.selfbar.main;

import it.unifi.selfbar.product.*;

import java.util.*;

import it.unifi.selfbar.decorator.*;

public class Main {
	public static void main(String[] args) {
		// Simple product->1.50
		Arabic arabic = new Arabic();
		System.out.println(arabic);

		// milk(arabic)->1.50 + 0.20
		Milk milk = new Milk(arabic);
		System.out.println(milk);

		// milk(milk(arabic))->1.50 + 0.20 + 0.20
		Milk milk2 = new Milk(milk);
		System.out.println(milk2);

		// cream(milk(milk(arabic)))1.50 + 0.20 + 0.20 + 0.20
		Cream cream = new Cream(milk2);
		System.out.println(cream);

		// Compile error OK
		// Appetizer app1 = new Appetizer(arabic);

		// Compile safe OK
		Appetizer app = new Appetizer(new Martini());
	}
}
