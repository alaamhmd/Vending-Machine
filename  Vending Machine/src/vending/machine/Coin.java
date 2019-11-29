
package vending.machine;


//dooooone

public enum Coin {
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25),
    HALF(50),
    DOLLAR (100),
    DOLLARS (200);
    private int category;
    private Coin(int category){ 
        this.category = category; 
    } 
    public int getCategory(){ 
        return category; 
    }

  
    
}
