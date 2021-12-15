class Punkt
{
	private double x = 0;
	private double y = 0;
	private String namn = "P";

	public Punkt ()
	{
		this.x = 0;
		this.y = 0;
	}

	public Punkt (String namn, double x, double y) //konstruktor med namn och koordinater som parametrar
	{
		this.namn = namn;
		this.x = x;
		this.y = y;
	}

	public  Punkt (double x, double y) //konstruktor med koordinater som parametrar
	{
		this.x = x;
		this.y = y;
	}

	public Punkt (Punkt p) //Kopieringskonstruktor
	{
		this.x = p.getX ();
		this.y = p.getY ();
	}

	public String toString ()
	{
		return namn + " (" + x + ", " + y + ")";
	}

	public String getNamn ()
	{
		return namn;
	}

	public double getX ()
	{
		return x;
	}

	public double getY ()
	{
		return y;
	}

	public void setX (double x)
	{
		this.x = x;
	}

	public void setY (double y)
	{
		this.y = y;
	}
}