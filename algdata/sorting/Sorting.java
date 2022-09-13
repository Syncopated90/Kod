import java.util.Random;
import java.util.Arrays;
class Sorting{
  public static void main(String[] args){
    int n = 100; //array size
    int loop = 100; //number of time to loop the algorithms
    benchmark(n, loop);
  }
  private static void randomize(int[] array){
    Random random = new Random();
    for(int i = 0; i < array.length; i++){
      array[i] = random.nextInt(10);
    }
  }
  private static void benchmark(int n, int loop){
    while(n <= 8192000){
      int[] array = new int[n];
      long t0, t1;
      double min = Double.POSITIVE_INFINITY;
    /*  for(int i = 0; i < loop; i++){
          min = Double.POSITIVE_INFINITY;
          randomize(array);
          t0 = System.nanoTime();
          Selection.sort(array);
          t1 = (System.nanoTime() - t0);
          if(t1 < min)
            min = t1;
      }
      System.out.println(min/1000 + " us: time for selection sort");
      for(int i = 0; i < loop; i++){
        min = Double.POSITIVE_INFINITY;
        randomize(array);
        t0 = System.nanoTime();
        Insertion.sort(array);
        t1 = (System.nanoTime() - t0);
        if(t1 < min)
          min = t1;
      }
      System.out.println(min/1000 + " us: time for insertion sort");
      */for(int i = 0; i < loop; i++){
        min = Double.POSITIVE_INFINITY;
        randomize(array);
        t0 = System.nanoTime();
        Merge.sort(array);
        t1 = (System.nanoTime() - t0);
        if(t1 < min)
          min = t1;
      }
      System.out.println(min/1000 + " us: time for merge sort");
      n *=2;
    }
  }
}
