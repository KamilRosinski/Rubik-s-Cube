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

	private static final ThistlethwaiteCube SOLVED_CUBE = ThistlethwaiteCubeBuilder.solvedCube();

	public static boolean isSolvable(ThistlethwaiteCube cube) {
		return false;
	}

	public static List<ThistlethwaiteMove> solve(ThistlethwaiteCube cube) {
		List<ThistlethwaiteMove> result = new LinkedList<>();
		Map<OrientationVector, OrientationVector> predecessors = new HashMap<>();
		Map<OrientationVector, ThistlethwaiteMove> previousMoves = new HashMap<>();
		Queue<ThistlethwaiteCube> toVisit = new LinkedList<>(Arrays.asList(cube, SOLVED_CUBE));
		Map<OrientationVector, Direction> directions = new HashMap<>();
		directions.put(cube.getEdgesOrientation(), Direction.FORWARD);
		directions.put(SOLVED_CUBE.getEdgesOrientation(), Direction.BACKWARD);
		ThistlethwaiteCube currentCube = toVisit.peek();
		OrientationVector currentState = currentCube.getEdgesOrientation();
		boolean stop = false;
		while (!stop) {
			currentCube = toVisit.poll();
			currentState = currentCube.getEdgesOrientation();
			Direction currentDirection = directions.get(currentState);
			List<ThistlethwaiteMove> moves = ThistlethwaiteMove.notEmptyValues();
			for (int index = 0; index < moves.size() && !stop; ++index) {
				ThistlethwaiteMove move = moves.get(index);
				ThistlethwaiteCube newCube = currentCube.applyMove(move);
				OrientationVector newState = newCube.getEdgesOrientation();
				if (!directions.containsKey(newState)) {
					predecessors.put(newState, currentState);
					previousMoves.put(newState, move);
					directions.put(newState, currentDirection);
					toVisit.add(newCube);
				}
				if (directions.containsKey(newState) && directions.get(newState) != currentDirection) {
					stop = true;
					if (currentDirection == Direction.BACKWARD) {
						move = move.inverse();
						OrientationVector tmpState = currentState;
						currentState = newState;
						newState = tmpState;
						System.out.println(":)");
					}
					result.add(move);
					List<ThistlethwaiteMove> forwardSolution = new LinkedList<>();
					OrientationVector state = currentState;
					while (!state.equals(cube.getEdgesOrientation())) {
						forwardSolution.add(0, previousMoves.get(state));
						state = predecessors.get(state);
					}
					result.addAll(0, forwardSolution);
					List<ThistlethwaiteMove> backwardSolution = new LinkedList<>();
					state = newState;
					while (!state.equals(SOLVED_CUBE.getEdgesOrientation())) {
						backwardSolution.add(previousMoves.get(state).inverse());
						state = predecessors.get(state);
					}
					result.addAll(backwardSolution);
				}
			}
		}
		result.add(0, ThistlethwaiteMove.EMPTY);
		System.err.println(result);
		return result;
	}

}
