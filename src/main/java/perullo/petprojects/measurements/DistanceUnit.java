package perullo.petprojects.measurements;

public enum DistanceUnit implements Unit {
	METERS(1.0),
	DECIMETERS(0.1),
	CENTIMETERS(0.01),
	MILLIMETERS(0.001),
	DECAMETERS(10.0),
	HECTOMETERS(100.0),
	KILOMETERS(1000.0),
	FEET(0.3048),
	YARDS(0.9144),
	INCHES(0.0254);

	private final double toBaseMultiplier;

	private DistanceUnit(double toBaseMultiplier) {
		this.toBaseMultiplier = toBaseMultiplier;
	}

    @Override
    public double getToBaseMultiplier() {
        return toBaseMultiplier;
    }
}
