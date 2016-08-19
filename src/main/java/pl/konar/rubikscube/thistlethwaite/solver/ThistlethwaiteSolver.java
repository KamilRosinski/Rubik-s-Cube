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
import pl.konar.rubikscube.thistlethwaite.state.ThistlethwaiteState;
import pl.konar.rubikscube.thistlethwaite.state.ThistlethwaiteStateFactory;

public class ThistlethwaiteSolver {

	private static final ThistlethwaiteCube SOLVED_CUBE = ThistlethwaiteCubeBuilder.solvedCube();

	public static boolean isSolvable(ThistlethwaiteCube initialCube) {
		return false;
	}

	public static List<ThistlethwaiteMove> solve(ThistlethwaiteCube initialCube) {
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
			List<ThistlethwaiteMove> moves = ThistlethwaiteMove.notEmptyValues();
			for (int index = 0; index < moves.size() && !stop; ++index) {
				ThistlethwaiteMove move = moves.get(index);
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
		stageSolution.add(0, ThistlethwaiteMove.EMPTY);
		return stageSolution;
	}

}
