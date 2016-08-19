package pl.konar.rubikscube.thistlethwaite.state;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.math.OrientationVector;

public class ThistlethwaiteState1 implements ThistlethwaiteState {

	private OrientationVector edgesOrientation;

	public ThistlethwaiteState1(ThistlethwaiteCube cube) {
		edgesOrientation = cube.getEdgesOrientation();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edgesOrientation == null) ? 0 : edgesOrientation.hashCode());
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
		ThistlethwaiteState1 other = (ThistlethwaiteState1) obj;
		if (edgesOrientation == null) {
			if (other.edgesOrientation != null) {
				return false;
			}
		} else if (!edgesOrientation.equals(other.edgesOrientation)) {
			return false;
		}
		return true;
	}

}
