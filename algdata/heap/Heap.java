import java.util.Random;
class Heap{
  public static void main(String[] args){
    HeapTree heapTree = new HeapTree();
    Random random = new Random();
    /*for(int i = 0; i < 20; i++)
      heapTree.add(random.nextInt(100));
    System.out.println(heapTree.toString());
    System.out.println("size of heapTree: " + heapTree.size);*/
    HeapArray heapArray = new HeapArray();
    heapArray.add(5);
    heapArray.add(10);
    System.out.println(heapArray.toString());
    System.out.println(heapArray.freeSpot);
  }
}
