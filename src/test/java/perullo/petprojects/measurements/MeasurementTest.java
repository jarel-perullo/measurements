package perullo.petprojects.measurements;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;

public class MeasurementTest {

	private final Offset<Double> tolerance = Offset.offset(0.0000001);
	private final SoftAssertions softly = new SoftAssertions();

	@Test
	public void testDistanceUnits() {

		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.METERS, 1.0);

		assertUnitConversion(1.0, DistanceUnit.FEET, DistanceUnit.METERS, 0.3048);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.FEET, 1.0/0.3048);

        assertUnitConversion(1.0, DistanceUnit.DECIMETERS, DistanceUnit.METERS, 0.1);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.DECIMETERS, 1.0/0.1);

        assertUnitConversion(1.0, DistanceUnit.CENTIMETERS, DistanceUnit.METERS, 0.01);
        assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.CENTIMETERS, 1.0/0.01);

		assertUnitConversion(1.0, DistanceUnit.MILLIMETERS, DistanceUnit.METERS, 0.001);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.MILLIMETERS, 1.0/0.001);

		assertUnitConversion(1.0, DistanceUnit.DECAMETERS, DistanceUnit.METERS, 10.0);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.DECAMETERS, 1.0/10.0);

		assertUnitConversion(1.0, DistanceUnit.INCHES, DistanceUnit.METERS, 0.0254);
		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.INCHES, 1.0/0.0254);

        assertUnitConversion(1.0, DistanceUnit.FEET, DistanceUnit.INCHES, 12.0);
        assertUnitConversion(1.0, DistanceUnit.INCHES, DistanceUnit.FEET, 1.0/12.0);


//    	HECTOMETER(100.0),
//    	KILOMETERS(1000.0),
//    	FEET(0.3048),
//    	YARDS(0.9144),
//    	INCHES(0.0254);

		softly.assertAll();
	}

	private <U extends Unit> void assertUnitConversion(double value, U unitToConvertFrom, U unitToConvertTo,
			double expected) {
		Measurement<U> measurement = Measurement.of(value, unitToConvertFrom);
		double actual = measurement.doubleValueIn(unitToConvertTo);
		softly.assertThat(actual).isCloseTo(expected, tolerance);
	}
}
