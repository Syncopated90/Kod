	import java.lang.*; //Math

class DenKortasteVagen
{
	public static int[] mellanstationer (int[] a, int[][] b, int[] c) //Returnerar vilka stationer som ing�r i den kortaste v�gen,
																	  	//tar emot vektor med alla avstånd mellan stationerna
	{
		int[][] avstand = new int [a.length][c.length];//skapar ny vektor avstand och samlar alla v�gar i den
		for (int i = 0; i < a.length; i++)
						{
							for(int j = 0; j < c.length; j++)
								avstand[i][j] = a[i] + b[i][j] + c[j];
						}

		int[] mellanstationer = new int [2]; //vektorn som ska returneras, med stationernas nummer
		int langd = avstand[0][0];

		for (int i = 0; i < avstand.length; i++)
		{
			for (int j = 0; j < avstand[0].length; j++)
			{
				if (langd > avstand[i][j])
				{
					langd = avstand[i][j];
					mellanstationer[0] = i;
					mellanstationer[1] = j;
				}
			}
		}

	return mellanstationer;
	}

	public static int langd (int[] a, int[][] b, int[] c) //L�ngden p� den kortaste v�gen
	{
		int[][] avstand = new int [a.length][c.length]; // avstand samlar alla avst�nden i en vektor
				for (int i = 0; i < a.length; i++)
				{
					for(int j = 0; j < c.length; j++)
						avstand[i][j] = a[i] + b[i][j] + c[j];
				}

		int langd = avstand[0][0];

		for (int i = 0; i < avstand.length; i++) //hittar minsta avst�ndet och tilldelar det v�rdet till langd
		{
			for (int j = 0; j < avstand[0].length; j++)
			{
				if (langd > avstand[i][j])
				{
					langd = avstand[i][j];
				}
			}
		}
		return langd;
	}
}