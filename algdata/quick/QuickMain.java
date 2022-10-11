import java.util.Random;
import java.util.Arrays;

class QuickMain{
  public static void main(String[] args){
    Random random = new Random();
    int size = 5;
    LinkedList list = null;
    /*int[] array = new int[size];
    int[] nArray = {2,3,4,5,1};
    for(int i = 0; i < size; i++)
      array[i] = random.nextInt(200);
    System.out.println(Arrays.toString(nArray));
    Qsort.sort(nArray, 0, nArray.length - 1);
    System.out.println(Arrays.toString(nArray));
    System.out.println("larger array: ");
    System.out.println(Arrays.toString(array));
    Qsort.sort(array, 0, size - 1);
    System.out.println(Arrays.toString(array));*/

    /*for(int i = size - 1; i >= 0; i--){
      node = new Node(random.nextInt(20), node);
    }
    */
    list = new LinkedList(2);
    list.append(list.new Node(3, null, null));
    list.append(list.new Node(1, null, null));
    System.out.println("linked list: " + list.toString());
    list.quicksort(list.first, list.last);
    System.out.println("linked list: " + list.toString());
  }
}
