package se.kth.iv1350.processsale.model;
import DTO.*; //ItemDTO and SaleInformationDTO
import java.time.LocalTime;

/**
 * A sale of one or more items to a customer.
 */
public class Sale {
    private LocalTime saleTime;
    private int totalPrice;
    private double totalTaxAmount;
    private int amountPaid;
    private ItemDTO[] itemDTOArray = new ItemDTO[5];
    private SaleInformationDTO saleInformationDTO;
    
    /**
     * Creates an instance of the class and sets the time for the start of the sale.
     */
    public Sale (){
        setTimeOfSale();
    }
    private void setTimeOfSale(){
        saleTime = LocalTime.now();
    }
    private LocalTime getSaleTime(){
        return saleTime;
    }
    /**
     * Registers item as scanned and to be purchased by the customer. 
     * No error handling is implemented.
     * @param itemDTO Registered item.
     */
    public void addItem(ItemDTO itemDTO){
        if(checkIfArrayFull())
            enlargenArray();
        addItemToArray(itemDTO);
        updateTotalPrice(itemDTO);
        updateTotalTaxAmount(itemDTO);
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
