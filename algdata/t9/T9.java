class T9{
  public static void main(String[] args){
    Trie trie = new Trie();
    trie.add("ask");
    trie.add("bsl");
    trie.add("asl");
    //System.out.println(trie.search(args[0]));
    String[] words = {"hello", "world"};
    for(String i: words){
      i = "world " + i;
      System.out.println(i);
    }

    /*


    System.out.println(trie.codeToIndex(trie.charToCode('a')));
    trie.search("12");
    String hello = "9234";
    String a, b, c;
    a = b = c = "";
    System.out.println(c);
    System.out.println(hello.substring(5, hello.length()));
    if(hello.substring(0, hello.length()).length() == 0)
      System.out.println("1134 :" + String.valueOf(1234 - 100));
    System.out.println(Character.getNumericValue(hello.charAt(0)));
    System.out.println();
    if(trie.root[0] != null)
      System.out.println(trie.codeToChar(trie.indexToCode(0)));
    if(trie.root[trie.codeToIndex(trie.charToCode('a'))].next[trie.codeToIndex(trie.charToCode('s'))] != null)
      System.out.println((trie.charToCode('s')));
    System.out.println(trie.codeToChar(25));
    System.out.println(trie.keyToIndex(trie.charToCode('c')));char c = 109;//ascii m
    int a = trie.charToCode(c) + 96;
    char b = (char) a;
    for(int i = 0; i < 27; i++)
      System.out.println(args[0].charAt(i) + " : " + trie.charToKey(args[0].charAt(i)));
    System.out.println(trie.charToKey('s'));
    */
  }
}
