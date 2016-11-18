#Requirements (italian)
Esiste un cliente, che siede ad un TAVOLO
Un tavolo può essere visto come un INSIEME DI ORDINI

Un ordine è ESCLUSIVAMENTE 1 (e una sola) Drink (con eventuali aggiunte)

Un tavolo ha un CONTO
Il CONTO di un tavolo, descrive in dettaglio ogni singolo ordine



#Classes
###Bill
\abstract\Bill
 
    private Strategy strategy;
    abstract public pay();
    abstract public print();
    private List <Order> orders;
    
    public Bill(){
    	orders= new List<Order>();
    }
    
    public void updateOrder(List<Order> o){
    	orders.append(o);
    }

    makePaymentTemplate(){
        strategy.discountRequest(this);
        pay();
        print();
    }
     
\concrete\BillCard
\concrete\BillCash

###Clients
\concrete\Client
  
    private Table table;
    public Client(){
    	table = new Table();
    }
    public requestOrder(List<Order> order){
    	table.setOrder(order);
    }
    public requestPayment(){
        //table.getBill().getTotal();
        table.getBill().makePaymentTemplate();
    }
 

###Table
\concrete\Table

        private String name;
        private int maxClients;
        private boolean isReserved;
        private Bill bill=new Bill();
        public void setOrder(List<Order> order){
        	if(order.length>0){
        		bill.updateOrder(order);
        	}
        }

###Order
	public interface Order(){
		public Order(Product d, List<Supplement> ls);
		public void addSupplements();
	}
	
And real implementation of Order can be

	class Order implements Order
			private Product product;
            private List<SupplementCoffee> supplement
            public Order(Product d, List<Supplement> ls){
            	this.product=d;
            	supplements=ls;
            }


###Supplements
abstract\Supplement
	
	abstract\SupplementCoffee
	1. Milk
	2. Coffee 
	3. Americano
	
	abstract\SupplementCocktail
    1. soda
    2. appetizer

##Product 
\abstract\ Product
	
	String name;
	double price;
	
	public void setPrice(double p){}
	public double getPrice(){}
	public void setName(String s){}
	public String getName(){}

###Drink
\abstract\Drink

	public class Drink<T extends Supplement> {
	
	}

And real implementation of Drink, using Typecheck, can be

	Coffee<T extends SupplementCoffee> extends Drink<T extends Supplement>
	    1. Brasilian
	    2. Arabic

	Cocktail<T extends SupplementCocktail> extends Drink<T extends Supplement>
	    1. Martini
	    2. Long Island
	    3. Mojito

###Food
\abstract\Food

\abstract\Food\Appetizer
    - Toast

\abstract\Food\FingerFood
    - Olive





 #### Unifi - Development Methodologies
 ##### Busiello Salvatore - Mauro Matteo





COSE DA CHIEDERE ALLA PROFESSORESSA
Noi vogliamo poter sapere alla compilazione se un determinato Drink può ricevere un determinato supplement.
