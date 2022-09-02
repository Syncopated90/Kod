public class Main{
	public static void main(String[] args){
		Interfacetest it = new Interfacetest();
		it.setLogger(new ConsoleLogger());
		it.logNumber(5);
	}
}



