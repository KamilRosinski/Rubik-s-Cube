package pl.konar.rubikscube.model.cube.math.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
		Integer[] elements = { 0, 2, 3, 4, 1 };
		// when
		PermutationVector permutation = new PermutationVector(elements);
		// then
		assertNotNull(permutation);
	}

	@Test(expected = IllegalPermutationVectorException.class)
	public void shouldThrowExceptionOnWrongElementValue() {
		// given
		Integer[] elements = { 0, 5, 3, 4, 1 };
		// when
		new PermutationVector(elements);
		// then
		fail("No exception thrown.");
	}

	@Test(expected = IllegalPermutationVectorException.class)
	public void shouldThrowExceptionOnNonUniqueElement() {
		// given
		Integer[] elements = { 0, 2, 2, 4, 1 };
		// when
		new PermutationVector(elements);
		// then
		fail("No exception thrown.");
	}

	@Test
	public void shouldComposeTwoPermutations() {
		// given
		PermutationVector first = new PermutationVector(1, 3, 0, 2, 4);
		PermutationVector second = new PermutationVector(4, 3, 2, 1, 0);
		PermutationVector expected = new PermutationVector(4, 2, 0, 3, 1);
		// when
		PermutationVector result = first.permute(second);
		// then
		assertNotNull(result);
		assertEquals(expected, result);
	}

}
