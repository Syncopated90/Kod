class Merge{
  public static void sort(int[] array1) {
    if (array1.length == 0)
      return;
    int[] array2 = array1.clone();
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
    int i = lo;
    int j = mid+1;
    for (int k = lo; k <= hi; k++) {
      if(i > mid)
        array1[k] = array2[j++];
      else if(j > hi)
        array1[k] = array2[i++];
      else if(array2[i] < array2[j])
        array1[k] = array2[i++];
      else
        array1[k] = array2[j++];
    }
  }
}
