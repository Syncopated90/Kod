import java.util.Scanner;
import java.util.Random;
class Calculate{
	public static void main(String[] args){
		Calculate calculate = new Calculate();
		//calculate.startStatic();
		//calculate.startDynamicConst();
		calculate.calcP();
		calculate.benchmark();
	}

	public void startStatic(){
		StartStatic startS = new StartStatic();
		startS.run();
	}

	public void startDynamicConst(){
		StartDynamicConst startDC = new StartDynamicConst();
		startDC.run();
	}
	public void calcP(){
		CalcP calcP = new CalcP();
		calcP.run();
	}
	public void benchmark(){
		int n = 80000;
		Calculate calculate = new Calculate();
		Calculator calculator;
		Random random = new Random();
		long n0, n1, staticTime, n2, dummy, averageStatic, dynamicTime;
		long averageDynamic = 0;
		Item[] items = new Item[3];
		while(n < 5120000){
			n0 = System.nanoTime();
			for(int i = 0; i < n; i++)
				calculate.startStatic();
			n1 = System.nanoTime();
			staticTime = n1 - n0;
			for(int i = 0; i < n; i++){
				items[0] = new Item(random.nextInt(1000000));
				items[1] = new Item(random.nextInt(1000000));
				items[2] = new Item(ItemType.ADD);
				calculator = new Calculator(items);
			}
			n2 = System.nanoTime();
			dummy = n2 - n1;
			staticTime = staticTime - dummy;
			//averageStatic = (staticTime - dummy)/n;

			System.out.println("Calculation time for static stack for n =  " + n + ": " + staticTime);
			//n = n / 100;
			n0 = System.nanoTime();
			for(int i = 0; i < n; i++)
				calculate.startDynamicConst();
			n1 = System.nanoTime();
			dynamicTime = n1 - n0;
			for(int i = 0; i < n; i++){
				items[0] = new Item(random.nextInt(1000000));
				items[1] = new Item(random.nextInt(1000000));
				items[2] = new Item(ItemType.ADD);
				calculator = new Calculator(items);
			}
			n2 = System.nanoTime();
			dummy = n2 - n1;
			//averageDynamic = (dynamicTime - dummy)/n;
			dynamicTime = dynamicTime - dummy;
			//n *= 100;
			System.out.println("Calculation time for dynamic stack for n = " + (n) + ": " + dynamicTime);
			n *= 2;
		}

	}
}