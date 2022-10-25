class Paths{
  City[] path;
  int sp;
  Map map;
  static final int MAX = 1_000_000;
  public Paths(Map map){
    this.map = map;
    this.path = new City[54];
    sp = 0;
  }
  public void bench(String from, String to, int max){
    long t0 = System.nanoTime();
    int distance = shortest(this.map.lookup(from), this.map.lookup(to), max);
    long min = System.nanoTime() - t0;
    System.out.println("Shortest paths:" + distance + " in " + min/1000 + " us");
  }
  private int shortest(City from, City to, int max){
    if(max < 0)
      return MAX;
    if(from.equals(to))
      return MAX;

    int shrt = MAX;
    int shortestConn = 0;
  outerLoop:
    for(int i = 0; i < from.neighbors.length; i++){
      if(from.neighbors[i] != null){
        Connection conn = from.neighbors[i];
        if(conn.city.equals(to))
          return conn.distance;
        for(int j = 0; j < sp; j++){
          if(path[j] != null && path[j].equals(from) == true)
            continue outerLoop;
        }
        this.path[sp++] = from;
        int dist = shortest(conn.city, to, max - conn.distance);
        if(dist < shrt){
          shrt = dist;
          shortestConn = conn.distance;
          //max = shrt;
        }
        this.path[sp--] = null;
      }
    }

    return shrt + shortestConn;
  }
}
