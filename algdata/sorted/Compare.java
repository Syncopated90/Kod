class Compare{
  public static int compare(int[] array1, int[] array2){
    int numberOfFoundItems = 0;
    int first1 = array1[0];
    int first2 = array2[0];
    for(int i = 0; i < array1.length; i++){
      if(first1 == first2 ){
        numberOfFoundItems++;
        first1++;
      }
      else if(first2 < first1)
        first2++;
      else if(first1 < first2)
        first1++;
    }
    return numberOfFoundItems;
  }
  public static int linearCompare(int[] array1, int[] array2){
    int numberOfFoundItems = 0;
    for(int i = 0; i < array1.length; i++){
      int key = array1[i];
      for(int j = 0; j < array2.length; j++){
        if(key == array2[j]){
          numberOfFoundItems++;
          break;
        }
      }
    }
    return numberOfFoundItems;
  }
  public void compareBench(){
    int n = 2000;
    int loop = 100;
    long t0, t1;
    double min = 0;
    LinearSearch linear = new LinearSearch();

    while(n < 135000){
      int[] array1 = linear.fillSorted(n);
      int[] array2 = linear.fillSorted(n);
      for(int i = 0; i < loop; i++){
        min = Double.POSITIVE_INFINITY;
        t0 = System.nanoTime();
        compare(array1, array2);
        t1 = System.nanoTime();
        double temp = (t1 - t0);
        if(min > (temp))
          min = (temp);
      }
      System.out.println("Minimum search time for n = " + n + ": "+ min + " using a good algo");
      /*for(int i = 0; i < loop; i++){
        min = Double.POSITIVE_INFINITY;
        t0 = System.nanoTime();
        linearCompare(array1, array2);
        t1 = System.nanoTime();
        double temp = (t1 - t0);
        if(min > (temp))
          min = (temp);
      }
      System.out.println("Minimum search time for n = " + n + ": "+ min + " using a bad algo");
    */  n *= 2;
    }
  }
}
