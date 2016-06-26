package pl.konar.rubikscube.model.cube.mapper;

import pl.konar.rubikscube.model.cube.ObservableCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.builder.ThistlethwaiteCubeBuilder;

public class CubeMapper {

	// private static List<Cubicle> expectedCentersColours =
	// Colour.getAllNonTransparent().stream()
	// .map(colour -> new Cubicle(colour)).collect(Collectors.toList());

	private static ObservableCube solvedCube = CubeMapper.map(ThistlethwaiteCubeBuilder.buildSolvedCube());

	public static ObservableCube map(ThistlethwaiteCube cube) {
		// TODO: Cube mapping
		return null;
	}

	public static ThistlethwaiteCube map(ObservableCube cube) {
		// TODO: Cube mapping
		return null;
	}

	public static boolean isMappable(ObservableCube cube) {
		return checkCenterCubicles(cube) && checkEdgeCubicles(cube) && checkCornerCubicles(cube);
	}

	private static boolean checkEdgeCubicles(ObservableCube cube) {
		// ObservableCube cube = new ObservableCube();
		// cube.fill(CubicleFactory.extractCenterCubicles(facets).stream().map(cubicle
		// -> cubicle.getColour(0))
		// .collect(Collectors.toList()));
		// List<Cubicle> solvedEdges =
		// CubicleFactory.extractEdgeCubicles(cube.getColours());
		// List<Cubicle> edges = CubicleFactory.extractEdgeCubicles(facets);
		// System.out.println(cube.getColours());
		// System.out.println(facets);
		// return edges.containsAll(solvedEdges) &&
		// solvedEdges.containsAll(edges);
		return false;
	}

	private static boolean checkCenterCubicles(ObservableCube cube) {
		// return centers.containsAll(expectedCenters) &&
		// expectedCenters.containsAll(centers);
		return false;
	}

	private static boolean checkCornerCubicles(ObservableCube cube) {
		return false;
	}

}
