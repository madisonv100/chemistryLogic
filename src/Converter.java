
public class Converter {
	public enum prefixValue
	{
		giga(1000000000f), mega(1000000f), kilo(1000f), hecto(100f), decka(10f), base(1f),
		deci(0.1f), centi(0.01f), milli(0.001f), micro(0.000001f), nano(.000000001f);
		
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
	
	
	public static  prefixValue getPrefix(String prefix)
	{
		if(prefix.equals("giga"))
		{
		return  prefixValue.giga;
		 
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
