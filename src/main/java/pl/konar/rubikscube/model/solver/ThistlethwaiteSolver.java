package pl.konar.rubikscube.model.solver;

import java.util.Arrays;
import java.util.List;

import pl.konar.rubikscube.model.cube.Move;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.exception.CubeNotSolvableException;

public class ThistlethwaiteSolver {

	private static final int DELAY_MS = 250;

	public static List<Move> solve(ThistlethwaiteCube cube) throws CubeNotSolvableException {
		sleep(DELAY_MS);
		// throw new CubeNotSolvableException("Could not solve given Cube.");
		return Arrays.asList(Move.F1, Move.B3, Move.L1, Move.F2, Move.U3, Move.D2, Move.R2);
	}

	private static void sleep(int delayMs) {
		try {
			Thread.sleep(delayMs);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
