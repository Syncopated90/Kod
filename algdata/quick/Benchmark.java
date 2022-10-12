import java.util.Random;
class Benchmark{
  public static void bench(int n, int loop, int tries){
    while(n <= 4096000){
      Random random = new Random();
      int[] array = new int[n];
      for(int i = 0; i < n; i++)
        array[i] = (random.nextInt(10 * n));
      long t0, t1;
      double min = Double.POSITIVE_INFINITY;
      double min2 = Double.POSITIVE_INFINITY;
      for(int i = 0; i < loop; i++){

        for(int j = 0; j < 1; j++){
          min = Double.POSITIVE_INFINITY;
          int[] copy = array.clone();
          t0 = System.nanoTime();
          Qsort.sort(copy, 0, n-1);
          t1 = (System.nanoTime() - t0);
          if(t1 < min)
              min = t1;
        }
      }
      System.out.println("n: " + n + ": " + min/(loop * 1000) + " us: time for quicksort. t/n: " + (min/loop)/n + " t/n*log n: "
      + (min/loop)/(n * Math.log(n)) );
      n *=2;
    }
  }
}
