import java.util.Scanner;
import java.util.Random;
class StartStatic{
	Item[] items;

	public void StartStatic(){
	}
	public void run(){
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		items = new Item[3];
		int total = 0;
		Calculator calculator;

		for(int i = 0; i < 49; i++){
			items[0] = new Item(random.nextInt(1000000));
			items[1] = new Item(random.nextInt(1000000));
			items[2] = new Item(ItemType.ADD);
			calculator = new Calculator(items);
			calculator.run();
		}
	}
}