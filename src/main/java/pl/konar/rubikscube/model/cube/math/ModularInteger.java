package pl.konar.rubikscube.model.cube.math;

import pl.konar.rubikscube.model.cube.math.exception.IllegalModularIntegerValueException;

public class ModularInteger {

	private int value;
	private int base;

	public ModularInteger(int value, int base) {
		if (value >= base) {
			throw new IllegalModularIntegerValueException(
					"ModularInteger value must not be greater equals to base: value=" + value + ", base=" + base + ".");
		}
		this.value = value;
		this.base = base;
	}

	public int getValue() {
		return value;
	}

	public int getBase() {
		return base;
	}

	public static ModularInteger[] getPossibleValues(int base) {
		ModularInteger[] result = new ModularInteger[base];
		for (int i = 0; i < base; ++i) {
			result[i] = new ModularInteger(i, base);
		}
		return result;
	}

	public ModularInteger add(int i) {
		return new ModularInteger((value + i) % base, base);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + base;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ModularInteger)) {
			return false;
		}
		ModularInteger other = (ModularInteger) obj;
		if (base != other.base) {
			return false;
		}
		if (value != other.value) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(value) + "mod" + String.valueOf(base);
	}
	
}
