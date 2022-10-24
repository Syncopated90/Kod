class City{
  String name;
  Connection[] neighbors;
  City next;

  public City(String name){
    this.name = name;
    this.neighbors = new Connection[4];
    this.next = null;
  }
  public City(String name, City next){
    this.name = name;
    this.neighbors = new Connection[10];
    this.next = next;
  }
  public void addConnection(City city, int distance){
    int i = 0;
    while(neighbors[i] != null){
      if(neighbors[i].equals(city))
        return;
      i++;
    }
    neighbors[i] = new Connection(city, distance);
  }
  public void printConnections(){
    for(Connection c: neighbors){
      if(c != null)
        System.out.println(c.toString());
    }
  }
  public boolean equals(Object other){
    if(other == null)
      return false;
    else if(this.getClass() != other.getClass())
      return false;
    else if(!this.name.equals(((City)other).name))
      return false;
    else
      return true;
  }
  public String toString(){
    return this.name;
  }
}
