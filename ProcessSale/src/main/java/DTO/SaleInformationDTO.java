package DTO;

import java.time.LocalTime;

/**
 * Class containing all the data of the finished sale.
 */
public class SaleInformationDTO {
    private final int totalPrice;
    private final LocalTime timeOfSale;
    private final ItemDTO[] itemDTOArray;
    private final double taxAmount;
    private final int amountPaid;
    /**
     * Creates a DTO object with information about the concluded sale.
     * @param totalPrice The total price of all items registered.
     * @param timeOfSale The time of sale.
     * @param itemDTOArray An array with all the items sold.
     * @param taxAmount The amount of tax included in the total price.
     * @param amountPaid How much money the customer paid.
     */
    public SaleInformationDTO(int totalPrice, LocalTime timeOfSale, ItemDTO[] itemDTOArray
            , double taxAmount, int amountPaid){
        this.totalPrice = totalPrice;
        this.timeOfSale = timeOfSale;
        this.itemDTOArray = itemDTOArray;
        this.taxAmount = taxAmount;
        this.amountPaid = amountPaid;
    }
    /**
     * Returns the total price for all items in the completed sale.
     * @return Total price for all items in the sale.
     */
    public int getTotalPrice(){
        return this.totalPrice;
    }
    /**
     * Returns the time of initiation for the completed sale.
     * @return Start time of the sale.
     */
    public LocalTime getTimeOfSale(){
        return this.timeOfSale;
    }/**
     * Returns array with itemDTOs of all items bought in the sale.
     * @return ItemDTO array containing all items bought in the sale.
     */
    public ItemDTO[] getItemDTOArray(){
        return this.itemDTOArray;
    }
    /**
     * Returns the tax part of the total price.
     * @return How much tax was included in the total price.
     */
    public double getTaxAmount(){
        return this.taxAmount;
    }/**
     * Returns how much the customer paid.
     * @return How much money the customer paid.
     */
    public int getAmountPaid(){
        return this.amountPaid;
    }
}
