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

	public PermutationVector(int... values) {
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

	public PermutationVector permute(int... cycle) {
		int[] result = new int[size()];
		for (int index = 0; index < size(); ++index) {
			result[index] = get(index);
		}
		int tmp = get(cycle[0]);
		for (ModularInteger index : ModularInteger.getPossibleValues(cycle.length)) {
			result[cycle[index.getValue()]] = get(cycle[index.add(1).getValue()]);
		}
		result[cycle[cycle.length - 1]] = tmp;
		return new PermutationVector(result);
	}

	public PermutationParity parity() {
		return null;
	}

}
