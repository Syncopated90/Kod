class BinaryTree{
  private Node root;
  public BinaryTree(Integer key, Integer value){
    this.root = new Node(key,value);
  }
  public BinaryTree(){
    this.root = null;
  }
  public class Node{
    private Integer key;
    private Integer value;
    private Node left, right;

    public Node(Integer key, Integer value){
      this.key = key;
      this.value = value;
      this.left = this.right = null;
    }
    private String valuesToString(){
      StringBuilder sb = new StringBuilder();
      sb.append("(");
      sb.append(this.key);
      sb.append(", ");
      sb.append(this.value);
      sb.append(")");
      return sb.toString();
    }
    public String toString(){
      StringBuilder sb = new StringBuilder();
      if(this.left != null)
        sb.append(this.left.toString());
      sb.append(this.valuesToString());
      if(this.right != null)
        sb.append(this.right.toString());
      return sb.toString();
    }
    private Integer lookup(Integer searchKey){
      if(searchKey == this.key)
        return this.value;
      else if(this.left != null && searchKey < this.key)
        return this.left.lookup(searchKey);
      else if(this.right != null && searchKey > this.key)
        return this.right.lookup(searchKey);
      else
        return null;
    }
    private void add(Integer key, Integer value){
      if(key == this.key)
        this.value = value;
      if(key < this.key){
        if(this.left == null){
          this.left = new Node(key, value);
        }
        else
          this.left.add(key, value);
      }
      if(key > this.key){
        if(this.right == null)
          this.right = new Node(key, value);
        else{
          this.right.add(key, value);
        }
      }
    }
  }

  public void add(Integer key, Integer value){
    if(this.root == null)
      this.root = new Node(key,value);
    else
      root.add(key, value);
  }
  public Integer lookup(Integer key){
    if(this.root != null)
      return this.root.lookup(key);
    else
      return null;
  }
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(this.root.valuesToString());
    if(this.root.left != null)
      sb.append(this.root.left.toString());
    if(this.root.right != null)
    sb.append(this.root.right.toString());
    return sb.toString();
  }
}
