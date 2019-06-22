package perullo.petprojects.measurements;

public interface Unit {
	public double convertToBaseValue(double valueToConvert);
	
	public double convertFromBaseValue(double valueToConvert);
}
