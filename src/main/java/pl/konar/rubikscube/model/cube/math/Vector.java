package pl.konar.rubikscube.model.cube.math;

import java.util.Arrays;
import java.util.Iterator;

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

}
