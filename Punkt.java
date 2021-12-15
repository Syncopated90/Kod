import java.lang.Math.*; //sqrt
class Punkt
{
	private int x = 0;
	private int y = 0;
	private String namn = "P";

	public Punkt ()
	{
		this.x = 0;
		this.y = 0;
	}

	public Punkt (String namn, int x, int y) //konstruktor med namn och koordinater som parametrar
	{
		this.namn = namn;
		this.x = x;
		this.y = y;
	}

	public  Punkt (int x, int y) //konstruktor med koordinater som parametrar
	{
		this.x = x;
		this.y = y;
	}

	public  Punkt (int x) //konstruktor med endast x-koordinat som parameter
		{
			this.x = x;
			this.y = 0;
	}

	public Punkt (Punkt p) //Kopieringskonstruktor, sätter y till 0 pga
	{
		this.x = p.getX ();
		this.y = 0;
	}

	public String toString ()
	{
		return namn + " (" + x + ", " + y + ")";
	}

	public String getNamn ()
	{
		return namn;
	}

	public int getX ()
	{
		return x;
	}

	public int getY ()
	{
		return y;
	}

	public void setX (int x)
	{
		this.x = x;
	}

	public void setY (int y)
	{
		this.y = y;
	}

	public void setNamn(String namn)
	{
		this.namn = namn;
	}

	public double avstand (Punkt p2)
	{
		double avstand = Math.sqrt((this.x - p2.x) * (this.x - p2.x) + (this.y - p2.y) * (this.y - p2.y));
		return avstand;
	}

	public boolean equals (Punkt p2)
	{
		boolean equals = false;
		if (this.x == p2.x && this.y == p2.y /*&& this.namn == p2.namn*/)
			equals = true;
		return equals;
	}
}