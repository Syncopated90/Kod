class ArrayQ<T>{
  int first;
  int last;
  T[] array;
  public ArrayQ(T item){
    this.array = (T[]) new Object[10];
    this.array[0] = item;
    this.first = 0;
    this.last = 1;
  }
  public void add(T item){
    if(item == null)
      return;
    else if(this.last == this.array.length && this.first != 0){
      this.last = 0;
      array[last++] = item;
    }
    else if(this.last == this.array.length && this.first == 0){
      T[] newArray =(T[]) new Object[this.array.length * 2];
      for(int i = 0; i < this.array.length; i++)
        newArray[i] = this.array[i];
      newArray[last++] = item;
      this.array = newArray;
    }
    else if(this.last == this.first && this.array[last] != null){
      T[] newArray =(T[]) new Object[this.array.length * 2];
      int j = 0;
      for(int i = this.first; i < this.array.length; i++)
        newArray[j++] = this.array[i];
      for(int i = 0; i < this.last; i++)
        newArray[j++] = this.array[i];
      this.first = 0;
      this.last = this.array.length;
      newArray[last++] = item;
      this.array = newArray;
    }
    else
      this.array[last++] = item;
  }
  public T remove(){
    if(this.array[first] == null)
      return null;
    T item = this.array[first];
    this.array[first++] = null;
    if( first == array.length)
      first = 0;
    return item;
  }
  public boolean empty(){
    return this.array[first] == null;
  }
  public String toString(){
    StringBuilder sb = new StringBuilder();
    if(array[first] == null)
      return null;
    else if(this.first <= this.last){
      int i = this.first;
      while(i < this.last)
        sb.append(array[i++] + " ");
    }
    else{
      int j = this.last - 1;
      while(j++ < first)
        sb.append(array[j++] + " ");
    }
    return sb.toString();
  }
}
