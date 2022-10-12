import java.util.Random;
import java.util.Arrays;

class QuickMain{
  public static void main(String[] args){
    Random random = new Random();
    int size = 5;
    LinkedList list = null;
    int n = 1000; //array size
    int loop = 10; //number of time to loop the algorithms
    int tries = 10000;
    //Benchmark.bench(n, loop, tries);
    list = new LinkedList(2);
    list.append(list.new Node(3, null));
    list.append(list.new Node(1, null));
    //list.append(list.new Node(4, null));
    //list.append(list.new Node(5, null));
    //list.append(list2);
    System.out.println("linked list: " + list.toString());
    list = list.quicksort(list.first, list.last);
    System.out.println("linked list: " + list.toString());
  }
}
