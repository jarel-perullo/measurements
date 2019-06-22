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
		Measurement<DistanceUnit> measurement;
		double actual;
		double expected;

		measurement = Measurement.of(1.0, DistanceUnit.METERS);
		expected = 3.280839895013123;
		actual = measurement.doubleValueIn(DistanceUnit.FEET);
		softly.assertThat(actual).isCloseTo(expected, tolerance);

		softly.assertAll();
	}
}
