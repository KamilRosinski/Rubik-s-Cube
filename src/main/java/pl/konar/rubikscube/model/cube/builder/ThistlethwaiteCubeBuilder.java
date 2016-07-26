package pl.konar.rubikscube.model.cube.builder;

import pl.konar.rubikscube.model.cube.CubeConstants;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.math.OrientationVector;
import pl.konar.rubikscube.model.cube.math.PermutationVector;

public class ThistlethwaiteCubeBuilder {

	public static ThistlethwaiteCube buildSolvedCube() {
		PermutationVector cornersPermutation = new PermutationVector(CubeConstants.NUMBER_OF_CORNERS);
		OrientationVector cornersOrientation = new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER,
				CubeConstants.NUMBER_OF_CORNERS);
		PermutationVector edgesPermutation = new PermutationVector(CubeConstants.NUMBER_OF_EDGES);
		OrientationVector edgesOrientation = new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE,
				CubeConstants.NUMBER_OF_EDGES);
		return new ThistlethwaiteCube(cornersPermutation, cornersOrientation, edgesPermutation, edgesOrientation);
	}

	public static ThistlethwaiteCube buildScrumbledCube() {
		// TODO: Build cube.
		return null;
	}

}
