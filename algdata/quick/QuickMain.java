import java.util.Random;
import java.util.Arrays;

class QuickMain{
  public static void main(String[] args){
    int size = 20;
    Random random = new Random();
    int[] array = new int[size];
    int[] nArray = {2,3,4,5,1};
    for(int i = 0; i < size; i++)
      array[i] = random.nextInt(200);
    System.out.println(Arrays.toString(nArray));
    Qsort.sort(nArray, 0, nArray.length - 1);
    System.out.println(Arrays.toString(nArray));
    System.out.println("larger array: ");
    System.out.println(Arrays.toString(array));
    Qsort.sort(array, 0, size - 1);
    System.out.println(Arrays.toString(array));
  }
}
