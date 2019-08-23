
public class DimensionCalc {

private float startNum;
private Converter.prefixValue startUnit;
private Converter.dimensionValue startDimension;
private Converter.prefixValue goalUnit;
private Converter.dimensionValue goalDimension;


	DimensionCalc(float startNum, String startUnit, String startDimension, String goalUnit, String goalDimension)
	{
		this.startNum = startNum;
		this.startUnit = Converter.getPrefix(startUnit);
		this.goalUnit = Converter.getPrefix(goalUnit);
		this.goalDimension = Converter.getDimension(goalDimension);
		this.startDimension = Converter.getDimension(startDimension);
		
	}
	 
	/*
	 * CASE'S 
	 * 	length --> 
	 */
	
}
