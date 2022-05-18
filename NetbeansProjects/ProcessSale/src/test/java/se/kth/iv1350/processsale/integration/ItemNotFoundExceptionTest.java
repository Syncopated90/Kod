package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.DTO.ItemDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class ItemNotFoundExceptionTest {
    private ItemDTO itemDTO;
    private ItemDTO[] inventoryAndAccountingSystems;
    private DbHandler dbhandler;
    CashRegister register;
    int positiveIdentifierProducingException = 5;
    int negativeIdentifierProducingException = -1;
    int identifierNotProducingException = 4;
    String expectedErrorMessage = "No item matching " + identifierNotProducingException 
            + " was found in the inventory.";
    
    @BeforeEach
    public void setUp() {
        register = new CashRegister();
        dbhandler = new DbHandler(register);
        dbhandler.initializeFakeDatabases();
    }
    
    @AfterEach
    public void tearDown() {
        register = null;
        dbhandler = null; 
        inventoryAndAccountingSystems = null;
        itemDTO = null;
    }

    @Test
    public void testLookupOfItemNotFound() {
        try{
            itemDTO = dbhandler.lookupOfItem(positiveIdentifierProducingException);
            fail("Should produce ItemNotFoundException");
        }
        catch(ItemNotFoundException infe){
            assertTrue(true, "Identifier that should trigger an exception in lookupOfItem did not.");
        }
    }
    @Test
    public void testLookupOfItemNotFoundNegativeIdentifier() {
        try{
            itemDTO = dbhandler.lookupOfItem(negativeIdentifierProducingException);
            fail("Should produce ItemNotFoundException");
        }
        catch(ItemNotFoundException infe){
            assertTrue(true, "Identifier that should trigger an exception in lookupOfItem did not.");
        }
    }
    @Test
    public void testLookupOfItemNotThrowingException(){
        try{
            itemDTO = dbhandler.lookupOfItem(identifierNotProducingException);
        }
        catch(ItemNotFoundException infe){
            fail("This identifier should not make lookupOfItem throw an exception");
        }
    }
    @Test
    public void testCorrectErrorMessage(){
        try{
            itemDTO = dbhandler.lookupOfItem(identifierNotProducingException);
        }
        catch(ItemNotFoundException infe){
            assertTrue(infe.getMessage().equals(expectedErrorMessage), 
                    "Did not produce expected error message");
        }
    }
}
