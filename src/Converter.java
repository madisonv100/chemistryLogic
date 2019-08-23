
public class Converter{
	
private String unitName;  


public String getUnitName()
{
	return unitName;
}

public prefixValue getBase(dimensionValue dimension)
{
	if(dimension.equals(dimensionValue.length))
	{
		return prefixValue.base;
	}
	else if (dimension.equals(dimensionValue.pressure))
	{
		return prefixValue.atm;
	}
	else if(dimension.equals(dimensionValue.time))
	{
		return prefixValue.seconds;
	}
	else if (dimension.equals(dimensionValue.temperature))
	{
		return prefixValue.celcius;
	}
	else
	{
		return prefixValue.invalid;
	}
}
	public enum prefixValue
	{
			
	//atm is base 
	//seconds is base 
	
		//length, weight
		// TODO; MAKES IT REGONIZED VOLUME IN LENGHT CUBED 
		giga(1000000000,1), mega(1000000,1), kilo(1000,1), hecto(100,1), decka(10,1), base(1,1),
		deci(0.1,1), centi(0.01,1), milli(0.001,1), micro(0.000001,1), nano(.000000001,1),
		
		//time second is your base
		
		seconds(1,1), minutes(3600,1), hours(216000,1), days(5184000,1), weeks(36288000,1), years(1886976000,1),
		
		//PRESSURE
		//atm is your base 
		
		atm(1,1), torr(760,1), mmhg(760,1), kpa(101.3,1), psi(147,1),
		
		//SPEED
		//Base: is the base for time and length --> meters / seconds 
		//this will have to be a combination of lengths conversions and times conversions: it will go into unit calc calculations for
		//starting with a number on the top AND bottom 
		
		
		//temperature 
		//BASE = celcius 
		celcius(1,1), kelvin(274.15,1), farenheit(33.8,1),
		
		//default
		invalid(0,1)
		
		;
		
		private doouble numerator;
		private float denominator;
		private prefixValue(double numerator, float denominator)
		{
			this.numerator = numerator;
			this.denominator = denominator;
			
		}
	
	}
	
	public enum dimensionValue
	{
		length, pressure, density, weight, volume, speed, time, temperature,  invalid
	}
	
	public static dimensionValue getDimension(String dimension)
	{
		if(dimension.equals("length"))
		{
			return dimensionValue.length;
		}
		else if (dimension.equals("time"))
		{
			return dimensionValue.time;
		}
		else if (dimension.equals("temperature"))
		{
			
			return dimensionValue.temperature;
		}
		else if (dimension.equals("pressure") )
		{
			return dimensionValue.pressure;
		}
		else if (dimension.equals("density"))
		{
			return dimensionValue.density;
		}
		else if (dimension.equals("weight"))
		{
			return dimensionValue.weight;
		}
		else if(dimension.equals("volume"))
		{
			return dimensionValue.volume;
		}
		else if (dimension.equals("speed"))
		{
			return dimensionValue.speed;
		} 
		else 
		{
			return dimensionValue.invalid;
		}
	}
	
	
	public static  prefixValue getPrefix(String prefix)
	{
		if(prefix.equals("giga"))
		{
		return  prefixValue.giga;
		 
		}
		else if (prefix.equals("seconds"))
		{
	 return prefixValue.seconds;
		}
		else if (prefix.equals("minutes"))
		{
			return prefixValue.minutes;
		}
		else if (prefix.equals("hours"))
		{
			return prefixValue.hours;
		}
		else if (prefix.equals("days"))
		{
			return prefixValue.days;
		}
		else if (prefix.equals("weeks"))
		{
			return prefixValue.weeks;
		}
		else if (prefix.equals("years"))
		{
			return prefixValue.years;
		}
		else if (prefix.equals("atm"))
		{
			return prefixValue.atm;
		}
		else if (prefix.equals("torr"))
		{
			return prefixValue.torr;
		}
		else if (prefix.equals("kpa"))
		{
			return prefixValue.kpa;
		}
		else if (prefix.equals("psi"))
		{
			return prefixValue.psi;
		}
	else if (prefix.equals("mega"))
	{
		return  prefixValue.mega;
		
	}
	else if (prefix.equals("kilo"))
	{
		return prefixValue.kilo;
	}
	else if (prefix.equals("hecto"))
	{
		return prefixValue.hecto;
	}
	else if (prefix.equals("decka"))
	{
		return prefixValue.decka;
	}
	else if (prefix.equals("base"))
	{
	return prefixValue.base;
	}
	else if (prefix.equals("deci"))
	{
		return prefixValue.deci;
	}
	else if (prefix.equals("centi"))
	{
		return prefixValue.centi;
	}
	else if(prefix.equals("milli"))
	{
		return  prefixValue.milli;
	}
	else if(prefix.equals("micro"))
	{
		return  prefixValue.micro;
	}
	else if(prefix.equals("nano"))
	{
		return  prefixValue.nano;
	}
	
	else
	{
		return  prefixValue.base;
	}
	}
	
	private String getPrefix(Float value)
	{
	if(value == 1000000000 )
	{
		return "giga";
	}
	else if (value == 1000000)
	{
		return "mega";	
	}
	else if (value == 1000)
	{
		return "kilo";	
	}
	else if (value == 100)
	{
		return "hecto";	
	}
	else if (value == 10)
	{
		return "deca";	
	}
	else if (value == 1)
	{
		return "base";	
	}
	else if (value == .1)
	{
		return "deci";	
	}
	else if (value == .01)
	{
		return "centi";	
	}
	else if (value == .001)
	{
		return "milli";	
	}
	else if (value == 000001)
	{
		return "micro";	
	}

	else if (value == 000000001)
	{
		return "nano";	
	}
	else
	{
		return "couldnt find your prefix";
	 
	}


		
	}
	


	
}
