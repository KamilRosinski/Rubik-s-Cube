package pl.konar.rubikscube.model.cube.math.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.math.ModularInteger;
import pl.konar.rubikscube.model.cube.math.OrientationVector;

public class OrientationVectorTest {

	@Test
	public void shouldInitializeOrientationVector() {
		// given
		int size = 5;
		int base = 3;
		// when
		OrientationVector orientation = new OrientationVector(base, size);
		ModularInteger expected = new ModularInteger(0, base);
		// then
		assertNotNull(orientation);
		assertEquals(size, orientation.size());
		assertEquals(expected, orientation.get(0));
		assertEquals(expected, orientation.get(size - 1));
	}

	@Test
	public void shouldInitializeOrientationVectorFromArray() {
		// given
		int[] elements = { 0, 2, 1, 2 };
		int base = 3;
		// when
		OrientationVector orientation = new OrientationVector(base, elements);
		// then
		assertNotNull(orientation);
		assertEquals(elements.length, orientation.size());
	}

	@Test
	public void shouldSumElements() {
		// given
		OrientationVector orientation = new OrientationVector(3, 0, 1, 2, 1);
		// when
		ModularInteger result = orientation.sum();
		ModularInteger expected = new ModularInteger(1, 3);
		// then
		assertEquals(expected, result);
	}

}
