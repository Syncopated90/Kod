package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.DTO.SaleInformationDTO;
import se.kth.iv1350.processsale.integration.RegisterObserver;

/**
 * Displays the total amount paid to the register since the program started.
 */
public class TotalRevenueView implements RegisterObserver {
    private int amountPaidToRegister;
    
    @Override
    public void updateAmountPaidToRegister(SaleInformationDTO saleinformation){
        amountPaidToRegister += saleinformation.getTotalPrice();
        System.out.println("View Observer: Total amount paid to register since start of prgram: " 
                + amountPaidToRegister);
    };
}
