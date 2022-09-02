import java.io.FileWriter;
import java.io.PrintWriter;

public class RunProgramPrinter{
	private String logMessage = "Total amount paid to the register since program started: ";
	private PrintWriter revenueLogger;
	private int totalAmount;

	public void runProgram(int amount){
		try{
			FileWriter fw = new FileWriter("textlog.txt", true);
			PrintWriter revenueLogger = new PrintWriter(fw);
			totalAmount += amount;
			revenueLogger.println(logMessage + totalAmount);
			revenueLogger.flush();
			revenueLogger.close();
		}catch(Exception e){}
		System.out.println("hello world");
	}
}