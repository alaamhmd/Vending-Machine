
package vending.machine;

//dooooone


public class SoldOutException extends RuntimeException {
    private static String msg; 
    
    
    public SoldOutException(String string) {
        
            this.msg = string;
    } 
    
    
    @Override 
    
    
    public String getMessage(){ 
        
        
        
        return msg;
    }

    
}
