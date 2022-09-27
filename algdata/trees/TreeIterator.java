import java.util.Iterator;
public class TreeIterator implements Iterator<Integer>{
  private BinaryTree.Node next;
  private Stack<BinaryTree.Node> stack;

  public TreeIterator(BinaryTree tree){
    this.stack = new Stack(tree.root, null);
    this.next = tree.root.left;
    while(this.next != null){
      traverse();
    }
  }
  public void traverse(){
    System.out.println(next().toString());
    while(!hasRight()){
      this.next = stack.pop();
    }
    this.next = next.right;
    return;
  }
  public boolean hasRight(){
    if(next.right != null)
      return true;
    else
      return false;
  }
  @Override
  public boolean hasNext(){
    if(next.left != null)
      return true;
    else
      return false;
  }
  @Override
  public Integer next(){
    while(hasNext()){
      stack.push(this.next);
      this.next = next.left;
    }
    return this.next.value;
  }
  @Override
  public void remove(){
    throw new UnsupportedOperationException();
  }
}
