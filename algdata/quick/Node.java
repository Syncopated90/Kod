class LinkedList{
  public Node first;
  public Node last;
  public Node beforePivot;
  public LinkedList(int head){
    this.first = this.last = new Node(head, null);
    this.beforePivot = null;
  }
  public LinkedList(){
    this.first = this.last = this.beforePivot = null;
  }
  public LinkedList(Node node){
    this.first = this.last = node;
    this.beforePivot = null;
  }
  public void append(Node node){
    if(this.first == null){
      this.first = node;
      this.last = node;
    }
    else{
      this.last.tail = node;
      this.last = node;
    }
  }
  public void append(LinkedList list){
    if(list.first == null){
      return;
    }
    this.last.tail = list.first;
    this.last = list.last;
    if(list.last != null)
      list.last.tail = null;
  }
  class Node{
    public int head;
    public Node tail;
    public Node(int head, Node tail){
      this.head = head;
      this.tail = tail;
    }
    private void append(Node node){
      Node temp = this.tail;
      this.tail = node;
      node.tail = temp;
    }
    private void append(LinkedList list){
      this.tail = list.first;
      list.first = this;
    }
    public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append(this.head);
      return sb.toString();
    }
  }
  public LinkedList quicksort(Node start, Node end){
    if(start == null || end == null || end == start){
      LinkedList list = new LinkedList(start);
      return list;
    }
    LinkedList list = partition(start, end);
    LinkedList low = list.quicksort(list.first, list.beforePivot);
    LinkedList high = list.quicksort(list.beforePivot.tail, list.last);
    low.append(high);
    return low;
  }

  public LinkedList partition(Node next, Node end){
    if(next == null || end == null || end.equals(next))
      return new LinkedList(next);
    Node pivot = end;
    Node previous = null;
    LinkedList low = new LinkedList();
    LinkedList high = new LinkedList();
    while(next != null && !next.equals(end)){
      if(next.head > end.head){
        high.append(next);
      }else
        low.append(next);
      previous = next;
      next = next.tail;
    }
    low.append(end);
    low.append(high);
    if(low.first.equals(end))
      low.beforePivot = end;
    else
      low.beforePivot = previous;
    return low;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder("(");
    Node next = this.first;
    if(next == null)
      return "";
    while(next.tail != null){
      sb.append(next.head + ", ");
      next = next.tail;
    }
    sb.append(next.head + ")");
    return sb.toString();
  }
}
