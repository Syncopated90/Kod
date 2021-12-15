import java.util.*; //Scanner
class PolylinjeTest
{
	public static void main (String[] args)
	{
		Scanner input = new Scanner (System.in);
		System.out.println("Skriv in hur manga horn som polylinjen ska besta av: ");
		int antal = input.nextInt();

		Punkt[] pArray = new Punkt[antal];
		for (int i = 0; i < pArray.length; i++)
			{
				pArray[i] = new Punkt(i);
			}

		Polylinje pl = new Polylinje(pArray);

		pl.setFarg("Vit");
		pl.setBredd(3);
		pl.setNamn();

		System.out.println(pl);
	}
}