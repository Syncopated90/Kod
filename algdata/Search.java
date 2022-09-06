import java.util.Random;
class Search{
	public static void main(String[] args){
		int k = 5000; //m är antalet nycklar, n är storleken på arrayen och k är antalet varv som nya arrayer
		int m = 10;//och nycklar slumpas fram och sökningen görs. m måste vara mindre än n.
		int n = 1000;
		long t_total = 0;
		int sum = 0;
		Random rnd = new Random();
		int[] keys = new int[m];
		int[] array = new int[n];
		for(int h = 0; h < 6; h++){
			keys = new int[m];
			array = new int[n];
		for (int j = 0; j < k; j++) {
			for(int i = 0; i < m; i++)
				keys[i] = rnd.nextInt(10 * n);
			for(int i = 0; i < n; i++)
				array[i] = rnd.nextInt(10 * n);
			long t0 = System.nanoTime();
			for (int ki = 0; ki < m; ki++) {
				int key = keys[ki];
				for (int i = 0; i < n ; i++) {
					if (array[i] == key) {
						sum++;
						break;
					}
				}
			}
			t_total += (System.nanoTime() - t0);
		}
		System.out.println("Average time per search for n = " + n + ": " + (t_total/k) + " ns");
		n *= 2;
		}

	}
}