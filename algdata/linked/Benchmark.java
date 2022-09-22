import java.util.Random;
class Benchmark{
  public void benchmarkArrayStaticB(){
    int n = 200000;
    int b = 100;
    int loop = 10;
    int tries = 10;
    Random random = new Random();
    while(n < 25600000){
      int[] arrayA = new int[n];
      for(int i = 0; i < n; i++)
        arrayA[i] = i;
      int[] arrayB = new int[b];
      for(int i = 0; i < b;i++)
        arrayB[i] = i;
      long t0, t1;
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries;i++){
        t0 = System.nanoTime();
        for(int j = 0; j < loop; j++){
          int[] arrayC = new int[n + b];
          for(int k = 0; k < n; k++)
            arrayC[k] = arrayA[k];
          for(int k = n; k < n + b; k++)
            arrayC[k] = arrayB[k - n];
        }
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = (t1 - t0);
      }
      System.out.println(min/(1000 * loop) + " us to append array a with " + n + " elements with a fixed size array b");
      n *= 2;
    }
  }
  public void benchmarkArrayDynamicB(){
    int n = 200000;
    int loop = 10;
    int tries = 10;
    int b = 100;
    while(n < 25600000){
      int[] arrayA = new int[b];
      for(int i = 0; i < b; i++)
        arrayA[i] = i;
      int[] arrayB = new int[n];
      for(int i = 0; i < n; i++)
        arrayB[i] = i;
      long t0, t1;
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries;i++){
        t0 = System.nanoTime();
        for(int j = 0; j < loop; j++){
          int[] arrayC = new int[n + b];
          for(int k = 0; k < b; k++)
            arrayC[k] = arrayA[k];
          for(int k = b; k < n + b; k++)
            arrayC[k] = arrayB[k - b];
        }
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = (t1 - t0);
      }
      System.out.println(min/(1000 * loop) + " us to append static array a with " + n + " elements  size array b");
      n *= 2;
    }
  }
  public void benchmarkFixedB(){
    int n = 1000;
    int loop = 1;
    int tries = 5;
    LinkedList listA;
    while(n < 256000){
      long t0, t1;
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries;i++){
        listA = createList(0, n);
        t0 = System.nanoTime();
        for(int j = 0; j < loop; j++){
          listA.append(createList(0, 50));
        }
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = (t1 - t0);
      }
      System.out.println(min/(1000 * loop) + " us to append list a with " + n + " elements with a fixed size list b");
      n *= 2;
    }
  }
  public void benchmarkDynamicB(){
    int n = 500;
    int loop = 10;
    int tries = 5;
    long t0, t1, dummy;
    LinkedList listA, listB;
    while(n < 1024000){
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries;i++){
        listB = createList(0, n);
        listA = createList(0, 100);
        t0 = System.nanoTime();
        listA.append(listB);
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = (t1 - t0);
      }
      //min -= dummy;
      System.out.println(min + " ns to append 100 element list a with a " + n + " size list b");
      n *= 2;
    }
  }
  public void benchmarkAllocation(){
    int n = 1000;
    int loop = 10;
    int tries = 10;
    long t0, t1;
    LinkedList list;
    int[] array = new int[5];
    while(n < 1024000000){
      double min = Double.POSITIVE_INFINITY;
      /*for(int i = 0; i < tries;i++){
        t0 = System.nanoTime();
        for(int j = 0; j < loop;j++)
          list = createList(0, n);
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = (t1 - t0);
      }
      System.out.println((min/(1000 *loop)) + " us to allocate " + n + " elements sized list");
    */  min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries;i++){
        t0 = System.nanoTime();
        for(int j = 0; j < loop;j++)
          array = new int[n];
          //for(int k = 0; k < n;k++)
            //array[k] = k;
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = (t1 - t0);
      }
      System.out.println((min/(/*loop **/ 1000)) + " us to allocate " + n + " elements sized array");
      n *= 2;
    }
  }

  public LinkedList createList (int headStart, int listNumber){
    LinkedList list = new LinkedList(headStart, null);
    for(int i = headStart + 1; i < listNumber; i++)
      list.append(new LinkedList(i, null));
    return list;
  }

  private long setDummy(int n, int loop, int tries){
    LinkedList listB;
    long t0, t1;
    long dummy = 0;
    for(int i = 0; i < tries; i++){
      t0 = System.nanoTime();
      for(int j = 0; j < loop; j++){
        listB = createList(0, n);
        listB = createList(0, 100);
      }
      t1 = System.nanoTime();
      dummy = t1 - t0;
    }
    return dummy;
  }
}
