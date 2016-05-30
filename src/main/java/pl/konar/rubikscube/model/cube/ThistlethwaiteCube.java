package pl.konar.rubikscube.model.cube;

import java.util.ArrayList;
import java.util.List;

import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.exception.NotExistingCubeException;

public class ThistlethwaiteCube {

	private List<Integer> edgesPermutation = new ArrayList<>();
	private List<Integer> edgesOrientation = new ArrayList<>();
	private List<Integer> cornersPermutation = new ArrayList<>();
	private List<Integer> cornersOrientation = new ArrayList<>();

	public ThistlethwaiteCube(List<Colour> colours) throws NotExistingCubeException {
		ThistlethwaiteCube solvedCube = new ThistlethwaiteCube();
		generateEdgesPermutation(colours.subList(0, CubeConstants.NUMBER_OF_FACES), solvedCube);
	}

	private void generateEdgesPermutation(List<Colour> colours, ThistlethwaiteCube solvedCube) {
	}

	public ThistlethwaiteCube() {
		for (int edge = 0; edge < CubeConstants.NUMBER_OF_EDGES; ++edge) {
			edgesOrientation.add(0);
			edgesPermutation.add(edge);
		}
		for (int corner = 0; corner < CubeConstants.NUMBER_OF_CORNERS; ++corner) {
			cornersOrientation.add(0);
			cornersPermutation.add(corner);
		}
	}

	public List<Integer> getEdgesPermutation() {
		return edgesPermutation;
	}

	public List<Integer> getCornersPermutation() {
		return cornersPermutation;
	}

	public List<Integer> getEdgesOrientation() {
		return edgesOrientation;
	}

	public List<Integer> getCornersOrientation() {
		return cornersOrientation;
	}

}
