
public class Fraction {

	private float numerator;
	private float denominator;
	
	
Fraction(float numerator, float denominator)
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
	Float newNumerator = numerator*otherFraction.numerator;
	Float newDenominator = denominator*otherFraction.denominator;
 Fraction f1 = new Fraction(newNumerator, newDenominator);
 return f1;
}


public Float getDecimal()
{
	return numerator/denominator;
	
}

public String toString()
{
	return (numerator + "/" + denominator);
	
}

public Float getNumerator()
{
	return numerator;
}
public Float getDenominator()
{
	return denominator;
}



}
