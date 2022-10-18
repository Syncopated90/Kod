class Benchmark{
  public Benchmark(){

  }
  public void bench(){
    int tries = 10;
    int loop = 10000;
    double t0, t1;
    double min = Double.POSITIVE_INFINITY;
    String dummy = "";
    String firstCodeString = "111 15";
    Integer firstCodeInteger = 11115;
    String secondCodeString = "984 25"; //obs inte tänkta!!
    Integer secondCodeInteger = 98431;
    Zip zip = new Zip("postnummer.csv");
    ArrayZip aZip = new ArrayZip("postnummer.csv");
    Integer modulo = 20011;
    HashProbing hProbe = new HashProbing("postnummer.csv", modulo);
    HashZip hZip = new HashZip("postnummer.csv", modulo);
    Integer numberOfChecks = 0;
    Integer number = 11325;
    Integer lookupNumber = secondCodeInteger;
    for(int j = 0; j < tries; j++){
      t0 = System.nanoTime();
      for(int i = 0; i < loop; i++){
        numberOfChecks = hZip.lookup(lookupNumber);
        //dummy = hZip.lookup(lookupNumber);
      }
      t1 = System.nanoTime();
      if((t1 - t0) < min)
        min = t1 - t0;
    }
    System.out.println(numberOfChecks + " checks for lookup of " + lookupNumber + " mod " + modulo + " in buckets");
    //System.out.println(dummy);
    System.out.println("Execution time: " + min/loop + " ns");
    min = Double.POSITIVE_INFINITY;
    for(int j = 0; j < tries; j++){
      t0 = System.nanoTime();
      for(int i = 0; i < loop; i++){
        numberOfChecks = hProbe.lookup(lookupNumber);
      }
      t1 = System.nanoTime();
      if((t1 - t0) < min)
        min = t1 - t0;
    }
    System.out.println(numberOfChecks + " checks for lookup of " + lookupNumber + " mod " + modulo + " for linear probing");
    System.out.println("Execution time: " + min/loop + " ns");
    /*for(int j = 0; j < tries; j++){
      t0 = System.nanoTime();
      for(int i = 0; i < loop; i++){
        dummy = zip.lookup(secondCodeInteger);
      }
      t1 = System.nanoTime();
      if((t1 - t0) < min)
        min = t1 - t0;
    }
    System.out.println("min search time : " + min/(loop) + " ns for linear Integer comparison of " + secondCodeString);
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
    System.out.println("min search time : " + min/(loop) + " ns for linear String comparison");
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
    System.out.println("min search time : " + min/(loop) + " ns for array code index lookup");*/
  }
}
