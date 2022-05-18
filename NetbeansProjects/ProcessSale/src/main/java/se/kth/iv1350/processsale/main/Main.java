package se.kth.iv1350.processsale.main;

import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.integration.CashRegister;
import se.kth.iv1350.processsale.integration.DbHandler;
import se.kth.iv1350.processsale.view.View;

/**
 * Main initiates the code necessary to run the rest of the program.
 */
public class Main {
    /**
     * Main method starts the program.
     * @param args No parameter handling has been implemented.
     */
    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        DbHandler dbhandler = new DbHandler(register);
        dbhandler.initializeFakeDatabases();
        Controller contr = new Controller(dbhandler);
        View view = new View(contr);
        
        view.runFakeSale();
    }
}
