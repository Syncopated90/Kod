class LinkedQ<T>{
  Node first;
  Node last;

  public LinkedQ(T item){
    this.first = new Node(item, null);
    this.last = this.first;
  }
  public boolean empty(){
    return this.first == null;
  }
  public void add(T item){
    if(item == null)
      return;
    else if(this.first == null)
      this.first = this.last = new Node(item, null);
    else{
      this.last.tail = new Node(item, null);
      this.last = this.last.tail;
    }
    //System.out.println("Q is now: " + this.firstToString());
  }
  public T remove(){
    if(this.first == null)
      return null;
    Node<T> node = this.first;
    this.first = this.first.tail;
    return node.value;
  }

  public class Node<T>{
    public T value;
    public Node<T> tail;

    public Node(T item, Node tail){
      this.value = item;
      this.tail = tail;
    }
    public String toString(){
      StringBuilder sb = new StringBuilder();
      Node next = this;
      while(next.tail != null){
        sb.append("" + next.value + " ");
        next = next.tail;
      }
      sb.append("" + next.value + " ");
      return sb.toString();
    }
  }
  /*public Node getTail(){
    return this.tail;
  }
  public Integer getHead(){
    return this.value;
  }*/
  public String toString(){
    if(this.first == null)
      return "";
    return this.first.toString();
  }
  public String firstToString(){
    if(this.first == null)
      return "";
    StringBuilder sb = new StringBuilder();
    sb.append(this.first.value + " ");
    return sb.toString();
  }

}
