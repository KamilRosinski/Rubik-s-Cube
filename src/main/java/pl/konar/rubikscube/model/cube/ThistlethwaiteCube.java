package pl.konar.rubikscube.model.cube;

import pl.konar.rubikscube.model.cube.exception.IllegalCubeException;
import pl.konar.rubikscube.model.cube.math.OrientationVector;
import pl.konar.rubikscube.model.cube.math.PermutationVector;

public class ThistlethwaiteCube {

	private PermutationVector cornersPermutation;
	private OrientationVector cornersOrientation;
	private PermutationVector edgesPermutation;
	private OrientationVector edgesOrientation;

	public ThistlethwaiteCube(PermutationVector cornersPermutation, OrientationVector cornersOrientation,
			PermutationVector edgesPermutation, OrientationVector edgesOrientation) {
		if (cornersPermutation == null || cornersPermutation.size() != CubeConstants.NUMBER_OF_CORNERS) {
			throw new IllegalCubeException("Cube must have " + CubeConstants.NUMBER_OF_CORNERS + " corners.");
		}
		this.cornersPermutation = cornersPermutation;
		if (cornersOrientation == null || cornersOrientation.size() != CubeConstants.NUMBER_OF_CORNERS) {
			throw new IllegalCubeException("Cube must have " + CubeConstants.NUMBER_OF_CORNERS + " corners.");
		}
		this.cornersOrientation = cornersOrientation;
		if (edgesPermutation == null || edgesPermutation.size() != CubeConstants.NUMBER_OF_EDGES) {
			throw new IllegalCubeException("Cube must have " + CubeConstants.NUMBER_OF_EDGES + " edges.");
		}
		this.edgesPermutation = edgesPermutation;
		if (edgesOrientation == null || edgesOrientation.size() != CubeConstants.NUMBER_OF_EDGES) {
			throw new IllegalCubeException("Cube must have " + CubeConstants.NUMBER_OF_EDGES + " edges.");
		}
		this.edgesOrientation = edgesOrientation;
	}

	public PermutationVector getEdgesPermutation() {
		return edgesPermutation;
	}

	public PermutationVector getCornersPermutation() {
		return cornersPermutation;
	}

	public OrientationVector getEdgesOrientation() {
		return edgesOrientation;
	}

	public OrientationVector getCornersOrientation() {
		return cornersOrientation;
	}

	public ThistlethwaiteCube applyMove(ThistlethwaiteMove move) {
		OrientationVector newCornersOrientation = cornersOrientation.increaseElements(move.getCornersCycle(),
				move.getCornersFlip());
		PermutationVector newCornersPermutation = cornersPermutation.applyCycle(move.getCornersCycle());
		OrientationVector newEdgesOrientation = edgesOrientation.increaseElements(move.getEdgesCycle(),
				move.getEdgesFlip());
		PermutationVector newEdgesPermutation = edgesPermutation.applyCycle(move.getEdgesCycle());
		return new ThistlethwaiteCube(newCornersPermutation, newCornersOrientation, newEdgesPermutation,
				newEdgesOrientation);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cornersOrientation == null) ? 0 : cornersOrientation.hashCode());
		result = prime * result + ((cornersPermutation == null) ? 0 : cornersPermutation.hashCode());
		result = prime * result + ((edgesOrientation == null) ? 0 : edgesOrientation.hashCode());
		result = prime * result + ((edgesPermutation == null) ? 0 : edgesPermutation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ThistlethwaiteCube other = (ThistlethwaiteCube) obj;
		if (cornersOrientation == null) {
			if (other.cornersOrientation != null) {
				return false;
			}
		} else if (!cornersOrientation.equals(other.cornersOrientation)) {
			return false;
		}
		if (cornersPermutation == null) {
			if (other.cornersPermutation != null) {
				return false;
			}
		} else if (!cornersPermutation.equals(other.cornersPermutation)) {
			return false;
		}
		if (edgesOrientation == null) {
			if (other.edgesOrientation != null) {
				return false;
			}
		} else if (!edgesOrientation.equals(other.edgesOrientation)) {
			return false;
		}
		if (edgesPermutation == null) {
			if (other.edgesPermutation != null) {
				return false;
			}
		} else if (!edgesPermutation.equals(other.edgesPermutation)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return cornersPermutation + "\n" + cornersOrientation + "\n" + edgesPermutation + "\n" + edgesOrientation;
	}

}
