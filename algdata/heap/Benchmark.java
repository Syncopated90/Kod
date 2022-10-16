import java.util.Random;
import java.lang.Math;
class Benchmark{
  LinkedQFastAdd linkedFAdd;
  LinkedQFastRemove linkedFRemove;
  public Benchmark(){
    this.linkedFAdd = new LinkedQFastAdd();
    this.linkedFRemove = new LinkedQFastRemove();
  }
  public void removeBench(){
    int n = 1000;
    int tries = 10;
    Random random = new Random();
    HeapArray heapArray;
    HeapTree heapTree;
    double t0, t1;
    while(n < 256000){
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries; i++){
        heapTree = new HeapTree();
        for(int j = 0; j < 2 * n; j++)
          heapTree.add(random.nextInt(10 * n));
        t0 = System.nanoTime();
        for(int j = 0; j < n; j++)
          heapTree.remove();
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = t1 - t0;
      }
      System.out.println("Minimum time for " + n + " removes : " + min/1000 + " for tree heap");
      System.out.println("n log n quotient: " + min/(n * n));
      n *= 2;
    }
  }
  public void arrayBench(){
    int n = 1000;
    int tries = 10;
    Random random = new Random();
    HeapArray heapArray;
    HeapTree heapTree;
    double t0, t1;
    while(n < 4096000){
      double min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries; i++){
        heapArray = new HeapArray(n);
        t0 = System.nanoTime();
        for(int j = 0; j < n; j++)
          heapArray.add(random.nextInt(10 * n));
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = t1 - t0;
      }
      System.out.println("Minimum time for " + n + " adds : " + min/1000 + " for array heap");
      System.out.println("n log n quotient: " + min/(n * Math.log(n)));
      /*min = Double.POSITIVE_INFINITY;
      for(int i = 0; i < tries; i++){
        heapTree = new HeapTree();
        t0 = System.nanoTime();
        for(int j = 0; j < n; j++)
          heapTree.add(random.nextInt(10 * n));
        t1 = System.nanoTime();
        if((t1 - t0) < min)
          min = t1 - t0;
      }
      System.out.println("Minimum time for " + n + " adds : " + min/1000 + " for tree heap");
      System.out.println("n log n quotient: " + min/(n * Math.log(n)));*/
      n *= 2;
    }
  }
  public void treeBench(){
    HeapTree tree = new HeapTree();
    Random random = new Random();
    int n = 5;
    int nPush = 10;
    int heapSize = 64;
    int tries = 10;
    for(int i = 0; i < heapSize; i++){
      tree.add(random.nextInt(100));
    }
    double mean = 0;

    for(int i = 0; i < tries; i++){
      mean += tree.push(random.nextInt(10) + 10);
    }
    mean /= nPush;
    System.out.println("mean push depth for " + nPush + " pushes with " + heapSize + " elements: " + (int) Math.round(mean));
    tree.root = null;
    mean = 0;
    for(int i = 0; i < heapSize; i++)
      tree.add(random.nextInt(100));
    for(int i = 0; i < nPush; i++){
      mean += tree.add(random.nextInt(10) + 10);
      //tree.remove();
    }
    mean /= nPush;
    System.out.println("mean add depth for " + nPush + " adds with " + heapSize + " elements: " + (int) Math.round(mean));
    tree.root = null;

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
