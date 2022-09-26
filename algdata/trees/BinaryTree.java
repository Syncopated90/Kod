class BinaryTree{
  private Node root;
  public BinaryTree(int key, int value){
    this.root = new Node(key,value);
  }
  public BinaryTree(){
    this.root = null;
  }
  public class Node{
    private int key;
    private int value;
    private Node left, right;

    public Node(int key, int value){
      this.key = key;
      this.value = value;
      this.left = this.right = null;
    }
    public String toString(){
      StringBuilder sb = new StringBuilder("(");
      sb.append(key);
      sb.append(", ");
      sb.append(value);
      sb.append(")");
      return sb.toString();
    }

  }

  public void add(int key, int value){
    if(this.root == null)
      this.root = new Node(key,value);
  }

  public String toString(){
    return root.toString();
  }

}
