package pl.konar.rubikscube.model.cube.builder.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.builder.ThistlethwaiteCubeBuilder;
import pl.konar.rubikscube.thistlethwaite.solver.ThistlethwaiteSolver;

public class ThistlethwaiteCubeBuilderTest {

	private static final int NUMBER_OF_ITERATIONS = 1000;

	@Test
	public void shouldBuildRandomSolvableCube() {
		for (int counter = 0; counter < NUMBER_OF_ITERATIONS; ++counter) {
			// given
			// when
			ThistlethwaiteCube cube = ThistlethwaiteCubeBuilder.scrambledCube();
			// then
			assertTrue(ThistlethwaiteSolver.isSolvable(cube));
		}
	}

}
