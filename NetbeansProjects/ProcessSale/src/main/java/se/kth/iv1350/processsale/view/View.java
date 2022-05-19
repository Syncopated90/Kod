package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.DTO.ItemDTO;
import se.kth.iv1350.processsale.controller.Controller;
/**
 * Contains dummy code representing the view layer of the program.
 */
public class View {
    private Controller contr;
    private ItemDTO scannedItem;
    static final int AMOUNT_PAID_BY_CUSTOMER = 500;
    
    /**
    *Creates an instance of the class. Also creates a total revenue observer 
    * that shows the total amount paid to the register after every sale.
    *@param contr Takes a controller object as parameter to get access to it.
    */
    public  View (Controller contr){
        this.contr = contr;
        contr.addRegisterObserver(new TotalRevenueView());
    }
    /**
     * Runs through a fake sale.
     */
    public void runFakeSale(){
        contr.startSale();
        System.out.println("A fake sale has started.");
        fakeScanOfItems();
        System.out.println("Three items have been scanned and their info printed.");
        showAmountToBePaid();
        contr.registerAmountPaid(AMOUNT_PAID_BY_CUSTOMER);
        contr.endSale();
        showChangeToReturn();
    }
    private void fakeScanOfItems(){
        for(int i=0; i<3; i++)
            scanItem(i);
        //scanItem(6);
        //scanItem(9);
    }
    private void scanItem(int itemIdentifier){
        try{
            scannedItem = contr.scanOfItem(itemIdentifier);
            printItem(scannedItem);
            printRunningTotal();
        }
        catch(IllegalArgumentException iae){
            showItemNotFoundMessage(iae.getMessage());
            }
        catch(Exception e){
            showErrorMessage();
        }
    }
    private void printItem(ItemDTO scannedItem){
        if(scannedItem == null)
            return;
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
    private void showItemNotFoundMessage(String badItemIdentifier){
        System.out.println("User message: No item matching item identifier " + badItemIdentifier 
                + " was found.");
    }
    private void showErrorMessage(){
        System.out.println("User message: Program error.");
    }
    
}
