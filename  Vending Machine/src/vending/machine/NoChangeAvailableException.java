
package vending.machine;

//dooooone


public class NoChangeAvailableException extends RuntimeException{
    private String msg; 
    public NoChangeAvailableException(String string) {
        this.msg = string;
    } 
    @Override public String getMessage(){
        return msg;
    }

    
}
