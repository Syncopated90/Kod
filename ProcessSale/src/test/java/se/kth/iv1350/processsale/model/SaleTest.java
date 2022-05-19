package se.kth.iv1350.processsale.model;

import DTO.ItemDTO;
import DTO.SaleInformationDTO;
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
    double taxAmount;
    double expectedTaxAmount = 55;
    
    @BeforeEach
    public void setUp() {
        sale  = new Sale();
        itemDTO = new ItemDTO(2);
    }
    
    @AfterEach
    public void tearDown() {
        sale = null;
        itemDTO = null;
    }

    @Test
    public void testAddItem() {
    }

    @Test
    public void testGetTotalTaxAmount() {
        sale.addItem(itemDTO);
        taxAmount = sale.getTotalTaxAmount();
        assertTrue(taxAmount == expectedTaxAmount, "Produced tax amount and expected amount are not the same");
        
    }

    @Test
    public void testCalculateChangeToBeReturned() {
    }

    
}
