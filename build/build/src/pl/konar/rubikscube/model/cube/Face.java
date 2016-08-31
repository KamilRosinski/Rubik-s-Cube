package pl.konar.rubikscube.model.cube;

public enum Face {

	UP, BACK, RIGHT, FRONT, LEFT, DOWN;

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
