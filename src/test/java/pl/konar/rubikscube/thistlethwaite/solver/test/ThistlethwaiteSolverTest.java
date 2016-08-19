package pl.konar.rubikscube.thistlethwaite.solver.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
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

	@Test
	public void shouldTest1() {
		// given
		ThistlethwaiteCube cube = ThistlethwaiteCubeBuilder.solvedCube().applyMoves(
				Arrays.asList(ThistlethwaiteMove.UP_1, ThistlethwaiteMove.FRONT_2, ThistlethwaiteMove.DOWN_3));
		// when
		List<ThistlethwaiteMove> solution = ThistlethwaiteSolver.solve(cube);
		// then
		assertEquals(ThistlethwaiteCubeBuilder.solvedCube().getEdgesOrientation(),
				cube.applyMoves(solution).getEdgesOrientation());
	}

	@Test
	public void shouldTest2() {
		// given
		ThistlethwaiteCube cube = CubeMapper.map(new ObservableCube(ObservableCubeTest.SCRAMBLED_COLOURS));
		// when
		List<ThistlethwaiteMove> solution = ThistlethwaiteSolver.solve(cube);
		// then
		assertEquals(ThistlethwaiteCubeBuilder.solvedCube().getEdgesOrientation(),
				cube.applyMoves(solution).getEdgesOrientation());
	}

	@Test
	public void shouldTest3() {
		// given
		ThistlethwaiteCube cube = ThistlethwaiteCubeBuilder.solvedCube().applyMoves(
				Arrays.asList(ThistlethwaiteMove.UP_1, ThistlethwaiteMove.FRONT_2, ThistlethwaiteMove.DOWN_3,
						ThistlethwaiteMove.LEFT_1, ThistlethwaiteMove.RIGHT_1, ThistlethwaiteMove.BACK_3));
		// when
		List<ThistlethwaiteMove> solution = ThistlethwaiteSolver.solve(cube);
		// then
		assertEquals(ThistlethwaiteCubeBuilder.solvedCube().getEdgesOrientation(),
				cube.applyMoves(solution).getEdgesOrientation());
	}

}
