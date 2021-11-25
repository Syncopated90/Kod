	import java.util.*; // Scanner, Locale
class Temperaturer
{
	public static void main (String[] args)
	{
		System.out.println ("TEMPERATURER\n");
		// inmatningsverktyg
		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);
		// mata in uppgifter om antalet veckor och antalet m�tningar

		System.out.print ("antalet veckor: ");
		int antalVeckor = in.nextInt ();
		System.out.print ("antalet matningar per vecka: ");
		int antalMatningarPerVecka = in.nextInt ();

		// plats att lagra temperaturer
		double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];
		// mata in temperaturerna
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			System.out.println ("temperaturer - vecka " + vecka + ":");
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			t[vecka][matning] = in.nextDouble ();
		}
		System.out.println ();

		// visa temperaturerna
		System.out.println ("temperaturerna:");
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			System.out.print (t[vecka][matning] + " ");
			System.out.println ();
		}
		System.out.println ();


		double[] minT = new double[antalVeckor + 1];//Mintemperatur veckovis
		for(int vecka=1; vecka<=antalVeckor; vecka++)
		{
			minT[vecka]=t[vecka][1];
			for (int matning=1; matning<=antalMatningarPerVecka;matning++)
			{
				if(t[vecka][matning]<minT[vecka])
					minT[vecka]=t[vecka][matning];
			}
		}

		double[] maxT = new double[antalVeckor + 1];//Maxtemperatur veckovis
		for(int vecka=1; vecka<=antalVeckor; vecka++)
		{
			maxT[vecka]=t[vecka][1];
			for (int matning=1; matning<=antalMatningarPerVecka;matning++)
			{
				if(t[vecka][matning]>maxT[vecka])
					maxT[vecka]=t[vecka][matning];
			}
		}

		double[] sumT = new double[antalVeckor + 1];//Temperatursumma veckovis
		for(int vecka=1; vecka<=antalVeckor; vecka++)
		{
			for (int matning=1; matning<=antalMatningarPerVecka;matning++)
			sumT[vecka]=sumT[vecka]+t[vecka][matning];
		}

		double[] medelT = new double[antalVeckor + 1];//Medelvärden veckovis
		for(int vecka=1; vecka<=antalVeckor; vecka++)
		{
			medelT[vecka]=sumT[vecka]/antalMatningarPerVecka;
		}


		for(int vecka=1; vecka<=antalVeckor; vecka++)
			System.out.println("Minsta temperatur vecka " + vecka + ": " + minT[vecka]);
		System.out.println();
		for(int vecka=1; vecka<=antalVeckor; vecka++)
			System.out.println("Storst temperatur vecka " + vecka + ": " + maxT[vecka]);
		System.out.println();
		for(int vecka=1; vecka<=antalVeckor; vecka++)
			System.out.println("Summa temperatur vecka " + vecka + ": " + sumT[vecka]);
		System.out.println();
		for(int vecka=1; vecka<=antalVeckor; vecka++)
			System.out.println("Medelvarde temperatur vecka " + vecka + ": " + medelT[vecka]);
		System.out.println();

		double minTemp = minT[1]; //Mintemptemperatur hela mätperioden
		for (int vecka=2; vecka<=antalVeckor;vecka++)
			if (minT[vecka]<minTemp)
				minTemp=minT[vecka];

		double maxTemp = maxT[1]; //Matemperatur hela mätperioden
		for (int vecka=2; vecka<=antalVeckor;vecka++)
					if (maxT[vecka]>maxTemp)
				maxTemp=maxT[vecka];

		double sumTemp = sumT[1];  //Temperatursumma hela mätperioden
		for (int vecka=2; vecka<=antalVeckor;vecka++)
					sumTemp=sumTemp + sumT[vecka];

		double medelTemp = sumTemp/(antalVeckor * antalMatningarPerVecka); //Medeltemperatur hela mätperioden


		System.out.println();
		System.out.println("Minsta temperatur av alla matningar: " + minTemp);
		System.out.println("Storsta temperatur av alla matningar: " + maxTemp);
		System.out.println("Summa temperatur for alla matningar: " + sumTemp);
		System.out.println("Medelvardestemperatur for alla veckor: " + medelTemp);
	}
}