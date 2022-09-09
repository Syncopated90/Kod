import java.util.Random;

class Binary{
  public static boolean searchBinary(int[] array, int key){
    int first = 0;
    int last = array.length - 1;
    while (first <= last) {
      int mid = first + ((last - first)/2);
      /*if(first == last)
        mid = first;*/
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
      break;
    }
    return false;
  }
}
