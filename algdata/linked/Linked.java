import java.util.Random;

class Linked{
  public static void main(String[] args){
    Benchmark bench = new Benchmark();
    LinkedList list = new LinkedList(1, null);
    Random random = new Random();
    DoubleList doubleList = new DoubleList(0,null);
    //bench.benchmarkFixedB();
    //bench.benchmarkDynamicB();
    //bench.benchmarkArrayStaticB();
    //bench.benchmarkArrayDynamicB();
    //bench.benchmarkAllocation();
    /*doubleList = DoubleList.createList(0,20);
    System.out.println(doubleList.toString());
    int number = random.nextInt(20);
    System.out.println("index to remove : " + number);
    doubleList = doubleList.remove(number);
    System.out.println(doubleList.toString());
    //doubleList = doubleList.add(new DoubleList(0,null));
    //System.out.println(doubleList.toString());
    number = random.nextInt(19);
    System.out.println("index to remove : " + number);
    doubleList = doubleList.remove(number);
    System.out.println(doubleList.toString());*/

    bench.doubleBench();
  }
}
