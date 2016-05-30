package pl.konar.rubikscube.model.cube.math;

public class Permutation extends Vector<Integer> {

	public Permutation(int size) {
		super(size);
		for (int index = 0; index < size(); ++index) {
			set(index, new Integer(index));
		}
	}

	public void permute(Integer[] cycle) {
		Integer tmp = get(cycle[0]);
		for (int index = 0; index < cycle.length; ++index) {
			set(cycle[index], get(cycle[(index + 1) % cycle.length]));
		}
		set(cycle[cycle.length - 1], tmp);
	}

}
