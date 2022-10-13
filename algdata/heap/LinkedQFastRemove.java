class LinkedQFastRemove{
  Node first;
  Node last;

  public LinkedQFastRemove(Integer item){
    this.first = new Node(item, null);
    this.last = this.first;
  }
  public boolean empty(){
    return this.first == null;
  }
  public void add(Integer item){
    if(item == null)
      return;
    Node node = new Node(item, null);
    if(this.first == null)
      this.first = this.last = node;
    else{
      Node next = this.first;
      Node previous = null;
      while(next != null){
        if(item.compareTo(next.head) <= 0){
          if(previous == null){
            node.tail = this.first;
            this.first = node;
            return;
          }
          else{
            previous.tail = node;
            node.tail = next;
            return;
          }
        }
        previous = next;
        next = next.tail;
      }
      previous.tail = node;
    }
  }
  public Integer remove(){
    if(this.first == null)
      return null;
    Node node = this.first;
    this.first = this.first.tail;
    return node.head;
  }

  public class Node{
    public Integer head;
    public Node tail;

    public Node(Integer item, Node tail){
      this.head = item;
      this.tail = tail;
    }
    public String toString(){
      StringBuilder sb = new StringBuilder();
      Node next = this;
      while(next.tail != null){
        sb.append("" + next.head + " ");
        next = next.tail;
      }
      sb.append("" + next.head + " ");
      return sb.toString();
    }
  }
  public String toString(){
    if(this.first == null)
      return "";
    return this.first.toString();
  }
}
