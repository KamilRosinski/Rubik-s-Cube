package pl.konar.rubikscube.model.solver.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteMove;
import pl.konar.rubikscube.model.cube.builder.ThistlethwaiteCubeBuilder;
import pl.konar.rubikscube.model.solver.ThistlethwaiteSolver;

public class ThistlethwaiteSolverTest {

	@Test
	public void shouldTest() {
		// given
		ThistlethwaiteCube cube = ThistlethwaiteCubeBuilder.solvedCube().applyMoves(
				Arrays.asList(ThistlethwaiteMove.UP_1, ThistlethwaiteMove.FRONT_2, ThistlethwaiteMove.DOWN_3));
		// when
		List<ThistlethwaiteMove> solution = ThistlethwaiteSolver.solve(cube);
		// then
		assertEquals(ThistlethwaiteCubeBuilder.solvedCube().getEdgesOrientation(),
				cube.applyMoves(solution).getEdgesOrientation());
	}

}
