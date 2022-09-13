class Merge{
  public static void sort(int[] array1) {
    if (array1.length == 0)
      return;
    int[] array2 = new int[array1.length];
    sort(array1, array2, 0, array1.length -1);
    return;
  }
  private static void sort(int[] array1, int[] array2, int lo, int hi) {
    if (lo != hi) {
      int mid = lo + (hi-lo)/2;
      sort(array1, array2, lo, mid);
      sort(array1, array2, mid + 1, hi);
      merge(array1, array2, lo, mid, hi);
    }
  }
  private static void merge(int[] array1, int[] array2, int lo, int mid, int hi) {
    for (int i = lo; i <= hi; i++) {
      array2[i] = array1[i];
    }
    int i = lo; // the index in the first part
    int j = mid+1; // the index in the second part
    for (int k = lo; k <= hi; k++) {
      if(i > mid) // if i is greater than mid, move the j item to the array1 array, update j
        array1[k] = array2[j++];
      else if(j > hi)// else if j is greate than hi, move the i item to the array1 array, update i
        array1[k] = array2[i++];
      else if(array2[i] < array2[j])// else if the i item is smaller than the j item, move it to the array1 array, update i
        array1[k] = array2[i++];
      else// else you can move the j item to the array1 array, update j
        array1[k] = array2[j++];
    }
  }
}
