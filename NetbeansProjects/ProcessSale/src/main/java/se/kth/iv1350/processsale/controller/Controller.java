package se.kth.iv1350.processsale.controller;

import se.kth.iv1350.processsale.DTO.ItemDTO;
import se.kth.iv1350.processsale.DTO.SaleInformationDTO;
import se.kth.iv1350.processsale.integration.DatabaseConnectionException;
import se.kth.iv1350.processsale.integration.DbHandler;
import se.kth.iv1350.processsale.integration.ItemNotFoundException;
import se.kth.iv1350.processsale.integration.RegisterObserver;
import se.kth.iv1350.processsale.model.Sale;

/**
 *Calls between the view and the model and integration layer pass through this class.
 */
public class Controller {
    private Sale sale;
    private DbHandler dbhandler;
    private ItemDTO itemDTO;
    private SaleInformationDTO saleinformation;
    
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
    * @throws IllegalArgumentException when an item matching the parameter 
    * is not found in the database.
    * @throws RuntimeException when database can't be reached.
    */
    public ItemDTO scanOfItem(int itemIdentifier) throws IllegalArgumentException{
        try{
            itemDTO = dbhandler.lookupOfItem(itemIdentifier);
            sale.addItem(itemDTO);
            
        }
        catch(ItemNotFoundException ine){
            System.out.println("Developer log message: " + ine.getMessage());
            String message = Integer.toString(ine.getItemNotFound());
            throw new IllegalArgumentException(message);
        }
        catch(DatabaseConnectionException dce){
            System.out.println("Developer log message: " + dce.getMessage());
            throw new RuntimeException();
        }
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
        saleinformation = sale.createSaleInformationDTO();
        printReceipt(saleinformation);
        logSale(saleinformation);
        
    }
    private void printReceipt(SaleInformationDTO saleinformation){
        dbhandler.printReceipt(saleinformation);
    }
    private void logSale(SaleInformationDTO saleInformation){
        dbhandler.updateDatabaseOfSoldItems(saleInformation);
        dbhandler.updateRegister(saleInformation);
    }
    /**
     * Calculates the total tax amount included in the current total price.
     * @return The current total amount of tax to be paid.
     */
    public double calculateTotalTaxAmount() {
        return sale.getTotalTaxAmount();
    }
    /**
     * Adds a register observer to the list in dbhandler 
     * which is updated when money is paid to the register.
     * @param regObs The observer object to be added.
     */
    public void addRegisterObserver(RegisterObserver regObs){
        dbhandler.addRegisterObserver(regObs);
    }
}
