class Queue{
  public static void main(String[] args){
    BinaryTree binTree = new BinaryTree(10,20);
    System.out.println("binTree was created: " + binTree.toString());
    binTree.add(2,4);
    binTree.add(7,14);
    binTree.add(1,2);
    binTree.add(8,16);
    binTree.add(15,30);
    binTree.add(13,26);
    binTree.add(14,28);
    binTree.add(6, 12);
    //System.out.println(binTree.toString());
    for(BinaryTree.Node i:binTree)
      System.out.println(i.value);

    /*LinkedQ q = new LinkedQ(8);
    System.out.println(q.toString());
    q.add(7);
    System.out.println(q.toString());
    q.add(6);
    System.out.println(q.toString());
    q.add(5);
    System.out.println(q.toString());
    Integer a = (Integer) q.remove();
    System.out.println(q.toString());
    System.out.println("removed: " + a);
    a = (Integer) q.remove();
    System.out.println(q.toString());
    System.out.println("removed: " + a);
    a = (Integer) q.remove();
    System.out.println(q.toString());
    System.out.println("removed: " + a);
    a = (Integer) q.remove();
    System.out.println("removed: " + a);
    a = (Integer) q.remove();
    System.out.println("removed: " + a);
    System.out.println(q.toString());
    q.add(1);
    System.out.println(q.toString());*/
  }
}