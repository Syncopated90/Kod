package DTO;

/**
 *Container for all data regarding one item.
 */
public final class ItemDTO {
    private final int itemIdentifier;
    private static final double TAX_RATE = 0.25;
    private static final String NAME = "itemName"; 
    private final int price;
    private final String itemDescription = "Description of item.";
    private final int PRICE_MULTIPLIER = 100;
    private final int MINIMUM_PRICE_OF_ITEM = 20;
    /**
     * Creates an instance of the class from the item's identifying code.
     * @param itemIdentifier The identifying code for the specific item. 
     */
    public ItemDTO(int itemIdentifier){
        this.itemIdentifier = itemIdentifier;
        this.price = (itemIdentifier * PRICE_MULTIPLIER) + MINIMUM_PRICE_OF_ITEM;
    }
    /**
     * Constructor which takes an itemDTO object and creates a copy of it.
     * @param itemDTOToCopy the DTO  to be copied
     */
    public ItemDTO(ItemDTO itemDTOToCopy){
        this.itemIdentifier = itemDTOToCopy.getItemIdentifier();
        this.price = itemDTOToCopy.getPrice();
    }
    /**
     * Returns the item identifier for the item this object contains data of.
     * @return The identifier for the item represented by the DTO.
     */
    public int getItemIdentifier(){
        return this.itemIdentifier;
    }
    /**
     * Returns the tax rate of the item represented by the DTO.
     * @return Tax rate of the item.
     */
    public double getTaxRate(){
        return this.TAX_RATE;
    }
    /**
     * Returns the name of the item represented by the DTO.
     * @return The name of the item.
     */
    public String getItemName(){
        return this.NAME; 
    }/**
     * Returns the price of the item represented by the DTO.
     * @return The price of the item.
     */
    public int getPrice(){
        return this.price;
    }
    /**
     * Returns the description of the current item.
     * @return String containing the item description.
     */
    public String getItemDescription(){
        return this.itemDescription;
    }
}
