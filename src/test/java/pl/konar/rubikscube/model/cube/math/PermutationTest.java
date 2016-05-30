package pl.konar.rubikscube.model.cube.math;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PermutationTest {

	@Test
	public void shouldInitializePermutation() {
		// given
		int initialSize = 5;
		Integer index = 3;
		// when
		Permutation permutation = new Permutation(initialSize);
		// then
		assertEquals(index, permutation.get(index));
	}

	@Test
	public void shouldPermuteElements() {
		// given
		Permutation permutation = new Permutation(4);
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
