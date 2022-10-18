class Hash{
  public static void main(String[] args){
    String post = "postnummer.csv";
    Benchmark bench = new Benchmark();
    //HashZip hzip = new HashZip(post);
    //ArrayZip aZip = new ArrayZip("postnummer.csv");
    /*Integer skalvik = 13034;
    System.out.println(aZip.lookup(skalvik));*/
    bench.bench();
    //HashMod hMod = new HashMod(post);
    //hMod.collisions(Integer.parseInt(args[0]));
    //System.out.println(hzip.lookup(11115));
    //HashProbing hProbe = new HashProbing(post);
    /*for(int i = 11115; i < 98499; i++){
      if(hProbe.lookup(i) != null && hProbe.lookup(i).equals(1) == false)
        System.out.println(i);
    }*/
    //System.out.println(hProbe.lookup(98494));
    //System.out.println(hProbe.lookup(13134));
  }
}
