package pl.konar.rubikscube.model.cube.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class OrientationVectorTest {

	@Test
	public void shouldInitializeOrientationVector() {
		// given
		int size = 5;
		int base = 3;
		// when
		OrientationVector orientation = new OrientationVector(size, base);
		ModularInteger expected = new ModularInteger(0, base);
		// then
		assertNotNull(orientation);
		assertEquals(size, orientation.size());
		assertEquals(expected, orientation.get(0));
		assertEquals(expected, orientation.get(size - 1));
	}

	@Test
	public void shouldIncreaseElement() {
		// given
		int size = 5;
		int base = 3;
		// when
		OrientationVector orientation = new OrientationVector(size, base);
		orientation.increaseElementBy(0, 4);
		// then
		assertNotNull(orientation);
		assertEquals(new ModularInteger(1, base), orientation.get(0));
	}

}
