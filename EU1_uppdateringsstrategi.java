class EU1_uppdateringsstrategi
{
	public static int eu1_uppdatering (int [] element)
	{
		int min_value = element [0];
		for (int i = 1; i < element.length; i++)
		{
			if ( min_value >= element [i])
				min_value = element [i];
		}
		return min_value;
	}
}