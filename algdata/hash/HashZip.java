import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashZip{
  Node[] data;
  int max;
  final int MODULO = 5001;

  public String lookup(Integer postal){
    Integer hash = postal % MODULO;
    Node node = this.data[hash];
    int amount = 1;
    while(node != null && node.code.equals(postal) == false){
      node = node.next;
      amount++;
    }
    if(node != null)
      return node.name;
      //return amount;
    else
      return null;
  }

  public HashZip(String file){
    data = new Node[MODULO];
    Node nextInBucket;
    try(BufferedReader br = new BufferedReader(new FileReader(file))){
      String line;
      int i = 0;
      while((line = br.readLine()) != null){
        String[] row =line.split(",");
        Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
        Node node = new Node(code, row[1], Integer.valueOf(row[2]));
        nextInBucket = this.data[code % MODULO];
        if(this.data[code % MODULO] == null)
          this.data[code % MODULO] = node;
        else{
          while(nextInBucket.next != null)
            nextInBucket = nextInBucket.next;
          nextInBucket.next = node;
        }
      }
      this.max = i -1;
    }catch (IOException ioe){
      System.out.println("file " + file + " not found");
    }
  }

  public class Node{
    Integer code;
    String name;
    Integer pop;
    Node next;

    public Node(Integer code, String name, Integer pop){
      this.code = code;
      this.name = name;
      this.pop = pop;
      this.next = null;
    }
  }
}
