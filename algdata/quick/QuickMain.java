import java.util.Random;
import java.util.Arrays;

class QuickMain{
  public static void main(String[] args){
    int size = 10;
    Random random = new Random();
    int[] array = new int[size];
    int[] nArray = {3,2,1};
    for(int i = 0; i < size; i++)
      array[i] = random.nextInt(20);
    System.out.println(Arrays.toString(nArray));
    Qsort.sort(nArray, 0, nArray.length-1);
    System.out.println(Arrays.toString(nArray));
  }
}
