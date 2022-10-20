class T9{
  public static void main(String[] args){
    Trie trie = new Trie();
    trie.addList("kelly2.txt");
    String[] a = trie.search(args[0]);
    for(String s : a)
      System.out.println(s);
    //System.out.println(a.length);

    /*
    trie.add("ask");
    trie.add("bsl");
    trie.add("asl");
    trie.add("bajs");
    */
  }
}
