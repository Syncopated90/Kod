class Insertion{
  public static void sort(int[] array){
    for (int i = 0; i < array.length; i++) {
      int temp = array[i];
      int j;
      for (j = i - 1; j >= 0 && temp < array[j] ; j--)
        array[j + 1] = array[j];
      array[j+1] = temp;
    }
    return ;
  }
  public static void insertion_sort (int[] array)
    {
        for (int i = 0; i < array.length; i++){
          int curVal = array[i];
          int j;
          for (j = i-1; j >= 0 && curVal < array[j]; --j)
          {
              array[j+1] = array[j];
          }
              array[j+1] = curVal;
        }
    }
}
