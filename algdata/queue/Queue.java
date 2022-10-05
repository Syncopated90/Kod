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
    binTree.add(16,32);
    binTree.add(6, 12);
    binTree.add(18,36);
    binTree.add(14,28);
    binTree.add(5,10);
    binTree.add(20, 40);
    //System.out.println(binTree.toString());
    for(BinaryTree.Node i:binTree)
      System.out.println(i.value);
    /*ArrayQ<Integer> q = new ArrayQ<Integer>(0);
    Integer hello = q.remove();
    hello = q.remove();
    for(int i = 1; i < 10; i++)
      q.add(i);
    System.out.println(q.toString());
    for(int i = 0; i < 5; i++){
      Integer dummy = q.remove();
      System.out.println("removed value: " + dummy);
      System.out.println(q.toString());
      }
    for(int i = 1; i < 10; i++)
      q.add(i);
    System.out.println(q.toString());
    for(int i = 0; i < 10; i++){
      Integer dummy = q.remove();
      System.out.println("removed value: " + dummy);
      System.out.println(q.toString());
      }
*/
    /*
    System.out.println(q.toString());
    q.add(5);
    System.out.println(q.toString());

    dummy = q.remove();
    System.out.println(q.toString());
    System.out.println("removed value: " + dummy);
    dummy = q.remove();
    System.out.println(q.toString());
    System.out.println("removed value: " + dummy);
    */
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
    q.add(2);
    System.out.println(q.toString());
    a = (Integer) q.remove();
    System.out.println(q.toString());
    System.out.println("removed: " + a);*/
  }
}
