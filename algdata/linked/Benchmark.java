class Benchmark{
  public void benchmarkArrayStaticB(){
    int n = 1000;
    int loop = 10;
    int tries = 100;
    while(n < 257000){
      int[] arrayA = new int[n];
      int[] arrayB = new int[50];
      long t0, t1;
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < loop;i++){
        t0 = System.nanoTime();
        for(int j = 0; j < tries; j++){
          int[] arrayC = new int[n + 50];
          for(int k = 0; k < n; k++)
            arrayC[k] = arrayA[k];
          for(int k = n; k < n + 50; k++)
            arrayC[k] = arrayB[k - n];
        }
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = (t1 - t0);
      }
      System.out.println(min/tries + " ns to append array a with " + n + " elements with a fixed size array b");
      n *= 2;
    }
  }
  public void benchmarkArrayDynamicB(){
    int n = 1000;
    int loop = 10;
    int tries = 100;
    while(n < 257000){
      int[] arrayA = new int[50];
      int[] arrayB = new int[n];
      long t0, t1;
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < loop;i++){
        t0 = System.nanoTime();
        for(int j = 0; j < tries; j++){
          int[] arrayC = new int[n + 50];
          for(int k = 0; k < 50; k++)
            arrayC[k] = arrayA[k];
          for(int k = 50; k < n + 50; k++)
            arrayC[k] = arrayB[k - 50];
        }
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = (t1 - t0);
      }
      System.out.println(min/tries + " ns to append static array a with " + n + " elements  size array b");
      n *= 2;
    }
  }
  public void benchmarkFixedB(){
    int n = 1000;
    int loop = 10;
    int tries = 10;
    LinkedList listA;
    while(n < 51300){
      long t0, t1;
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries;i++){
        listA = createList(0, n);
        t0 = System.nanoTime();
        for(int j = 0; j < loop; j++){
          listA.append(createList(0, 10));
        }
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = (t1 - t0);
      }
      System.out.println(min/tries + " ns to append list a with " + n + " elements with a fixed size list b");
      n *= 2;
    }
  }
  public void benchmarkDynamicB(){
    int n = 500;
    int loop = 10;
    int tries = 10;
    long t0, t1, dummy;
    LinkedList listA, listB;
    while(n < 128000){
      //dummy = setDummy(n, loop, tries);
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
