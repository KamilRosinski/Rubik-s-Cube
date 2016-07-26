package pl.konar.rubikscube.model.cube;

public enum ThistlethwaiteMove {

	U1(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 1, 2 }, new int[] { 0, 1, 2, 3 }, new int[] { 1, 1, 1, 1 }), //
	U2(new int[] { 2, 2, 0, 3 }, new int[] { 0, 0, 0, 0 }, new int[] { 2, 3, 0, 1 }, new int[] { 0, 0, 0, 0 }), //
	U3(new int[] { 0, 1, 2, 3 }, new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 1, 2 }, new int[] { 1, 1, 1, 1 });

	private int[] cornersCycle;
	private int[] cornersFlip;
	private int[] edgesCycle;
	private int[] edgesFlip;

	private ThistlethwaiteMove(int[] cornersCycle, int[] cornersFlip, int[] edgesCycle, int[] edgesFlip) {
		this.cornersCycle = cornersCycle;
		this.cornersFlip = cornersFlip;
		this.edgesCycle = edgesCycle;
		this.edgesFlip = edgesFlip;
	}

	public int[] getCornersCycle() {
		return cornersCycle;
	}

	public int[] getEdgesCycle() {
		return edgesCycle;
	}

	public int[] getCornersFlip() {
		return cornersFlip;
	}

	public int[] getEdgesFlip() {
		return edgesFlip;
	}

	@Override
	public String toString() {
		return name();
	}

	public ThistlethwaiteMove inverse() {
		return values()[ordinal() == 0 ? ordinal() : ordinal() + 2 * (1 - (ordinal() - 1) % 3)];
	}

}
