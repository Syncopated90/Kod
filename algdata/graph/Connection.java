class Connection{
  City city;
  int distance;

  public Connection(City city, int distance){
    this.city = city;
    this.distance = distance;
  }
  public String toString(){
    return this.city.toString() + ": " + distance;
  }
}
