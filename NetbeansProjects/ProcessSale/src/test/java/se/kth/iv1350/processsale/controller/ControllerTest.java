package se.kth.iv1350.processsale.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.processsale.DTO.ItemDTO;
import se.kth.iv1350.processsale.DTO.SaleInformationDTO;
import se.kth.iv1350.processsale.integration.CashRegister;
import se.kth.iv1350.processsale.integration.DbHandler;
import se.kth.iv1350.processsale.model.Sale;

public class ControllerTest {
    private Sale sale;
    private DbHandler dbhandler;
    private ItemDTO itemDTO;
    private ItemDTO itemWithQuantityOfTwo;
    private ItemDTO[] itemDTOArray;
    private SaleInformationDTO saleinformation;
    private final int ITEM_IDENTIFIER = 2;
    private final int EXPECTED_QUANTITY = 2;
    
    @BeforeEach
    public void setUp()throws Exception {
        sale = new Sale();
        dbhandler = new DbHandler(new CashRegister());
        dbhandler.initializeFakeDatabases();
        itemDTO = dbhandler.lookupOfItem(ITEM_IDENTIFIER);
        itemWithQuantityOfTwo = new ItemDTO(itemDTO, 1);
    }
    
    @AfterEach
    public void tearDown() {
        sale = null;
        dbhandler = null;
        itemDTO = null;
        itemDTOArray = null;
        saleinformation = null;
    }
    
    @Test
    public void testScanOfItemWithPrice(){
        sale.addItem(itemDTO);
        assertTrue(sale.getTotalPrice() == itemDTO.getPrice() , 
                "Total price of sale with one item differs from price of the same single item");
    }
    
    @Test
    public void testScanOfItem(){
        sale.addItem(itemDTO);
        saleinformation = sale.createSaleInformationDTO();
        itemDTOArray = saleinformation.getItemDTOArray();
        assertTrue(itemDTOArray[0].equals(itemDTO) , 
                "Scanned item does not equal the item found in the saleinformationDTO array.");
    }
    @Test
    public void testScanOfItemWithQuantityOfTwo(){
        sale.addItem(itemWithQuantityOfTwo);
        saleinformation = sale.createSaleInformationDTO();
        itemDTOArray = saleinformation.getItemDTOArray();
        assertTrue(itemDTOArray[0].getQuantity() == EXPECTED_QUANTITY , 
                "Item quantity is not two.");
    }
}
