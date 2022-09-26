class DoubleList{
  private int head;
  private DoubleList tail;
  private DoubleList prev;

  public DoubleList(int item, DoubleList list){
    this.head = item;
    this.tail = list;
    this.prev = null;
  }
  public DoubleList(int item, DoubleList tailList, DoubleList prevList){
    this.head = item;
    this.tail = tailList;
    this.prev = prevList;
  }

  public static DoubleList createList(int headStart, int headEnd){
    DoubleList list = new DoubleList(headEnd, null);
    for(int i = headEnd - 1; i >= headStart; i--){
      list = new DoubleList(i, list, null);
      list.getTail().setPrev(list);
    }
    return list;
  }

  public DoubleList remove(int index){
    DoubleList list = this;
    int current = 0;
    if(index == 0){
      list.getTail().setPrev(null);
      list = list.getTail();
      return list;
    }
    while(current < index && list.getTail() != null){
      list = list.getTail();
      current++;
    }
    if(list.getTail() == null){
      list.getPrev().setTail(null);
      return this;
    }
    list.getTail().setPrev(list.getPrev());
    list.getPrev().setTail(list.getTail());
    return this;
  }

  public DoubleList add(DoubleList newList){
    newList.setTail(this);
    this.setPrev(newList);
    return newList;
  }

  public void append(DoubleList tail){
    DoubleList next = this;
    DoubleList prev = null;
    while(next.getTail() != null)
      next = next.getTail();
    next.setTail(tail);
    tail.setPrev(next);
  }
  public int getHead(){
    return this.head;
  }
  private void setHead(int newHead){
    this.head = newHead;
  }
  public DoubleList getTail(){
    return this.tail;
  }
  public void setTail(DoubleList newTail){
    this.tail = newTail;
  }
  public DoubleList getPrev(){
    return this.prev;
  }
  public void setPrev(DoubleList list){
    this.prev = list;
  }
  public String toString(){
    StringBuilder sb = new StringBuilder();
    DoubleList next = this;
    while(next.getTail() != null){
      sb.append("" + next.getHead() + " ");
      next = next.getTail();
    }
    sb.append("" + next.getHead() + " ");
    return sb.toString();
  }
  public void push(int value){
    DoubleList list = new DoubleList(this.getHead(), this.getTail());
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
}
