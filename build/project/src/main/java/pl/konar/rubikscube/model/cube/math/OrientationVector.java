package pl.konar.rubikscube.model.cube.math;

import java.util.Arrays;

import pl.konar.rubikscube.model.cube.math.exception.IllegalOrientationVectorException;
import pl.konar.rubikscube.model.cube.math.exception.WrongVectorLengthException;

public class OrientationVector extends Vector<ModularInteger> {

	private static final int INITIAL_VALUE = 0;
	private int base;

	public OrientationVector(int base, int size) {
		super(size);
		this.base = base;
		for (int index = 0; index < size(); ++index) {
			set(index, new ModularInteger(INITIAL_VALUE, base));
		}
	}

	public OrientationVector(int base, int... values) {
		super(values.length);
		this.base = base;
		for (int index = 0; index < size(); ++index) {
			if (values[index] >= base) {
				throw new IllegalOrientationVectorException(
						"Orientation vector element must not be greater or equal to ist base.");
			}
			set(index, new ModularInteger(values[index], base));
		}
	}

	public OrientationVector(int base, ModularInteger... values) {
		super(values);
		this.base = base;
	}

	public OrientationVector increaseElements(int[] elements, int[] increments) {
		int[] values = new int[size()];
		for (int index = 0; index < elements.length; ++index) {
			values[index] = get(index).getValue();
		}
		for (int index = 0; index < elements.length; ++index) {
			values[index] = (values[index] + increments[index]) % base;
		}
		return new OrientationVector(base, values);
	}

	public OrientationVector increaseElements(OrientationVector vector) {
		if (size() != vector.size()) {
			throw new WrongVectorLengthException("Vectors must have equal lengths.");
		}
		OrientationVector result = new OrientationVector(base, size());
		for (int index = 0; index < size(); ++index) {
			ModularInteger value = get(index).add(vector.get(index));
			result.set(index, value);
		}
		return result;
	}

	public void increaseElement(int index, int value) {
		int newValue = (get(index).getValue() + value) % base;
		set(index, new ModularInteger(newValue, base));
	}

	public ModularInteger sum() {
		ModularInteger result = new ModularInteger(0, base);
		for (ModularInteger element : this) {
			result = result.add(element);
		}
		return result;
	}

	@Override

	public OrientationVector permute(PermutationVector permutation) {
		return new OrientationVector(base,
				Arrays.copyOf(super.permute(permutation).toArray(), size(), ModularInteger[].class));
	}

}
