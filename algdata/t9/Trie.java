import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Trie{
  public Trie[] next;
  public boolean exist;

  public Trie(){
    this.next = new Trie[27];
    this.exist = false;
  }

  public Trie(boolean word){
    this.next = new Trie[27];
    this.exist = word;
  }
  public void addList(String file){
    try(BufferedReader br = new BufferedReader(new FileReader(file))){
      String line;
      while((line = br.readLine()) != null){
        add(line);
      }
    }catch (IOException ioe){
      System.out.println("file " + file + " not found");
    }
  }

  public void add(String word){
    Trie[] letters = this.next;
    for(int i = 0; i < word.length(); i++){
      if(letters[codeToIndex(charToCode(word.charAt(i)))] == null)
        letters[codeToIndex(charToCode(word.charAt(i)))] = new Trie(false);
      if(i == word.length() - 1)
        letters[codeToIndex(charToCode(word.charAt(i)))].exist = true;
      letters = letters[codeToIndex(charToCode(word.charAt(i)))].next;
    }
  }
  public String[] search(String word){
    int key = Character.getNumericValue(word.charAt(0));
    String a, b, c;
    a = b = c = "";
    String[] array1, array2, array3;
    array1 = array2 = array3 = new String[0];
    int strings = 0;
    if(word.length() == 1){
      if(this.next[(key - 1) * 3] != null && this.next[(key - 1) * 3].exist == true){
        a = Character.toString(codeToChar((key - 1) * 3 + 1));
        strings++;
      }
      if(this.next[((key - 1) * 3) + 1] != null && this.next[(key - 1) * 3 + 1].exist == true){
        b = Character.toString(codeToChar((key - 1) * 3 + 2));
        strings++;
      }
      if(this.next[((key - 1) * 3) + 2] != null && this.next[(key - 1) * 3 +2].exist == true){
        c = Character.toString(codeToChar((key - 1) * 3 + 3));
        strings++;
      }
      String[] array = new String[strings];
      strings = 0;
      if(!a.equals("")){
        array[strings] = a;
        strings++;
      }
      if(!b.equals("")){
        array[strings] = b;
        strings++;
      }
      if(!c.equals(""))
        array[strings] = c;
      return array;
    }
    else if(word.length() > 1){
      if(this.next[(key - 1) * 3] != null){
        array1 = this.next[(key - 1) * 3].search(word.substring(1, word.length()));
        for(int i = 0; i < array1.length;i++)
          array1[i] = Character.toString(codeToChar((key - 1) * 3 + 1)) + array1[i];
      }
      if(this.next[((key - 1) * 3 + 1)] != null){
        array2 = this.next[((key - 1) * 3 + 1)].search(word.substring(1, word.length()));
        for(int i = 0; i < array2.length;i++)
          array2[i] = Character.toString(codeToChar((key - 1) * 3 + 2)) + array2[i];

      }
      if(this.next[((key - 1) * 3 + 2)] != null){
        array3 = this.next[((key - 1) * 3 + 2)].search(word.substring(1, word.length()));
        for(int i = 0; i < array3.length;i++)
          array3[i] = Character.toString(codeToChar((key - 1) * 3 + 3)) + array3[i];
      }
    }
    String[] array = new String[array1.length + array2.length + array3.length];
    int i = 0;
    for(i = 0; i < array1.length; i++)
      array[i] = array1[i];
    for(i = i; i < array1.length + array2.length; i++)
      array[i] = array2[i - array1.length];
    for(i = i; i < array.length; i++)
      array[i] = array3[i - (array1.length + array2.length)];
    return array;
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
    return (int) (code + 2)/3;
  }
}
