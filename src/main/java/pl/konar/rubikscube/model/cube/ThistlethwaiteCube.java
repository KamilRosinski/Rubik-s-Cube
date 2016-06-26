package pl.konar.rubikscube.model.cube;

import java.util.List;

import pl.konar.rubikscube.model.colour.Colour;

public class ThistlethwaiteCube {

//	private List<Integer> edgesPermutation = new ArrayList<>();
//	private List<Integer> edgesOrientation = new ArrayList<>();
//	private List<Integer> cornersPermutation = new ArrayList<>();
//	private List<Integer> cornersOrientation = new ArrayList<>();

	private int[] edgesPermutation = new int[CubeConstants.NUMBER_OF_EDGES];
	private int[] edgesOrientation = new int[CubeConstants.NUMBER_OF_EDGES];
	private int[] cornersPermutation = new int[CubeConstants.NUMBER_OF_CORNERS];
	private int[] cornersOrientation = new int[CubeConstants.NUMBER_OF_CORNERS];

	public ThistlethwaiteCube(List<Colour> colours) {
		ThistlethwaiteCube solvedCube = new ThistlethwaiteCube();
		generateEdgesPermutation(colours.subList(0, CubeConstants.NUMBER_OF_FACES), solvedCube);
	}

	private void generateEdgesPermutation(List<Colour> colours, ThistlethwaiteCube solvedCube) {
	}

	public ThistlethwaiteCube() {
		
//		for (int edge = 0; edge < CubeConstants.NUMBER_OF_EDGES; ++edge) {
//			edgesOrientation[edge] = 0;
//			edgesPermutation[edge] = edge;
//		}
//		for (int corner = 0; corner < CubeConstants.NUMBER_OF_CORNERS; ++corner) {
//			cornersOrientation[corner] = 0;
//			cornersPermutation[corner] = corner;
//		}
	}

	public int[] getEdgesPermutation() {
		return edgesPermutation;
	}

	public int[] getCornersPermutation() {
		return cornersPermutation;
	}

	public int[] getEdgesOrientation() {
		return edgesOrientation;
	}

	public int[] getCornersOrientation() {
		return cornersOrientation;
	}

}
