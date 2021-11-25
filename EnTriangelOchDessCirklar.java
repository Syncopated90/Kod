	import java.util.*; //Scanner, Locale
	import java.lang.*; //Math

class EnTriangelOchDessCirklar
{
	public static void main (String[] args)
	{
		System.out.println ("En triangel och dess cirklar\n");

		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);

		System.out.println ("Skriv in triangelns sidor:");
		double sidea = in.nextDouble ();
		double sideb = in.nextDouble ();
		double sidec = in.nextDouble ();

		System.out.println ("Sida a: " + sidea);
		System.out.println ("Sida b: " + sideb);
		System.out.println ("Sida c: " + sidec);

		System.out.println ("Skriv in vinkeln i grader mellan sida a och b:");
		double angleab = Math.toRadians (in.nextDouble ());

		System.out.println ("Skriv in vinkeln mellan sida b och c:");
		double anglebc = Math.toRadians (in.nextDouble ());

		System.out.println ("Skriv in vinkeln mellan sida a och c:");
		double angleac = Math.toRadians (in.nextDouble ());

		System.out.println ("Omskrivna cirkelns radie ar: " + Triangel.circumscribedTriangleRadius (sidea, sideb, sidec));
		System.out.println ("Inskrivna cirkelns radie ar: " + Triangel.inscribedTriangleRadius (sidea, sideb, sidec));

		System.out.println("Bisektrisen mellan sida a och sida b ar sa har lang: " + Triangel.bisektris (sidea, sideb, angleab));
		System.out.println("Bisektrisen mellan sida b och sida c ar sa har lang: " + Triangel.bisektris (sideb, sidec, anglebc));
		System.out.println("Bisektrisen mellan sida a och sida c ar sa har lang: " + Triangel.bisektris (sidec, sidea, angleac));
	}
}