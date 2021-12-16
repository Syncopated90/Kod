import java.util.*; //Random
class ValjPolylinje
{
	public static final Random rand = new Random ();
	public static final int ANTAL_POLYLINJER = 10;
	public static void main (String[] args)
	{
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			{
			polylinjer[i] = slumpPolylinje ();
			System.out.println(polylinjer[i]);
			}

		Polylinje kortastGul = new Polylinje ();
		kortastGul = polylinjer[0];
		for ( int i = 1; i < ANTAL_POLYLINJER; i++)
		{
			if (polylinjer[i].getFarg().equals("gul") && polylinjer[i].langd() <= kortastGul.langd())
				kortastGul = polylinjer[i];
			else if (!kortastGul.getFarg().equals("gul") && polylinjer[i].getFarg().equals("gul"))
				kortastGul = polylinjer[i];
		}
		if ( ! kortastGul.getFarg().equals("gul"))
			System.out.println("Ingen polylinje ar gul");
		else
			System.out.println(kortastGul);
	}
	// slumpPunkt returnerar en punkt med ett slumpm�ssigt namn, som �r en stor bokstav i
	// det engelska alfabetet, och slumpm�ssiga koordinater.
	public static Punkt slumpPunkt ()
	{
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		return new Punkt (n, x, y);
	}
	// slumpPolylinje returnerar en slumpm�ssig polylinje, vars f�rg �r antingen bl�, eller r�d
	// eller gul. Namn p� polylinjens h�rn �r stora bokst�ver i det engelska alfabetet. Tv� h�rn
	// kan inte ha samma namn.
	public static Polylinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och l�gg till h�rn till den
		Polylinje polylinje = new Polylinje ();
		int antalHorn = 2 + rand.nextInt (7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		// ett och samma namn kan inte f�rekomma flera g�nger
		Punkt valdPunkt = null;
		char valtChar = 0;
		while (antalValdaHorn <= antalHorn)
		{
			Punkt p = slumpPunkt();
			valtChar = p.getNamn().charAt(0);
			while (valdaNamn[valtChar - 65] == true)
				{
					p = slumpPunkt();
					valtChar = p.getNamn().charAt(0);
				}
			polylinje.laggTill (p);
			antalValdaHorn++;
		}

		String[] farger = new String[] {"rod", "bla", "gul"};
		polylinje.setFarg(farger[rand.nextInt(3)]);
		return polylinje;
	}
}