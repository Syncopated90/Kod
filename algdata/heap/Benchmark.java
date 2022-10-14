import java.util.Random;
class Benchmark{
  LinkedQFastAdd linkedFAdd;
  LinkedQFastRemove linkedFRemove;
  public Benchmark(){
    this.linkedFAdd = new LinkedQFastAdd();
    this.linkedFRemove = new LinkedQFastRemove();
  }

  
  public void benchRemoveLinked(){
    int n = 800;
    int loop = 10;
    int tries = 5;
    int adds = 20;
    double t0, t1;
    Random random = new Random();
    while(n < 204800){
      int[] randomInts = new int[n + adds];
      for(int i = 0; i < n + adds; i++){
        randomInts[i] = random.nextInt(n * 10);
      }
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries; i++){
        this.linkedFAdd.first = null;
        this.linkedFAdd.last = null;
        for(int k = 0; k < n; k++){
          this.linkedFAdd.add(randomInts[k]);
        }
				t0 = System.nanoTime();
        for(int k = 0; k < adds; k++){
          this.linkedFAdd.remove();
        }
				t1 = System.nanoTime();
				double temp = (t1 - t0);
				if(temp < min)
					min = temp;
			}
			System.out.println("Minimum remove time for " + adds + " elements with n = " + n + ": " + min/1000 + " us with a fast add linked list");
      System.out.println("Quotient for fast add t/n : " + min/(n));
      min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries; i++){
  			this.linkedFRemove.first = null;
        this.linkedFRemove.last = null;
        for(int k = 0; k < n; k++){
          this.linkedFRemove.add(randomInts[k]);
        }
        t0 = System.nanoTime();
        for(int k = 0; k < adds; k++){
          this.linkedFRemove.remove();
        }
				t1 = System.nanoTime();
				double temp = (t1 - t0);
				if(temp < min)
					min = temp;
			}
			System.out.println("Minimum remove time for " + adds + " elements with n = " + n + ": " + min/1000 + " us with a fast remove linked list");
      //System.out.println("Quotient for fast remove t/n : " + min/(n));
      n *= 2;
    }
  }
  public void benchAddLinked(){
    int n = 800;
    int loop = 10;
    int tries = 5;
    int adds = 20;
    double t0, t1;
    Random random = new Random();
    while(n < 204800){
      int[] randomInts = new int[n + adds];
      for(int i = 0; i < n + adds; i++){
        randomInts[i] = random.nextInt(n * 10);
      }
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries; i++){
        this.linkedFAdd.first = null;
        this.linkedFAdd.last = null;
        for(int k = 0; k < n; k++){
          this.linkedFAdd.add(randomInts[k]);
        }
				t0 = System.nanoTime();
        for(int k = n; k < n + adds; k++){
          this.linkedFAdd.add(randomInts[k]);
        }
				t1 = System.nanoTime();
				double temp = (t1 - t0);
				if(temp < min)
					min = temp;
			}
			System.out.println("Minimum add time for " + adds + " elements with n = " + n + ": " + min/1000 + " us with a fast add linked list");
      //System.out.println("Quotient for fast add t/n : " + min/(n));
      min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries; i++){
  			this.linkedFRemove.first = null;
        this.linkedFRemove.last = null;
        for(int k = 0; k < n; k++){
          this.linkedFRemove.add(randomInts[k]);
        }
        t0 = System.nanoTime();
        for(int k = n; k < n + adds; k++){
          this.linkedFRemove.add(randomInts[k]);
        }
				t1 = System.nanoTime();
				double temp = (t1 - t0);
				if(temp < min)
					min = temp;
			}
			System.out.println("Minimum add time for " + adds + " elements with n = " + n + ": " + min/1000 + " us with a fast remove linked list");
      System.out.println("Quotient for fast remove t/n : " + min/(n));
      n *= 2;
    }
  }
}
