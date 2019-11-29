
package vending.machine;
import java.util.*;

//dooooone


public class VendingMachine {

    

     private float total;
     private float CashIn;
     private Item RequstedItem;

    private Inventory<Item> Item_In_Inventory = new Inventory<Item>();  



    private Inventory<Coin> cash_of_Inventory = new Inventory<Coin>();
   
   
    public void insertCoin(Coin coin) {
        CashIn = CashIn + coin.getCategory();
        cash_of_Inventory.add(coin);
    }
   
    public float ChooseItems(Item item) {
        if(Item_In_Inventory.available(item)){
            RequstedItem= item;
            return RequstedItem.GetPrice();
        }
        else{
        throw new SoldOutException("Sold Out");
        }
    
   

   
       
    private Item GroupSelectedItems() throws NoChangeAvailableException, NotSufficientPaidException{
        if(EnoughCash()){
            if(ChangeAvailable()){
                Item_In_Inventory.remove(RequstedItem);
                return RequstedItem;
            }           
            throw new NoChangeAvailableException("No  change Available in  The Inventory");
           
        }
        float TheChange = RequstedItem.GetPrice()- CashIn;
        throw new NotSufficientPaidException("Price not full paid, remaining : ",  TheChange );
    }
     private boolean ChangeAvailable(){
        return AvaliableChange(CashIn - RequstedItem.GetPrice());
    }
        private boolean AvaliableChange(float cash){
        boolean ThereIsChange = true;
        try{
            getChange(cash);
        }catch(NoChangeAvailableException x){
            return ThereIsChange = false;
        }
       
        return ThereIsChange;
    }
     private boolean EnoughCash() {
        if(CashIn >= RequstedItem.GetPrice()){
            return true;
        }
        return false;
    }
   
    private ArrayList<Coin> ReturnChange() {
        float change = CashIn - RequstedItem.GetPrice();
        ArrayList<Coin> Change = getChange(change);
        Remain(Change);
        CashIn = 0;
        RequstedItem = null;
        return Change;
    }
   
    public ArrayList<Coin> refund(){
        ArrayList<Coin> refund = getChange(CashIn);
        Remain((ArrayList) refund);
        CashIn = 0;
        RequstedItem = null;
        return (ArrayList<Coin>) refund;
    }
   
   
    

      
    private ArrayList<Coin> getChange(float cash) throws NotSufficientPaidException{
        ArrayList<Coin> change = (ArrayList<Coin>) Collections.EMPTY_SET;
       
        if(cash> 0){
            change = new ArrayList<Coin>();
            float RemainCash = cash;
            while(RemainCash > 0){
                if(RemainCash >= Coin.PENNY.getCategory()&& cash_of_Inventory.available(Coin.PENNY)) {
                    change.add(Coin.PENNY);
                    RemainCash = RemainCash- Coin.PENNY.getCategory();
                   
                }
                else if(RemainCash >= Coin.NICKLE.getCategory()&& cash_of_Inventory.available(Coin.NICKLE)) {
                    change.add(Coin.NICKLE);
                    RemainCash = RemainCash - Coin.NICKLE.getCategory();
                }
                  else if(RemainCash >= Coin.DIME.getCategory()&& cash_of_Inventory.available(Coin.DIME)) {
                   change.add(Coin.DIME);
                    RemainCash = RemainCash - Coin.DIME.getCategory();
                   
                }
                      else if(RemainCash >= Coin.HALF.getCategory()&& cash_of_Inventory.available(Coin.HALF)) {
                   change.add(Coin.HALF);
                    RemainCash = RemainCash - Coin.HALF.getCategory();
                   
                }
                 
                   
                
                else if(RemainCash >= Coin.QUARTER.getCategory()&& cash_of_Inventory.available(Coin.QUARTER)){
                    change.add(Coin.QUARTER);
                    RemainCash = RemainCash - Coin.QUARTER.getCategory();
                   
                }
              
            else if(RemainCash >= Coin.DOLLAR.getCategory()&& cash_of_Inventory.available(Coin.DOLLAR)) {
                    change.add(Coin.DOLLAR);
                    RemainCash = RemainCash - Coin.DOLLAR.getCategory();
                   
                }
            else if(RemainCash >= Coin.DOLLARS.getCategory()&& cash_of_Inventory.available(Coin.DOLLARS)) {
                    change.add(Coin.DOLLARS);
                    RemainCash = RemainCash - Coin.DOLLARS.getCategory();
                   
                }
                else{
                    throw new NoChangeAvailableException("No Change Available");
                }
            }
        }
       
        return change;
    }
    public float getTotal(){
        return total;
    }
   

       
    public void DisplayBill(){
        System.out.println("Total Sales : " + total);
        System.out.println("Remain  Items In Inventory : " + Item_In_Inventory);
        System.out.println("Remain Cash In  Inventory : " + cash_of_Inventory);
    }   
   
  
   
   
 

    private void Remain(ArrayList change) {
        for(Object c : change){
            cash_of_Inventory.remove((Coin) c);
        }
    }
   
    
        
    public void reset(){
        cash_of_Inventory.clear();
        Item_In_Inventory.clear();
        total = 0;
        RequstedItem = null;
        CashIn = 0;
    } 
   
}




    

