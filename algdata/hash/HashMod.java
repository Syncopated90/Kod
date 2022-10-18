import java.io.BufferedReader;
import java.io.FileReader;

class HashMod{
    Integer[] keys;
    int max;
    public void collisions(int mod){
      int modSize = 15;
      int[] data = new int[mod];
      int[] cols = new int[modSize];

      for(int i = 0; i < this.max; i++){
        Integer index = keys[i] % mod;
        cols[data[index]]++;
        data[index]++;
      }
      System.out.print(mod);
      for(int i = 0; i < modSize; i++)
        System.out.print("\t" + cols[i]);
      System.out.println();
    }

    public HashMod(String file){
      this.keys = new Integer[9675];
      try(BufferedReader br = new BufferedReader(new FileReader(file))){
        String line;
        int i = 0;
        while((line = br.readLine()) != null){
          String[] row =line.split(",");
          Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
          this.keys[i++] = code;
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
