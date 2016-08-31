package pl.konar.rubikscube.thistlethwaite.state;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;

public class ThistlethwaiteState4 implements ThistlethwaiteState {

	private ThistlethwaiteCube cube;

	public ThistlethwaiteState4(ThistlethwaiteCube cube) {
		this.cube = cube;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cube == null) ? 0 : cube.hashCode());
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
		ThistlethwaiteState4 other = (ThistlethwaiteState4) obj;
		if (cube == null) {
			if (other.cube != null) {
				return false;
			}
		} else if (!cube.equals(other.cube)) {
			return false;
		}
		return true;
	}

}
