/*Definitionsklass för en polylinje, en vektor med Punkt-objekt. Polylinjen har
färg och bredd, och punkterna har x- och y-koordinater*/

import java.util.*;//Arrays
public class Polylinje
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	public Polylinje ()
	{
		this.horn = new Punkt[0];
	}

	public Polylinje (Punkt[] horn) //Konstruktor som tar emot en vektor med Punkt-objekt och kopierar över de punkterna till Polylinjen
	{
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt (horn[i]);
	}

	public String toString ()
	{
		String s = "{[";
		for (int i = 0; i < horn.length; i++)
			s += " " + horn[i].toString();
		s += (" ], " + this.getFarg() + ", " + this.getBredd() ) + "}";
		return s;
	}

	public Punkt[] getHorn () //returnerar en kopia av polylinjens vektor med hörn
	{
		Punkt[] arrayH = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
		{
			arrayH[i] = new Punkt (horn[i]);
		}
		return arrayH;
	}

	public String getFarg () //returnerar objektets färg
	{
		String nyans = this.farg;
		return nyans;
	}

	public int getBredd () //returnerar objektets bredd
	{
		int width = this.bredd;
		return width;
	}

	public void setFarg (String farg) //ändrar polylinjens färg
	{
		this.farg = farg;
	}

	public void setBredd (int bredd) //ändrar polylinjens bredd
	{
		this.bredd = bredd;
	}

	public void setNamn () //Namnger alla punkterna i polylinjen efter sin position, första blir A, andra B osv.
	{
		char hornNamn = 'A';
		for (int i = 0; i < horn.length; i++)
		{
			horn[i].setName(String.valueOf(hornNamn));
			hornNamn++;
		}
	}

	public double langd () //returnerar polylinjens längd
	{
		double langd = 0;
		for (int i = 0; i < horn.length; i++)
			langd++;
		double length = langd;
		return length;
	}

	public Punkt getPoint (String namn) //returnerar en kopia av ett hörn utifrån dess namn
	{
		int i = 0;
		while (!horn[i].getNamn().equals(namn))
			i++;
		Punkt p = new Punkt (horn[i]);
		return p;
	}

	public void laggTill (Punkt horn)//lägger till en punkt sist i polylinjen
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];

		h[i] = new Punkt (horn);
		this.horn = h;
	}

	public void laggTillFramfor (Punkt hornGammalt, String hornNamn) //lägger till en ny punkt framför en annan punkt
	{
		Punkt hornNytt = new Punkt (hornGammalt);
		Punkt[] hArray = Arrays.copyOf(horn, horn.length + 1);
		int i = horn.length - 1;
		while (!horn[i].getNamn().equals(hornGammalt.getNamn() ))
		{
			hArray[i + 1] = horn[i];
			i--;
		}
		hArray[i + 1] = hornNytt;
		while (i >= 0)
		{
			hArray[i] = horn[i];
			i--;
		}
		horn = hArray;
	}

	public void taBort (String hornNamn) //tar bort ett hörn utifrån dess namn
	{
		Punkt[] hArray = Arrays.copyOf(horn, horn.length - 1);
		int i = 0;
		while (! horn[i].getNamn().equals(hornNamn))
		{
			hArray[i] = horn[i];
			i++;
		}
		hArray[i] = horn [i + 1];
		i++;
		while (i != hArray.length)
		{
			hArray[i] = horn [i + 1];
			i++;
		}
		horn = hArray;
	}

	public class PolylinjeIterator
	{
		private int aktuell = -1;

		public PolylinjeIterator ()
		{
			if (Polylinje.this.horn.length > 0)
				aktuell = 0;
		}

		public boolean finnsHorn ()
		{
			return aktuell != -1;
		}

		public Punkt horn () throws java.util.NoSuchElementException
		{
		if (!this.finnsHorn ())
			throw new java.util.NoSuchElementException ("slut av iterationen");
		Punkt horn = Polylinje.this.horn[aktuell];
		return horn;
		}

		public void gaFram ()
		{
			if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
				aktuell++;
			else
				aktuell = -1;
		}
	}
}