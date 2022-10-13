import java.util.Random;
class Heap{
  public static void main(String[] args){
    HeapTree heapTree = new HeapTree();
    Random random = new Random();
    for(int i = 0; i < 20; i++)
      heapTree.add(random.nextInt(20) + 1);
    System.out.println(heapTree.toString());
    for(int i = 0; i < 15; i++){
      System.out.println(heapTree.remove() + " was removed");
      System.out.println(heapTree.toString());
    }

    /*
    heapTree.add(1);
    System.out.println(heapTree.toString());*/
  }
}
