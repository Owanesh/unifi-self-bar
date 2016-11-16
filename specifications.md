#Requirements (italian)
Esiste un cliente, che siede ad un TAVOLO
Un tavolo può essere visto come un INSIEME DI ORDINI

Un ordine è ESCLUSIVAMENTE 1 (e una sola) Drink (con eventuali aggiunte)

Un tavolo ha un CONTO
Il CONTO di un tavolo, descrive in dettaglio ogni singolo ordine



#Classes
###Bill
\abstract\Bill
    ```
    private Strategy strategy;
    abstract public pay();
    abstract public print();

    makePaymentTemplate(){
        strategy.discountRequest(this);
        pay();
        print();
    }
    ```
\concrete\BillCard
\concrete\BillCash

###Clients
\concrete\Client
    ```
    private Table table;
    public requestPayment(){
        //table.getBill().getTotal();
        table.getBill().makePaymentTemplate();
    }
    ```

###Table
\concrete\Table
        ```
        private String name;
        private int maxClients;
        private boolena isReserved;
        private List <Orders>
        private Bill
        ```

###Order
\abstract\Order
     ```
     protected Drink drink;
     private List<Supplement> supplements;
     ```

  ```class OrderCoffee extends Order
            private List<SupplementCoffee> ListSupplement```
  ```class OrderCocktail extends Order
            private List<SupplementCocktail> ListSupplement```

###Supplements
abstract\Supplement
|
|
-- abstract\SupplementCoffee
|    - milk
|    - cream
|    - choco
|
|
-- abstract\SupplementCocktail
    - soda
    - appetizer

###Drink
\abstract\Drink

\abstract\Drink\Coffee
    - Brasilian
    - Arabic

\abstract\Drink\Cocktail
    - Martini
    - Long Island
    - Mojito

###Food
\abstract\Food

\abstract\Food\Appetizer
    - Toast

\abstract\Food\FingerFood
    - Olive




 #### Unifi - Development Methodologies
 ##### Busiello Salvatore - Mauro Matteo

