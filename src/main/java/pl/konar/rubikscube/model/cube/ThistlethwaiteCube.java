package pl.konar.rubikscube.model.cube;

import java.util.Arrays;
import java.util.List;

import pl.konar.rubikscube.model.colour.Colour;

public class ThistlethwaiteCube {

	private int[] centersPermutation = new int[CubeConstants.NUMBER_OF_FACES];
	private int[] edgesPermutation = new int[CubeConstants.NUMBER_OF_EDGES];
	private int[] cornersPermutation = new int[CubeConstants.NUMBER_OF_CORNERS];
	private int[] edgesOrientation = new int[CubeConstants.NUMBER_OF_EDGES];
	private int[] cornersOrientation = new int[CubeConstants.NUMBER_OF_CORNERS];

	public ThistlethwaiteCube(List<Colour> colours) {
		
	}
	
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

	public int[] getCentersPermutation() {
		return centersPermutation;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ThistlethwaiteCube)) {
			return false;
		}
		ThistlethwaiteCube other = (ThistlethwaiteCube) obj;
		if (!Arrays.equals(cornersOrientation, other.cornersOrientation)) {
			return false;
		}
		if (!Arrays.equals(cornersPermutation, other.cornersPermutation)) {
			return false;
		}
		if (!Arrays.equals(edgesOrientation, other.edgesOrientation)) {
			return false;
		}
		if (!Arrays.equals(edgesPermutation, other.edgesPermutation)) {
			return false;
		}
		return true;
	}
	
}
