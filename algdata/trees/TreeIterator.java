import java.util.Iterator;
public class TreeIterator implements Iterator<Integer>{
  private BinaryTree.Node next;
  private Stack<BinaryTree.Node> stack;

  public TreeIterator(BinaryTree tree){
    this.stack = new Stack(tree.root, null);
    this.next = tree.root.left;
    while(next.left != null){
      stack = stack.push(next);
      next = next.left;
    }
  }
  @Override
  public boolean hasNext(){
    return next != null;
  }
  @Override
  public Integer next(){
    BinaryTree.Node node = next;
    if(next.right != null){
      next = next.right;
      while(next.left != null){
        stack = stack.push(next);
        next = next.left;
      }
      return node.value;
    }
    while(true){
      BinaryTree.Node parent = stack.pop();
      if(parent == null){
        next = null;
        return node.value;
      }
      if(parent.left.key == next.key){
        next = parent;
        return node.value;
      }
      next = parent;
      return node.value;
    }
  }
  @Override
  public void remove(){
    throw new UnsupportedOperationException();
  }
}
