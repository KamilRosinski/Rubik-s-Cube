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
		for (ModularInteger index : ModularInteger.getValues(cycle.length)) {
			set(cycle[index.getValue()], get(cycle[index.add(1).getValue()]));
		}
		set(cycle[cycle.length - 1], tmp);
	}

}
