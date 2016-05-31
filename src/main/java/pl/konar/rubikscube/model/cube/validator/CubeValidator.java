package pl.konar.rubikscube.model.cube.validator;

import java.util.List;
import java.util.stream.Collectors;

import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.ObservableCube;
import pl.konar.rubikscube.model.cube.cubicle.Cubicle;
import pl.konar.rubikscube.model.cube.cubicle.CubicleFactory;

public class CubeValidator {

	private static List<Cubicle> expectedCenters = Colour.getAllNonTransparentSet().stream()
			.map(colour -> new Cubicle(colour)).collect(Collectors.toList());

	public static boolean checkSolvability(List<Colour> facets) {
		List<Cubicle> centers = CubicleFactory.centerCubicles(facets);
		if (!checkCentersSet(centers)) {
			System.err.println("centers");
			return false;
		}
		if (!checkEdgesSet(facets)) {
			System.err.println("edges");
			return false;
		}
		return true;
	}

	private static boolean checkEdgesSet(List<Colour> facets) {
		ObservableCube cube = new ObservableCube();
		cube.fill(CubicleFactory.centerCubicles(facets).stream().map(cubicle -> cubicle.getColour(0))
				.collect(Collectors.toList()));
		List<Cubicle> solvedEdges = CubicleFactory.edgeCubicles(cube.getColours());
		List<Cubicle> edges = CubicleFactory.edgeCubicles(facets);
		System.out.println(cube.getColours());
		System.out.println(facets);
		return edges.containsAll(solvedEdges) && solvedEdges.containsAll(edges);
	}

	private static boolean checkCentersSet(List<Cubicle> centers) {
		return centers.containsAll(expectedCenters) && expectedCenters.containsAll(centers);
	}

}
