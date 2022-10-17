import java.io.BufferedReader;
import java.io.FileReader;

public class ArrayZip{
  Node[] data;
  int max;

  public String lookup(Integer code){
    if(this.data[code] != null)
      return this.data[code].name;
    return null;
  }
  public ArrayZip(String file){
    data = new Node[100000];
    try(BufferedReader br = new BufferedReader(new FileReader(file))){
      String line;
      int i = 0;
      while((line = br.readLine()) != null){
        String[] row =line.split(",");
        Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
        this.data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
      }
      this.max = i -1;
    }catch (Exception e){
      System.out.println("file " + file + " not found");
    }
  }

  public class Node{
    Integer code;
    String name;
    Integer pop;

    public Node(Integer code, String name, Integer pop){
      this.code = code;
      this.name = name;
      this.pop = pop;
    }
  }
}
