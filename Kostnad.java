class Kostnad
{
	public static void main (String []args)
	{
		System.out.println("KOSTNAD\n");
		java.util.Scanner in=new java.util.Scanner (System.in);
		in.useLocale(java.util.Locale.US);

		System.out.println("Antal böcker:");
		int antal= in.nextInt ();

		System.out.println("Pris på böckerna:");
		int pris= in.nextInt();

		double kostnad=antal*pris;
		System.out.println("Kostnad: " + kostnad);
	}
}