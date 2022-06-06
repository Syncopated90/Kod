package se.kth.iv1350.processsale.model;

import se.kth.iv1350.processsale.DTO.ItemDTO;
import se.kth.iv1350.processsale.DTO.SaleInformationDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class SaleTest {
    private Sale sale;
    private ItemDTO itemDTO;
    private ItemDTO[] itemDTOArray;
    private SaleInformationDTO saleinfoDTO;
    int testItemIdentifier = 2;
    int AMOUNT_PAID = 500;
    int EXPECTED_CHANGE_AMOUNT = 280;
    double EXPECTED_TAX_AMOUNT = 55;
    
    @BeforeEach
    public void setUp() {
        sale  = new Sale();
        itemDTO = new ItemDTO(testItemIdentifier);
    }
    
    @AfterEach
    public void tearDown() {
        sale = null;
        itemDTO = null;
        itemDTOArray = null;
        saleinfoDTO = null;
    }
    @Test 
    public void testAddITem(){
        sale.addItem(itemDTO);
        saleinfoDTO = sale.createSaleInformationDTO();
        itemDTOArray = saleinfoDTO.getItemDTOArray();
        assertTrue(itemDTO.equals(itemDTOArray[0]), 
                "Item added is not the same as the item found in the array.");
    }
    @Test
    public void testCheckIfItemAlreadyRegistered() {
        sale.addItem(itemDTO);
        assertTrue(sale.checkIfItemAlreadyRegistered(testItemIdentifier), 
            "An item with the expected itemIdentifier was not added to the itemDTOArray.");
    }
    @Test
    public void testGetTotalTaxAmount() {
        sale.addItem(itemDTO);
        assertTrue(sale.getTotalTaxAmount() == EXPECTED_TAX_AMOUNT, 
            "Produced tax amount and expected amount are not the same");
    }
    @Test
    public void testCalculateChangeToBeReturned() {
        sale.addItem(itemDTO);
        sale.registerAmountPaid(AMOUNT_PAID);
        assertTrue(sale.calculateChangeToBeReturned() == EXPECTED_CHANGE_AMOUNT, 
            "Actual change amount differed from expected change amount.");
    }
    
}
