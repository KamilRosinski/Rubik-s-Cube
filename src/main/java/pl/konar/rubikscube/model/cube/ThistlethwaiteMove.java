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
	UP_3(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	DOWN_1(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	DOWN_2(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	DOWN_3(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	FRONT_1(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	FRONT_2(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	FRONT_3(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	BACK_1(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	BACK_2(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	BACK_3(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	LEFT_1(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	LEFT_2(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	LEFT_3(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	RIGHT_1(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	RIGHT_2(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), //
	RIGHT_3(new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7),
			new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, 0, 0, 0, 0, 0, 0, 0, 0),
			new PermutationVector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
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

	@Override
	public String toString() {
		return name();
	}

	public ThistlethwaiteMove inverse() {
		return values()[ordinal() == 0 ? ordinal() : ordinal() + 2 * (1 - (ordinal() - 1) % 3)];
	}

}
