package se.kth.iv1350.processsale.model;
import se.kth.iv1350.processsale.DTO.SaleInformationDTO;
import se.kth.iv1350.processsale.DTO.ItemDTO;
import java.time.LocalTime;

/**
 * A sale of one or more items to a customer.
 */
public class Sale {
    private LocalTime saleTime;
    private int totalPrice;
    private double totalTaxAmount;
    private int amountPaid;
    private ItemDTO[] itemDTOArray;
    private SaleInformationDTO saleInformationDTO;
    
    /**
     * Creates an instance of the class and sets the time for the start of the sale.
     */
    public Sale (){
        setTimeOfSale();
        itemDTOArray = new ItemDTO[20];
    }
    private void setTimeOfSale(){
        saleTime = LocalTime.now();
    }
    private LocalTime getSaleTime(){
        return saleTime;
    }
    /**
     * Registers item as scanned and to be purchased by the customer.
     * @param itemDTO Registered item.
     */
    public void addItem(ItemDTO itemDTO){
        if(checkIfArrayFull())
            enlargenArray();
        addItemToArray(itemDTO);
        updateTotalPriceAndTax(itemDTO);
    }
    /**
     * Checks if an item with the same itemIdentifier is already registered. If so it increases 
     * the quantity of the item with one.
     * @param itemIdentifier Item to be checked for.
     * @return Returns true if there was an item with the same itemIdentifier already registered.
     */
    public boolean checkIfItemAlreadyRegistered(int itemIdentifier){
        for(int i = 0; i < itemDTOArray.length; i++){
            if(itemDTOArray[i] != null && itemDTOArray[i].getItemIdentifier() == itemIdentifier){
                itemDTOArray[i] = new ItemDTO(itemDTOArray[i], 1);
                updateTotalPriceAndTax(itemDTOArray[i]);
                return true;
            }
        }
        return false;
    }
    
    private boolean checkIfArrayFull(){
        if(itemDTOArray[itemDTOArray.length - 1] == null)
            return false;
        return true;
    }
    private void enlargenArray(){
        ItemDTO[] newArray = new ItemDTO[itemDTOArray.length + 20];
        java.lang.System.arraycopy(itemDTOArray, 0, newArray, 0, itemDTOArray.length);
        itemDTOArray = newArray;
    }
    private void addItemToArray(ItemDTO itemDTO){
        for(int i = 0; i < itemDTOArray.length; i++){
            if(itemDTOArray[i] == null){
                itemDTOArray[i] = itemDTO;
                return;
            }
        }
    }
    private ItemDTO[] getItemDTOArray(){
        return this.itemDTOArray;
    }
    private void updateTotalPriceAndTax(ItemDTO itemDTO){
        updateTotalPrice(itemDTO);
        updateTotalTaxAmount(itemDTO);
    }
    private void updateTotalPrice(ItemDTO itemDTO){
        totalPrice += itemDTO.getPrice();
    }
    /**
     * The running total price for all items that have been registered so far.
     * @return The current running total price for all items.
     */
    public int getTotalPrice(){
        return totalPrice;
    }
    private void updateTotalTaxAmount(ItemDTO itemDTO){
        totalTaxAmount += calculateTaxAmount(itemDTO);
    }
    /**
     * Returns how much tax is part of the total cost. 
     * @return Total tax amount so far.
     */
    public double getTotalTaxAmount(){
        return totalTaxAmount;
    }
    /**
     * Calculates how much money should be returned to the customer.
     * @return The amount that should be returned to the customer.
     */
    public int calculateChangeToBeReturned(){
        return getAmountPaid() - getTotalPrice();
    }
    /**
     * Records how much money the customer paid.
     * @param amountPaid How much money the customer paid.
     */
    public void registerAmountPaid(int amountPaid){
        this.amountPaid = amountPaid;
    }
    private int getAmountPaid(){
        return this.amountPaid;
    }
    /**
     * Creates a DTO with all info regarding the current sale.
     * @return DTO with info about the current sale.
     */
    public SaleInformationDTO createSaleInformationDTO(){
        saleInformationDTO = new SaleInformationDTO(getTotalPrice(), getSaleTime(), getItemDTOArray(), 
        getTotalTaxAmount(), getAmountPaid());
        return saleInformationDTO;
    }
    
    private double calculateTaxAmount(ItemDTO itemDTO){
        return itemDTO.getPrice() * itemDTO.getTaxRate();
    }
}
