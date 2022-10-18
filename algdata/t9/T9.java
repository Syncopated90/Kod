class T9{
  public static void main(String[] args){
    Trie trie = new Trie();
    char c = 109;//ascii m
    int a = trie.charToCode(c) + 96;
    char b = (char) a;
    for(int i = 0; i < 27; i++)
      System.out.println(args[0].charAt(i) + " : " + trie.charToKey(args[0].charAt(i)));
    //System.out.println(trie.charToKey('s'));
  }
}
