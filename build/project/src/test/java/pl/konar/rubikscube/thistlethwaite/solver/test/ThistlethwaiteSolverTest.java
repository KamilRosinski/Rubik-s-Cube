package pl.konar.rubikscube.thistlethwaite.solver.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.ObservableCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteMove;
import pl.konar.rubikscube.model.cube.builder.ThistlethwaiteCubeBuilder;
import pl.konar.rubikscube.model.cube.mapper.CubeMapper;
import pl.konar.rubikscube.model.cube.test.ObservableCubeTest;
import pl.konar.rubikscube.thistlethwaite.solver.ThistlethwaiteSolver;

public class ThistlethwaiteSolverTest {

	private static final int NUMBER_OF_ITERATIONS = 10;

	@Test
	public void shouldSolveCube() {
		// given
		ThistlethwaiteCube cube = CubeMapper.map(new ObservableCube(ObservableCubeTest.SCRAMBLED_COLOURS));
		// when
		List<ThistlethwaiteMove> solution = ThistlethwaiteSolver.solve(cube);
		// then
		assertEquals(ThistlethwaiteCubeBuilder.solvedCube(), cube.applyMoves(solution));
	}

	@Test
	public void shouldSolveRandomCube() {
		for (int counter = 0; counter < NUMBER_OF_ITERATIONS; ++counter) {
			// given
			ThistlethwaiteCube cube = ThistlethwaiteCubeBuilder.scrambledCube();
			// when
			List<ThistlethwaiteMove> solution = ThistlethwaiteSolver.solve(cube);
			// then
			assertTrue(ThistlethwaiteSolver.isSolved(cube.applyMoves(solution)));
			System.err.println("Solution " + counter + " (" + solution.size() + " moves): " + solution);
		}
	}

}
