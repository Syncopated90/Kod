package se.kth.iv1350.processsale.integration;

/**
 * Exception thrown when an item matching an item identifier 
 * is not found in the inventory database.
 */
public class ItemNotFoundException extends Exception{
    private final int itemNotFoundIdentifier;
    /**
     * Creates an instance of the class.
     * @param itemNotFoundIdentifier itemIdentifier missing from the inventory.
     */
    public ItemNotFoundException(int itemNotFoundIdentifier){
        super("No item matching " +itemNotFoundIdentifier + " was found in the inventory.");
        this.itemNotFoundIdentifier = itemNotFoundIdentifier;
    }
    /**
     * Get method for item identifier with no corresponding item in the database.
     * @return int itemIdentifier not corresponding to any item in the database. 
     */
    public int getItemNotFound(){
        return this.itemNotFoundIdentifier;
    }
}
