import java.util.Random;
import java.util.Arrays;
class Sorting{
  public static void main(String[] args){
    int n = 5; //array size
    int[] array = new int[n];
    randomize(array);
    Selection.sort(array);
    randomize(array);
    Insertion.sort(array);
    randomize(array);
    Merge.sort(array);
  }
  private static void randomize(int[] array){
    Random random = new Random();
    for(int i = 0; i < array.length; i++){
      array[i] = random.nextInt(10);
    }
  }
}
