package pl.konar.rubikscube.model.cube.math.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.math.PermutationVector;
import pl.konar.rubikscube.model.cube.math.exception.IllegalPermutationVectorException;

public class PermutationVectorTest {

	@Test
	public void shouldInitializePermutationVcetor() {
		// given
		int initialSize = 5;
		Integer index = 3;
		// when
		PermutationVector permutation = new PermutationVector(initialSize);
		// then
		assertEquals(initialSize, permutation.size());
		assertEquals(index, permutation.get(index));
	}

	@Test
	public void shouldInitializePermutationFromArray() {
		// given
		int[] elements = { 0, 2, 3, 4, 1 };
		// when
		PermutationVector permutation = new PermutationVector(elements);
		// then
		assertNotNull(permutation);
	}

	@Test(expected = IllegalPermutationVectorException.class)
	public void shouldThrowExceptionOnWrongElementValue() {
		// given
		int[] elements = { 0, 5, 3, 4, 1 };
		// when
		new PermutationVector(elements);
		// then
		fail("No exception thrown.");
	}

	@Test(expected = IllegalPermutationVectorException.class)
	public void shouldThrowExceptionOnNonUniqueElement() {
		// given
		int[] elements = { 0, 2, 2, 4, 1 };
		// when
		new PermutationVector(elements);
		// then
		fail("No exception thrown.");
	}

	@Test
	public void shouldPermuteTwoElements() {
		// given
		PermutationVector permutation = new PermutationVector(4);
		Integer[] cycle = { 0, 2 };
		// when
		permutation.permute(cycle);
		List<Integer> result = new ArrayList<>();
		for (Integer i : permutation) {
			result.add(i);
		}
		// then
		assertEquals(Arrays.asList(2, 1, 0, 3), result);
	}

}
