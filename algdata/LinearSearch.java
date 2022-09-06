import java.util.Random;
class LinearSearch{
	public void Benchmark(){
		Random random = new Random();
		int n = 10000;
		int max = 5000;
		int key;
		boolean dummy;
		long searchTime = 0;
		long t0, dummyTime, newTime;
		int[] array;
		while(n < 1000000){
			array = fillArray(n);
			t0 = System.nanoTime();
			for(int i = 0; i < max; i++){
				key = random.nextInt(n * 10);
				key++;
			}
			dummyTime = (System.nanoTime() - t0);
			t0 = System.nanoTime();
			for(int i = 0; i < max; i++){
				key = random.nextInt(n * 10);
				dummy = search_unsorted(array, key);
			}
			searchTime = (System.nanoTime() - t0);
			searchTime -= dummyTime;
			System.out.println("Total search time for n = " + n + ": " + searchTime);
			array = sorted(n);
			t0 = System.nanoTime();
			for(int i = 0; i < max; i++){
				key = random.nextInt(n * 10);
				dummy = search_sorted(array, key);
			}
			searchTime = (System.nanoTime() - t0);
			searchTime -= dummyTime;
			System.out.println("Total search time for n = " + n + ": " + searchTime + " in a sorted array");
			n *= 2;
		}
	}
	public static boolean search_unsorted(int[] array, int key) {
		for (int index = 0; index < array.length; index++) {
			if (array[index] == key)
				return true;
		}
		return false;
	}
	public static boolean search_sorted(int[] array, int key) {
		for (int index = 0; index < array.length; index++) {
			int target = array[index];
			/*if (target > key)
				return false;*/
			if (target == key)
				return true;

		}
		return false;
	}
	public static int[] fillArray(int n){
		int[] array = new int[n];
		Random random = new Random();
		for(int i = 0;i < array.length-1; i++)
			array[i] = random.nextInt(n);
		return array;
	}
	private static int[] sorted(int n) {
		Random rnd = new Random();
		int[] array = new int[n];
		int nxt = 0;
		for (int i = 0; i < n ; i++) {
			nxt += rnd.nextInt(10) + 1;
			array[i] = nxt;
		}
		return array;
}
}