import java.util.ArrayList;

public class UnitCalc {

public ArrayList<Fraction> UnitPath = new ArrayList <Fraction>();
public ArrayList<String> UnitPathLabel = new ArrayList<String>();


prefixValue StartingUnit;
prefixValue GoalUnit;
String goalPrefix;
String startPrefix;
float startNum;
float answer;
String dimension;



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

UnitCalc(String dimension, String StartingUnit, float startNum,  String GoalUnit)
{
this.dimension = dimension;
this.startNum = startNum;
startPrefix = StartingUnit;
goalPrefix = GoalUnit;

	if(StartingUnit.equals("giga"))
		{
		this.StartingUnit = prefixValue.giga;
		 
		
		
		}
	else if (StartingUnit.equals("mega"))
	{
		this.StartingUnit = prefixValue.mega;
		
	}
	else if (StartingUnit.equals("kilo"))
	{
		this.StartingUnit = prefixValue.kilo;
	}
	else if (StartingUnit.equals("hecto"))
	{
		this.StartingUnit = prefixValue.hecto;
	}
	else if (StartingUnit.equals("decka"))
	{
		this.StartingUnit = prefixValue.decka;
	}
	else if (StartingUnit.equals("base"))
	{
		this.StartingUnit = prefixValue.base;
	}
	else if (StartingUnit.equals("deci"))
	{
		this.StartingUnit = prefixValue.deci;
	}
	else if (StartingUnit.equals("centi"))
	{
		this.StartingUnit = prefixValue.centi;
	}
	else if(StartingUnit.equals("milli"))
	{
		this.StartingUnit = prefixValue.milli;
	}
	else if(StartingUnit.equals("micro"))
	{
		this.StartingUnit = prefixValue.micro;
	}
	else if(StartingUnit.equals("nano"))
	{
		this.StartingUnit = prefixValue.nano;
	}
	else
	{
		this.StartingUnit = prefixValue.base;
	}
	
	if(GoalUnit.equals("giga"))
	{
	this.GoalUnit = prefixValue.giga;
	}
else if (GoalUnit.equals("mega"))
{
	this.GoalUnit = prefixValue.mega;
}
else if (GoalUnit.equals("kilo"))
{
	this.GoalUnit = prefixValue.kilo;
}
else if (GoalUnit.equals("hecto"))
{
	this.GoalUnit = prefixValue.hecto;
}
else if (GoalUnit.equals("decka"))
{
	this.GoalUnit = prefixValue.decka;
}
else if (GoalUnit.equals("base"))
{
	this.GoalUnit = prefixValue.base;
}
else if (GoalUnit.equals("deci"))
{
	this.GoalUnit = prefixValue.deci;
}
else if (GoalUnit.equals("centi"))
{
	this.GoalUnit = prefixValue.centi;
}
else if(GoalUnit.equals("milli"))
{
	this.GoalUnit = prefixValue.milli;
}
else if(GoalUnit.equals("micro"))
{
	this.GoalUnit = prefixValue.micro;
}
else if(GoalUnit.equals("nano"))
{
	this.GoalUnit = prefixValue.nano;
}
else
{
	this.GoalUnit = prefixValue.base;
}
	
}


public void createPath()
{
  if(StartingUnit.unitsFromBase == GoalUnit.unitsFromBase)
  {
	 Fraction startAndEnd = new Fraction(startNum,1);
	 UnitPath.add(startAndEnd);
	 answer = startAndEnd.getDecimal();
	 
  }
  


  //all other cases should be done in 3 steps 
  else
  {
	  Fraction start = new Fraction(startNum,1);
	
	
	
	  
	  Fraction base = new Fraction(StartingUnit.unitsFromBase,1);
	  
	  Fraction goal = new Fraction(1, GoalUnit.unitsFromBase);
	  
	  UnitPath.add(start);
	  UnitPath.add(base);
	  UnitPath.add(goal);
	  
	Fraction f1 =  start.getProduct(base);
	  Fraction f2 = f1.getProduct(goal);
	  
	answer = f2.getDecimal();
	


	
	if (goal.getDenominator().equals(goal.getNumerator()))
	{
		UnitPath.remove(2);
		
	}
	  
	
	  
	  
	  
  }
  
  
}

public void makeString()
{
	  for (int i = 0; i < UnitPath.size(); i ++) 
	  { 
		  Float numerator =  UnitPath.get(i).getNumerator(); 
		  
		  Float denominator = UnitPath.get(i).getDenominator(); 
		  
		 if(i == 0)
		 {
			 System.out.print(numerator + startPrefix+dimension + "/" +
	          denominator + dimension +"   x   ");
		 }
		  
		  else if(i != UnitPath.size()-1) 
		  {
			  System.out.print(numerator + dimension + "/" +
	          denominator + startPrefix +dimension +"   x   "); 
		  }
		  else {
			  System.out.print(numerator + goalPrefix +dimension+ "/" + denominator+ dimension + " = ");
	          System.out.printf("%.3f",answer);
	          System.out.print(" " + goalPrefix+dimension);
	  }
	  
	  
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
