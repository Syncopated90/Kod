import java.io.BufferedReader;
import java.io.FileReader;

public class Zip{
  Node[] data;
  int max;

  public String lookup(Integer code){
      for(int i = 0; i < this.data.length; i++){
        if(code.equals(this.data[i].code) == true)
          return this.data[i].name;
      }
      return null;
  }
  public String binaryLookup(Integer code){
    int first = 0;
    int last = this.data.length - 1;
    while(first <= last){
      int mid = first + ((last - first) / 2);
      if(code.compareTo(this.data[mid].code) == 0)
        return this.data[mid].name;
      else if(code.compareTo(this.data[mid].code) < 0)
        last = mid - 1;
      else if(code.compareTo(this.data[mid].code) > 0)
        first = mid + 1;
      else
        break;
    }
    return null;
  }
  public String binaryLookup(String code){
    int first = 0;
    int last = this.data.length - 1;
    while(first <= last){
      int mid = first + ((last - first) / 2);
      if(code.compareTo(this.data[mid].codeString) == 0)
        return this.data[mid].name;
      else if(code.compareTo(this.data[mid].codeString) < 0)
        last = mid - 1;
      else if(code.compareTo(this.data[mid].codeString) > 0)
        first = mid + 1;
      else
        break;
    }
    return null;
  }
  public String lookup(String code){
      for(int i = 0; i < this.data.length; i++){
        if(this.data[i] != null && code.equals(this.data[i].codeString) == true)
          return this.data[i].name;
      }
      return null;
  }

  public Zip(String file){
    data = new Node[9675];
    try(BufferedReader br = new BufferedReader(new FileReader(file))){
      String line;
      int i = 0;
      while((line = br.readLine()) != null){
        String[] row = line.split(",");
        Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
        this.data[i++] = new Node(code, row[0], row[1], Integer.valueOf(row[2]));
      }
      this.max = i -1;
    }catch (Exception e){
      System.out.println("file " + file + " not found");
    }
  }

  public class Node{
    Integer code;
    String codeString;
    String name;
    Integer pop;

    public Node(Integer code, String codeString, String name, Integer pop){
      this.code = code;
      this.codeString = codeString;
      this.name = name;
      this.pop = pop;
    }
  }
}
