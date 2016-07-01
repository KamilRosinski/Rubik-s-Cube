package pl.konar.rubikscube.model.cube.mapper;

import java.util.List;

import pl.konar.rubikscube.model.cube.ObservableCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.cubicle.Cubicle;
import pl.konar.rubikscube.model.cube.cubicle.CubicleFactory;

public class CubeMapper {

	public static boolean isMappable(ObservableCube cube) {
		ObservableCube solved = new ObservableCube();
		solved.fill(cube.getCenterColours());
		return checkCenterCubicles(solved, cube) && checkEdgeCubicles(solved, cube) && checkCornerCubicles(solved, cube);
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
	
	public static ObservableCube map(ThistlethwaiteCube cube) {
		// TODO: Cube mapping
		return null;
	}

	public static ThistlethwaiteCube map(ObservableCube cube) {
		// TODO: Cube mapping
		return null;
	}

}
