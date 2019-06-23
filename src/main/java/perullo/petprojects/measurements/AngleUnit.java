package perullo.petprojects.measurements;

public enum AngleUnit implements Unit {
    RADIANS(1.0),
    DEGREES(0.0174533);
    
    private final double toBaseMultiplier;
    
    private AngleUnit(double toBaseMultiplier) {
        this.toBaseMultiplier = toBaseMultiplier;
    }
    
    @Override
    public double getToBaseMultiplier() {
        return toBaseMultiplier;
    }
}
