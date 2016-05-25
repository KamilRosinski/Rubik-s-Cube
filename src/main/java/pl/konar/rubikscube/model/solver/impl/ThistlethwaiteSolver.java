package pl.konar.rubikscube.model.solver.impl;

import java.util.Arrays;
import java.util.List;

import pl.konar.rubikscube.model.cube.Move;
import pl.konar.rubikscube.model.solver.CubeSolver;

public class ThistlethwaiteSolver implements CubeSolver {

	@Override
	public List<Move> solve() {
		return Arrays.asList(Move.F1, Move.U2, Move.R1);
	}

}
