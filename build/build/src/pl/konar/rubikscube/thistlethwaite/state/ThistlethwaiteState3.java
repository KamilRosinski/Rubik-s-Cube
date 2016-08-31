package pl.konar.rubikscube.thistlethwaite.state;

import java.util.HashSet;
import java.util.Set;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.math.PermutationParity;

public class ThistlethwaiteState3 implements ThistlethwaiteState {

	private Set<Integer> firstSlice = new HashSet<>();
	private Set<Integer> secondSlice = new HashSet<>();
	private Set<Integer> firstPair = new HashSet<>();
	private Set<Integer> secondPair = new HashSet<>();
	private Set<Integer> thirdPair = new HashSet<>();
	private Set<Integer> fourthPair = new HashSet<>();
	private PermutationParity parity;

	public ThistlethwaiteState3(ThistlethwaiteCube cube) {
		for (int i : new int[] { 0, 2, 8, 10 }) {
			firstSlice.add(cube.getEdgesPermutation().get(i));
		}
		for (int i : new int[] { 4, 5, 6, 7 }) {
			secondSlice.add(cube.getEdgesPermutation().get(i));
		}
		for (int i : new int[] { 0, 2 }) {
			firstPair.add(cube.getCornersPermutation().get(i));
		}
		for (int i : new int[] { 1, 3 }) {
			secondPair.add(cube.getCornersPermutation().get(i));
		}
		for (int i : new int[] { 4, 6 }) {
			thirdPair.add(cube.getCornersPermutation().get(i));
		}
		for (int i : new int[] { 5, 7 }) {
			fourthPair.add(cube.getCornersPermutation().get(i));
		}
		parity = cube.getCornersPermutation().parity();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstPair == null) ? 0 : firstPair.hashCode());
		result = prime * result + ((firstSlice == null) ? 0 : firstSlice.hashCode());
		result = prime * result + ((fourthPair == null) ? 0 : fourthPair.hashCode());
		result = prime * result + ((parity == null) ? 0 : parity.hashCode());
		result = prime * result + ((secondPair == null) ? 0 : secondPair.hashCode());
		result = prime * result + ((secondSlice == null) ? 0 : secondSlice.hashCode());
		result = prime * result + ((thirdPair == null) ? 0 : thirdPair.hashCode());
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
		if (getClass() != obj.getClass()) {
			return false;
		}
		ThistlethwaiteState3 other = (ThistlethwaiteState3) obj;
		if (firstPair == null) {
			if (other.firstPair != null) {
				return false;
			}
		} else if (!firstPair.equals(other.firstPair)) {
			return false;
		}
		if (firstSlice == null) {
			if (other.firstSlice != null) {
				return false;
			}
		} else if (!firstSlice.equals(other.firstSlice)) {
			return false;
		}
		if (fourthPair == null) {
			if (other.fourthPair != null) {
				return false;
			}
		} else if (!fourthPair.equals(other.fourthPair)) {
			return false;
		}
		if (parity != other.parity) {
			return false;
		}
		if (secondPair == null) {
			if (other.secondPair != null) {
				return false;
			}
		} else if (!secondPair.equals(other.secondPair)) {
			return false;
		}
		if (secondSlice == null) {
			if (other.secondSlice != null) {
				return false;
			}
		} else if (!secondSlice.equals(other.secondSlice)) {
			return false;
		}
		if (thirdPair == null) {
			if (other.thirdPair != null) {
				return false;
			}
		} else if (!thirdPair.equals(other.thirdPair)) {
			return false;
		}
		return true;
	}

}
