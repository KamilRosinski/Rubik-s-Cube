package pl.konar.rubikscube.model.cube.math;

import java.util.Arrays;
import java.util.Iterator;

import pl.konar.rubikscube.model.cube.math.exception.WrongVectorLengthException;

public class Vector<T> implements Iterable<T> {

	private T[] values;

	@SuppressWarnings("unchecked")
	public Vector(int size) {
		values = (T[]) new Object[size];
	}

	@SuppressWarnings("unchecked")
	public Vector(T... values) {
		this(values.length);
		for (int index = 0; index < size(); ++index) {
			this.values[index] = values[index];
		}
	}

	public int size() {
		return values.length;
	}

	public T get(int index) {
		return values[index];
	}

	protected void set(int index, T value) {
		values[index] = value;
	}

	public Object[] toArray() {
		// @SuppressWarnings("unchecked")
		// T[] result = (T[]) new Object[size()];
		// for (int index = 0; index < size(); ++index) {
		// result[index] = (T) values[index];
		// }
		return values;
	}

	public Vector<T> permute(PermutationVector permutation) {
		if (size() != permutation.size()) {
			throw new WrongVectorLengthException("Permutation vector must be equal length as permuted vector, but are: "
					+ permutation.size() + " and " + size() + ".");
		}
		Vector<T> result = new Vector<>(size());
		for (int index = 0; index < size(); ++index) {
			result.set(index, get(permutation.get(index)));
		}
		return result;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < values.length;
			}

			@Override
			public T next() {
				return values[currentIndex++];
			}
		};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(values);
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
		if (!(obj instanceof Vector)) {
			return false;
		}
		Vector<?> other = (Vector<?>) obj;
		if (!Arrays.equals(values, other.values)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return Arrays.toString(values);
		// String result = "[";
		// for (T element : values) {
		// result += " " + element;
		// }
		// return result + " ]";
	}

}
