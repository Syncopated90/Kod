public class Polylinje
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	public Polylinje ()
	{
		this.horn = new Punkt[0];
	}

	public Polylinje (Punkt[] horn)
	{
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt (horn[i]);
	}

	public String toString ()
	{
		String s = "{[";
		for (int i = 0; i < horn.length; i++)
			s += horn[i].toString() + ", ";
		s += (" Farg: " + this.getFarg() + " Bredd: " + this.getBredd() + "]}");
		return s;
	}

	public Punkt[] getHorn ()
	{
		return null;
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
			horn[i].setNamn(String.valueOf(hornNamn));
			hornNamn++;
	}

	public double langd ()
	{
		int langd = 0;
		for (int i = 0; i<horn.length; i++)
			langd++;
		return langd;
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

	public void laggTillFramfor (Punkt horn, String hornNamn)
	{

	}
	public void taBort (String hornNamn)
	{

	}


}