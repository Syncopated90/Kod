import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

class Map{
  private City[] cities;
  private final int MOD = 541;

  public Map(String file){
    cities = new City[MOD];
    try(BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), "UTF-8"))){
      String line;
      while((line = br.readLine()) != null){
        String[] row = line.split(",");
        lookup(row[0]);
        lookup(row[1]);
        lookup(row[0]).addConnection(lookup(row[1]), Integer.parseInt(row[2]));
        lookup(row[1]).addConnection(lookup(row[0]), Integer.parseInt(row[2]));
      }
    }catch (IOException ioe){
      System.out.println("file " + file + " not found or corrupt");
    }
  }
  public City lookup(String name){
    if(this.cities[hash(name)] == null){
      this.cities[hash(name)] = new City(name);
      return this.cities[hash(name)];
    }
    else if(this.cities[hash(name)].name.equals(name))
      return this.cities[hash(name)];
    else{
      City nextLink = this.cities[hash(name)];
      while(nextLink.next != null){
        nextLink = nextLink.next;
        if(nextLink.name.equals(name))
          return nextLink;
      }
      nextLink.next = new City(name);
      return nextLink.next;
    }
  }

  private Integer hash(String name){
    int hash = 7;
    for(int i = 0; i < name.length(); i++)
      hash = (hash * 31 % MOD) + name.charAt(i);
    return hash % MOD;
  }
  public String toString(){
    String names = "";
    for(int j = 0; j < MOD; j++){
      if(cities[j] != null){
        names += cities[j].toString() + " ";
        City nextLink = cities[j].next;
        while(nextLink != null){
          names += nextLink.toString() + " ";
          nextLink = nextLink.next;
        }
      }
    }
    return names;
  }
}
