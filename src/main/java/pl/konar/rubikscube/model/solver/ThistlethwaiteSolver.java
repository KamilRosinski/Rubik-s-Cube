package pl.konar.rubikscube.model.solver;

import java.util.Arrays;
import java.util.List;

import pl.konar.rubikscube.model.cube.Move;

public class ThistlethwaiteSolver {

	public static List<Move> solve() {
		return Arrays.asList(Move.F1, Move.U2, Move.R1, Move.L1, Move.D2);
	}

}
