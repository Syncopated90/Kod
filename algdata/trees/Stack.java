class Stack<Node>{
  public BinaryTree.Node head;
  public Stack tail;

  public Stack(BinaryTree.Node node, Stack tail){
    this.head = node;
    this.tail = tail;
  }
  public Stack push(BinaryTree.Node node){
    this.tail = this;
    this.head = node;
    return this;
  }

  public BinaryTree.Node pop(){
    BinaryTree.Node node = this.head;
    if(this.tail != null){
      this.head = this.tail.head;
      this.tail = this.tail.tail;
      return node;
    }
    else{
      this.head = null;
      return node;
    }
  }
}
