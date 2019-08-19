import java.util.ArrayList;



/*
Improvment Notes:
- make it handle fractional starting points:p1
density in g/L ---> denisty in mg/ml
-make it convert time into --> minutes, hours, days, week, years
-make it convert temperature--> kelvin, farheit, celcius
-
*/

public class UnitCalc {

public ArrayList<Fraction> UnitPath = new ArrayList <Fraction>();
public ArrayList<String> UnitPathLabel = new ArrayList<String>();


Converter.prefixValue StartingUnit;
Converter.prefixValue GoalUnit;
String goalPrefix;
String startPrefix;
float startNum;
float answer;
String dimensionName;
Converter.dimensionValue dimension;






UnitCalc(String dimension, String dimensionName, String StartingUnit, float startNum,  String GoalUnit)
{
this.dimensionName = dimensionName;
this.dimension = Converter.getDimension(dimension);

this.startNum = startNum;
startPrefix = StartingUnit;
goalPrefix = GoalUnit;

this.StartingUnit = Converter.getPrefix(StartingUnit);
this.GoalUnit = Converter.getPrefix(GoalUnit);



	
}


public void createPath()
{
	
//if(dimension =)
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
	
if(dimension.equals(Converter.dimensionValue.weight)|| dimension.equals(Converter.dimensionValue.volume) || dimension.equals(Converter.dimensionValue.length)
	||	dimension.equals(Converter.dimensionValue.weight))
{
	

	  for (int i = 0; i < UnitPath.size(); i ++) 
	  { 
		  Float numerator =  UnitPath.get(i).getNumerator(); 
		  
		  Float denominator = UnitPath.get(i).getDenominator(); 
		  
		 if(i == 0)
		 {
			 System.out.print(numerator + startPrefix+dimensionName + "/" +
	          denominator + dimensionName +"   x   ");
		 }
		  
		  else if(i != UnitPath.size()-1) 
		  {
			  System.out.print(numerator + dimensionName + "/" +
	          denominator + startPrefix +dimensionName +"   x   "); 
		  }
		  else {
			  System.out.print(numerator + goalPrefix +dimensionName+ "/" + denominator+ dimensionName + " = ");
	          System.out.printf("%.3f",answer);
	          System.out.print(" " + goalPrefix+dimensionName);
	  }
	  
	  
	  }
}


}





}
