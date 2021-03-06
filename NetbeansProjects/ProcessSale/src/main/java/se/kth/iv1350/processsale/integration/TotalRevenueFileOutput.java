package se.kth.iv1350.processsale.integration;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import se.kth.iv1350.processsale.DTO.SaleInformationDTO;

/**
 * Writes total amount paid to the register since the program started to a file.
 */
public class TotalRevenueFileOutput implements RegisterObserver{
    private String logMessage = "Total amount paid to the register since program started: ";
    private PrintWriter revenueLogger;
    private int totalAmount;
    /**
     * Creates an instance of the class, initiates objects necessary to write to a txt file.
     */
    public TotalRevenueFileOutput(){
        try {
            revenueLogger = new PrintWriter(new FileWriter(("RevenueLog.txt"), true));
        } catch (IOException ex) {
            System.out.println("Developer log: TotalRevenueFileOutput failed to create txt log");
        }
    }
    /**
     * Updates RevenueLog.txt with the amount paid to the register after a finished sale.
     * @param saleinformation The DTO containing the final amount paid.
     */
    @Override
    public void updateAmountPaidToRegister(SaleInformationDTO saleinformation){
        totalAmount += saleinformation.getTotalPrice();
        revenueLogger.println(logMessage + totalAmount);
        revenueLogger.flush();
    }
}
