import java.util.Random;
class Duplicate{
	public static void main(String[] args){
		int k = 100;
		int n = 1000;
		long t_total = 0;
		int sum = 0;
		Random rnd = new Random();
		int[] keys = new int[n];
		int[] array = new int[n];
		for(int h = 0; h < 5; h++){
			keys = new int[n];
			array = new int[n];
			for (int j = 0; j < k; j++) {
				for(int i = 0; i < n; i++){
					keys[i] = rnd.nextInt(10 * n);
					array[i] = rnd.nextInt(10 * n);
				}
				long t0 = System.nanoTime();
				for (int ki = 0; ki < n; ki++) {
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
		n*=2;
		}
	}
}