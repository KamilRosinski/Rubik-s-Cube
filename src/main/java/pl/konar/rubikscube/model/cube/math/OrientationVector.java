package pl.konar.rubikscube.model.cube.math;

public class OrientationVector extends Vector<ModularInteger> {

	private static final int INITIAL_VALUE = 0;

	public OrientationVector(int size, int base) {
		super(size);
		for (int index = 0; index < size(); ++index) {
			set(index, new ModularInteger(INITIAL_VALUE, base));
		}
	}

	public void increaseElementBy(int index, int value) {
		set(index, get(index).add(value));
	}

}
