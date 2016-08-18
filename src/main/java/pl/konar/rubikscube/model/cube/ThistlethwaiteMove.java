package pl.konar.rubikscube.model.cube;

import pl.konar.rubikscube.model.cube.math.OrientationVector;
import pl.konar.rubikscube.model.cube.math.PermutationVector;

public enum ThistlethwaiteMove {

	EMPTY(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	UP_1(new PermutationVector(1, 2, 3, 0, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 1, 2, 1, 2, 0, 0, 0, 0),
			new PermutationVector(1, 2, 3, 0, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0)), //
	UP_2(new PermutationVector(2, 3, 0, 1, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(2, 3, 0, 1, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	UP_3(new PermutationVector(3, 0, 1, 2, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 1, 2, 1, 2, 0, 0, 0, 0),
			new PermutationVector(3, 0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0)), //
	DOWN_1(new PermutationVector(0, 1, 2, 3, 7, 4, 5, 6),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 2, 1, 2, 1),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 11, 8, 9, 10),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1)), //
	DOWN_2(new PermutationVector(0, 1, 2, 3, 6, 7, 4, 5),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 8, 9),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	DOWN_3(new PermutationVector(0, 1, 2, 3, 5, 6, 7, 4),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 2, 1, 2, 1),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 8),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1)), //
	FRONT_1(new PermutationVector(0, 1, 6, 2, 4, 5, 7, 3),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 6, 3, 4, 5, 10, 2, 8, 9, 7, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	FRONT_2(new PermutationVector(0, 1, 7, 6, 4, 5, 3, 2),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 10, 3, 4, 5, 7, 6, 8, 9, 2, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	FRONT_3(new PermutationVector(0, 1, 3, 7, 4, 5, 2, 6),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 7, 3, 4, 5, 2, 10, 8, 9, 6, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	BACK_1(new PermutationVector(4, 0, 2, 3, 5, 1, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(4, 1, 2, 3, 8, 0, 6, 7, 5, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	BACK_2(new PermutationVector(5, 4, 2, 3, 1, 0, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(8, 1, 2, 3, 5, 4, 6, 7, 0, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	BACK_3(new PermutationVector(1, 5, 2, 3, 0, 4, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(5, 1, 2, 3, 0, 8, 6, 7, 4, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	LEFT_1(new PermutationVector(3, 1, 2, 7, 0, 5, 6, 4),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 2, 0, 0, 1, 1, 0, 0, 2),
			new PermutationVector(0, 1, 2, 7, 3, 5, 6, 11, 8, 9, 10, 4),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	LEFT_2(new PermutationVector(7, 1, 2, 4, 3, 5, 6, 0),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 11, 7, 5, 6, 4, 8, 9, 10, 3),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	LEFT_3(new PermutationVector(4, 1, 2, 0, 7, 5, 6, 3),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 2, 0, 0, 1, 1, 0, 0, 2),
			new PermutationVector(0, 1, 2, 4, 11, 5, 6, 3, 8, 9, 10, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	RIGHT_1(new PermutationVector(0, 5, 1, 3, 4, 6, 2, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 1, 2, 0, 0, 2, 1, 0),
			new PermutationVector(0, 5, 2, 3, 4, 9, 1, 7, 8, 6, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	RIGHT_2(new PermutationVector(0, 6, 5, 3, 4, 2, 1, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 9, 2, 3, 4, 6, 5, 7, 8, 1, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	RIGHT_3(new PermutationVector(0, 2, 6, 3, 4, 1, 5, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 1, 2, 0, 0, 2, 1, 0),
			new PermutationVector(0, 6, 2, 3, 4, 1, 9, 7, 8, 5, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

	private PermutationVector cornersPermutation;
	private OrientationVector cornersOrientation;
	private PermutationVector edgesPermutation;
	private OrientationVector edgesOrientation;

	private ThistlethwaiteMove(PermutationVector cornersPermutation, OrientationVector cornersOrientation,
			PermutationVector edgesPermutation, OrientationVector edgesOrientation) {
		this.cornersPermutation = cornersPermutation;
		this.cornersOrientation = cornersOrientation;
		this.edgesPermutation = edgesPermutation;
		this.edgesOrientation = edgesOrientation;
	}

	public PermutationVector getCornersPermutation() {
		return cornersPermutation;
	}

	public PermutationVector getEdgesPermutation() {
		return edgesPermutation;
	}

	public OrientationVector getCornersOrientation() {
		return cornersOrientation;
	}

	public OrientationVector getEdgesOrientation() {
		return edgesOrientation;
	}

	// public static List<ThistlethwaiteMove> notEmptyValues() {
	// List<ThistlethwaiteMove> result = new ArrayList<>();
	// for (ThistlethwaiteMove move : values()) {
	// if (move != EMPTY) {
	// result.add(move);
	// }
	// }
	// return result;
	// }

	@Override
	public String toString() {
		return name();
	}

	public ThistlethwaiteMove inverse() {
		return values()[ordinal() == 0 ? ordinal() : ordinal() + 2 * (1 - (ordinal() - 1) % 3)];
	}

}
