class LogCounter{
  public static void main(String[] args){
    /*int i = 4000;
    System.out.println(0.007 * (i * Math.log(i)));
    i *= 2;
    System.out.println(0.007 * (i * Math.log(i)));
    i *= 2;
    System.out.println(0.022 * (i * Math.log(i)));
    i *= 2;
    System.out.println(0.019 * (i * Math.log(i)));
    i *= 2;
    System.out.println(0.02 * (i * Math.log(i)));
    i *= 2;
    System.out.println(0.02 * (i * Math.log(i)));
    i *= 2;
    System.out.println(0.023 * (i * Math.log(i)));
    i *= 2;*/
    for(int i = 45; i < 4000; i *= 2)
      System.out.println(i);
  }
}
