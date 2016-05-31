package pl.konar.rubikscube.model.cube.math;

public class ModularInteger {

	private int value;
	private int base;

	public ModularInteger(int value, int base) {
		this.value = value % base;
		this.base = base;
	}

	public int getValue() {
		return value;
	}

	public int getBase() {
		return base;
	}

	public static ModularInteger[] getValues(int base) {
		ModularInteger[] result = new ModularInteger[base];
		for (int i = 0; i < base; ++i) {
			result[i] = new ModularInteger(i, base);
		}
		return result;
	}

	public ModularInteger add(int i) {
		return new ModularInteger((value + i) % base, base);
	}

}
