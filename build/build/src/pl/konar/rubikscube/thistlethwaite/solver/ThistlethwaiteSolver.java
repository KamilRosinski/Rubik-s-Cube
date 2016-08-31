package pl.konar.rubikscube.thistlethwaite.solver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteMove;
import pl.konar.rubikscube.model.cube.builder.ThistlethwaiteCubeBuilder;
import pl.konar.rubikscube.model.cube.exception.CubeNotSolvableException;
import pl.konar.rubikscube.thistlethwaite.state.ThistlethwaiteState;
import pl.konar.rubikscube.thistlethwaite.state.ThistlethwaiteStateFactory;

public class ThistlethwaiteSolver {

	private static final ThistlethwaiteCube SOLVED_CUBE = ThistlethwaiteCubeBuilder.solvedCube();

	public static boolean isSolved(ThistlethwaiteCube cube) {
		return SOLVED_CUBE.equals(cube);
	}

	public static boolean isSolvable(ThistlethwaiteCube cube) {
		return chceckEdgesOrientationSolvability(cube) && checkCornersOrientationSolvability(cube)
				&& checkPermutationSolvability(cube);
	}

	private static boolean chceckEdgesOrientationSolvability(ThistlethwaiteCube initialCube) {
		return initialCube.getEdgesOrientation().sum().getValue() == 0;
	}

	private static boolean checkCornersOrientationSolvability(ThistlethwaiteCube initialCube) {
		return initialCube.getCornersOrientation().sum().getValue() == 0;
	}

	private static boolean checkPermutationSolvability(ThistlethwaiteCube initialCube) {
		return initialCube.getEdgesPermutation().parity() == initialCube.getCornersPermutation().parity();
	}

	public static List<ThistlethwaiteMove> solve(ThistlethwaiteCube initialCube) {
		if (!isSolvable(initialCube)) {
			throw new CubeNotSolvableException("Given cube is not solvable:" + initialCube);
		}
		List<ThistlethwaiteMove> solution = new LinkedList<>();
		for (Phase phase : Phase.values()) {
			List<ThistlethwaiteMove> phaseSolution = solvePhase(initialCube, phase);
			solution.addAll(phaseSolution);
			initialCube = initialCube.applyMoves(phaseSolution);
		}
		return solution;
	}

	private static List<ThistlethwaiteMove> solvePhase(ThistlethwaiteCube initialCube, Phase phase) {
		List<ThistlethwaiteMove> stageSolution = new LinkedList<>();
		Map<ThistlethwaiteState, ThistlethwaiteState> predecessors = new HashMap<>();
		Map<ThistlethwaiteState, ThistlethwaiteMove> previousMoves = new HashMap<>();
		Map<ThistlethwaiteState, Direction> directions = new HashMap<>();
		Queue<ThistlethwaiteCube> toVisit = new LinkedList<>(Arrays.asList(initialCube, SOLVED_CUBE));
		ThistlethwaiteState initialState = ThistlethwaiteStateFactory.buildState(initialCube, phase);
		ThistlethwaiteState solvedState = ThistlethwaiteStateFactory.buildState(SOLVED_CUBE, phase);
		directions.put(initialState, Direction.FORWARD);
		directions.put(solvedState, Direction.BACKWARD);
		boolean stop = initialState.equals(solvedState);
		while (!stop) {
			ThistlethwaiteCube currentCube = toVisit.poll();
			ThistlethwaiteState currentState = ThistlethwaiteStateFactory.buildState(currentCube, phase);
			Direction currentDirection = directions.get(currentState);
			ThistlethwaiteMove[] moves = phase.getApplicableMoves();
			for (int index = 0; index < moves.length && !stop; ++index) {
				ThistlethwaiteMove move = moves[index];
				ThistlethwaiteCube newCube = currentCube.applyMove(move);
				ThistlethwaiteState newState = ThistlethwaiteStateFactory.buildState(newCube, phase);
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
						ThistlethwaiteState tmpState = currentState;
						currentState = newState;
						newState = tmpState;
					}
					stageSolution.add(move);
					for (ThistlethwaiteState state = currentState; !state.equals(initialState); state = predecessors
							.get(state)) {
						stageSolution.add(0, previousMoves.get(state));
					}
					for (ThistlethwaiteState state = newState; !state.equals(solvedState); state = predecessors
							.get(state)) {
						stageSolution.add(previousMoves.get(state).inverse());
					}
				}
			}
		}
		return stageSolution;
	}

}
