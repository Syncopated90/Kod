class Kostnad
{
	public static void main (String []args)
	{
		System.out.println("KOSTNAD\n");
		java.util.Scanner in=new java.util.Scanner (System.in);
		in.useLocale(java.util.Locale.US);

		System.out.println("Antal b�cker:");
		int antal= in.nextInt ();

		System.out.println("Pris p� b�ckerna:");
		int pris= in.nextInt();

		double kostnad=antal*pris;
		System.out.println("Kostnad: " + kostnad);
	}
}