class Trie{
  public int charToCode(char letter){
    if((int) letter == 246)//ö
      return 27;
    else if((int) letter == 228)//ä
      return 26;
    else if((int) letter == 229)//å
      return 25;
    if((int) letter > 112)//larger than p
      letter--;
    if((int) letter > 118)//larger than v
      letter--;
    return (int) letter - 96;
  }
  public char codeToChar(int code){
    char oo = (char) 246;
    if(code == 27)//ö
      return (char) 246;
    else if(code == 26)//ä
      return (char) 228;
    else if(code == 25)//å
      return (char) 229;
    else
      return (char) (code + 96);
  }
  public int keyToIndex(int key){
    return key - 1;
  }
  public int charToKey(char letter){
    int code = charToCode(letter);
    /*if(code > 18)
      code--;
    if(code > 22)
      code--;
    if(code > 24)
      code += 2;*/
    return (int) (code + 2)/3;
  }

  public class Node{
    public Node[] next;
    public boolean word;

    public Node(){
      this.next = new Node[27];
      this.word = false;
    }
  }
}
