class Linked{
  public static void main(String[] args){
    Benchmark bench = new Benchmark();
    LinkedList list = new LinkedList(1, null);
    //bench.benchmarkFixedB();
    //bench.benchmarkDynamicB();
    bench.benchmarkArrayStaticB();
    bench.benchmarkArrayDynamicB();
    //bench.benchmarkAllocation();
  }
}
