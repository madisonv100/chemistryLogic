import java.text.DecimalFormat;
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
double startNum;
double answer;
String dimensionName;
Converter.dimensionValue dimension;






UnitCalc(String dimension, String StartingUnit, double startNum,  String GoalUnit)
{

this.dimension = Converter.getDimension(dimension);
this.dimensionName = Converter.getDimensionName(this.dimension);

this.startNum = startNum;
startPrefix = StartingUnit;
goalPrefix = GoalUnit;

this.StartingUnit = Converter.getPrefix(StartingUnit);
this.GoalUnit = Converter.getPrefix(GoalUnit);



	
}  


private int tempCase;  
public void createPath()
{


//if your are converting WITHIN the dimension length or weight or volume
if(dimension.equals(Converter.dimensionValue.length) || dimension.equals(Converter.dimensionValue.weight) || dimension.equals(Converter.dimensionValue.weight))
{
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

	if (goal.getDenominator() ==(goal.getNumerator()))
	{
		UnitPath.remove(2);
		
	}	  
  }
}
else if (dimension.equals(Converter.dimensionValue.temperature))
{

	//cel to kel.
    if(StartingUnit.equals(Converter.prefixValue.cel) && GoalUnit.equals(Converter.prefixValue.kelvin))
	{
    	tempCase = 1;
		answer = (float) (startNum + 273.15);
	}
	//cel to far.
	else if(StartingUnit.equals(Converter.prefixValue.cel) && GoalUnit.equals(Converter.prefixValue.far))
	{
		tempCase = 2;
		answer =  (float) ((startNum*(1.8))+32);
	}
	//kel to cel.
	else if(StartingUnit.equals(Converter.prefixValue.kelvin) && GoalUnit.equals(Converter.prefixValue.cel))
	{
		tempCase = 3;
		answer = (float) (startNum - 273.15);
	}
	//kel to far.
	else if(StartingUnit.equals(Converter.prefixValue.kelvin) && GoalUnit.equals(Converter.prefixValue.far))
	{
		tempCase = 4;
	  answer =  (float)((startNum-273.15)*(1.8)+32);
	}
	//far to cel 
	else if(StartingUnit.equals(Converter.prefixValue.far) && GoalUnit.equals(Converter.prefixValue.cel))
	{
		tempCase = 5;
		answer =  (float)((startNum-32)*(.5555556));
	}
	//far to kel
	else if(StartingUnit.equals(Converter.prefixValue.far) && GoalUnit.equals(Converter.prefixValue.kelvin))
	{
		tempCase = 6;
		answer = (float) (((startNum-32)*(.5555556))+ 273.15);
	}
  
}
else if(dimension.equals(Converter.dimensionValue.pressure))
{
	//if you are starting at the base unit
	if(StartingUnit.equals(Converter.prefixValue.atm))
	{
		Fraction start = new Fraction(startNum,1);
		Fraction goal = new Fraction(GoalUnit.unitsFromBase,1);
		UnitPath.add(start);
		UnitPath.add(goal);		
		
		Fraction f1 =  start.getProduct(goal);
		answer = f1.getDecimal();
	}
	//if you are ending in the base Unit
	else if(GoalUnit.equals(Converter.prefixValue.atm))
	{
		Fraction start = new Fraction(startNum, 1);
		Fraction goal = new Fraction(1,StartingUnit.unitsFromBase);
		UnitPath.add(start);
		UnitPath.add(goal);
		
		Fraction f1 = start.getProduct(goal);
		answer = f1.getDecimal();
		
	}
	//if your not starting or ending in the base unit
	else if (!(StartingUnit.equals(Converter.prefixValue.atm)) && 
			!(GoalUnit.equals(Converter.prefixValue.atm)))
	{
		Fraction start = new Fraction(startNum,1);
		Fraction base = new Fraction(1, StartingUnit.unitsFromBase);
		Fraction goal = new Fraction(GoalUnit.unitsFromBase,1);
		UnitPath.add(start);
		UnitPath.add(base);
		UnitPath.add(goal);
		
		Fraction f1 = start.getProduct(base);
		Fraction f2 = f1.getProduct(goal);
		
		answer = f2.getDecimal();
		
	}
	
}


}

public void makeString()
{
	
if(dimension.equals((Converter.dimensionValue.length)) || (dimension.equals(Converter.dimensionValue.weight)) || (dimension.equals(Converter.dimensionValue.volume))
	||	dimension.equals(Converter.dimensionValue.pressure))
{
	for (int i = 0; i < UnitPath.size(); i ++) 
	  { 
		  double numerator =  UnitPath.get(i).getNumerator(); 
		  
		  double denominator = UnitPath.get(i).getDenominator(); 
		     
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
 
else if(dimension.equals(Converter.dimensionValue.temperature))
{
DecimalFormat df = new DecimalFormat("#.##");

	//cel to kel
	if(tempCase ==1)
	{
		System.out.print(startNum+ " "  + dimensionName + " "+startPrefix+" " + " "+273.15 + " = "+ df.format(answer) + " "  + dimensionName + " "+GoalUnit);
	}
	//cel to far
	else if(tempCase ==2)
	{
		System.out.print("("+startNum+ " "  + dimensionName + " "+startPrefix +" x  9/5) + 32 = "+ df.format(answer)+ " "+ dimensionName + " "+GoalUnit  );
	}
	//kel to cel
	else if(tempCase == 3)
	{
		System.out.print(startNum+ " "  + dimensionName + " "+startPrefix+ " - 273.15 = "+ df.format(answer)+ " " + dimensionName + " "+GoalUnit);
	}
	//kel to far
	else if(tempCase == 4)
	{
		System.out.print("[("+startNum+ " "  + dimensionName + " "+startPrefix+ " - 273.15) x 9/5] +32 = "+ df.format(answer)+ " "+ dimensionName + " "+GoalUnit);
	}
	//far to cel
	else if(tempCase ==5)
	{
		System.out.print("("+ startNum+ " "  + dimensionName + " "+startPrefix+ " - 32) x 5/9 = " + df.format(answer)+ " " + dimensionName + " "+GoalUnit );
	}
	//far to kel
	else if (tempCase ==6)
	{
		System.out.print("[(" + startNum+ " "  + dimensionName + " "+startPrefix + " - 32) x 5/9] + 273.15 = " + df.format(answer)+ " " + dimensionName + " "+GoalUnit);
	}
  
}

}






}
