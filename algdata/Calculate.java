import java.util.Scanner;

class Calculate{
	public static void main(String[] args){
		Calculate calculate = new Calculate();
		calculate.start();
	}

	public void start(){
		Item[] items;
		items = new Item[3];
		Scanner scanner = new Scanner(System.in);
		System.out.println ("Enter first number: ");
		items[0] = new Item(scanner.nextInt());
		System.out.println ("Enter second number: ");
		items[1] = new Item(scanner.nextInt());
		items[2] = new Item(ItemType.ADD);
		Calculator calculator = new Calculator(items);



		System.out.println("Result of calculation: " + calculator.run());
	}
}