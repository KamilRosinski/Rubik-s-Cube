package pl.konar.rubikscube.model.cube.math;

import pl.konar.rubikscube.model.cube.math.exception.IllegalOrientationVectorException;

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

	public OrientationVector(int base, int[] values) {
		super(values.length);
		for (int index = 0; index < size(); ++index) {
			if (values[index] >= base) {
				throw new IllegalOrientationVectorException(
						"Orientation vector element must not be greater or equal to ist base.");
			}
			set(index, new ModularInteger(values[index], base));
		}
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

	// public void increaseElementBy(int index, int increment) {
	// set(index, (get(index) + increment) % base);
	// }

}
