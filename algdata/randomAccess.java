import java.util.Random;

class randomAccess
{
	public static void main(String[] args){
		System.out.println("n = 1, resolution " + access(1) + " nanoseconds");
		System.out.println("n = 10, resolution " + access(10) + " nanoseconds");
		System.out.println("n = 100, resolution " + access(100) + " nanoseconds");
		System.out.println("n = 1000, resolution " + access(1000) + " nanoseconds");
		System.out.println("n = 10 000, resolution " + access(10000) + " nanoseconds");
	}

	private static double access(int n){
		int k = 1_000_000;
		int l = n;

		Random rnd = new Random();
		int[] indx = new int[l];
		for (int i = 0; i < l ; i++)
			indx[i] = rnd.nextInt(n);

		int[] array = new int[n];
		for(int i = 0; i < n; i++)
			array[i] = rnd.nextInt(100);
		int sum = 0;

		long t0 = System.nanoTime();
		for (int j = 0; j < k; j++) {
			for (int i = 0; i < l; i++)
				sum += array[indx[i]];
		}

		long t_access = (System.nanoTime() - t0);
		t0 = System.nanoTime();

		for (int j = 0; j < k; j++) {
			for (int i = 0; i < l; i++)
				sum += 1;
		}
		long t_dummy = (System.nanoTime() - t0);
		return ((double)(t_access - t_dummy))/((double)k*(double)l);
	}
}