package se.kth.iv1350.processsale.integration;

import DTO.ItemDTO;

/**
 * Thrown when the application can't connect to the inventory database.
 */
public class DatabaseConnectionException extends RuntimeException{
    
    
    public DatabaseConnectionException(String msg){
        super(msg);
    }
}
