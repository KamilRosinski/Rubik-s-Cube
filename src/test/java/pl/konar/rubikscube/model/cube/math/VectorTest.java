package pl.konar.rubikscube.model.cube.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class VectorTest {

	@Test
	public void shouldInitializeVectorAndCheckItsLength() {
		// given
		int initialSize = 5;
		// when
		Vector<Integer> vector = new Vector<>(initialSize);
		// then
		assertEquals(initialSize, vector.size());
	}

	@Test
	public void shouldSetVectorElement() {
		// given
		int initialSize = 5;
		int index = 3;
		Integer value = 2;
		// when
		Vector<Integer> vector = new Vector<>(initialSize);
		vector.set(index, value);
		// then
		assertEquals(value, vector.get(index));
	}

	@Test
	public void shouldIterateOverVector() {
		// given
		List<Integer> values = Arrays.asList(2, 3, 5, 7);
		Vector<Integer> vector = new Vector<>(values.size());
		// when
		for (int i = 0; i < vector.size(); ++i) {
			vector.set(i, values.get(i));
		}
		List<Integer> result = new ArrayList<>();
		for (Integer i : vector) {
			result.add(i);
		}
		// then
		assertEquals(result, values);
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
