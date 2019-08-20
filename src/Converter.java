
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
	else if (dimension.equals(dim))
}
	public enum prefixValue
	{
			
	//atm is base 
	//seconds is base 
	//
		//length, weight
		// TODO; MAKES IT REGONIZED VOLUME IN LENGHT CUBED 
		giga(1000000000f), mega(1000000f), kilo(1000f), hecto(100f), decka(10f), base(1f),
		deci(0.1f), centi(0.01f), milli(0.001f), micro(0.000001f), nano(.000000001f),
		
		//time second is your base
		
		seconds(1f), minutes(3600f), hours(216000f), days(5184000f), weeks(36288000f), years(1886976000f),
		
		//PRESSURE
		//atm is your base 
		
		atm(1f), torr(760f), mmhg(760f), kpa(101.3f), psi(147f)
		
		//SPEED
		//Base: is the base for time and length --> meters / seconds 
		//this will have to be a combination of lengths conversions and times conversions: it will go into unit calc calculations for
		//starting with a number on the top AND bottom 
		
		;
		
		public Float unitsFromBase;
		prefixValue(Float unitsFromBase)
		{
			this.unitsFromBase = unitsFromBase;
			
		}
		public Float getUnitsFromBase()
		{
			return this.unitsFromBase;
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
