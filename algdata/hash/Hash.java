class Hash{
  public static void main(String[] args){
    String post = "postnummer.csv";
    Benchmark bench = new Benchmark();
    HashZip hzip = new HashZip(post);
    //ArrayZip aZip = new ArrayZip("postnummer.csv");
    /*Integer skalvik = 13034;
    System.out.println(aZip.lookup(skalvik));*/
    //bench.bench();
    HashMod hMod = new HashMod(post);
    //hMod.collisions(Integer.parseInt(args[0]));
    System.out.println(hzip.lookup(13034));
  }
}
