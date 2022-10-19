class Trie{
  Node[] root;

  public Trie(){
    this.root = new Node[27];
  }

  public void add(String word){
    Node[] letters = this.root;
    for(int i = 0; i < word.length(); i++){
      if(letters[codeToIndex(charToCode(word.charAt(i)))] == null)
        letters[codeToIndex(charToCode(word.charAt(i)))] = new Node(false);
      if(i == word.length() - 1)
        letters[codeToIndex(charToCode(word.charAt(i)))].exist = true;
      letters = letters[codeToIndex(charToCode(word.charAt(i)))].next;
    }
  }
  public String search(String word){
    int key = Character.getNumericValue(word.charAt(0));
    String a, b, c;
    a = b = c = "";
    if(word.length() == 1){
      if(this.root[(key - 1) * 3] != null && this.root[(key - 1) * 3].exist == true){
        a = Character.toString(codeToChar((key - 1) * 3 + 1)) + " ";
      }
      if(this.root[((key - 1) * 3) + 1] != null && this.root[(key - 1) * 3 + 1].exist == true){
        b = Character.toString(codeToChar((key - 1) * 3 + 2)) + " ";
      }
      if(this.root[((key - 1) * 3) + 2] != null && this.root[(key - 1) * 3 + 2].exist == true)
        c = Character.toString(codeToChar((key - 1) * 3 + 3)) + " ";
    }
    else if(word.length() > 1){
      if(this.root[(key - 1) * 3] != null){
        a = this.root[(key - 1) * 3].search(word.substring(1, word.length()));
        //if(this.root[(key - 1) * 3].exist == true)
        if(a.length() != 0)
          a = Character.toString(codeToChar((key - 1) * 3 + 1)) + a;

      }
      if(this.root[((key - 1) * 3 + 1)] != null){
        b = this.root[((key - 1) * 3 + 1)].search(word.substring(1, word.length()));
        //if(this.root[(key - 1) * 3 + 1].exist == true)
        if(b.length() != 0)
          b = Character.toString(codeToChar((key - 1) * 3 + 2)) + b;

      }
      if(this.root[((key - 1) * 3 + 2)] != null){
        c = this.root[((key - 1) * 3 + 2)].search(word.substring(1, word.length()));
        //if(this.root[(key - 1) * 3 + 2].exist == true)
        if(c.length() != 0)
          c = Character.toString(codeToChar((key - 1) * 3 + 3)) + c;
      }
    }
    return a + b + c;
  }

  public class Node{
    public Node[] next;
    public boolean exist;

    public Node(){
      this.next = new Node[27];
      this.exist = false;
    }

    public Node(boolean word){
      this.next = new Node[27];
      this.exist = word;
    }
    public String search(String word){
      int key = Character.getNumericValue(word.charAt(0));
      String a, b, c;
      a = b = c = "";
      if(word.length() == 1){
        if(this.next[(key - 1) * 3] != null)
          a = Character.toString(codeToChar((key - 1) * 3 + 1)) + " ";
        if(this.next[((key - 1) * 3) + 1] != null)
          b = Character.toString(codeToChar((key - 1) * 3 + 2)) + " ";
        if(this.next[((key - 1) * 3) + 2] != null)
          c = Character.toString(codeToChar((key - 1) * 3 + 3)) + " ";
      }
      else if(word.length() > 1){
        if(this.next[(key - 1) * 3] != null){
          a = this.next[(key - 1) * 3].search(word.substring(1, word.length()));
          if(a.length() != 0)
            a = Character.toString(codeToChar((key - 1) * 3 + 1)) + a;

        }
        if(this.next[((key - 1) * 3 + 1)] != null){
          b = this.next[((key - 1) * 3 + 1)].search(word.substring(1, word.length()));
          if(b.length() != 0)
            b = Character.toString(codeToChar((key - 1) * 3 + 2)) + b;

        }
        if(this.next[((key - 1) * 3 + 2)] != null){
          c = this.next[((key - 1) * 3 + 2)].search(word.substring(1, word.length()));
          if(c.length() != 0)
            c = Character.toString(codeToChar((key - 1) * 3 + 3)) + c;
        }
      }
      return a + b + c;
    }
  }
  
  public int charToCode(char letter){//returns 1 - 27 for respective letter
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
    if(code == 27)//ö
      return (char) 246;
    else if(code == 26)//ä
      return (char) 228;
    else if(code == 25)//å
      return (char) 229;
    if(code > 16)
      code++;
    if(code > 21)
      code++;
    return (char) (code + 96);
  }
  public int codeToIndex(int code){
    code -= 1;
    return code;
  }
  public int indexToCode(int index){
    index += 1;
    return index;
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
}
