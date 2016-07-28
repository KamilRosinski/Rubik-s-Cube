package pl.konar.rubikscube.model.solver;

import java.util.Arrays;
import java.util.List;

import pl.konar.rubikscube.model.cube.Move;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;

public class ThistlethwaiteSolver {

	private static final int DELAY_MS = 250;

	public static boolean isSolvable(ThistlethwaiteCube cube) {
		return false;
	}

	public static List<Move> solve(ThistlethwaiteCube cube) {
		sleep(DELAY_MS);
		// throw new CubeNotSolvableException("Could not solve given Cube.");
		return Arrays.asList(Move.E, Move.D1, Move.U1, Move.R3, Move.L1, Move.F2, Move.U3, Move.D2, Move.R2);
	}

	private static void sleep(int delayMs) {
		try {
			Thread.sleep(delayMs);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
