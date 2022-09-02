import java.util.Scanner;
import java.util.Random;
class StartDynamicConst{
	Item[] items;
	int MAX_NUMBER = 5;

	public void run(){
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		items = new Item[149];
		for(int i = 0; i < 100; i++)
			items[i] = new Item(random.nextInt(1000000));
		for(int i = 100; i < 149; i++)
			items[i] = new Item(ItemType.ADD);
		Calculator calculator = new Calculator(items);
		calculator.run();
	}
}