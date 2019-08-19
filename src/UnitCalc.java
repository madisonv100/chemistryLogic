import java.util.ArrayList;

public class UnitCalc {

public ArrayList<Fraction> UnitPath = new ArrayList <Fraction>();
public ArrayList<String> UnitPathLabel = new ArrayList<String>();


Converter.prefixValue StartingUnit;
Converter.prefixValue GoalUnit;
String goalPrefix;
String startPrefix;
float startNum;
float answer;
String dimension;





UnitCalc(String dimension, String StartingUnit, float startNum,  String GoalUnit)
{
this.dimension = dimension;
this.startNum = startNum;
startPrefix = StartingUnit;
goalPrefix = GoalUnit;

this.StartingUnit = Converter.getPrefix(StartingUnit);
this.GoalUnit = Converter.getPrefix(GoalUnit);



	
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





}
