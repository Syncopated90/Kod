class Insertion{
  public static void sort(int[] array){
    for (int i = 0; i < array.length; i++) {
      for (int j = i; j > 0 && array[j] < array[j - 1] ; j--) {
        int temp = array[j - 1];
        array[j - 1] = array[j];
        array[j] = temp;
      }
    }
    return ;
  }
}
