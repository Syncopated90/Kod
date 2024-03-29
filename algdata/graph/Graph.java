class Graph{
  public static void main(String[] args){
    Map map = new Map("trains.csv");
    Naive naive = new Naive(map);
    Paths paths = new Paths(map);
    map.lookup(args[0]).printConnections();
    System.out.println();
    map.lookup(args[1]).printConnections();
    System.out.println();
    //naive.bench(args[0], args[1], Integer.parseInt(args[2]));
    paths.bench(args[0], args[1], Integer.parseInt(args[2]));
    //System.out.println(map.lookup(args[0]).toString());
    //System.out.println(map.toString());
  }
}
