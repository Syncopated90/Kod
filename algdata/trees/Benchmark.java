import java.util.Random;

class Benchmark{
  public static void bench(){
    int n = 1000;
    int loop = 100;
    int[] array;
		int[] keys;
    double t0, t1;

		Binary binary = new Binary();
    while(n < 82000000){
      array = fillSorted(n);
      keys = fillKeys(1000, n);
      BinaryTree tree = new BinaryTree(n/2, n);
      tree.fillTree(n-1);
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < loop; i++){
        boolean dummy = false;
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
      for(int i = 0; i < loop; i++){
        int dummy2 = 0;
				min = Double.POSITIVE_INFINITY;
				t0 = System.nanoTime();
				dummy2 = findTree(tree, keys);
				t1 = System.nanoTime();
				double temp = (t1 - t0);
				if(temp < min)
					min = temp;
			}
			System.out.println("Minimum search time for n = " + n + ": " + min/1000 + " with a binary tree");
      n *= 2;
    }
  }
  public static int findTree(BinaryTree tree, int[] keys){
    int dummy = 0;
    for(int i = 0; i < keys.length; i++){
      dummy += tree.lookup(keys[i]);
    }
    return dummy;
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
