package pl.konar.rubikscube.model.cube;

public enum Angle {

	CLOCKWISE, DOUBLE, COUNTER_CLOCKWISE;

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
