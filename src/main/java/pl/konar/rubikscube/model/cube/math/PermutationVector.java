package pl.konar.rubikscube.model.cube.math;

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
				throw new IllegalPermutationVectorException("Illegag permutation vector: " + values + ".");
			}
			set(index, values[index]);
		}
	}

	public void permute(Integer[] cycle) {
		Integer tmp = get(cycle[0]);
		for (ModularInteger index : ModularInteger.getPossibleValues(cycle.length)) {
			set(cycle[index.getValue()], get(cycle[index.add(1).getValue()]));
		}
		set(cycle[cycle.length - 1], tmp);
	}

	public PermutationParity parity() {
		return null;
	}

}
