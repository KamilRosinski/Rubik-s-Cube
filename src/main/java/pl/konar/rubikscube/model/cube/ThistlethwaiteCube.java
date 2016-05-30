package pl.konar.rubikscube.model.cube;

public class ThistlethwaiteCube {

	private int[] edgesPermutation = new int[CubeConstants.NUMBER_OF_EDGES];
	private int[] cornersPermutation = new int[CubeConstants.NUMBER_OF_CORNERS];
	private int[] edgesOrientation = new int[CubeConstants.NUMBER_OF_EDGES];
	private int[] cornersOrientation = new int[CubeConstants.NUMBER_OF_CORNERS];

	public ThistlethwaiteCube() {
		fill();
	}

	private void fill() {
		for (int edge = 0; edge < CubeConstants.NUMBER_OF_EDGES; ++edge) {
			edgesOrientation[edge] = 0;
			edgesPermutation[edge] = edge;
		}
		for (int corner = 0; corner < CubeConstants.NUMBER_OF_CORNERS; ++corner) {
			cornersOrientation[corner] = 0;
			cornersPermutation[corner] = corner;
		}
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
