package pl.konar.rubikscube.model.cube.math;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

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
