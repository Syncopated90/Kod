import java.util.*; // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
	public static void main (String[] args)
	{
		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

		// mata in tv� naturliga heltal
		Scanner in = new Scanner (System.in);
		out.println ("tva naturliga heltal:");
		String tal1 = in.next ();
		String tal2 = in.next ();
		out.println ();

		// addera heltalen och visa resultatet
		String summa = addera (tal1, tal2);
		visa (tal1, tal2, summa, '+');

		String differens = subtrahera (tal1, tal2);
		visa (tal1, tal2, differens, '-');
		// subtrahera heltalen och visa resultatet
		// koden h�r
	}



		// visa visar tv� givna naturliga heltal, och resultatet av en aritmetisk operation
		// utf�rd i samband med hetalen
		public static void visa (String tal1, String tal2, String resultat, char operator)
		{
		// s�tt en l�mplig l�ngd p� heltalen och resultatet
			int len1 = tal1.length ();
			int len2 = tal2.length ();
			int len = resultat.length ();
			int maxLen = Math.max (Math.max (len1, len2), len);
			tal1 = sattLen (tal1, maxLen - len1);
			tal2 = sattLen (tal2, maxLen - len2);
			resultat = sattLen (resultat, maxLen - len);

			// visa heltalen och resultatet
			out.println ("  " + tal1);
			out.println ("" + operator + " " + tal2);
			for (int i = 0; i < maxLen + 2; i++)
				out.print ("-");
			out.println ();
			out.println ("  " + resultat + "\n");
		}

		// sattLen l�gger till ett angivet antal mellanslag i b�rjan av en given str�ng
		public static String sattLen (String s, int antal)
		{
			StringBuilder sb = new StringBuilder (s);
			for (int i = 0; i < antal; i++)
				sb.insert (0, "0");
			return sb.toString ();
		}

		public static StringBuilder sattLen (StringBuilder s, int antal)
		{
			StringBuilder sb = new StringBuilder (s);
			for (int i = 0; i < antal; i++)
				sb.insert (0, '0');
			return sb;
		}

		// addera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar deras
		// summa som en teckenstr�ng.
		public static String addera (String tal1, String tal2)
		{
			if (tal1.length() > tal2.length()) //lägger till nollor i början av talen om något tal är längre än det andra
				tal2 = sattLen (tal2, tal1.length() - tal2.length());
			else if (tal2.length() > tal1.length())
				tal1 = sattLen (tal1, tal2.length() - tal1.length());

			StringBuilder sb_addition = new StringBuilder(); //sb_addition är summan av parametrarna
			int minnessiffra = 0;

			for (int i = tal1.length() - 1; i >= 0; i--) //adderar siffrorna i de två talen var för sig, motsvarande lång addition
			{
				int sum =  (tal1.charAt(i) + tal2.charAt(i) - 96 + minnessiffra); //minus 96  pga unicode 48 = 0, 2* 48 = 96. Använda 2 * '0' istället?
				if (sum > 9)
				{
					sum -= 10;
					minnessiffra = 1;
				}
				else
					minnessiffra = 0;
				sb_addition.insert (0, sum);
			}
			if (minnessiffra == 1)
				sb_addition.insert (0, 1);

			return sb_addition.toString();
		}

		// subtrahera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar
		// deras differens som en teckenstr�ng.
		// Det f�rsta heltalet �r inte mindre �n det andra heltalet.
		public static String subtrahera (String tal1, String tal2)
		{
			if (tal1.length() > tal2.length()) //lägger till nollor i början av talen om något tal är längre än det andra
				tal2 = sattLen (tal2, tal1.length() - tal2.length());
			else if (tal2.length() > tal1.length())
				tal1 = sattLen (tal1, tal2.length() - tal1.length());

			StringBuilder sb_subtraction = new StringBuilder(); //sb_subtraction är differensen mellan parametrarna
			int minnessiffra = 0;

			for (int i = tal1.length() - 1; i >= 0; i--) //subtraherar siffrorna i de två talen var för sig
			{
				int difference =  (tal1.charAt(i) - tal2.charAt(i) - minnessiffra);
				if (difference < 0)
				{
					minnessiffra = 1;
					difference += 10;
				}
				else
					minnessiffra = 0;
				sb_subtraction.insert (0, difference);
			}
			return sb_subtraction.toString();
		}
}
