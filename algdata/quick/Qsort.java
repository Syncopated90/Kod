class Qsort{
  public static void sort(int[] array, int low, int high){
    if(array == null || array.length == 1)
      return;
    if(low < high){
      int pivot = partition(array, low, high);
      //sort(array, low, pivot - 1);
      //sort(array, pivot + 1, high);
    }
  }
  public static int partition(int[] array, int low, int high){
    int pivot = array[low];
    //System.out.println("high: " + high + "low : " + low);
    while(true){
      while(low <= (high - low) && array[low] <= pivot){
        low++;
        System.out.println(low + " " + high);
      }
      while(array[high] > pivot && high > 0)
        high--;
      if(low > high){
        swap(array, 0, high);
        return high;
      }
      else
        swap(array, low++ , high--);

        //System.out.println("high: " + high + "low : " + low);
    }
  }
  private static void swap (int[] array, int low, int high){
    int temp = array[low];
    array[low] = array[high];
    array[high] = temp;
  }
}
