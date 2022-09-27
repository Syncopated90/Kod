import java.util.Random;

class Trees{
  public static void main(String[] args){
    Random random = new Random();
    BinaryTree binTree = new BinaryTree(10,10);
    System.out.println(binTree.toString());
    binTree.add(2,4);
    binTree.add(7,14);
    binTree.add(1,2);
    binTree.add(8,16);
    binTree.add(15,30);
    binTree.add(13,26);
    binTree.add(14,28);
    //System.out.println(binTree.toString());
    //System.out.println(binTree.lookup(Integer.parseInt(args[0])));
    for(Integer i:binTree)
      System.out.println(i.toString());
  }
}
