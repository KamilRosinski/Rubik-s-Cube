package pl.konar.rubikscube.model.solver;

import java.util.Arrays;
import java.util.List;

import pl.konar.rubikscube.model.cube.Move;

public class ThistlethwaiteSolver {

	private static final int DELAY_MS = 3000;

	public static List<Move> solve() {
		try {
		    Thread.sleep(DELAY_MS);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return Arrays.asList(Move.F1, Move.U2, Move.R1, Move.L1, Move.D2);
	}

}
