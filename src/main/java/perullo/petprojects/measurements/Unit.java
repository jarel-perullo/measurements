package perullo.petprojects.measurements;

public interface Unit {
    
	public default double convertToBaseValue(double valueToConvert) {
	    return valueToConvert * getToBaseMultiplier();
	}
	
	public default double convertFromBaseValue(double valueToConvert){
	    return valueToConvert / getToBaseMultiplier();
	}
	
	public double getToBaseMultiplier(); 
}
