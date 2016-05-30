package pl.konar.rubikscube.model.cube.math;

import java.util.Iterator;

public class Vector<T> implements Iterable<T> {

	private T[] values;

	@SuppressWarnings("unchecked")
	public Vector(int size) {
		values = (T[]) new Object[size];
	}

	public int size() {
		return values.length;
	}

	public T get(int index) {
		return values[index];
	}

	public void set(int index, T value) {
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

}
