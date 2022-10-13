import java.util.Random;
class Heap{
  public static void main(String[] args){
    HeapTree heapTree = new HeapTree();
    Random random = new Random();
    for(int i = 0; i < 20; i++)
      heapTree.add(random.nextInt(100));
    System.out.println(heapTree.toString());
    System.out.println(heapTree.remove() + " was removed");
    System.out.println(heapTree.toString());
    System.out.println("depth of push: " + heapTree.push(100));
    System.out.println(heapTree.toString());
  }
}
