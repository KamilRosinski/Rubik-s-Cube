package pl.konar.rubikscube.model.solver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteMove;
import pl.konar.rubikscube.model.cube.builder.ThistlethwaiteCubeBuilder;
import pl.konar.rubikscube.model.cube.math.OrientationVector;

public class ThistlethwaiteSolver {

	// private static final int DELAY_MS = 250;
	private static final ThistlethwaiteCube SOLVED_CUBE = ThistlethwaiteCubeBuilder.solvedCube();

	public static boolean isSolvable(ThistlethwaiteCube cube) {
		return false;
	}

	// List<Move> result = Arrays.asList(Move.E, Move.B1, Move.U1, Move.R3,
	// Move.L1, Move.F2, Move.U3, Move.D2,
	// Move.R2, Move.L1, Move.F3, Move.R3, Move.L1, Move.F2, Move.D2, Move.R2,
	// Move.L1, Move.F3);

	public static List<ThistlethwaiteMove> solve(ThistlethwaiteCube cube) {
		List<ThistlethwaiteMove> result = new LinkedList<>(Arrays.asList(ThistlethwaiteMove.EMPTY));
		Map<OrientationVector, OrientationVector> predecessors = new HashMap<>();
		Map<OrientationVector, ThistlethwaiteMove> previousMoves = new HashMap<>();
		Queue<ThistlethwaiteCube> toVisit = new LinkedList<>(Arrays.asList(cube));
		ThistlethwaiteCube currentCube = toVisit.peek();
		while (!toVisit.isEmpty() && !currentCube.getEdgesOrientation().equals(SOLVED_CUBE.getEdgesOrientation())) {
			currentCube = toVisit.poll();
			for (ThistlethwaiteMove move : ThistlethwaiteMove.values()) {
				ThistlethwaiteCube newCube = currentCube.applyMove(move);
				if (!predecessors.containsKey(newCube.getEdgesOrientation())) {
					predecessors.put(newCube.getEdgesOrientation(), currentCube.getEdgesOrientation());
					previousMoves.put(newCube.getEdgesOrientation(), move);
					toVisit.add(newCube);
				}
			}
		}
		OrientationVector currentState = currentCube.getEdgesOrientation();
		while (!currentState.equals(cube.getEdgesOrientation())) {
			result.add(0, previousMoves.get(currentState));
			currentState = predecessors.get(currentState);
		}
		System.err.println(result);
		return result;
	}

	// private static void sleep(int delayMs) {
	// try {
	// Thread.sleep(delayMs);
	// } catch (InterruptedException ex) {
	// Thread.currentThread().interrupt();
	// }
	// }

}
