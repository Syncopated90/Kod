import java.util.Random;

class Trees{
  public static void main(String[] args){
    Random random = new Random();
    BinaryTree binTree = new BinaryTree(10,20);
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
    for(Integer i:binTree){
      System.out.println(i);
    }
    /*Stack stack = new Stack(binTree.root, null);
    BinaryTree.Node node = binTree.new Node(2,4);
    stack = stack.push(node);
    node = binTree.new Node(7,14);
    stack = stack.push(node);
    node = stack.pop();
    System.out.println(node.value);
    node = stack.pop();
    System.out.println(node.value);
    node = stack.pop();
    System.out.println(node.value);
    node = binTree.new Node(8,16);
    stack = stack.push(node);
    node = stack.pop();
    System.out.println(node.value);*/
  }
}
