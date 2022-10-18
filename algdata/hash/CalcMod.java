import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CalcMod{
  Node[] data;
  int max;
  final int SIZE = 9765;
  public String congruent(Integer mod){
    Integer remainder1;
    Integer remainder2;
    for(int i = 0; i < data.length - 1; i++){
      remainder1 = (data[i].code / mod);
      for(int j = 0; j< data.length; j++){
        remainder2 = (data[j].code / mod);
        if(remainder1.equals(remainder2))
          return new String("" + remainder1 + " " + remainder2);
      }
    }
    return "no mod found";
  }
  public CalcMod(String file){
    data = new Node[SIZE];
    Node nextInBucket;
    try(BufferedReader br = new BufferedReader(new FileReader(file))){
      String line;
      int i = 0;
      while((line = br.readLine()) != null){
        String[] row =line.split(",");
        Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
        Node node = new Node(code, row[1], Integer.valueOf(row[2]));
        this.data[code] = node;
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
