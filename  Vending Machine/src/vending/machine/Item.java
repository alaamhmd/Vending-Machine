
package vending.machine;


//dooooone

public enum Item {
    CANDY ("Candy",10),
    SNACK ("Snack",50),
    NUTS ("Nuts",90),
    COKE("Coke", 25),
    PEPSI("Pepsi", 35),
    SODA("Soda", 45); 
     private String name;
     private int price;
     private Item(String name, int price){
         this.name = name;
         this.price = price;
     } 
     public String GetName(){
         return name; 
     } 
     public long GetPrice(){
         return price; 
     }

   
}

    

