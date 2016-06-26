package pl.konar.rubikscube.model.cube.math.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.math.Vector;

public class VectorTest {

	@Test
	public void shouldInitializeVectorAndCheckItsLength() {
		// given
		int initialSize = 5;
		// when
		Vector<Integer> vector = new Vector<>(initialSize);
		// then
		assertNotNull(vector);
		assertEquals(initialSize, vector.size());
	}

	@Test
	public void shouldInitializeVectorFromArray() {
		// given
		Integer[] values = {2, 3, 5};
		// when
		Vector<Integer> vector = new Vector<>(values);
		// then
		assertNotNull(vector);
		assertEquals(values[1], vector.get(1));
	}
	
	@Test
	public void shouldIterateOverVector() {
		// given
		Integer[] values = { 2, 3, 5, 7 };
		Vector<Integer> vector = new Vector<>(values);
		// when
		List<Integer> result = new ArrayList<>();
		for (Integer i : vector) {
			result.add(i);
		}
		// then
		assertNotNull(vector);
		assertEquals(Arrays.asList(values), result);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void shouldThowArrayIndexOutOfBoundException() {
		// given
		Vector<Integer> vector = new Vector<>(5);
		int index = 7;
		// when
		vector.get(index);
		// then
		fail("No exception thrown.");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldThowUnsupportedOperationExceptionOnRemovingElement() {
		// given
		Vector<Integer> vector = new Vector<>(5);
		Iterator<Integer> iterator = vector.iterator();
		// when
		iterator.remove();
		// then
		fail("No exception thrown.");
	}

}
