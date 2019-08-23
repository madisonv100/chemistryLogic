
public class Fraction {

	private double numerator;
	private double denominator;
	
	
Fraction(double numerator, double denominator)
{
	this.numerator = numerator;
	this.denominator = denominator;

	if(denominator == 0)
	{
		denominator =1;
	}
}  

public Fraction getProduct(Fraction otherFraction)
{
	double newNumerator = numerator*otherFraction.numerator;
	double newDenominator = denominator*otherFraction.denominator;
 Fraction f1 = new Fraction(newNumerator, newDenominator);
 return f1;
}


public double getDecimal()
{
	return numerator/denominator;
	
}

public String toString()
{
	return (numerator + "/" + denominator);
	
}

public double getNumerator()
{
	return numerator;
}
public double getDenominator()
{
	return denominator;
}



}
