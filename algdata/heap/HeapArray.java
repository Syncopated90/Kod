class HeapArray{
  Node[] array;
  int freeSpot;
  public HeapArray(){
    this.array = new Node[100];
    this.freeSpot = 0;
  }
  public HeapArray(int n){
    this.array = new Node[n];
    this.freeSpot = 0;
  }
  public Integer push(int incr){
    this.array[0].head += incr;
    Integer depth = sink();
    return depth;
  }
  public Integer remove(){
    Integer valueToReturn = this.array[0].head;
    this.array[0] = this.array[--freeSpot];
    sink();
    return valueToReturn;
  }
  public Integer sink(){
    int index = 0;
    int depth = 0;
    while(true){
      if(getLeftChildIndex(index) < freeSpot && getRightChildIndex(index) < freeSpot &&
        this.array[index].compareTo(getLeftChild(index)) > 0 &&
        getLeftChild(index).compareTo(getRightChild(index)) <= 0){
        swap(index, getLeftChildIndex(index));
        index = getLeftChildIndex(index);
        depth++;
      }
      else if(getRightChildIndex(index) < freeSpot && this.array[index].compareTo(getRightChild(index)) > 0){
        swap(index, getRightChildIndex(index));
        index = getRightChildIndex(index);
        depth++;
      }
      else if(getLeftChildIndex(index) < freeSpot && this.array[index].compareTo(getLeftChild(index)) > 0){
        swap(index, getLeftChildIndex(index));
        index = getLeftChildIndex(index);
        depth++;
      }
      else
        return depth;
    }
  }
  public Node getLeftChild(int index){
    return this.array[(2 * index) + 1];
  }
  public Node getRightChild(int index){
    return this.array[(2 * index) + 2];
  }
  public int getLeftChildIndex(int index){
    return (2 * index) + 1;
  }
  public int getRightChildIndex(int index){
    return (2 * index) + 2;
  }
  public Integer add(Integer item){
    this.array[this.freeSpot++] = new Node(item);
    return bubble(freeSpot - 1);
  }
  public Integer bubble(int index){
    Integer depth = 0;
    while(index > 0 && this.array[index].compareTo(getParent(index)) < 0){
        swap(index, getParentIndex(index));
        index = getParentIndex(index);
        depth++;
    }
    return depth;
  }
  public Node getParent(int index){
    if(index % 2 == 0)
      return this.array[(index - 2) / 2];
    else
      return this.array[(index - 1) / 2];
  }
  public int getParentIndex(int index){
    if(index % 2 == 0)
      return (index - 2) / 2;
    else
      return (index - 1) / 2;
  }
  public void swap(int one, int two){
    Node temp = this.array[one];
    this.array[one] = this.array[two];
    this.array[two] = temp;
  }
  public class Node implements Comparable<Node>{
    Integer head;
    int position;
    public Node(Integer item){
      this.head = item;
    }
    public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append(this.head);
      return sb.toString();
    }

    @Override
    public int compareTo(Node node){
      if(this.head.compareTo(node.head) < 0)
        return -1;
      else if (this.head.compareTo(node.head) == 0)
        return 0;
      else
        return 1;
    }
  }

  public String toString(){
    if(this.freeSpot == 0)
      return "";
    else{
      StringBuilder sb = new StringBuilder();
      int i = 0;
      while(i < this.freeSpot){
        sb.append(this.array[i++].toString() + " ");
      }
      return sb.toString();
    }
  }
}
