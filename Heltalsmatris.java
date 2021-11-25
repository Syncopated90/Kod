class Heltalsmatris
{
	public static void main (String[] args)
	{
		System.out.println("En heltalsmatris\n\n");
		java.util.Scanner in= new java.util.Scanner (System.in);
		in.useLocale(java.util.Locale.US);

		int[][] v = new int [3+1][4+1];
		System.out.println("Ange 12 heltal, 4 per rad:");

		for(int i=1;i<v.length;i++)
			for (int j=1;j<v[i].length;j++)
				v[i][j]=in.nextInt ();
		System.out.println();

		int [] max= new int[v.length];
		double [] mean= new double [v.length];
		int sum=0;

		for (int i=1;i<v.length;i++)
		{
			max [i]=v[i][1];
			sum =v[i][1];
			for (int j=2;j<v[i].length;j++)
			{
				if(v[i][j]>max[i]);
				max[i]=v[i][j];
				sum += v[i][j];
			}
			mean[i]= (double) sum/ (v[i].length-1);
		}

		System.out.println("De storsta heltalen och medelvarden - radvis:");
		for( int i=1;i<v.length;i++)
		{
			System.out.printf("%4d  |  %7.2f\n", max[i], mean[i]);
			System.out.println ();
		}
	}
}