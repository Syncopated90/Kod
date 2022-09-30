import java.util.Iterator;
public class TreeIterator implements Iterator<Integer>{
  private BinaryTree.Node next;
  private Stack<BinaryTree.Node> stack;

  public TreeIterator(BinaryTree tree){
    this.stack = new Stack(tree.root, null);
    this.next = tree.root.left;
    while(next.left != null){
      stack = stack.push(next);
      this.next = next.left;
    }
  }
  @Override
  public boolean hasNext(){
    return next != null;
  }
  @Override
  public Integer next(){
    BinaryTree.Node node = this.next;
    if(next.right != null){
      this.next = next.right;
      while(next.left != null){
        stack = stack.push(next);
        this.next = next.left;
      }
      return node.value;
    }
    while(true){
      BinaryTree.Node parent = stack.pop();
      if(parent == null){
        this.next = null;
        return node.value;
      }
      if(parent.left.key == next.key){
        this.next = parent;
        return node.value;
      }
      this.next = parent;
      return node.value;
    }
  }
  @Override
  public void remove(){
    throw new UnsupportedOperationException();
  }
}
