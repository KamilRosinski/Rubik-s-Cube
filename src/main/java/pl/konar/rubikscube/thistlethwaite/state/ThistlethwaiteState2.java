package pl.konar.rubikscube.thistlethwaite.state;

import java.util.HashSet;
import java.util.Set;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.math.OrientationVector;

public class ThistlethwaiteState2 implements ThistlethwaiteState {

	private OrientationVector cornersOrientation;
	private Set<Integer> middleSlice = new HashSet<>();

	public ThistlethwaiteState2(ThistlethwaiteCube cube) {
		cornersOrientation = cube.getCornersOrientation();
		for (int i : new int[] { 1, 3, 9, 11 }) {
			middleSlice.add(cube.getEdgesPermutation().get(i));
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cornersOrientation == null) ? 0 : cornersOrientation.hashCode());
		result = prime * result + ((middleSlice == null) ? 0 : middleSlice.hashCode());
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
		ThistlethwaiteState2 other = (ThistlethwaiteState2) obj;
		if (cornersOrientation == null) {
			if (other.cornersOrientation != null) {
				return false;
			}
		} else if (!cornersOrientation.equals(other.cornersOrientation)) {
			return false;
		}
		if (middleSlice == null) {
			if (other.middleSlice != null) {
				return false;
			}
		} else if (!middleSlice.equals(other.middleSlice)) {
			return false;
		}
		return true;
	}

}
