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
    if(next.right != null){
      next = next.right;
      while(next.left != null)
        next = next.left;
      return next.value;
    }
    while(true){
      BinaryTree.Node parent = stack.pop();
      if( parent == null){
        next = null;
        return null;
      }
      if(parent.left == next){
        next = parent;
        return next.value;
      }
      next = parent;
    }
  }
  @Override
  public void remove(){
    throw new UnsupportedOperationException();
  }
}
