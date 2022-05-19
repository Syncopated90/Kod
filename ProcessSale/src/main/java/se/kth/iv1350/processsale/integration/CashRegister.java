package se.kth.iv1350.processsale.integration;

import DTO.SaleInformationDTO;

/**
 * Class representing the register at a point of sale.
 */
public class CashRegister {
    private static final int CASH_IN_REGISTER_AT_START_OF_SHIFT = 5000;
    private int amountOfCashInRegister;

    /**
     * Creates an instance of the class.
     */
    public CashRegister(){
        this.amountOfCashInRegister = CASH_IN_REGISTER_AT_START_OF_SHIFT;
    }
    /**
     * Updates the amount of money in the register.
     * @param saleInformationDTO Contains all the info of a finished sale
     */
    public void updateRegister(SaleInformationDTO saleInformationDTO){
        this.amountOfCashInRegister -= saleInformationDTO.getTotalPrice();
    }
}
