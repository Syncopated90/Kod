package se.kth.iv1350.processsale.view;

import DTO.ItemDTO;
import se.kth.iv1350.processsale.controller.Controller;
/**
 * Contains dummy code representing the view layer of the program.
 */
public class View {
    private Controller contr;
    private ItemDTO scannedItem;
    static final int AMOUNT_PAID_BY_CUSTOMER = 500;
    /**
    *Creates an instance of the class. 
    *@param contr Takes a controller object as parameter to get access to it.
    */
    public  View (Controller contr){
        this.contr = contr;
    }
    /**
     * Runs through a fake sale.
     */
    public void runFakeSale(){
        try{
            contr.startSale();
            System.out.println("A fake sale has started.");
            fakeScanOfItems();
        }
            catch(IllegalArgumentException iae){
                showItemNotFoundMessage();
            }
            System.out.println("Three items have been scanned and their info printed.");
            showAmountToBePaid();
            contr.registerAmountPaid(AMOUNT_PAID_BY_CUSTOMER);
            contr.endSale();
            showChangeToReturn();
    }
    private void printItem(ItemDTO scannedItem){
        System.out.println("Item description: " + scannedItem.getItemDescription());
        System.out.println("Price: " + scannedItem.getPrice());
    }
    private void printRunningTotal(){
        System.out.println("Running total: " + contr.getTotalPrice());
        System.out.println("VAT: " + contr.calculateTotalTaxAmount() + "\n");
    }
    private void showAmountToBePaid(){
        System.out.println("Amount to be paid: " + contr.getTotalPrice());
    }
    private void showChangeToReturn(){
        System.out.println("Change to be returned: " + contr.calculateChangeToBeReturned());
    }
    private void showItemNotFoundMessage(){
        System.out.println("POS Error: No item matching this identifier was found.");
    }
    /**
     * @throws IllegalArgumentException when an item matching the parameter is not found in the database.
     */
    private void fakeScanOfItems() throws IllegalArgumentException{
        for(int i=0; i<3; i++){
            scannedItem = contr.scanOfItem(i);
            printItem(scannedItem);
            printRunningTotal();
        }
        scannedItem = contr.scanOfItem(6);
    }
}
