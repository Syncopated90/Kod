import java.util.Random;
class LinearSearch{
	public void Benchmark(){
		Random random = new Random();
		int n = 200;
		int loop = 1000;
		int[] array;
		int[] keys;
		long searchTime = 0;
		double t0, t1;
		boolean dummy;
		double min = Double.POSITIVE_INFINITY;
		Binary binary = new Binary();
		Compare compare = new Compare();
		while(n < 120000){
			array = fillSorted(n);
			keys = fillKeys(loop, n);

			for(int i = 0; i < loop; i++){
				min = Double.POSITIVE_INFINITY;
				t0 = System.nanoTime();
				for(int j = 0; j < keys.length; j++)
					dummy = search_unsorted(array, keys[j]);
				t1 = System.nanoTime();
				if((t1 - t0) < min)
					min = (t1 - t0);
			}
			System.out.println("Minimum search time for n = " + n + ": " + min/1000);
			for(int i = 0; i < loop; i++){
				min = Double.POSITIVE_INFINITY;
				t0 = System.nanoTime();
				for(int j = 0; j < keys.length; j++)
					dummy = search_sorted(array, keys[j]);
				t1 = System.nanoTime();
				double temp = (t1 - t0);
				if(temp < min)
					min = temp;
			}
			System.out.println("Minimum search time for n = " + n + ": " + min/1000 + " with a sorted algorithm");
			for(int i = 0; i < loop; i++){
				min = Double.POSITIVE_INFINITY;
				t0 = System.nanoTime();
				for(int j = 0; j < keys.length; j++)
					dummy = binary.searchBinary(array, keys[j]);
				t1 = System.nanoTime();
				double temp = (t1 - t0);
				if(temp < min)
					min = temp;
			}
			System.out.println("Minimum search time for n = " + n + ": " + min/1000 + " with a binary algorithm");
			int dummyInt = 0;
			for(int i = 0; i < loop; i++){
				min = Double.POSITIVE_INFINITY;
				t0 = System.nanoTime();
				dummyInt = compare.compare(array, keys);
				t1 = System.nanoTime();
				double temp = (t1 - t0);
				if(temp < min)
					min = temp;
			}
			System.out.println("Minimum search time for n = " + n + ": " + min/1000 + " with the best algorithm");

			n *= 2;
		}
	}

	public static boolean search_unsorted(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key)
					return true;
		}
		return false;
	}
	public static boolean search_sorted(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key)
					return true;
			if(array[i] > key)
					break;
		}
		return false;
	}
	public static int[] fillSorted(int n) {
		Random rnd = new Random();
		int[] array = new int[n];
		int nxt = 0;
		for (int i = 0; i < n ; i++) {
			nxt += rnd.nextInt(10) + 1;
			array[i] = nxt;
		}
		return array;
	}
	private static int[] fillKeys(int length, int n){
		Random random = new Random();
		int[] index = new int[length];
		for(int i = 0; i < length; i++)
			index[i] = random.nextInt(n * 5);
		return index;
	}
}
