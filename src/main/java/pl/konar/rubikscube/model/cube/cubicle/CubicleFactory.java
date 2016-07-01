package pl.konar.rubikscube.model.cube.cubicle;

import java.util.ArrayList;
import java.util.List;

import pl.konar.rubikscube.model.cube.CubeConstants;
import pl.konar.rubikscube.model.cube.ObservableCube;

public class CubicleFactory {

	private static final int CENTERS_END_INDEX = CubeConstants.NUMBER_OF_FACES;
	private static final int EDGES_END_INDEX = 2 * CubeConstants.NUMBER_OF_EDGES + CENTERS_END_INDEX;
	private static final int CORNERS_END_INDEX = 3 * CubeConstants.NUMBER_OF_CORNERS + EDGES_END_INDEX;

//	public static List<Cubicle> extractCubicles(ObservableCube cube) {
//		List<Cubicle> result = new ArrayList<>();
//		result.addAll(extractCenterCubicles(cube));
//		result.addAll(extractEdgeCubicles(cube));
//		result.addAll(extractCornerCubicles(cube));
//		return result;
//	}
	
	public static List<Cubicle> extractCenterCubicles(ObservableCube cube) {
		List<Cubicle> result = new ArrayList<>();
		for (int index = 0; index < CENTERS_END_INDEX; index += 1) {
			result.add(new Cubicle(cube.getColour(index)));
		}
		return result;
	}

	public static List<Cubicle> extractEdgeCubicles(ObservableCube cube) {
		List<Cubicle> result = new ArrayList<>();
		for (int index = CENTERS_END_INDEX; index < EDGES_END_INDEX; index += 2) {
			result.add(new Cubicle(cube.getColour(index), cube.getColour(index + 1)));
		}
		return result;
	}

	public static List<Cubicle> extractCornerCubicles(ObservableCube cube) {
		List<Cubicle> result = new ArrayList<>();
		for (int index = EDGES_END_INDEX; index < CORNERS_END_INDEX; index += 3) {
			result.add(new Cubicle(cube.getColour(index), cube.getColour(index + 1), cube.getColour(index + 2)));
		}
		return result;
	}
	
}
