import java.util.*; //Scanner
class PolylinjeTest
{
	public static void main (String[] args)
	{
		Scanner input = new Scanner (System.in);
		System.out.println("Skriv in hur manga horn som polylinjen ska besta av: ");
		int antal = input.nextInt();
		System.out.println("Skriv in onskad farg pa polylinjen: ");
		String farg = input.next();
		System.out.println("Skriv in onskad bredd pa polylinjen: ");
		int bredd = input.nextInt();

		Punkt[] pArray = new Punkt[antal];
		for (int i = 0; i < pArray.length; i++)
			{
				pArray[i] = new Punkt(i);
			}

		Polylinje pl = new Polylinje(pArray);

		pl.setFarg(farg);
		pl.setBredd(bredd);
		pl.setNamn();

		System.out.println(pl);
		System.out.println("Valj vilket horn som ska fa ett nytt horn inlagt framfor sig: ");
		String framforNamn = input.next();

		pl.laggTillFramfor(pl.getPoint (framforNamn) , framforNamn);
		System.out.println(pl);

		Punkt p = new Punkt(6);
		pl.laggTill (p);
		System.out.println (pl);
		pl.setFarg ("bla");

		pl.setBredd (5);
		System.out.println(pl);
		pl.setNamn();
		System.out.println(pl);

		pl.taBort ("B");
		System.out.println(pl);

	}
}