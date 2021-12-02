import java.util.*; //Scanner
class EU1_19
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);

		System.out.println ("Skriv in en serie pa 19 siffror som ska sorteras:");
		int[] element = new int [19];

		for ( int i = 0; i < 19; i++)
			element [i] = in.nextInt();

		//System.out.println ("Minsta elementet: " + Min.min ( element ));
		System.out.println ("Minsta elementet: " + EU1_uppdateringsstrategi.eu1_uppdatering ( element ));
	}
}