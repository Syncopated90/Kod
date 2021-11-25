	import java.lang.*;//Math

class Triangel
{
	public static double area (double side1, double side2, double side3) //Arean n�r man k�nner alla sidor
	{
		double area = Math.sqrt ( ((perimeter(side1, side2, side3) / 2) * ((perimeter(side1, side2, side3) / 2) - side1) * ((perimeter(side1, side2, side3) / 2) - side2) * ((perimeter(side1, side2, side3) / 2) - side3)));
		return area;
	}

	public static double perimeter (double side1, double side2, double side3) //Omkrets n�r man k�nner alla sidor
	{
		double perimeter = side1 + side2 + side3;
		return perimeter;
	}

	public static double inscribedTriangleRadius (double side1, double side2, double side3) //Inskrivna triangelns radie
	{
		double semiperimeter = ((perimeter (side1, side2, side3)) / 2); //semiperimeter är halva omkretsen
		double radius = Math.sqrt (((semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3)) / semiperimeter);
		return radius;
	}

	public static double circumscribedTriangleRadius (double side1, double side2, double side3) //Omskrivna triangelns radie
	{
		double radius = ((side1 * side2 * side3) / (4 * area (side1, side2, side3)));
		return radius;
	}

	/*public static double anglecalc (double angle1, double angle2)
	{
		double angle3 = Math.toRadians (Math.PI - (angle1 + angle2));
		return angle3;
	}*/

	public static double bisektris (double b, double c, double alfa) //Längden på bisektrisen från hörnet till motstående sida när man känner två sidor och mellanliggande vinkel
	{
		double p = 2 * b * c * Math.cos (alfa / 2);
		double bis = p / (b + c);
		return bis;
	}
}