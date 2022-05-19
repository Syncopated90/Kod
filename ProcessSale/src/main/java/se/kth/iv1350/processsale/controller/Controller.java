package se.kth.iv1350.processsale.controller;

import DTO.ItemDTO;
import DTO.SaleInformationDTO;
import se.kth.iv1350.processsale.integration.DbHandler;
import se.kth.iv1350.processsale.integration.ItemNotFoundException;
import se.kth.iv1350.processsale.model.Sale;

/**
 *Calls between the view and the model and integration layer pass through this class.
 */
public class Controller {
    private Sale sale;
    private DbHandler dbhandler;
    private ItemDTO itemDTO;
    
    /**
     * Creates an instance of the class.
     * @param dbhandler Accesses DbHandler class through this parameter.
     */
    public Controller(DbHandler dbhandler){
        this.dbhandler = dbhandler;
    }
    /**
     * Initiates a sale and creates the necessary object 
     * in the sale layer. 
     */
    public void startSale(){
        sale = new Sale();
    }
    /**
    * Registers an item in the current purchase.
    * @param itemIdentifier Identifier for the item being added to the purchase.
    * @return DTO of the item being added to the purchase.
    * @throws ItemNotFoundException when an item matching the parameter 
    * is not found in the database.
    */
    public ItemDTO scanOfItem(int itemIdentifier) throws IllegalArgumentException{
        try{
            itemDTO = dbhandler.lookupOfItem(itemIdentifier);
        }
        catch(ItemNotFoundException e){
            System.out.println("Developer log message: Error, invalid item identifier: " + itemIdentifier
                    + ", corresponding product not found in database");
            throw new IllegalArgumentException();
        }
        sale.addItem(itemDTO);
        return itemDTO;
    } 
    /**
     * The running total price for all items that have been registered so far.
     * @return The current running total price for all items.
     */
    public int getTotalPrice(){
        return sale.getTotalPrice();
    }
    /**
     * Records how much money was paid by the customer. 
     * @param amountPaid How much money was paid.
     */
    public void registerAmountPaid(int amountPaid) {
        sale.registerAmountPaid(amountPaid);
    }
     /**
     * Calculates how much money should be returned to the customer.
     * @return The amount that should be returned to the customer.
     */ 
    public int calculateChangeToBeReturned(){
        return sale.calculateChangeToBeReturned();
    }
    /**
     * Prints a receipt and creates a log of the sale which is sent to an external database.
     */
    public void endSale(){
        SaleInformationDTO saleinformation = sale.createSaleInformationDTO();
        printReceipt(saleinformation);
        logSale(saleinformation);
    }
    private void printReceipt(SaleInformationDTO saleinformation){
        dbhandler.printReceipt(saleinformation);
    }
    private void logSale(SaleInformationDTO saleinformation){
        dbhandler.updateDatabaseOfSoldItems(saleinformation);
        
    }

    public double calculateTotalTaxAmount() {
        return sale.getTotalTaxAmount();
    }
}
