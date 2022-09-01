class nanoTime
{
  public static void main(String [] args){
  	for (int i = 0; i < 10; i++) {
		long n0 = System.nanoTime();
		long n1 = System.nanoTime();
		System.out.println(" resolution " + (n1 - n0) + " nanoseconds");
	}
	System.out.println(" next loop");
	int[] given = {1,2,3,4,5,6,7,8,9,0};
	int sum = 0;
	for (int i = 0; i < 10; i++) {
		long t0 = System.nanoTime();
		sum += given[i];
		long t1 = System.nanoTime();
		System.out.println(" resolution " + (t1 - t0) + " nanoseconds");
	}
  }
}
