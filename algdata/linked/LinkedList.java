public class LinkedList{
  private int head;
  private LinkedList tail;

  public LinkedList(int item, LinkedList list){
    this.head = item;
    this.tail = list;
  }
  public void append(LinkedList list2){
    LinkedList next = this;
    while(next.getTail() != null)
      next = next.getTail();
    next.setTail(list2);
  }
  public void push(int value){
    LinkedList list = new LinkedList(this.getHead(), this.getTail());
    this.setHead(value);
    this.setTail(list);
  }

  public int pop(){
    int value = this.getHead();
    if(this.getTail() != null){
      this.setHead(this.getTail().getHead());
      this.setTail(this.getTail().getTail());
    }
    else if(this.getHead() != 0){
      this.setHead(0);
    }
    return value;
  }

  public int getHead(){
    return this.head;
  }
  private void setHead(int newHead){
    this.head = newHead;
  }
  public LinkedList getTail(){
    return this.tail;
  }
  public void setTail(LinkedList newTail){
    this.tail = newTail;
  }
  public String toString(){
    StringBuilder sb = new StringBuilder();
    LinkedList next = this;
    while(next.getTail() != null){
      sb.append("" + next.getHead() + " ");
      next = next.getTail();
    }
    sb.append("" + next.getHead() + " ");
    return sb.toString();
  }
}
