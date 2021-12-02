import java.util.*; //Scanner
class EU1
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);

		System.out.println ("Skriv in en serie pa 16 tal som ska sorteras:");
		int[] element = new int [16];

		for ( int i = 0; i < 16; i++)
			element [i] = in.nextInt();

		System.out.println ("Minsta talet: " + min.min ( element ));
	}
}