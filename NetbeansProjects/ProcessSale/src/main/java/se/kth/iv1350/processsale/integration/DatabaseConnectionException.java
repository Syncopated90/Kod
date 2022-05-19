package se.kth.iv1350.processsale.integration;

/**
 * Exception thrown when the application can't connect to the inventory database.
 */
public class DatabaseConnectionException extends RuntimeException{
    
    /**
     * Creates an instance of the class.
     * @param msg Message to be passed on to the method that catches the exception.
     */
    public DatabaseConnectionException(String msg){
        super(msg);
    }
}
