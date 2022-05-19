package se.kth.iv1350.processsale.integration;

import DTO.*; //ItemDTO and SaleInformationDTO

/**
 * Interface between the controller and external databases, 
 * the latter of which is not implemented.
 */
public class DbHandler {
    private ItemDTO itemDTO;
    private ItemDTO[] inventoryAndAccountingSystems;
    private SaleInformationDTO[] databaseOfSoldItems;
    private CashRegister register;
    /**
     * Creates an instance of the class.
     * @param register CashRegister object.
     */
    public DbHandler(CashRegister register){
        this.register = register;
    }
    /**
     * Finds the DTO associated with the item identifier and returns it.No error handling has been implemented.
     * @param itemIdentifier Identifying code for a specific item.
     * @return Returns itemDTO with data of a specific item. Returns null if item is not found.
     * @throws ItemNotFoundException when no item corresponding 
     * to the identifier is found in the inventory database.
     */
    public ItemDTO lookupOfItem(int itemIdentifier) throws ItemNotFoundException{
        if(itemIdentifier >= 5 || itemIdentifier < 0)
            throw new ItemNotFoundException(itemIdentifier);
        for(int i = 0; i < 5; i++){
            if(inventoryAndAccountingSystems[i].getItemIdentifier() == itemIdentifier){
                return inventoryAndAccountingSystems[i];
            }
        }
        return null;
    }
    /**
     * Prints receipt with times of sale, list of items purchased, total price of items and 
     * amount of tax included in the total price.
     * @param saleInformationDTO DTO containing the info needed in the receipt.
     */
    public void printReceipt(SaleInformationDTO saleInformationDTO){
        Printer printer = new Printer();
        printer.printReceipt(saleInformationDTO);
    }
    /**
     * Stores the data of the finished sale in an array representing an external inventory database.
     * @param saleInformationDTO The DTO with all info regarding the current, finished sale.
     */
    public void updateDatabaseOfSoldItems (SaleInformationDTO saleInformationDTO){
        databaseOfSoldItems[0] = saleInformationDTO;
    }
    /**
     * Initializes fake databases for a test run of the program.
     */
    public void initializeFakeDatabases(){
        inventoryAndAccountingSystems = new ItemDTO[5];
        for(int i = 0; i < 5; i++)
            this.inventoryAndAccountingSystems[i] = new ItemDTO(i);
        databaseOfSoldItems = new SaleInformationDTO[5];
    }
    /**
     * Returns the price of an item.
     * @param itemDTO The item whose price is to be determined.
     * @return The price of the item.
     */
    public int getPrice(ItemDTO itemDTO){
        return itemDTO.getPrice();
    }
    /**
     * Updates the amount of cash in the register according to the total final 
     * price of the items in the sale.
     * @param saleInformationDTO DTO containing data of the finished sale.
     */
    public void updateRegister(SaleInformationDTO saleInformationDTO){
        register.updateRegister(saleInformationDTO);
    }
}
