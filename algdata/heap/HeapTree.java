class HeapTree implements Comparable<HeapTree>{
  public Node root;
  public Integer size;
  public HeapTree(Integer item){
    this.root = new Node(item);
    this.size = 1;
  }
  public HeapTree(Node node){
    this.root = node;
    this.size = 1;
  }
  public HeapTree(){
    this.root = null;
    this.size = 0;
  }
  public Integer push(Integer incr){
    HeapTree current = this;
    current.root.head += incr;
    Integer depth = 0;
    while(true){
      if(current.root.left == null && current.root.right == null)
        return depth;
      else if(current.root.left == null){
        if(current.root.compareTo(current.root.right.root) <= 0)
          return depth;
        else{
          swapHead(current.root, current.root.right.root);
          current = current.root.right;
          depth++;
          continue;
        }
      }
      else if(current.root.right == null){
        if(current.root.compareTo(current.root.left.root) <= 0)
          return depth;
        else{
          swapHead(current.root, current.root.left.root);
          current = current.root.left;
          depth++;
          continue;
        }
      }
      else{
        if(current.root.compareTo(current.root.left.root) <= 0 && current.root.compareTo(current.root.right.root) <= 0)
          break;
        else if(current.root.left.root.compareTo(current.root.right.root) >= 0){
          swapHead(current.root, current.root.right.root);
          current = current.root.right;
          depth++;
          continue;
        }
        else{
          swapHead(current.root, current.root.left.root);
          current = current.root.left;
          depth++;
          continue;
        }
      }
    }
    return depth;
  }
  public Integer remove(){
    if(this.root == null)
      return null;
    Integer item = root.head;
    if(this.size == 1){
      this.size = 0;
      this.root = null;
      return item;
    }
    else{
      HeapTree current = this;
      current.size--;
      while(true){
        if(current.root.left == null){
          swapHead(current.root, current.root.right.root);
          if(current.root.right.root.left == null && current.root.right.root.right == null){
            current.root.right = null;
            current.root.left = null;
          }
          else{
            current = current.root.right;
            current.size--;
            continue;
          }
          break;
        }
        else if(current.root.right == null){
          swapHead(current.root, current.root.left.root);
          if(current.root.left.root.left == null && current.root.left.root.right == null){
            current.root.right = null;
            current.root.left = null;
          }
          else{
            current = current.root.left;
            current.size--;
            continue;
          }
          break;
        }
        else if(current.root.right.root.compareTo(current.root.left.root) < 1){
          swapHead(current.root, current.root.right.root);
          if(current.root.right.root.left == null && current.root.right.root.right == null){
            current.root.right = null;
            break;
          }
          else{
            current = current.root.right;
            current.size--;
            continue;
          }
        }
        else{
          swapHead(current.root, current.root.left.root);
          if(current.root.left.root.left == null && current.root.left.root.right ==null){
            current.root.left = null;
            break;
          }
          else{
            current = current.root.left;
            current.size--;
            continue;
          }
        }
      }
      return item;
    }
  }
  public void add(Integer item){
    Node node = new Node(item);
    if(this.root == null){
      this.root = node;
      this.size = 1;
    }
    else{
      HeapTree current = this;
      while(true){
        current.size++;
        if(node.compareTo(current.root) < 0){
          swapHead(node, current.root);
        }
        if(current.root.left == null){
          current.root.left = new HeapTree(node);
          return;
        }
        else if(current.root.right == null){
          current.root.right = new HeapTree(node);
          return;
        }
        else if(current.root.left.compareTo(current.root.right) < 0)
          current = current.root.left;
        else
          current = current.root.right;
      }
    }
  }
  public void swapHead(Node node, Node current){
    Integer temp = current.head;
    current.head = node.head;
    node.head = temp;
  }
  public class Node implements Comparable<Node>{
    public Integer head;
    public HeapTree left;
    public HeapTree right;

    public Node(Integer item){
      this.head = item;
      this.left = null;
      this.right = null;
    }
    public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append(this.head + " ");
      if(this.left != null)
        sb.append(this.left.toString());
      if(this.right != null)
        sb.append(this.right.toString());
      return sb.toString();
    }
    public String printNode(){
      return this.head.toString();
    }
    @Override
    public int compareTo(Node node){
      if(this.head < node.head)
        return -1;
      else if (this.head == node.head)
        return 0;
      else
        return 1;
    }
  }
  public String toString(){
    if(this.root == null)
      return "";
    else
    return root.toString();
  }
  @Override
  public int compareTo(HeapTree tree){
    if(this.size < tree.size)
      return -1;
    else if(this.size == tree.size)
      return 0;
    else
      return 1;
  }
}
