import java.util.*; //Scanner, StringTokenizer

class Stringdemo
{
	public static void main (String[] args)
		{
			char a = '2';
			char b = '5';
			//char c = (b - a + '0');
			//char d = (char) c;
			System.out.println (b - a);

			StringBuilder s1 = new StringBuilder ("51234");



			char c1 = s1.charAt (3);
			char c2 = s1.charAt (1);
			char c3 = s1.charAt (2);

			System.out.println(s1);

			StringBuilder s2 = new StringBuilder ("2345");
			StringBuilder s3 = new StringBuilder (sattLen ((s2), (s1.length() - s2.length())));
			System.out.println(s3);

			StringBuilder s5 = new StringBuilder();
			for (int i = 0; i < s1.length(); i++)
						{
							s5.insert ((s1.charAt(i) + s3.charAt(i) - 96), i);
			}
			System.out.println (s5);
			//char c5 = s2.charAt (0);
			//char sum = c1 + c5;
			//System.out.println (s + " " + s2);
			/*char s1 = scanner.next ();
			char s2 = scanner.next ();
			String s3 = scanner.next ();
			String s4 = scanner.next ();
			for (int i = 0; i < s.length(); i++)
			{
				System.out.print (s.charAt(i) + s2.charAt(i) - 96);
			}
			System.out.println();*/

			//StringBuilder = summan av chars + minnessiffra, if (char > 10) appendTo (char - 10) && minnessiffra = 1;

		}

		public static StringBuilder sattLen (StringBuilder s, int antal)
				{
					StringBuilder sb = new StringBuilder (s);
					for (int i = 0; i < antal; i++)
						sb.insert (0, '0');
					return sb;
		}
}