class Selection{
  public static void sort(int[] array){
    for (int i = 0; i < array.length -1; i++) {
      int cand = i;
      for (int j = i; j < array.length ; j++) {
        if(array[j] < array[cand])
          cand = j;
      }
      int temp = array[i];
      array[i] = array[cand];
      array[cand] = temp;
    }
    return;
  }
}
