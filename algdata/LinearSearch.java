import java.util.Random;
class LinearSearch{
	public void unsortedBenchmark(){
		Random random = new Random();
		int n = 100;
		int key;
		long searchTime = 0;
		boolean dummy;
		long t0, t1, dummyTime, newTime;
		int[] array;
		while(n < 51200){
			t0 = System.nanoTime();
			for(int i = 0; i < 5000; i++){
				array = fillArray(n);
				key = random.nextInt(100);
				dummy = search_unsorted(array, key);
			}
			t1 = System.nanoTime();
			searchTime += (t1 - t0);
			t0 = System.nanoTime();
			for(int i = 0; i < 5000; i++){
				array = fillArray(n);
				key = random.nextInt(100);
			}
			dummyTime = System.nanoTime() - t0;
			newTime = searchTime - dummyTime;
			System.out.println("Total search time for n = " + n + ": " + newTime);
			n *= 2;
		}
	}
	public static boolean search_unsorted(int[] array, int key) {
		for (int index = 0; index < array.length ; index++) {
			if (array[index] == key)
				return true;
		}
		return false;
	}
	public int[] fillArray(int n){
		int[] array = new int[n];
		Random random = new Random();
		for(int i = 0;i < array.length-1; i++)
			array[i] = random.nextInt(100);
		return array;
	}
}