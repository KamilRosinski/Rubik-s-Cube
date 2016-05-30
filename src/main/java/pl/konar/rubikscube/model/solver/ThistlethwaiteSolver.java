package pl.konar.rubikscube.model.solver;

import java.util.Arrays;
import java.util.List;

import pl.konar.rubikscube.model.cube.Move;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;

public class ThistlethwaiteSolver {

	private static final int DELAY_MS = 250;

	public static List<Move> solve() {
		try {
		    Thread.sleep(DELAY_MS);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		ThistlethwaiteCube cube = new ThistlethwaiteCube();
		return Arrays.asList(Move.F1, Move.B3, Move.L1, Move.F2, Move.U3, Move.D2, Move.R2);
	}

}
