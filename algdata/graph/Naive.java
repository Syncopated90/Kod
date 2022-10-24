class Naive{
  Map map;
  public Naive(Map map){
    this.map = map;
  }
  public void bench(String from, String to, int max){
    long t0 = System.nanoTime();
    int distance = shortest(this.map.lookup(from), this.map.lookup(to), max);
    long min = System.nanoTime() - t0;
    System.out.println("Shortest :" + distance + " in " + min/1000 + " us");
  }
  private int shortest(City from, City to, int max){
    if(max < 0)
      return 1_000_000;
    if(from.equals(to))
      return 1_000_000;
    int shrt = 1_000_000;
    int shortestConn = 0;
    for(int i = 0; i < from.neighbors.length; i++){
      if(from.neighbors[i] != null){
        Connection conn = from.neighbors[i];
        if(conn.city.equals(to))
          return conn.distance;
        if(shortest(conn.city, to, max - conn.distance) < shrt){
          shrt = shortest(conn.city, to, max - conn.distance);
          shortestConn = conn.distance;
        }
      }
    }
    return shrt + shortestConn;
  }
}
