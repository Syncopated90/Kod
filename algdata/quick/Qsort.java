class Qsort{
  public static void sort(int[] array, int low, int high){
    if(array == null || array.length == 1)
      return;
    if(low < high){
      int pivot = partition(array, low, high);
      sort(array, low, pivot - 1);
      sort(array, pivot + 1, high);
    }
  }
  public static int partition(int[] array, int low, int high){
    int pivot = array[low];
    int pivotIndex = low;
    while(true){
      while(low <= high && array[low] <= pivot)
        low++;
      while(array[high] > pivot && high > 0)
        high--;
      if(low > high){
        swap(array, pivotIndex, high);
        return high;
      }
      else
        swap(array, low++ , high--);
    }
  }
  private static void swap (int[] array, int low, int high){
    int temp = array[low];
    array[low] = array[high];
    array[high] = temp;
  }
}
