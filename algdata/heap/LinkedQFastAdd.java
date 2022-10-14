class LinkedQFastAdd{
  Node first;
  Node last;

  public LinkedQFastAdd(Integer item){
    this.first = new Node(item, null);
    this.last = this.first;
  }
  public LinkedQFastAdd(){
    this.first = this.last = null;
  }
  public boolean empty(){
    return this.first == null;
  }
  public void add(Integer item){
    if(item == null)
      return;
    else if(this.first == null)
      this.first = this.last = new Node(item, null);
    else{
      this.last.tail = new Node(item, null);
      this.last = this.last.tail;
    }
  }
  public Integer remove(){
    if(this.first == null)
      return null;
    Node prio = this.first;
    Node beforePrio = null;
    Node next = this.first;
    Node previous = null;
    while(next != null){
      if(next.head.compareTo(prio.head) < 0){
        beforePrio = previous;
        prio = next;
      }
      previous = next;
      next = next.tail;
    }
    if(beforePrio != null)
      beforePrio.tail = prio.tail;
    else
      this.first = first.tail;
    return prio.head;
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
