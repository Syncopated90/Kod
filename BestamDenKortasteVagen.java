	import java.util.*; //Scanner,
	import java.lang.*; //Math

class BestamDenKortasteVagen

{
	public static void main (String[] args)
	{
		System.out.println("Den Kortaste Vagen\n");

		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);

		System.out.println("Skriv in antal stationer i zon 2:");
		int zon2Antal = in.nextInt();
		int[] vagar12 = new int [zon2Antal]; //V�garna fr�n zon 1 till 2

		System.out.println("Skriv in antal stationer i zon 3:");
		int zon3Antal = in.nextInt();
		int[] vagar34 = new int [zon3Antal]; //V�garna fr�n zon 3 till 4

		int[][] vagar23 = new int [zon2Antal][zon3Antal]; //V�garna fr�n zon 2 till 3

		System.out.println("Skriv in avstanden pa vagarna mellan startpunkten och de forsta stationerna: ");
		for (int i = 0; i < zon2Antal; i++)
			vagar12[i] = in.nextInt();

		for (int i = 0; i < zon2Antal; i++)
		{
			System.out.print("Skriv in vagen fran station " + (i + 1) +" i zon 2 ");
			for (int j = 0; j<zon3Antal; j++)
			{
				System.out.println("till station " + (j + 1) + " i zon 3: ");
				vagar23[i][j] = in.nextInt();
			}
		}

		System.out.println("Skriv in avstanden pa vagarna mellan stationerna i zon 3 och slutstationen: ");
			for (int i = 0; i < zon3Antal; i++)
				vagar34[i] = in.nextInt();

		System.out.println("Stationerna pa den kortaste vagen ar: "); //Printar vilka stationer som finns på den kortaste vägen
		for (int i = 0; i < 2; i++)
			System.out.println ("Station " + (DenKortasteVagen.mellanstationer (vagar12, vagar23, vagar34)[i] + 1) + " i zon " + (i + 1));

		System.out.println ("Kortaste vagen ar sa har lang: " + DenKortasteVagen.langd (vagar12, vagar23, vagar34)); //Printar avståndet
	}

}