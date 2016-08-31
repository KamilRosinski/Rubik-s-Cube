package pl.konar.rubikscube.model.cube.builder;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import pl.konar.rubikscube.model.cube.CubeConstants;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.math.OrientationVector;
import pl.konar.rubikscube.model.cube.math.PermutationParity;
import pl.konar.rubikscube.model.cube.math.PermutationVector;

public class ThistlethwaiteCubeBuilder {

	private static final Random RANDOM = new Random();

	public static ThistlethwaiteCube solvedCube() {
		PermutationVector cornersPermutation = new PermutationVector(CubeConstants.NUMBER_OF_CORNERS);
		OrientationVector cornersOrientation = new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_CORNER,
				CubeConstants.NUMBER_OF_CORNERS);
		PermutationVector edgesPermutation = new PermutationVector(CubeConstants.NUMBER_OF_EDGES);
		OrientationVector edgesOrientation = new OrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE,
				CubeConstants.NUMBER_OF_EDGES);
		return new ThistlethwaiteCube(cornersPermutation, cornersOrientation, edgesPermutation, edgesOrientation);
	}

	public static ThistlethwaiteCube scrambledCube() {
		OrientationVector cornersOrientation = generateRandomOrientationVector(
				CubeConstants.NUMBER_OF_FACETS_PER_CORNER, CubeConstants.NUMBER_OF_CORNERS);
		OrientationVector edgesOrientation = generateRandomOrientationVector(CubeConstants.NUMBER_OF_FACETS_PER_EDGE,
				CubeConstants.NUMBER_OF_EDGES);
		PermutationParity parity = generateRandomParity();
		PermutationVector cornersPermutation = generateRandomPermutationVector(CubeConstants.NUMBER_OF_CORNERS, parity);
		PermutationVector edgesPermutation = generateRandomPermutationVector(CubeConstants.NUMBER_OF_EDGES, parity);
		return new ThistlethwaiteCube(cornersPermutation, cornersOrientation, edgesPermutation, edgesOrientation);
	}

	private static PermutationParity generateRandomParity() {
		PermutationParity[] parities = PermutationParity.values();
		return parities[RANDOM.nextInt(parities.length)];
	}

	private static PermutationVector generateRandomPermutationVector(int size, PermutationParity expectedParity) {
		List<Integer> sequence = generateSequence(size);
		Integer[] values = new Integer[size];
		for (int index = 0; index < size; ++index) {
			values[index] = getRandomFromSequence(sequence);
		}
		PermutationVector result = new PermutationVector(values);
		while (result.parity() != expectedParity) {
			List<Integer> tmp = generateSequence(size);
			int firstIndex = getRandomFromSequence(tmp);
			int secondIndex = getRandomFromSequence(tmp);
			result.swap(firstIndex, secondIndex);
		}
		return result;
	}

	private static Integer getRandomFromSequence(List<Integer> sequence) {
		return sequence.remove(RANDOM.nextInt(sequence.size()));
	}

	private static List<Integer> generateSequence(int size) {
		List<Integer> sequence = new LinkedList<>();
		for (int index = 0; index < size; ++index) {
			sequence.add(index);
		}
		return sequence;
	}

	private static OrientationVector generateRandomOrientationVector(int base, int size) {
		int[] array = new int[size];
		for (int index = 0; index < array.length; ++index) {
			array[index] = RANDOM.nextInt(base);
		}
		OrientationVector result = new OrientationVector(base, array);
		while (result.sum().getValue() != 0) {
			int index = RANDOM.nextInt(size);
			int value = RANDOM.nextInt(base);
			result.increaseElement(index, value);
		}
		return result;
	}

}
