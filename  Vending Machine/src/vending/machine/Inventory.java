
package vending.machine;
import java.util.*;


//dooooone

public class Inventory<ItemType> {
    private Map<ItemType, Integer> inventory = new HashMap<ItemType, Integer>();
   
    public void add(ItemType item){
        int count = inventory.get(item); 
        inventory.put(item, count+1); 
    } 
     public void insert(ItemType item, int amount) { 
        inventory.put(item, amount);
        
    }
   
    public boolean available(ItemType item){ 
        return getAmount(item) > 0; 
    }
      public void remove(ItemType item) {
        if (available(item)) 
        { 
            int count = inventory.get(item);
            inventory.put(item, count - 1);
        }
    }
    public void clear(){ 
        inventory.clear();
    }
      public int getAmount(ItemType item){
        Integer value = inventory.get(item);

        return value == null? 0 : value ; 

    }

  


   

    
    
}
