package perullo.petprojects.measurements;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.Offset;
import org.junit.Test;

public class MeasurementTest {

	private final Offset<Double> tolerance = Offset.offset(0.0001);
	private final SoftAssertions softly = new SoftAssertions();

	@Test
	public void testDistanceUnits() {
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.METERS, 1.0);

        assertUnitConversion(1.0, DistanceUnit.DECIMETERS, DistanceUnit.METERS, 0.1);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.DECIMETERS, 1.0/0.1);

        assertUnitConversion(1.0, DistanceUnit.CENTIMETERS, DistanceUnit.METERS, 0.01);
        assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.CENTIMETERS, 1.0/0.01);

		assertUnitConversion(1.0, DistanceUnit.MILLIMETERS, DistanceUnit.METERS, 0.001);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.MILLIMETERS, 1.0/0.001);

		assertUnitConversion(1.0, DistanceUnit.DECAMETERS, DistanceUnit.METERS, 10.0);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.DECAMETERS, 1.0/10.0);

		assertUnitConversion(1.0, DistanceUnit.HECTOMETERS, DistanceUnit.METERS, 100.0);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.HECTOMETERS, 1.0/100.0);
		
		assertUnitConversion(1.0, DistanceUnit.KILOMETERS, DistanceUnit.METERS, 1000.0);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.KILOMETERS, 1.0/1000.0);
		
		assertUnitConversion(1.0, DistanceUnit.INCHES, DistanceUnit.METERS, 0.0254);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.INCHES, 1.0/0.0254);

		assertUnitConversion(1.0, DistanceUnit.FEET, DistanceUnit.METERS, 0.3048);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.FEET, 1.0/0.3048);

        assertUnitConversion(1.0, DistanceUnit.INCHES, DistanceUnit.METERS, 0.0254);
        assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.INCHES, 1.0/0.0254);

        assertUnitConversion(1.0, DistanceUnit.FEET, DistanceUnit.INCHES, 12.0);
        assertUnitConversion(1.0, DistanceUnit.INCHES, DistanceUnit.FEET, 1.0/12.0);

        assertUnitConversion(1.0, DistanceUnit.YARDS, DistanceUnit.METERS, 0.9144);
        assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.YARDS, 1.0/0.9144);

		softly.assertAll();
	}

    @Test
    public void testAngleUnits() {
        assertUnitConversion(180, AngleUnit.DEGREES, AngleUnit.RADIANS, Math.PI);
        assertUnitConversion(Math.PI, AngleUnit.RADIANS, AngleUnit.DEGREES, 180.0);
        
        assertUnitConversion(360, AngleUnit.DEGREES, AngleUnit.RADIANS, 2 * Math.PI);
        assertUnitConversion(2 * Math.PI, AngleUnit.RADIANS, AngleUnit.DEGREES, 360.0);
        
        softly.assertAll();
    }

	private <U extends Unit> void assertUnitConversion(double value, U unitToConvertFrom, U unitToConvertTo,
			double expected) {
		Measurement<U> measurement = Measurement.of(value, unitToConvertFrom);
		double actual = measurement.doubleValueIn(unitToConvertTo);
		softly.assertThat(actual).isCloseTo(expected, tolerance);
	}
}
