package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.DTO.SaleInformationDTO;

/**
 * Interface for logging how much money has been paid to the register.
 */
public interface RegisterObserver {
    /**
     * Called when a sale is finished and money is paid to the register.
     * @param saleinformation DTO containing the total amount paid to the register.
     */
    void updateAmountPaidToRegister(SaleInformationDTO saleinformation);
}
