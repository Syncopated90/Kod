class HeapArray{
  Node[] array;
  int freeSpot;
  public HeapArray(){
    this.array = new Node[100];
    this.freeSpot = 0;
  }

  public void add(Integer item){
    this.array[this.freeSpot++] = new Node(item);
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
      if(this.head < node.head)
        return -1;
      else if (this.head == node.head)
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
