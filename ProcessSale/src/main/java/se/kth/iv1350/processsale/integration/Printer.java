
package se.kth.iv1350.processsale.integration;

import DTO.ItemDTO;
import DTO.SaleInformationDTO;

/**
 *Class representing the interface with a receipt printer.
 */
public class Printer {
    /**
     * Prints receipt with times of sale, list of items purchased, total price of items and 
     * amount of tax included in the total price.
     * @param saleInformationDTO 
     */
    public void printReceipt(SaleInformationDTO saleInformationDTO){
        System.out.println("Receipt: ");
        printNameAndPriceOfItems(saleInformationDTO);
        printTotalPriceAndTax(saleInformationDTO);
        System.out.println("Time of sale: " + saleInformationDTO.getTimeOfSale());
    }
    private void printNameAndPriceOfItems(SaleInformationDTO saleInformationDTO){
        int i = 0;
        while(itemExists(saleInformationDTO.getItemDTOArray()[i])){
            System.out.print(saleInformationDTO.getItemDTOArray()[i].getItemName()+ " ");
            System.out.println(saleInformationDTO.getItemDTOArray()[i].getPrice());
            i++;
        }
    }
    private boolean itemExists(ItemDTO itemDTO){
        if(itemDTO != null){
            return true;
        }
        return false;
    }
    private void printTotalPriceAndTax(SaleInformationDTO saleInformationDTO){
        System.out.println("Total price: " + saleInformationDTO.getTotalPrice());
        System.out.println("Total tax: " + saleInformationDTO.getTaxAmount());
    }
}
