class LinkedList{
  public Node first;
  public Node last;
  public LinkedList(int head){
    first = last = new Node(head, null, null);
  }
  public LinkedList(){
    this.first = this.last = null;
  }
  public void append(Node node){
    if(this.first == null){
      this.first = node;
      this.last = node;
    }
    else{
      node.before = this.last;
      this.last.tail = node;
      this.last = node;
    }
  }
  public void append(LinkedList list){
    this.last.tail = list.first;
    list.first.before = this.last;
    this.last = list.last;
  }
  class Node{
    public int head;
    public Node before;
    public Node tail;
    public Node(int head, Node before, Node tail){
      this.head = head;
      this.before = before;
      this.tail = tail;
    }
    private void append(Node node){
      Node temp = this.tail;
      node.before = this;
      this.tail = node;
      node.tail = temp;
    }
    public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append(this.head);
      return sb.toString();
    }
  }
  public void quicksort(Node start, Node end){
    if(start == null || end == null || end == start)
      return;
    Node pivot = partition(start, end);
    quicksort(start, pivot.before);
    System.out.println(this.toString());
    System.out.println("pivot: " + pivot);
    quicksort(pivot.tail, end);
  }

  public Node partition(Node next, Node end){
    if(next == null || end == null || end == next)
      return next;
    Node pivot = end;
    while(next != null && next.tail != null && next != pivot){
      if(next.tail.head > pivot.head){
        Node temp = next.tail.tail;
        pivot.append(next.tail);
        next.tail = temp;
        if(temp != null)
          temp.before = next;
      }
      next = next.tail;
      System.out.println("hello world");
    }
    return pivot;
  }
  public String toString(){
    StringBuilder sb = new StringBuilder("(");
    Node next = this.first;
    while(next.tail != null){
      sb.append(next.head + ", ");
      next = next.tail;
    }
    sb.append(next.head + ")");
    return sb.toString();
  }
}
