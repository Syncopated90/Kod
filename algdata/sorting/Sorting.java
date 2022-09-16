import java.util.Random;
import java.util.Arrays;
import java.lang.Math;
class Sorting{
  public static void main(String[] args){
    int n = 1000; //array size
    int loop = 10; //number of time to loop the algorithms
    int tries = 10;
    benchmark(n, loop, tries);
    /*int[] array = new int[] {1,2,3,4};
    System.out.println(Arrays.toString(array));
    Insertion.sort(array);
    System.out.println(Arrays.toString(array));*/
  }
  private static void randomize(int[] array){
    Random random = new Random();
    for(int i = 0; i < array.length; i++){
      array[i] = random.nextInt(10);
    }
  }
  private static void benchmark(int n, int loop, int tries){
    while(n <= 17097000){
      int[] array = new int[n];
      randomize(array);
      long t0, t1;
      double min = Double.POSITIVE_INFINITY;
      double min2 = Double.POSITIVE_INFINITY;
      /*for(int i = 0; i < loop; i++){
          min2 = Double.POSITIVE_INFINITY;
        for(int j = 0; j < tries; j++){
       		int[] copy = array.clone();
        	t0 = System.nanoTime();
        	Selection.sort(copy);
        	t1 = (System.nanoTime() - t0);
        	if(t1 < min)
          		min = t1;
		    }
      }
      System.out.println(min/1000 + " us: time for selection sort with n = " + n);
      for(int i = 0; i < loop; i++){
        min2 = Double.POSITIVE_INFINITY;
        for(int j = 0; j < tries; j++){
       		int[] copy = array.clone();
        	t0 = System.nanoTime();
        	Insertion.sort(copy);
        	t1 = (System.nanoTime() - t0);
        	if(t1 < min2)
          		min2 = t1;
		    }
      }
      System.out.println(min2/1000 + " us: time for insertion sort");*/
      //System.out.println(min2/min + ": Ratio insertion/selection");
      //System.out.println(min/((n/1000)*(n/1000)) + ": t/(n/1000)^2");
      for(int i = 0; i < loop; i++){
        min = Double.POSITIVE_INFINITY;
        for(int j = 0; j < tries; j++){
       		int[] copy = array.clone();
        	t0 = System.nanoTime();
        	Merge.sort(copy);
        	t1 = (System.nanoTime() - t0);
        	if(t1 < min)
          		min = t1;
		    }
      }
      System.out.println("n: " + n + ": " + min/(loop * 1000) + " us: time for merge sort. t/n: " + (min/loop)/n + " t/n*log n: "
      + (min/loop)/(n * Math.log(n)) );
      n *=2;
    }
  }
}
