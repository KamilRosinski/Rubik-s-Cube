package pl.konar.rubikscube.model.cube.cubicle;

import java.util.ArrayList;
import java.util.List;

import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.CubeConstants;

public class CubicleFactory {

	private static final int CENTERS_END_INDEX = CubeConstants.NUMBER_OF_FACES;
	private static final int EDGES_END_INDEX = 2 * CubeConstants.NUMBER_OF_EDGES + CENTERS_END_INDEX;
	private static final int CORNERS_END_INDEX = 3 * CubeConstants.NUMBER_OF_CORNERS + EDGES_END_INDEX;

	public static List<Cubicle> centerCubicles(List<Colour> facets) {
		List<Cubicle> result = new ArrayList<>();
		for (int index = 0; index < CENTERS_END_INDEX; index += 1) {
			result.add(new Cubicle(facets.get(index)));
		}
		return result;
	}

	public static List<Cubicle> edgeCubicles(List<Colour> facets) {
		List<Cubicle> result = new ArrayList<>();
		for (int index = CENTERS_END_INDEX; index < EDGES_END_INDEX; index += 2) {
			result.add(new Cubicle(facets.get(index), facets.get(index + 1)));
		}
		return result;
	}

	public static List<Cubicle> cornerCubicles(List<Colour> facets) {
		List<Cubicle> result = new ArrayList<>();
		for (int index = EDGES_END_INDEX; index < CORNERS_END_INDEX; index += 3) {
			result.add(new Cubicle(facets.get(index), facets.get(index + 1), facets.get(index + 2)));
		}
		return result;
	}
	
}
