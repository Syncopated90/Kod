public class Interfacetest{
	private Logger logger;
	public void setLogger(Logger logger){
		this.logger = logger;
	}
	public void logNumber(int number){
		logger.log("hello world " + number);
	}
}