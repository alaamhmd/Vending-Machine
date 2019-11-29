
package vending.machine;


//doooooone

public class NotSufficientPaidException extends RuntimeException{
    private String msg;
    private float TheChange;
    
    
    public NotSufficientPaidException(String msg, float TheChange) { 
        this.msg = msg; 
        this.TheChange = TheChange;
    }
      @Override 
    public String getMessage(){
        return msg + TheChange;
    }
    public float getTheChange(){
        return TheChange;
    } 
  

    
}
