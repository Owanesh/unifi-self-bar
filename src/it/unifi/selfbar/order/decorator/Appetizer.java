package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.order.Cocktail;

/**
 * @author Busiello & Mauro
 */
public class Appetizer extends CocktailDecorator {

 
		public Appetizer(Cocktail cocktail) throws IllegalArgumentException {
			super(cocktail);
	 	}
		
		@Override
		public double getPrice(){
			return super.getPrice()+getSimplePrice();
		}
		
		@Override
		public double getSimplePrice(){
			return 0.05;
		}


 

}