package pl.konar.rubikscube.model.cube.math;

import pl.konar.rubikscube.model.cube.math.exception.IllegalOrientationVectorException;

public class OrientationVector extends Vector</* Modular */Integer> {

	private static final int INITIAL_VALUE = 0;
	private int base;

	public OrientationVector(int size, int base) {
		super(size);
		this.base = base;
		for (int index = 0; index < size(); ++index) {
			set(index, INITIAL_VALUE);
		}
	}

	public OrientationVector(int base, int... values) {
		super(values.length);
		for (int index = 0; index < size(); ++index) {
			if (values[index] >= base) {
				throw new IllegalOrientationVectorException(
						"Orientation vector element must not be greater or equal to ist base.");
			}
			set(index, values[index]);
		}
	}

	public void increaseElementBy(int index, int increment) {
		set(index, (get(index) + increment) % base);
	}

}
