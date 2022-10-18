import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashProbing{
  Node[] data;
  int max;
  int modulo;

  public Integer lookup(Integer postal){
    Integer hash = postal % modulo;
    int numberOfChecks = 1;
    if(this.data[hash] != null && this.data[hash].code.equals(postal))
      return numberOfChecks;
      //return this.data[hash].name;
    else
      while(true){
        if(this.data[hash] != null && this.data[hash].code.equals(postal))
          //return this.data[hash].name;
          return numberOfChecks;
        numberOfChecks++;
        hash++;
        if(hash.equals(modulo))
          hash = 0;
      }
  }

  public HashProbing(String file, Integer modulo){
    this.modulo = modulo;
    data = new Node[modulo];
    try(BufferedReader br = new BufferedReader(new FileReader(file))){
      String line;
      int i = 0;
      while((line = br.readLine()) != null){
        String[] row =line.split(",");
        Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
        Node node = new Node(code, row[1], Integer.valueOf(row[2]));
        Integer hash = code % modulo;
        if(this.data[hash] == null)
          this.data[hash] = node;
        else{
          while(this.data[hash] != null){
            hash++;
            if(hash.equals(modulo))
              hash = 0;
          }
          if(this.data[hash] == null)
            this.data[hash] = node;
          else
            System.out.println("array was full??");
        }
      }
      this.max = i - 1;
    }catch (IOException ioe){
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
