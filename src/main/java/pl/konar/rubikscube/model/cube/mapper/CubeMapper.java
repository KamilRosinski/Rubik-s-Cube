package pl.konar.rubikscube.model.cube.mapper;

import java.util.ArrayList;
import java.util.List;

import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.CubeConstants;
import pl.konar.rubikscube.model.cube.ObservableCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.cubicle.Cubicle;
import pl.konar.rubikscube.model.cube.cubicle.CubicleFactory;
import pl.konar.rubikscube.model.cube.math.OrientationVector;
import pl.konar.rubikscube.model.cube.math.PermutationVector;

public class CubeMapper {

	public static boolean isMappable(ObservableCube cube) {
		ObservableCube solved = new ObservableCube();
		solved.fill(cube.getCenterColours());
		return checkCenterCubicles(solved, cube) && checkEdgeCubicles(solved, cube)
				&& checkCornerCubicles(solved, cube);
	}

	private static boolean checkCenterCubicles(ObservableCube solved, ObservableCube cube) {
		List<Cubicle> cubeCenters = CubicleFactory.extractCenterCubicles(solved);
		List<Cubicle> solvedCenters = CubicleFactory.extractCenterCubicles(cube);
		return compareCubicleLists(cubeCenters, solvedCenters);
	}

	private static boolean checkEdgeCubicles(ObservableCube solved, ObservableCube cube) {
		List<Cubicle> cubeEdges = CubicleFactory.extractEdgeCubicles(solved);
		List<Cubicle> solvedEdges = CubicleFactory.extractEdgeCubicles(cube);
		return compareCubicleLists(cubeEdges, solvedEdges);
	}

	private static boolean checkCornerCubicles(ObservableCube solved, ObservableCube cube) {
		List<Cubicle> cubeCorners = CubicleFactory.extractCornerCubicles(solved);
		List<Cubicle> solvedCorners = CubicleFactory.extractCornerCubicles(cube);
		return compareCubicleLists(cubeCorners, solvedCorners);
	}

	private static boolean compareCubicleLists(List<Cubicle> first, List<Cubicle> second) {
		return first != null && second != null && first.size() == second.size() && first.containsAll(second)
				&& second.containsAll(first);
	}

	public static ThistlethwaiteCube map(ObservableCube cube) {
		ObservableCube solved = new ObservableCube();
		solved.fill(cube.getCenterColours());
		List<Cubicle> cubeCorners = CubicleFactory.extractCornerCubicles(cube);
		List<Cubicle> solvedCorners = CubicleFactory.extractCornerCubicles(solved);

		int[] cornersPermutation = new int[8];
		int[] invCornersPerm = new int[8];
		int[] cornersOrientation = new int[8];
		for (int i = 0; i < 8; ++i) {
			cornersPermutation[i] = cubeCorners.indexOf(solvedCorners.get(i));
			invCornersPerm[cornersPermutation[i]] = i;
		}
		for (int i = 0; i < 8; ++i) {
			cornersOrientation[invCornersPerm[i]] = cubeCorners.get(cornersPermutation[i])
					.relativeTwist(solvedCorners.get(i));
		}

		List<Cubicle> cubeEdges = CubicleFactory.extractEdgeCubicles(cube);
		List<Cubicle> solvedEdges = CubicleFactory.extractEdgeCubicles(solved);

		int[] edgesPermutation = new int[12];
		int[] invEdgesPerm = new int[12];
		int[] edgesOrientation = new int[12];
		for (int i = 0; i < 12; ++i) {
			edgesPermutation[i] = cubeEdges.indexOf(solvedEdges.get(i));
			invEdgesPerm[edgesPermutation[i]] = i;
		}
		for (int i = 0; i < 12; ++i) {
			edgesOrientation[invEdgesPerm[i]] = cubeEdges.get(edgesPermutation[i]).relativeTwist(solvedEdges.get(i));
		}

		return new ThistlethwaiteCube(new PermutationVector(cornersPermutation),
				new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER, cornersOrientation),
				new PermutationVector(edgesPermutation),
				new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE, edgesOrientation));
	}

	public static ObservableCube map(ThistlethwaiteCube cube, List<Colour> centersColours) {
		ObservableCube solved = new ObservableCube();
		solved.fill(centersColours);
		List<Colour> colours = new ArrayList<>();
		colours.addAll(solved.getCenterColours());
		List<Cubicle> solvedEdges = CubicleFactory.extractEdgeCubicles(solved);
		List<Cubicle> solvedCorners = CubicleFactory.extractCornerCubicles(solved);
		for (int i : cube.getEdgesPermutation()) {
			
		}
		return new ObservableCube(colours);
	}

	// private static void corners(List<Cubicle> cubeCorners, List<Cubicle>
	// solvedCorners) {
	// int[] permutation = new int[8];
	// int[] invPerm = new int[8];
	// int[] orientation = new int[8];
	// for (int i = 0; i < 8; ++i) {
	// permutation[i] = cubeCorners.indexOf(solvedCorners.get(i));
	// invPerm[permutation[i]] = i;
	// }
	// for (int i = 0; i < 8; ++i) {
	// orientation[invPerm[i]] =
	// cubeCorners.get(permutation[i]).relativeTwist(solvedCorners.get(i));
	// }
	// for (int n : permutation) {
	// System.err.print(n + " ");
	// }
	// System.err.println("");
	// for (int n : orientation) {
	// System.err.print(n + " ");
	// }
	// System.err.println("");
	// }

	// private static void edges(List<Cubicle> cubeEdges, List<Cubicle>
	// solvedEdges) {
	// int[] permutation = new int[12];
	// int[] invPerm = new int[12];
	// int[] orientation = new int[12];
	// for (int i = 0; i < 12; ++i) {
	// permutation[i] = cubeEdges.indexOf(solvedEdges.get(i));
	// invPerm[permutation[i]] = i;
	// }
	// for (int i = 0; i < 12; ++i) {
	// // int twist =
	// // solvedCorners.get(invPerm[i]).relativeTwist(cubeCorners.get(i));
	// int twist =
	// cubeEdges.get(permutation[i]).relativeTwist(solvedEdges.get(i));
	// orientation[invPerm[i]] = twist;
	// // System.err.println(i + "\t" + permutation[i] + "\t" + twist);
	// }
	// for (int n : permutation) {
	// System.err.print(n + " ");
	// }
	// System.err.println("");
	// for (int n : orientation) {
	// System.err.print(n + " ");
	// }
	// System.err.println("");
	// }

}
