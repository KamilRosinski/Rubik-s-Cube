package pl.konar.rubikscube.thistlethwaite.state.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.ObservableCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.mapper.CubeMapper;
import pl.konar.rubikscube.model.cube.test.ObservableCubeTest;
import pl.konar.rubikscube.thistlethwaite.solver.Phase;
import pl.konar.rubikscube.thistlethwaite.state.ThistlethwaiteState;
import pl.konar.rubikscube.thistlethwaite.state.ThistlethwaiteStateFactory;

public class ThistlethwaiteStateTest {

	@Test
	public void shouldBuildCubeState() {
		// given
		ThistlethwaiteCube scrambled = CubeMapper.map(new ObservableCube(ObservableCubeTest.SCRAMBLED_COLOURS));
		// when
		ThistlethwaiteState scrambledState = ThistlethwaiteStateFactory.buildState(scrambled, Phase.FIRST);
		// then
		assertNotNull(scrambledState);
	}

}
