package pl.konar.rubikscube.model.cube;

public enum Move {

	E(Face.FRONT, 0), //
	F1(Face.FRONT, 1), F2(Face.FRONT, 2), F3(Face.FRONT, 3), //
	B1(Face.BACK, 1), B2(Face.BACK, 2), B3(Face.BACK, 3), //
	L1(Face.LEFT, 1), L2(Face.LEFT, 2), L3(Face.LEFT, 3), //
	R1(Face.RIGHT, 1), R2(Face.RIGHT, 2), R3(Face.RIGHT, 3), //
	U1(Face.UP, 1), U2(Face.UP, 2), U3(Face.UP, 3), //
	D1(Face.DOWN, 1), D2(Face.DOWN, 2), D3(Face.DOWN, 3);
	private Face face;
	private int angle;

	private Move(Face face, int angle) {
		this.face = face;
		this.angle = angle;
	}

	public Face getFace() {
		return face;
	}

	public int getAngle() {
		return angle;
	}

	@Override
	public String toString() {
		return face.toString() + "\t" + angle;
	}

	public Move inverse() {
		return values()[ordinal() == 0 ? ordinal() : ordinal() + 2 * (1 - (ordinal() - 1) % 3)];
	}

}
