import java.util.Random;
class Heap{
  public static void main(String[] args){
    HeapTree heapTree = new HeapTree();
    Random random = new Random();
    Benchmark bench = new Benchmark();
    //bench.removeBench();
    bench.arrayBench();
    //bench.treeBench();
    /*for(int i = 10; i >0; i--){
      System.out.println("depth: " + heapTree.add(i));
    }*/


    /*heapTree.add(10);
    heapTree.add(11);
    heapTree.add(12);
    heapTree.add(13);
    heapTree.add(14);
    heapTree.add(15);
    heapTree.add(16);
    System.out.println(heapTree.push(2));
    System.out.println(heapTree.toString());*/
  }
}
