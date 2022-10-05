import java.util.Iterator;
public class TreeIterator implements Iterator<BinaryTree.Node>{
  //private LinkedQ q;
  private ArrayQ q;

  public TreeIterator(BinaryTree tree){
    this.q = new ArrayQ(tree.root);
  }
  @Override
  public boolean hasNext(){
    return !q.empty();
  }
  @Override
  public BinaryTree.Node next(){
    BinaryTree.Node next = (BinaryTree.Node) q.remove();
    q.add(next.left);
    q.add(next.right);
    return next;
  }
  /*public Integer next(){
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
  }*/
  @Override
  public void remove(){
    throw new UnsupportedOperationException();
  }
}
