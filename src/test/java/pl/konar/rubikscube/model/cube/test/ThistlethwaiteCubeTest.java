package pl.konar.rubikscube.model.cube.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.builder.ThistlethwaiteCubeBuilder;

public class ThistlethwaiteCubeTest {

	@Test
	public void ShouldBuildSolvedCube() {
		// given
		// when
		ThistlethwaiteCube cube = ThistlethwaiteCubeBuilder.buildSolvedCube();
		// then
		System.err.println(cube);
		assertNotNull(cube);
	}

}
