class Benchmark{
  public Benchmark(){

  }
  public void bench(){
    int tries = 10;
    int loop = 10000;
    double t0, t1;
    double min = Double.POSITIVE_INFINITY;
    String dummy;
    String firstCodeString = "111 15";
    Integer firstCodeInteger = 11115;
    String secondCodeString = "954 25"; //obs inte tänkta!!
    Integer secondCodeInteger = 95435;
    Zip zip = new Zip("postnummer.csv");
    ArrayZip aZip = new ArrayZip("postnummer.csv");
    for(int j = 0; j < tries; j++){
      t0 = System.nanoTime();
      for(int i = 0; i < loop; i++){
        dummy = zip.lookup(secondCodeInteger);
      }
      t1 = System.nanoTime();
      if((t1 - t0) < min)
        min = t1 - t0;
    }
    System.out.println("min search time : " + min/(loop) + " ns for Integer comparison");
    min = Double.POSITIVE_INFINITY;
    for(int j = 0; j < tries; j++){
      t0 = System.nanoTime();
      for(int i = 0; i < loop; i++){
        dummy = zip.lookup(secondCodeString);
      }
      t1 = System.nanoTime();
      if((t1 - t0) < min)
        min = t1 - t0;
    }
    System.out.println("min search time : " + min/(loop) + " ns for String comparison");
    min = Double.POSITIVE_INFINITY;
    for(int j = 0; j < tries; j++){
      t0 = System.nanoTime();
      for(int i = 0; i < loop; i++){
        dummy = zip.binaryLookup(secondCodeString);
      }
      t1 = System.nanoTime();
      if((t1 - t0) < min)
        min = t1 - t0;
    }
    System.out.println("min search time : " + min/(loop) + " ns for binary string lookup");
    min = Double.POSITIVE_INFINITY;
    for(int j = 0; j < tries; j++){
      t0 = System.nanoTime();
      for(int i = 0; i < loop; i++){
        dummy = zip.binaryLookup(secondCodeInteger);
      }
      t1 = System.nanoTime();
      if((t1 - t0) < min)
        min = t1 - t0;
    }
    System.out.println("min search time : " + min/(loop) + " ns for binary Integer lookup");
    min = Double.POSITIVE_INFINITY;
    for(int j = 0; j < tries; j++){
      t0 = System.nanoTime();
      for(int i = 0; i < loop; i++){
        dummy = aZip.lookup(secondCodeInteger);
      }
      t1 = System.nanoTime();
      if((t1 - t0) < min)
        min = t1 - t0;
    }
    System.out.println("min search time : " + min/(loop) + " ns for array code index lookup");
  }
}
