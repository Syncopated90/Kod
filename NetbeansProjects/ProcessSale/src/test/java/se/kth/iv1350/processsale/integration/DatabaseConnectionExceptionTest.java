package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.DTO.ItemDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class DatabaseConnectionExceptionTest {
    private ItemDTO[] inventoryAndAccountingSystems;
    private DbHandler dbhandler;
    CashRegister register;
    String expectedMessage = "Can't access database.";
    int identifierProducingDatabaseException = 9;
    int identifierNotProducingDatabaseException = 2;
    
    @BeforeEach
    public void setUp() {
        register = new CashRegister();
        dbhandler = new DbHandler(register);
        dbhandler.initializeFakeDatabases();
    }
    
    @AfterEach
    public void tearDown() {
        inventoryAndAccountingSystems = null;
        register = null;
        dbhandler = null;
    }
    
    @Test
    public void testLookupOfItemTriggeringDatabaseConnectionException(){
        try{
            dbhandler.lookupOfItem(identifierProducingDatabaseException);
            fail();
        }
        catch(DatabaseConnectionException dce){
            assertTrue(true, "Expected exception was not thrown.");
        }
        catch(Exception e){
            fail();
        }
    }

    
    @Test
    public void testDatabaseConnectionExceptionErrorMessage() {
        try{
            dbhandler.lookupOfItem(identifierProducingDatabaseException);
        }
        catch(DatabaseConnectionException dce){
            assertTrue(expectedMessage.equals(dce.getMessage()), 
                    "DatabaseConnectionException did not contain expected error message");
        }
        catch(Exception e){
            fail("This identifier should not produce an exception.");
        }
    }
    @Test
    public void testLookupOfItemNotThrowingDatabaseConnectionException(){
        try{
            dbhandler.lookupOfItem(identifierNotProducingDatabaseException);
        }
        catch(DatabaseConnectionException dce){
            fail("This identifier should not produce an exception.");
        }
        catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    
}
