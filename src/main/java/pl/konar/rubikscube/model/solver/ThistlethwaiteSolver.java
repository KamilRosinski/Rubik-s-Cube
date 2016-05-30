package pl.konar.rubikscube.model.solver;

import java.util.Arrays;
import java.util.List;

import pl.konar.rubikscube.model.cube.Move;
import pl.konar.rubikscube.model.cube.ObservableCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.exception.NotExistingCubeException;

public class ThistlethwaiteSolver {

	private static final int DELAY_MS = 250;

	public static List<Move> solve(ObservableCube cube) {
		try {
			Thread.sleep(DELAY_MS);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		try {
			ThistlethwaiteCube thCube = new ThistlethwaiteCube(cube.facetslist());
		} catch (NotExistingCubeException e) {
			e.printStackTrace();
		}
		return Arrays.asList(Move.F1, Move.B3, Move.L1, Move.F2, Move.U3, Move.D2, Move.R2);
	}

}
