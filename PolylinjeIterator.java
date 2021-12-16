class PolylinjeIterator extends Polylinje
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
