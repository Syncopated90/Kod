import java.util.*; //Arrays
public class Polylinje1
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	public Polylinje1 ()
	{
		this.horn = new Punkt[0];
	}

	public Polylinje1 (Punkt[] horn)
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

	public Punkt[] getHorn ()
	{
		return horn;
	}

	public String getFarg ()
	{
		return farg;
	}

	public int getBredd ()
	{
		return bredd;
	}

	public void setFarg (String farg)
	{
		this.farg = farg;
	}

	public void setBredd (int bredd)
	{
		this.bredd = bredd;
	}

	public void setNamn ()
	{
		char hornNamn = 'A';
		for (int i = 0; i < horn.length; i++)
		{
			horn[i].setName(String.valueOf(hornNamn));
			hornNamn++;
		}
	}

	public double langd ()
	{
		int langd = 0;
		for (int i = 0; i < horn.length; i++)
			langd++;
		return langd;
	}

	public Punkt getPoint (String namn)
	{
		int i = 0;
		while (!horn[i].getNamn().equals(namn))
			i++;
		return horn[i];
	}

	public void laggTill (Punkt horn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];

		h[i] = new Punkt (horn);
		this.horn = h;
	}

	public void laggTillFramfor (Punkt hornGammalt, String hornNamn)
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

	public void taBort (String hornNamn)
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


}