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

		assertUnitConversion(1.0, DistanceUnit.METERS, DistanceUnit.FEET, 3.280839895013123);
		assertUnitConversion(1.0, DistanceUnit.FEET, DistanceUnit.METERS, 0.3048);

		softly.assertAll();
	}

	private <U extends Unit> void assertUnitConversion(double value, U unitToConvertFrom, U unitToConvertTo,
			double expected) {
		Measurement<U> measurement = Measurement.of(value, unitToConvertFrom);
		double actual = measurement.doubleValueIn(unitToConvertTo);
		softly.assertThat(actual).isCloseTo(expected, tolerance);
	}
}
