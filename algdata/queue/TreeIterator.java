import java.util.Iterator;
public class TreeIterator implements Iterator<BinaryTree.Node>{
  private BinaryTree.Node next;
  private LinkedQ q;

  public TreeIterator(BinaryTree tree){
    this.q = new LinkedQ(tree.root);
    this.next = tree.root;
  }
  @Override
  public boolean hasNext(){
    return q.first != null;
  }
  @Override
  public BinaryTree.Node next(){
    this.next = (BinaryTree.Node) q.remove();
    if(this.next != null){
      q.add(this.next.left);
      q.add(this.next.right);
    }
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