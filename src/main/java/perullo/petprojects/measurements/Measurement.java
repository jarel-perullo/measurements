package perullo.petprojects.measurements;

public class Measurement<U extends Unit> {

	private final Number baseValue;
	
	private Measurement(Number baseValue) {
		this.baseValue = baseValue;
	}
	
	public static <T extends Unit> Measurement<T> of(double value, T unit) {
		double baseValue = unit.convertToBaseValue(value);
		return new Measurement<>(baseValue);
	}

	public double doubleValueIn(U unit) {
		return unit.convertFromBaseValue(baseValue.doubleValue());
	}
}
