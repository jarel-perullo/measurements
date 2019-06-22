package perullo.petprojects.measurements;

public enum DistanceUnit implements Unit {
	METERS(1.0),
	DECIMETERS(0.1),
	CENTIMETERS(0.01),
	MILLIMETERS(0.001),
	KILOMETERS(1000.0),
	FEET(0.3048),
	YARDS(1.09361),
	INCHES(39.3701);

	private final double toBaseMultiplier;

	private DistanceUnit(double toBaseMultiplier) {
		this.toBaseMultiplier = toBaseMultiplier;
	}

	@Override
	public double convertToBaseValue(double valueToConvert) {
		return valueToConvert * toBaseMultiplier;
	}

	@Override
	public double convertFromBaseValue(double valueToConvert) {
		return valueToConvert / toBaseMultiplier;
	}
}
