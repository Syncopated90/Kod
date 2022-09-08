import java.util.Random;

class Binary{
  public static boolean searchBinary(int[] array, int key){
    int first = 0;
    int last = array.length-1;
    while (true) {
      int mid = array.length / 2;
      if(first == last && array[first] != key)
        return false;
      if (array[mid] == key)
        return true;
      if (array[mid] < key && mid < last) {
        first = mid + 1;
        continue;
      }
      if (array[mid] > key && mid > first) {
        last = mid - 1;
        continue;
      }
      return false;
    }
  }
}
