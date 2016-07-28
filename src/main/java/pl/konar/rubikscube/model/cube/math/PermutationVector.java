package pl.konar.rubikscube.model.cube.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import pl.konar.rubikscube.model.cube.math.exception.IllegalPermutationVectorException;

public class PermutationVector extends Vector<Integer> {

	public PermutationVector(int size) {
		super(size);
		for (int index = 0; index < size(); ++index) {
			set(index, index);
		}
	}

	public PermutationVector(Integer... values) {
		super(values.length);
		Set<Integer> insertedValues = new HashSet<>(size());
		for (int index = 0; index < size(); ++index) {
			if (!(values[index] < size() && insertedValues.add(values[index]))) {
				throw new IllegalPermutationVectorException(
						"Illegal permutation vector: " + Arrays.toString(values) + ".");
			}
			set(index, values[index]);
		}
	}

	@Override
	public PermutationVector permute(PermutationVector permutation) {
		return new PermutationVector(Arrays.copyOf(super.permute(permutation).toArray(), size(), Integer[].class));
	}

	public PermutationParity parity() {
		// TODO: Parity check.
		return null;
	}

}
